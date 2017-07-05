package macinapdf;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;



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
    public static String id5="TOTALE";
    public static String id6="F.C.IVA";
       
    public static void scansiona(){
         

        try {   
            // apro il file in lettura
            BufferedReader inputStream = new BufferedReader( new FileReader(MacinaPdf.nomeFile+".txt"));
            Scanner in = new Scanner(inputStream);
            // apro il file in cui riverso i dati elaborati
            PrintWriter outputStream = new PrintWriter(new FileWriter(MacinaPdf.nomeFile+"-elab1.txt"));
            
        
            // se c'è una nuova linea eseguo il codice
            while (in.hasNextLine()) {
                
                /*
                Analizzo linea per linea,
                se una linea contiene il codice che cerco (es. "60\t3")eseguo il blocco
                "id1" codice identificativo del tipo di file:
                ricaricabile, ricaricabile personali, abbonamento
                */
                
                line = in.nextLine();
                
                if (line.contains(id1)||line.contains(id2)||
                    line.contains(id3)||line.contains(id4)||
                    line.contains(id5)||line.contains(id6)){
                    
                    if (line.contains(id1))
                        outputStream.println(" ");
                    outputStream.println(line);
                    
                    // "line" è una linea che devo scannerizzare
                    // eseguo un'altra istanza di "scanner"
                    Scanner riga = new Scanner(line);
                    //salto il campo vuoto
                    riga.next();
                    //memorizzo il campo telefono
                    String Tel = riga.next();
                    // comparo il numero di telefono con i numeri della rubrica
                }

            }
        outputStream.close();        
        inputStream.close(); 
        
        } catch(IOException e){
            JOptionPane.showMessageDialog(null,"Scansionatore.scansiona ** "+e);
        }
    }
    
}