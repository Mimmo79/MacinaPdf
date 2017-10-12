/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macinapdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SenMa
 */

public class Main {

    static String fileParam="C:\\Users\\Massi\\XAMPP\\htdocs\\MacinaPdf\\src\\macinapdf\\parametri";//C:\\Users\\Massi\\XAMPP\\htdocs\\MacinaPdf\\src\\macinapdf---C:\\Users\\senma\\Documents\\NetBeansProjects\\MacinaPdf\\src\\macinapdf
   
    public static String nomeFile;
    public static String dbUrl;
    public static String dbUser;
    public static String dbPwd;
    public static String dbName;
    public static String tab;
    public static String nome_campo_linea;
   
    
    public static void pullParameters(){
        Properties props = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileParam); 
            props.load(in);

        } catch (FileNotFoundException ex) {

            Logger lgr = Logger.getLogger(MacinaPdf.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } catch (IOException ex) {

            Logger lgr = Logger.getLogger(MacinaPdf.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {
                 if (in != null) {
                     in.close();
                 }
            } catch (IOException ex) {
                Logger lgr = Logger.getLogger(MacinaPdf.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

        dbUrl = props.getProperty("dbUrl");
        dbName = props.getProperty("dbName");
        dbUser = props.getProperty("dbUser");
        dbPwd = props.getProperty("dbPwd");
        nomeFile = props.getProperty("nomeFile");
        tab = props.getProperty("tab");
        nome_campo_linea = props.getProperty("nome_campo_linea");
        
    }
    
    
    
    public static void main(String[] args) throws Exception {
        
        pullParameters();   //carico i parametri

        //converto il file in .txt
        MacinaPdf.macina(nomeFile);
        String data[][] = Scansionatore.scansiona(nomeFile);                //elaboro il pdf ed estraggo i dati in un array, estraggo i dati e li salvo in un array bidimensionale
        Excel.compilaExcel(data);                                           //passo l'array ad un methodo per la scrittura su un file excel

       
    } 
}