/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macinapdf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author SenMa
 */

public class MacinaPdf {

    public static String nomeFile="C:\\Users\\Massi\\Desktop\\Telecom\\TICRMB_2017_C40_4220517800019165";

    
    public static void main(String[] args) throws Exception {   
       //converto il file in .txt
       File file = new File(nomeFile+".pdf");
       PDDocument inputDoc= PDDocument.load(file);   
       PDFTextStripper stripper = new PDFTextStripper();
       PrintWriter outputStream = new PrintWriter(new FileWriter(nomeFile+".txt"));
       outputStream.println(stripper.getText(inputDoc));
       outputStream.close();
       //ripulisco il file e lo savo con nome diverso
       //estraggo i dati e li salvo in un array bidimensionale
       String [][] data = Scansionatore.scansiona();
       //passo l'array ad un methodo per la scrittura su un file excel
       Excel.compilaExcel(data);
     
    } 
}