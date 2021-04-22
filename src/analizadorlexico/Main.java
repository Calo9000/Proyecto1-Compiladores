/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author franc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String entrada = "";
        entrada = "entrada.txt";
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(entrada));
            AnalizadorLexico a = new AnalizadorLexico(bf);
            Yytoken token = null;
            do {
                token =  a.nextToken();
                System.out.println(token);
            } while (token != null);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bf.close();
            } catch (IOException ex){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("\n Ejecucion finalizada... \n");

    }
    
}
