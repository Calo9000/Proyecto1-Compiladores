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
    System.out.println("analizando archivo");
%init}

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
{NUMERO} {return new Symbol(sym.NUMERO, yychar, yyline, yytext());}

{NUMERO_OCTAL} {return new Symbol(sym.NUMERO_OCT, yychar, yyline, yytext());}

{NUMERO_HEX} {return new Symbol(sym.NUMERO_HEX, yychar, yyline, yytext());}

{NUMERO_FLOTANTE} {return new Symbol(sym.NUMERO_FLOAT, yychar, yyline, yytext());}

{LITERAL} {return new Symbol(sym.LITERAL, yychar, yyline, yytext());}

( long ) {return new Symbol(sym.LONG, yychar, yyline, yytext());}

( int ) {return new Symbol(sym.INT, yychar, yyline, yytext());}

( char ) {return new Symbol(sym.CHAR, yychar, yyline, yytext());}

( float ) {return new Symbol(sym.FLOAT, yychar, yyline, yytext());}

( double ) {return new Symbol(sym.DOUBLE, yychar, yyline, yytext());}

( short ) {return new Symbol(sym.SHORT, yychar, yyline, yytext());}

/* Palabra reservada If */
( if ) {return new Symbol(sym.IF, yychar, yyline, yytext());}

/* Palabra reservada Else */
( else ) {return new Symbol(sym.ELSE, yychar, yyline, yytext());}

/* Palabra reservada Do */
( do ) {return new Symbol(sym.DO, yychar, yyline, yytext());}

/* Palabra reservada While */
( while ) {return new Symbol(sym.WHILE, yychar, yyline, yytext());}

/* Palabra reservada For */
( for ) {return new Symbol(sym.FOR, yychar, yyline, yytext());}

( break ) {return new Symbol(sym.BREAK, yychar, yyline, yytext());}

( case ) {return new Symbol(sym.CASE, yychar, yyline, yytext());}

( const ) {return new Symbol(sym.CONST, yychar, yyline, yytext());}

( continue ) {return new Symbol(sym.CONTINUE, yychar, yyline, yytext());}

( default ) {return new Symbol(sym.DEFAULT, yychar, yyline, yytext());}

( return ) {return new Symbol(sym.RETURN, yychar, yyline, yytext());}

( switch ) {return new Symbol(sym.SWITCH, yychar, yyline, yytext());}

( void ) {return new Symbol(sym.VOID, yychar, yyline, yytext());}

{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yychar, yyline, yytext());}

/* Operador Igual */
( "=" ) {return new Symbol(sym.IGUAL, yychar, yyline, yytext());}

/* Operador Suma */
( "+" ) {return new Symbol(sym.SUMA, yychar, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.RESTA, yychar, yyline, yytext());}

/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.MULTIPLICACION, yychar, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.DIVISION, yychar, yyline, yytext());}

// OPERADORES BOOLEANOS

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {return new Symbol(sym.OP_LOGICO, yychar, yyline, yytext());}
/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {return new Symbol(sym.OP_RELACIONAL, yychar, yyline, yytext());}
/*Operadores Booleanos*/
( true | false ) {return new Symbol(sym.OP_BOOLEANO, yychar, yyline, yytext());}

// OPERADORES ARITMETICOS

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {return new Symbol(sym.OP_ATRIBUCION, yychar, yyline, yytext());}
/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.OP_INCDEC, yychar, yyline, yytext());}

( "(" ) {return new Symbol(sym.PARIZQ, yychar, yyline, yytext());}

( ")" ) {return new Symbol(sym.PARDER, yychar, yyline, yytext());}

( "{" ) {return new Symbol(sym.LLAVEIZQ, yychar, yyline, yytext());}

( "}" ) {return new Symbol(sym.LLAVEDER, yychar, yyline, yytext());}

( "[" ) {return new Symbol(sym.CORCHETEIZQ, yychar, yyline, yytext());}

( "]" ) {return new Symbol(sym.CORCHETEDER, yychar, yyline, yytext());}

( ";" ) {return new Symbol(sym.PCOMA, yychar, yyline, yytext());}

( "," ) {return new Symbol(sym.COMA, yychar, yyline, yytext());}



{IGNORAR} {
 	//ignorar
}

{SALTO} {
    //ignorar
}
{ERROR} {
            System.out.println("Error causado por " + yytext() + " en la línea " + yyline);
            return new Symbol(sym.ERROR, yychar, yyline, yytext());
         }

