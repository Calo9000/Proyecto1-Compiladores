// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: Documents/Proyecto1-Compiladores/src/analizadorlexico/alexico.flex

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




// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class AnalizadorLexico {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\3\1\4\22\0\1\5\1\6"+
    "\1\7\1\10\1\0\1\6\1\11\1\12\2\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\7\23\2\24"+
    "\2\13\1\25\1\26\1\27\1\13\1\0\4\30\1\31"+
    "\1\30\21\32\1\33\2\32\1\13\1\34\1\13\1\6"+
    "\2\0\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\32\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\32\1\54\1\55\1\56\1\57\1\60\1\61"+
    "\1\62\1\63\1\64\1\13\1\65\2\13\6\0\1\3"+
    "\u01a2\0\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\2\1\1\3\1\1\5\3"+
    "\2\4\2\3\20\5\1\3\1\0\1\6\11\0\1\7"+
    "\1\0\2\1\1\4\6\5\1\10\4\5\1\10\13\5"+
    "\3\0\2\11\1\12\2\13\1\4\30\5\2\0\16\5"+
    "\2\0\7\5\2\0\2\5\1\10";

  private static int [] zzUnpackAction() {
    int [] result = new int[137];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\66\0\154\0\66\0\242\0\330\0\u010e\0\u0144"+
    "\0\u017a\0\66\0\u01b0\0\154\0\u01e6\0\u021c\0\u0252\0\u0288"+
    "\0\u02be\0\u02f4\0\u032a\0\u0360\0\u0396\0\u03cc\0\u0402\0\u0438"+
    "\0\u046e\0\u04a4\0\u04da\0\u0510\0\u0546\0\u057c\0\u05b2\0\u05e8"+
    "\0\u061e\0\u0654\0\u068a\0\330\0\66\0\u06c0\0\u06f6\0\u072c"+
    "\0\u0762\0\u0798\0\u07ce\0\u0804\0\u083a\0\u0870\0\u08a6\0\u08dc"+
    "\0\u0912\0\u0948\0\u097e\0\u09b4\0\u09ea\0\u0a20\0\u0a56\0\u0a8c"+
    "\0\u0ac2\0\u0af8\0\u0b2e\0\u0b64\0\u0b9a\0\u0bd0\0\u032a\0\u0c06"+
    "\0\u0c3c\0\u0c72\0\u0ca8\0\u0cde\0\u0d14\0\u0d4a\0\u0d80\0\u0db6"+
    "\0\u0dec\0\u0e22\0\u0e58\0\u0e8e\0\u0ec4\0\66\0\u0efa\0\u0870"+
    "\0\u0f30\0\u0948\0\u0f66\0\u0f9c\0\u0fd2\0\u1008\0\u103e\0\u1074"+
    "\0\u10aa\0\u10e0\0\u1116\0\u114c\0\u1182\0\u11b8\0\u11ee\0\u1224"+
    "\0\u125a\0\u1290\0\u12c6\0\u12fc\0\u1332\0\u1368\0\u139e\0\u13d4"+
    "\0\u140a\0\u1440\0\u1476\0\u14ac\0\u14e2\0\u1518\0\u154e\0\u1584"+
    "\0\u15ba\0\u15f0\0\u1626\0\u165c\0\u1692\0\u16c8\0\u16fe\0\u1734"+
    "\0\u176a\0\u17a0\0\u17d6\0\u180c\0\u1842\0\u1878\0\u18ae\0\u18e4"+
    "\0\u191a\0\u1950\0\u1986\0\u19bc\0\u19f2\0\u1a28\0\u1a5e\0\u1a94"+
    "\0\66";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[137];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\0\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\5\1\13\1\14\1\15\1\12"+
    "\1\16\1\17\2\20\1\21\1\5\1\22\4\23\1\2"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\23"+
    "\1\33\1\23\1\34\4\23\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\3\23\1\43\67\0\2\3\1\0\1\3"+
    "\11\0\1\3\75\0\1\12\37\0\2\44\1\0\4\44"+
    "\1\45\24\44\1\46\31\44\40\0\1\47\4\0\1\50"+
    "\31\0\1\12\14\0\1\12\37\0\7\51\1\0\24\51"+
    "\1\52\31\51\15\0\1\12\10\0\1\12\56\0\1\12"+
    "\2\0\3\53\1\0\2\12\4\53\1\0\30\53\15\0"+
    "\1\54\4\0\1\55\4\0\1\12\57\0\1\56\1\0"+
    "\2\57\1\60\3\0\3\61\1\62\1\0\25\61\1\62"+
    "\2\61\21\0\1\56\1\0\3\20\3\0\1\61\1\63"+
    "\2\61\1\0\30\61\26\0\1\5\1\12\65\0\1\12"+
    "\1\5\56\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\30\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\22\23\1\64\5\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\17\23\1\65\10\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\1\66\6\23\1\67\5\23"+
    "\1\70\12\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\4\23\1\71\10\23\1\72\12\23\21\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\12\23\1\66\1\23"+
    "\1\73\10\23\1\74\2\23\21\0\1\56\1\0\3\23"+
    "\3\0\4\23\1\0\12\23\1\75\2\23\1\76\12\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\15\23"+
    "\1\64\12\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\5\23\1\77\6\23\1\100\13\23\21\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\15\23\1\101\12\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\4\23"+
    "\1\102\23\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\7\23\1\103\1\104\10\23\1\105\2\23\1\106"+
    "\3\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\26\23\1\107\1\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\14\23\1\110\13\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\15\23\1\111\12\23\21\0"+
    "\1\56\1\0\3\23\3\0\4\23\1\0\7\23\1\112"+
    "\20\23\27\0\1\12\36\0\1\12\3\44\2\0\61\44"+
    "\41\0\1\113\75\0\1\114\26\0\1\45\53\0\2\51"+
    "\3\0\61\51\20\0\1\56\1\0\3\53\3\0\4\53"+
    "\1\0\30\53\1\0\14\54\1\115\51\54\2\55\1\116"+
    "\1\55\1\117\61\55\22\0\3\120\3\0\4\120\1\0"+
    "\30\120\21\0\1\56\1\0\2\57\1\60\3\0\4\61"+
    "\1\0\30\61\21\0\1\56\1\0\3\60\3\0\4\61"+
    "\1\0\30\61\21\0\1\56\1\0\3\53\3\0\4\61"+
    "\1\0\30\61\21\0\1\56\1\0\3\121\3\0\2\122"+
    "\2\61\1\0\6\122\22\61\21\0\1\56\1\0\3\123"+
    "\3\0\4\61\1\0\30\61\21\0\1\56\1\0\3\23"+
    "\3\0\4\23\1\0\21\23\1\124\6\23\21\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\4\23\1\125\23\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\20\23"+
    "\1\126\7\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\1\76\27\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\14\23\1\127\13\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\5\23\1\130\22\23\21\0"+
    "\1\56\1\0\3\23\3\0\4\23\1\0\22\23\1\131"+
    "\5\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\22\23\1\132\5\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\21\23\1\133\6\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\15\23\1\134\12\23\21\0"+
    "\1\56\1\0\3\23\3\0\4\23\1\0\17\23\1\77"+
    "\10\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\21\23\1\77\6\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\14\23\1\135\13\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\6\23\1\136\12\23\1\137"+
    "\6\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\15\23\1\140\12\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\6\23\1\141\20\23\1\142\21\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\1\143\16\23\1\144"+
    "\10\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\10\23\1\145\17\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\16\23\1\146\11\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\10\23\1\147\7\23\1\150"+
    "\7\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\10\23\1\151\1\23\1\152\15\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\10\23\1\153\17\23\43\0"+
    "\1\154\62\0\1\155\26\0\14\54\1\115\4\54\1\116"+
    "\44\54\2\0\1\116\103\0\1\56\1\0\3\121\3\0"+
    "\2\121\2\53\1\0\6\121\22\53\21\0\1\56\1\0"+
    "\3\123\3\0\4\53\1\0\30\53\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\15\23\1\77\12\23\21\0"+
    "\1\56\1\0\3\23\3\0\4\23\1\0\1\156\27\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\4\23"+
    "\1\77\23\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\20\23\1\100\1\157\6\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\1\160\27\23\21\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\1\23\1\153\26\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\13\23"+
    "\1\77\14\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\4\23\1\161\23\23\21\0\1\56\1\0\3\23"+
    "\3\0\4\23\1\0\1\100\27\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\6\23\1\77\21\23\21\0"+
    "\1\56\1\0\3\23\3\0\4\23\1\0\10\23\1\162"+
    "\17\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\22\23\1\161\5\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\17\23\1\100\10\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\14\23\1\163\13\23\21\0"+
    "\1\56\1\0\3\23\3\0\4\23\1\0\4\23\1\164"+
    "\23\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\21\23\1\165\6\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\22\23\1\166\5\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\21\23\1\167\6\23\21\0"+
    "\1\56\1\0\3\23\3\0\4\23\1\0\4\23\1\170"+
    "\23\23\21\0\1\56\1\0\3\23\3\0\4\23\1\0"+
    "\15\23\1\171\12\23\21\0\1\56\1\0\3\23\3\0"+
    "\4\23\1\0\10\23\1\172\17\23\21\0\1\56\1\0"+
    "\3\23\3\0\4\23\1\0\3\23\1\77\24\23\21\0"+
    "\1\56\1\0\3\23\3\0\4\23\1\0\1\173\27\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\12\23"+
    "\1\126\15\23\46\0\1\174\67\0\1\175\36\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\11\23\1\77\16\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\10\23"+
    "\1\176\17\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\22\23\1\177\5\23\21\0\1\56\1\0\3\23"+
    "\3\0\4\23\1\0\17\23\1\171\10\23\21\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\20\23\1\200\7\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\4\23"+
    "\1\151\23\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\15\23\1\201\12\23\21\0\1\56\1\0\3\23"+
    "\3\0\4\23\1\0\10\23\1\202\17\23\21\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\2\23\1\100\25\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\2\23"+
    "\1\203\25\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\3\23\1\204\24\23\21\0\1\56\1\0\3\23"+
    "\3\0\4\23\1\0\14\23\1\77\13\23\21\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\6\23\1\141\21\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\21\23"+
    "\1\112\6\23\52\0\1\205\73\0\1\206\26\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\14\23\1\207\13\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\12\23"+
    "\1\100\15\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\21\23\1\210\6\23\21\0\1\56\1\0\3\23"+
    "\3\0\4\23\1\0\5\23\1\77\22\23\21\0\1\56"+
    "\1\0\3\23\3\0\4\23\1\0\2\23\1\77\25\23"+
    "\21\0\1\56\1\0\3\23\3\0\4\23\1\0\7\23"+
    "\1\77\20\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\4\23\1\201\23\23\42\0\1\211\64\0\1\205"+
    "\45\0\1\56\1\0\3\23\3\0\4\23\1\0\22\23"+
    "\1\126\5\23\21\0\1\56\1\0\3\23\3\0\4\23"+
    "\1\0\4\23\1\76\23\23\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6858];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\5\1\1\11\31\1\1\0"+
    "\1\11\11\0\1\1\1\0\32\1\3\0\1\11\35\1"+
    "\2\0\16\1\2\0\7\1\2\0\2\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[137];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
      contador = 0;
	tokens = new ArrayList<Yytoken>();
    errores = new ArrayList<Yytoken>();
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
	try{
		this.writeOutputFile();
        System.exit(0);
	}catch(IOException ioe){
		ioe.printStackTrace();
	}
    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Yytoken nextToken() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { contador++;
    Yytoken t = new Yytoken(yytext(),yyline);
    errores.add(t);
    return t;
            }
            // fall through
          case 12: break;
          case 2:
            { //ignorar
            }
            // fall through
          case 13: break;
          case 3:
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"OPERADOR",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
            // fall through
          case 14: break;
          case 4:
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"INT",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
            // fall through
          case 15: break;
          case 5:
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"IDENTIFICADOR",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
            // fall through
          case 16: break;
          case 6:
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"LITERAL",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
            // fall through
          case 17: break;
          case 7:
            { contador++;
    Yytoken t = new Yytoken(contador, yytext(), "NUM_OCT",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
            // fall through
          case 18: break;
          case 8:
            { contador++;
    Yytoken t = new Yytoken(contador,yytext(),"PALABRA_RESERVADA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
            // fall through
          case 19: break;
          case 9:
            { //Ignorar
            }
            // fall through
          case 20: break;
          case 10:
            { contador++;
    Yytoken t = new Yytoken(contador, yytext(), "NUM_FLOAT",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
            // fall through
          case 21: break;
          case 11:
            { contador++;
    Yytoken t = new Yytoken(contador, yytext(), "NUM_HEX",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
            // fall through
          case 22: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
