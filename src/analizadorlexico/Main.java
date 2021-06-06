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
import java.util.Scanner;
import java_cup.runtime.Symbol;
/**
 *
 * @author franc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Ingrese el nombre del archivo de texto: \n");
        Scanner in = new Scanner(System.in);
        String entrada = in.nextLine();
        String[] archivo = {entrada};
        parser.main(archivo);

        System.out.println("\n Ejecucion finalizada... \n");
        
        
    }
    
}
