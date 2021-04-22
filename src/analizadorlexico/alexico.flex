package analizadorlexico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Yytoken {
    Yytoken (int numToken,String token, String tipo, int linea, int columna){

        this.numToken = numToken;

        this.token = new String(token);

        this.tipo = tipo;

        this.linea = linea;

        this.columna = columna;
    }

    public int numToken;
    public String token;
    public String tipo;
    public int linea;
    public int columna;
    public String toString() {
        return "Token #"+numToken+": "+token+" C.Lexico: "+tipo+" ["+linea
        + "," +columna + "]";
    }
}


%% 

%function nextToken

%public

%class AnalizadorLexico

%unicode

%{
	
    private int contador;
    private ArrayList<Yytoken> tokens;

	private void writeOutputFile() throws IOException{
			String filename = "file.out";
			BufferedWriter out = new BufferedWriter(
				new FileWriter(filename));
            System.out.println("\n*** Tokens guardados en archivo ***\n");
			for(Yytoken t: this.tokens){
				System.out.println(t);
				out.write(t + "\n");
			}
			out.close();
	}
%}

%init{
    contador = 0;
	tokens = new ArrayList<Yytoken>();
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
EXP_OCTAL = [0-8]
NUMERO_OCTAL = "0"({EXP_OCTAL})+
EXP_HEX = [0-9a-fA-F]
NUMERO_HEX = "0x"({EXP_HEX})+
IDENTIFICADOR={EXP_ALPHA}({EXP_ALPHANUMERIC})*
ESPACIO=" "
SALTO=\n|\r|\r\n
PALABRA_RESERVADA = "auto"|"break"|"case"|"char"|"const"|"continue"|"default"|"do"|"double"|"else"|"enum"|"extern"|"float"|
"for"|"goto"|"if"|"int"|"long"|"register"|"return"|"short"|"signed"|"sizeof"|"static"|"struct"|"switch"|"typedef"|"union"
|"unsigned"|"void"|"volatile"|"while"
OPERADORES = "," | ";" |"++" |"--" |"==" |">=" |">" |"?" |"<=" |"<" |"!=" |"||" |"&&" |"!"| 
"=" |"+" |"-" |"*"| "/" |"%" |"(" |")"| "[" |"]" |"{"| "}" |":" |"." |"+=" |"-=" |"*=" |"/="| "&" |"^" |"|" 
">>" |"<<" |"~" |"%="| "&=" |"^=" |"|=" |"<<=" |">>=" |"->"
%% 


{NUMERO}    {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"num",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{NUMERO_HEX}    {
    contador++;
    Yytoken t = new Yytoken(contador, yytext(), "num_hex",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{NUMERO_OCTAL}    {
    contador++;
    Yytoken t = new Yytoken(contador, yytext(), "num_oct",yyline,yycolumn);
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
{PALABRA_RESERVADA}   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"palabra_reservada",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{IDENTIFICADOR}   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"id",yyline,yycolumn);
    tokens.add(t);
    return t;
}
{OPERADORES}   {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"operador",yyline,yycolumn);
    tokens.add(t);
    return t;
}
/*"+="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"asigna_suma",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"+"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"suma",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"="  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"asigna",yyline,yycolumn);
    tokens.add(t);
    return t;
}
"-"  {
    contador++;
    Yytoken t = new Yytoken(contador,yytext(),"resta",yyline,yycolumn);
    tokens.add(t);
    return t;
}*/

{ESPACIO} {
 	//ignorar
}
{SALTO} {
    contador++;
    Yytoken t = new Yytoken(contador,"","fin_linea",yyline,yycolumn);
    tokens.add(t);
    return t;
}

