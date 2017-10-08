/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macinapdf;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


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

public class MacinaPdf {
    // C:\\Users\\Massi\\Desktop\\Telecom\\
    public static String nomeFile="C:\\Users\\massi\\Desktop\\File Telecom\\TICRMB_2017_C40_4220517800019165";
    static String url;

    public void pullParameters(){
        Properties props = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("C:\\Users\\Massi\\XAMPP\\htdocs\\MacinaPdf\\src\\macinapdf\\parametri");
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

        url = props.getProperty("host");
        System.out.println(url );
    }
    
    
    
    public static void main(String[] args) throws Exception {   
       //converto il file in .txt
       File file = new File(nomeFile+".pdf");                       // apro il file .pdf
       PDDocument inputDoc= PDDocument.load(file);   
       PDFTextStripper stripper = new PDFTextStripper();            // lo strippo
       PrintWriter outputStream = new PrintWriter(new FileWriter(nomeFile+".txt"));
       outputStream.println(stripper.getText(inputDoc));            // salvo lo strippo in un .txt
       outputStream.close();
       String [][] data = Scansionatore.scansiona();            //elaboro il pdf ed estraggo i dati in un array, estraggo i dati e li salvo in un array bidimensionale
       Excel.compilaExcel(data);                                //passo l'array ad un methodo per la scrittura su un file excel
     
       
    } 
}