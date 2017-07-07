package macinapdf;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



/**
 *
 * @author massi
 */

public class Scansionatore {
    
    static String line = null;
    
    public static String id1="Linea numero";
    public static String id2="TOTALE CONTRIBUTI E ABBONAMENTI";
    public static String id3="TOTALE TRAFFICO";
    public static String id4="TOTALE ALTRI ADDEBITI E ACCREDITI";
    public static String id5="TOTALE -";
    public static String id6="TOTALE +";
    public static String id7="F.C.IVA";
    
    public static int n_row=0;
       
    public static void scansiona(){
        


        try {   
            // apro il file in lettura
            BufferedReader inputStream = new BufferedReader( new FileReader(MacinaPdf.nomeFile+".txt"));
            Scanner in = new Scanner(inputStream);
            // apro il file in cui riverso i dati elaborati
            PrintWriter outputStream = new PrintWriter(new FileWriter(MacinaPdf.nomeFile+"-elab1.txt"));


            Workbook wb = new HSSFWorkbook();
            Sheet sheet1 = wb.createSheet("new sheet");
            //Otteniamo una istanza di CreationHelper del nostro Workbook
            CreationHelper createHelper = wb.getCreationHelper();


            // Possiamo creare una cella e inserirci un valore in una sola riga di codice
            //row.createCell(2).setCellValue(
            //createHelper.createRichTextString("This is a string"));
            //row.createCell(3).setCellValue(true);
            //row.createCell(4).setCellValue("3,25");



            
        
            // se c'è una nuova linea eseguo il codice
            while (in.hasNextLine()) {
                
                // Creiamo la riga numero : "n_row"
                Row row = sheet1.createRow(n_row);
  
                
                /*
                Analizzo linea per linea,
                se una linea contiene il codice che cerco (es. "60\t3")eseguo il blocco
                "id1" codice identificativo del tipo di file:
                ricaricabile, ricaricabile personali, abbonamento
                */
                line = in.nextLine();
                
                if (line.contains(id1)){
                    outputStream.println(" ");
                    outputStream.println("id1 "+line);                    
             
                    Scanner riga = new Scanner(line);
                    //salto i campi che non mi interressano
                    riga.next(); riga.next();
                    //memorizzo il campo 
                    String Num = riga.next();
                    row.createCell(0).setCellValue("ciao");
                    //System.out.println(Num);

                }
                
                if (line.contains(id2)){
                    outputStream.println("id2 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next(); riga.next(); riga.next(); riga.next();
                    String Tot_Con = riga.next();
                    //System.out.println(Tot_Con);
                }

                if (line.contains(id3)){
                    outputStream.println("id3 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next(); riga.next();
                    String Tot_Traff = riga.next();
                    //System.out.println(Tot_Traff);                   
 
                }
                
                if (line.contains(id4)){
                    outputStream.println("id4 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next(); riga.next(); riga.next(); riga.next(); riga.next();
                    String Tot_Altri = riga.next();
                    //System.out.println(Tot_Altri);                    
                }
                
                if (line.contains(id5)||line.contains(id6)){
                    outputStream.println("id5/id6 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next();
                    String Tot = riga.next();
                    //System.out.println(Tot);                    
                }
          
                if (line.contains(id7)){
                    outputStream.println("id7 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next();
                    String FCIVA = riga.next();
                    //System.out.println(FCIVA); 
                }                  
            
            n_row++;
            }
        outputStream.close();        
        inputStream.close();
        
        FileOutputStream fileXLSOut = new FileOutputStream(MacinaPdf.nomeFile+".xls");
        wb.write(fileXLSOut);
        fileXLSOut.close();        
        
        } catch(IOException e){
            JOptionPane.showMessageDialog(null,"Scansionatore.scansiona ** "+e);
        }
    }
    
}
