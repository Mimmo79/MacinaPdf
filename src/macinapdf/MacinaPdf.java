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

/**
 *
 * @author SenMa
 */

public class MacinaPdf {
    // C:\\Users\\Massi\\Desktop\\Telecom\\
    public static String nomeFile="C:\\Users\\senma\\Desktop\\File Telecom\\TICRMB_2017_C52_DOM_4220517X00000475";

    
    public static void main(String[] args) throws Exception {   
       //converto il file in .txt
       File file = new File(nomeFile+".pdf");                       // apro il file .pdf
       PDDocument inputDoc= PDDocument.load(file);   
       PDFTextStripper stripper = new PDFTextStripper();            // lo strippo
       PrintWriter outputStream = new PrintWriter(new FileWriter(nomeFile+".txt"));
       outputStream.println(stripper.getText(inputDoc));            // salvo lo strippo in un .txt
       outputStream.close();
       String [][] data = Scansionatore.scansiona();            //elaboro il pdf ed estraggo i dati in un array                                                                //estraggo i dati e li salvo in un array bidimensionale
       Excel.compilaExcel(data);                                //passo l'array ad un methodo per la scrittura su un file excel
     
    } 
}