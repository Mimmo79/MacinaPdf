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

    public static String id0="CAP SPESA";
    public static String id1="CdR";
    public static String id2="CdG";
    public static String id3="RIL. IVA";
    public static String id4="IMPEGNO";
    public static String id5="NOTE";    
    public static String id6="Linea numero";
    public static String id7="TOTALE CONTRIBUTI E ABBONAMENTI";
    public static String id8="TOTALE TRAFFICO";
    public static String id9="TOTALE ALTRI ADDEBITI E ACCREDITI";
    public static String id10="TOTALE -";
    public static String id11="TOTALE +";
    public static String id12="F.C.IVA";

    
    public static int n_row=1;  // nella prima riga ci sono le intestazioni
    public static int n_FCIVA=0;
    public static String[][] data = new String[500][20];
    
    /*
    formato dell'array risultato
    La prima riga contiene l'intestazione
    [id1][id2][id3][id4][id5/6][id7]
    */
    
    public static String[][] scansiona() {

        try {   
            // apro il file .txt in lettura
            BufferedReader inputStream = new BufferedReader( new FileReader(MacinaPdf.nomeFile+".txt"));
            Scanner in = new Scanner(inputStream);
            // apro il file -elab1.txt in cui riverso i dati elaborati
            PrintWriter outputStream = new PrintWriter(new FileWriter(MacinaPdf.nomeFile+"-elab1.txt"));

            //salto la prima parte del documento
            while (in.hasNextLine()) {
                line = in.nextLine();
                if (line.contains(id6))
                    break;
            }
       
        
            // scansiono la parte in cui compaiono i report fattura
            while (in.hasNextLine()) {
              
                if (line.contains(id6)){
                    outputStream.println(" ");
                    outputStream.println("id6 "+line);

                   //inizializzo le celle per evitare i valori null che danno errore con la conversione in numeri
                    int i;
                    for (i=0; i<20; i++){
                        data[n_row][i]="0";
                    }                    
             
                    Scanner riga = new Scanner(line);
                    //salto i campi che non mi interressano
                    riga.next(); riga.next();
                    //memorizzo il campo 
                    String Num = riga.next();
                    //System.out.println(Num);
                    data[n_row][6]=Num;
                    
                    //dati DB
                    if (Mysql.esisteRecord("telefonia","fisso_dati_linee","n_linea",Num)) {
                        data[n_row][0] = Mysql.recuperaRecord("telefonia","fisso_dati_linee","n_linea",Num,"cap_spesa");
                    } else {
                        data[n_row][0] = id0 + " non presente";
                    }
      
                     
                    n_row++;
                    n_FCIVA=12; // punatore per i fuori campo iva

                } else if (line.contains(id7)){
                    outputStream.println("id7 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next(); riga.next(); riga.next(); riga.next();
                    String Tot_Con = riga.next();
                    //System.out.println(Tot_Con);
                    data[n_row-1][7]=Tot_Con.replace(".","").replace(",",".");  //il primo elimina i punti, il secondo converte le virgole in punti

                    
                } else if (line.contains(id8)){
                    outputStream.println("id8 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next(); riga.next();
                    String Tot_Traff = riga.next();
                    //System.out.println(Tot_Traff);
                    data[n_row-1][8]=Tot_Traff.replace(".","").replace(",",".");
 
                } else if (line.contains(id9)){
                    outputStream.println("id9 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next(); riga.next(); riga.next(); riga.next(); riga.next();
                    String Tot_Altri = riga.next();
                    //System.out.println(Tot_Altri);
                    data[n_row-1][9]=Tot_Altri.replace(".","").replace(",",".");
                    
                } else if (line.contains(id10)||line.contains(id11)){
                    outputStream.println("id10/id11 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next();
                    String Tot = riga.next();
                    //System.out.println(Tot);
                    data[n_row-1][11]=Tot.replace(".","").replace(",",".");
                    
                } else if (line.contains(id12)){
                    outputStream.println("id12 "+line);
                    
                    Scanner riga = new Scanner(line);
                    //rilevo il valore numero del fuori campo iva
                    String a = riga.next();
                    String b = riga.next();
                    while (!b.equals(id12)){
                    a=b;
                    b = riga.next();                    
                    }
                    //System.out.println(a);
                    data[n_row-1][n_FCIVA]=a.replace(".","").replace(",",".");   // il fuori F.C.IVA occupa i campi dal 12 in su
                    n_FCIVA++;
                }                  
            
            line = in.nextLine();
            
                
            }
            
        outputStream.close();        
        inputStream.close();


        
        } catch(IOException e){
            JOptionPane.showMessageDialog(null,"Scansionatore.scansiona ** "+e);
        }
                
    //intestazione
    data[0][0]=id0;    
    data[0][1]=id1;
    data[0][2]=id2;    
    data[0][3]=id3;
    data[0][4]=id4;
    data[0][5]=id5;
    data[0][6]=id6;
    data[0][7]=id7;
    data[0][8]=id8;
    data[0][9]=id9;
    data[0][10]=id10;
    data[0][11]=id11;
    data[0][12]=id12;
    data[0][13]=id12;
    data[0][14]=id12;
    data[0][15]=id12;
    
        
    return data;

//            STAMPA DEL ARRAY data
//            int rownum;
//            for (rownum = (short) 0; rownum < 500; rownum++) { 
//                for (short cellnum = (short) 0; cellnum < 10; cellnum += 1) {
//                    System.out.println(rownum+" "+cellnum+" "+data[rownum][cellnum]+" ");
//                }
//            System.out.println("\n");    
//            }
    
    


    }
}
  



