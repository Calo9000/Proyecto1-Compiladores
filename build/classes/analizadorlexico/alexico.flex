package analizadorlexico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Yytoken {
    Yytoken (int numToken,String token, String tipo, int linea, int columna){

        this.numToken = numToken;

        this.token = new String(token);

        this.tipo = tipo;

        this.linea = linea;

        this.columna = columna;
    }
    Yytoken (String token, int linea){

        this.token = new String(token);

        this.linea = linea;
    }

    public int numToken;
    public String token;
    public String tipo;
    public int linea;
    public int columna;

    public String toString() {
        return "Token #"+numToken+": "+token+" Tipo: "+tipo+" ["+linea
        + "," +columna + "]";
    }
    public String errorToStr() {
        return "Error en la linea número " + linea + " causado por " + token ;
    }
}



%% 
%function nextToken
%public

%class AnalizadorLexico

%unicode

%{	
    Hashtable<List<String>, List<Integer>> lexemas = new Hashtable<List<String>,  List<Integer>>();
    private int contador;
    private ArrayList<Yytoken> tokens;
    private ArrayList<Yytoken> errores;
	private void writeOutputFile() throws IOException{
			String filename = "file.out";
			BufferedWriter out = new BufferedWriter(
				new FileWriter(filename));
            System.out.println("\n*** Tokens guardados en archivo ***\n");
			for(Yytoken t: this.tokens){
				//System.out.println(t);
                                lexemas.putIfAbsent(List.of(t.token, t.tipo), new ArrayList<Integer>());
                                lexemas.get(List.of(t.token, t.tipo)).add(t.linea);
				out.write(t + "\n");
			}
                        // Los errores estan en this.tokens pero son de tipo ERROR
                        //ArrayList<Integer> errores = new ArrayList<Integer>();
                lexemas.forEach((k, v) -> {
                    System.out.print(k.get(0)+" "+k.get(1)+" ");
                    System.out.print(" ");
                    int i = 0;
                    while (i < v.size()){
                        int numero = v.get(i);
                        int repeticiones = Collections.frequency(v, numero);
                        System.out.print(numero);
                        if (repeticiones > 1){
                            System.out.print("("+repeticiones+")");
                        }
                        i += repeticiones;
                        if (i<v.size()) System.out.print(", ");
                    }
                    System.out.print("\n");
                });
                // Printea los errores
                
                
                if (errores.size()>0) System.out.println("\nERRORES:");
                out.write("\nERRORES \n");
                for(Yytoken e: this.errores){
                    System.out.println(e.errorToStr());
                    out.write(e.errorToStr() + "\n");
                }
                    //errores.forEach((e) -> {
                    //    System.out.println(e.errorToStr());
                    //    out.write(e + "\n");
                    //});
			out.close();
	}
%}

%init{
    contador = 0;
	tokens = new ArrayList<Yytoken>();
    errores = new ArrayList<Yytoken>();
%init}
%eof{
	try{
		this.writeOutputFile();
        System.exit(0);
	}catch(IOException ioe){
		ioe.printStackTrace();
	}
%eof}
%line
%column


EXP_ALPHA=[A-Za-z]
EXP_DIGITO=[0-9]
EXP_ALPHANUMERIC={EXP_ALPHA}|{EXP_DIGITO}
NUMERO=({EXP_DIGITO})+

EXP_OCTAL = [0-7]
NUMERO_OCTAL = "0x"({EXP_OCTAL})+

EXP_HEX = [0-9a-fA-F]
NUMERO_HEX = "0x"({EXP_HEX})+

SIGNO= "" | "-"
EXP_FLOAT = E{EXP_DIGITO}?{EXP_DIGITO}+
PARTE_NUMERICA = {EXP_DIGITO}*({EXP_DIGITO}\.|\.{EXP_DIGITO}){EXP_DIGITO}*
NUMERO_FLOTANTE = {SIGNO}?{PARTE_NUMERICA}{EXP_FLOAT}?

IDENTIFICADOR={EXP_ALPHA}({EXP_ALPHANUMERIC})*

IGNORAR= [\t,\r,\n]+ | " "

SALTO=\n|\r|\r\n

TERMINAR_LINEA = \r|\n|\r\n
CARACTER_ENTRADA = [^\r\n]


COMENTARIO_BLOQUE =  "/*"( [^*] | (\*+[^*/]) )*\*+\/ 
COMENTARIO_LINEA = "//" {CARACTER_ENTRADA}* {TERMINAR_LINEA}?
COMENTARIO = {COMENTARIO_BLOQUE}|{COMENTARIO_LINEA}


PALABRA_RESERVADA = "auto"|"break"|"case"|"char"|"const"|"continue"|"default"|"do"|"double"|"else"|"enum"|"extern"|"float"|
"for"|"goto"|"if"|"int"|"long"|"register"|"return"|"short"|"signed"|"sizeof"|"static"|"struct"|"switch"|"typedef"|"union"
|"unsigned"|"void"|"volatile"|"while" | "#include" | "#define"

OPERADORES = "," | ";" |"++" |"--" |"==" |">=" |">" |"?" |"<=" |"<" |"!=" |"||" |"&&" |"!"| 
"=" |"+" |"-" |"*"| "/" |"%" |"(" |")"| "[" |"]" |"{"| "}" |":" |"." |"+=" |"-=" |"*=" |"/="| "&" |"^" |"\|" |
">>" |"<<" |"~" |"%="| "&=" |"^=" |"|=" |"<<=" |">>=" |"->"

LITERAL = "\""([^\\\"]|\\.)*"\""|"\'"([^\\\"]|\\.)"\'"
ERROR = ({EXP_DIGITO})+({EXP_ALPHA})+ | .
%% 



{COMENTARIO}   {
 //Ignorar
}
{NUMERO}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"INT",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{NUMERO_OCTAL}    {
    contador++;
    Yytoken t = new Yytoken(contador, yytext(), "NUM_OCT",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{NUMERO_HEX}    {
    contador++;
    Yytoken t = new Yytoken(contador, yytext(), "NUM_HEX",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{NUMERO_FLOTANTE}    {
    contador++;
    Yytoken t = new Yytoken(contador, yytext(), "NUM_FLOAT",yyline,yycolumn);
    tokens.add(t);
    return t;
}
/*"int"   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"entero",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"float"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"flotante",yyline,yycolumn);
    tokens.add(t);
    return t;
}*/
{LITERAL}   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"LITERAL",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{PALABRA_RESERVADA}   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{IDENTIFICADOR}   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"IDENTIFICADOR",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{OPERADORES}   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"OPERADOR",yyline,yycolumn);
    tokens.add(t);
    return t;
}

{IGNORAR} {
 	//ignorar
}

{SALTO} {
    //ignorar
}
{ERROR} {
    contador++;
    Yytoken t = new Yytoken(yytext(),yyline);
    errores.add(t);
    return t;
}

