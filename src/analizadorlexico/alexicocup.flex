package analizadorlexico;

import java_cup.runtime.Symbol;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

%% 

%public

%class AnalizadorLexicoCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%unicode

%{	
    private Symbol symbol(int type, Object value){
    return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}

%init{
    //simbolos = new ArrayList<Symbol>();
    //errores = new ArrayList<Symbol>();
    System.out.println("Analizando Archivo . . .");
%init}
%eofval{
    return new Symbol(sym.EOF, yycolumn, yyline, yytext());
%eofval}
%line
%column


EXP_ALPHA=[A-Za-z]
EXP_DIGITO=[0-9]
DIGITO_MAYOR_CERO = [1-9]
EXP_ALPHANUMERIC={EXP_ALPHA}|{EXP_DIGITO}
NUMERO=({DIGITO_MAYOR_CERO}{EXP_DIGITO}*[E]?{EXP_DIGITO}* | 0)

EXP_OCTAL = [0-7]
NUMERO_OCTAL = "0"({EXP_OCTAL})+

EXP_HEX = [0-9a-fA-F]
NUMERO_HEX = "0x"({EXP_HEX})+ | "0X"({EXP_HEX})+

SIGNO= "" | "-"

NUMERO_FLOTANTE = {SIGNO}?{EXP_ALPHANUMERIC}+\.{EXP_ALPHANUMERIC}+

IDENTIFICADOR={EXP_ALPHA}({EXP_ALPHANUMERIC})*

IGNORAR= [\t,\r,\n]+ | " "

SALTO=\n|\r|\r\n

TERMINAR_LINEA = \r|\n|\r\n
CARACTER_ENTRADA = [^\r\n]


COMENTARIO_BLOQUE =  "/*"( [^*] | (\*+[^*/]) )*\*+\/ 
COMENTARIO_LINEA = "//" {CARACTER_ENTRADA}* {TERMINAR_LINEA}
COMENTARIO = {COMENTARIO_BLOQUE}|{COMENTARIO_LINEA}


PALABRA_RESERVADA = "auto"|"break"|"case"|"char"|"const"|"continue"|"default"|"do"|"double"|"else"|"enum"|"extern"|"float"|
"for"|"goto"|"if"|"int"|"long"|"register"|"return"|"short"|"signed"|"sizeof"|"static"|"struct"|"switch"|"typedef"|"union"
|"unsigned"|"void"|"volatile"|"while" | "#include" | "#define"

OPERADORES = "," | ";" |"++" |"--" |"==" |">=" |">" |"?" |"<=" |"<" |"!=" |"||" |"&&" |"!"| 
"=" |"+" |"-" |"*"| "/" |"%" |"(" |")"| "[" |"]" |"{"| "}" |":" |"." |"+=" |"-=" |"*=" |"/="| "&" |"^" |"\|" |
">>" |"<<" |"~" |"%="| "&=" |"^=" |"|=" |"<<=" |">>=" |"->"

LITERAL = [\"]([^\"\\\n]|\\.|\\\n)*[\"]|"\'"([^\\\"]|\\.)"\'"
ERROR = ({EXP_DIGITO})+({EXP_ALPHA})+ | . 
%% 



{COMENTARIO}   {
 //Ignorar
}
{NUMERO} {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}

{NUMERO_OCTAL} {return new Symbol(sym.NUMERO_OCT, yycolumn, yyline, yytext());}

{NUMERO_HEX} {return new Symbol(sym.NUMERO_HEX, yycolumn, yyline, yytext());}

{NUMERO_FLOTANTE} {return new Symbol(sym.NUMERO_FLOAT, yycolumn, yyline, yytext());}

{LITERAL} {return new Symbol(sym.LITERAL, yycolumn, yyline, yytext());}

( long ) {return new Symbol(sym.LONG, yycolumn, yyline, yytext());}

( int ) {return new Symbol(sym.INT, yycolumn, yyline, yytext());}

( char ) {return new Symbol(sym.CHAR, yycolumn, yyline, yytext());}

( float ) {return new Symbol(sym.FLOAT, yycolumn, yyline, yytext());}

( double ) {return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext());}

( short ) {return new Symbol(sym.SHORT, yycolumn, yyline, yytext());}

/*  INSTRUCCIONES   */

( read ) {return new Symbol(sym.READ, yycolumn, yyline, yytext());}

( write ) {return new Symbol(sym.WRITE, yycolumn, yyline, yytext());}

/* Palabra reservada If */
( if ) {return new Symbol(sym.IF, yycolumn, yyline, yytext());}

/* Palabra reservada Else */
( else ) {return new Symbol(sym.ELSE, yycolumn, yyline, yytext());}

/* Palabra reservada Do */
( do ) {return new Symbol(sym.DO, yycolumn, yyline, yytext());}

/* Palabra reservada While */
( while ) {return new Symbol(sym.WHILE, yycolumn, yyline, yytext());}

/* Palabra reservada For */
( for ) {return new Symbol(sym.FOR, yycolumn, yyline, yytext());}

( break ) {return new Symbol(sym.BREAK, yycolumn, yyline, yytext());}

( case ) {return new Symbol(sym.CASE, yycolumn, yyline, yytext());}

( const ) {return new Symbol(sym.CONST, yycolumn, yyline, yytext());}

( continue ) {return new Symbol(sym.CONTINUE, yycolumn, yyline, yytext());}

( default ) {return new Symbol(sym.DEFAULT, yycolumn, yyline, yytext());}

( return ) {return new Symbol(sym.RETURN, yycolumn, yyline, yytext());}

( switch ) {return new Symbol(sym.SWITCH, yycolumn, yyline, yytext());}

( void ) {return new Symbol(sym.VOID, yycolumn, yyline, yytext());}



{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}

( "=" ) {return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}

( "+" ) {return new Symbol(sym.SUMA, yycolumn, yyline, yytext());}

( "-" ) {return new Symbol(sym.RESTA, yycolumn, yyline, yytext());}

( "*" ) {return new Symbol(sym.MULTIPLICACION, yycolumn, yyline, yytext());}

( "/" ) {return new Symbol(sym.DIVISION, yycolumn, yyline, yytext());}

( ":" ) {return new Symbol(sym.DOSPUNTOS, yycolumn, yyline, yytext());}

( "%" ) {return new Symbol(sym.MODULO, yycolumn, yyline, yytext());}

// OPERADORES BOOLEANOS


( "&&" | "||" | "&" | "|" ) {return new Symbol(sym.OP_LOGICO, yycolumn, yyline, yytext());}
("!") {return new Symbol(sym.OP_NEGACION, yycolumn, yyline, yytext());}

( ">" | "<" | "==" | "!=" | ">=" | "<=" ) {return new Symbol(sym.OP_RELACIONAL, yycolumn, yyline, yytext());}

( true | false ) {return new Symbol(sym.OP_BOOLEANO, yycolumn, yyline, yytext());}

// OPERADORES ARITMETICOS

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {return new Symbol(sym.OP_ATRIBUCION, yycolumn, yyline, yytext());}
/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.OP_INCDEC, yycolumn, yyline, yytext());}

( "(" ) {return new Symbol(sym.PARIZQ, yycolumn, yyline, yytext());}

( ")" ) {return new Symbol(sym.PARDER, yycolumn, yyline, yytext());}

( "{" ) {return new Symbol(sym.LLAVEIZQ, yycolumn, yyline, yytext());}

( "}" ) {return new Symbol(sym.LLAVEDER, yycolumn, yyline, yytext());}

( "[" ) {return new Symbol(sym.CORCHETEIZQ, yycolumn, yyline, yytext());}

( "]" ) {return new Symbol(sym.CORCHETEDER, yycolumn, yyline, yytext());}

( ";" ) {return new Symbol(sym.PCOMA, yycolumn, yyline, yytext());}

( "," ) {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}

{IGNORAR} {
 	//ignorar
}

{SALTO} {
    //ignorar
}
{ERROR} {
            //System.out.println("Error causado por " + yytext() + " en la línea " + yyline);
            return new Symbol(sym.ERROR, yycolumn, yyline, yytext());
         }

