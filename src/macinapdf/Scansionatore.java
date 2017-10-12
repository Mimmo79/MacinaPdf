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

    public static String id_0="CAP SPESA";
    public static String id_1="CdR";
    public static String id_2="CdG";
    public static String id_3="RIL. IVA";
    public static String id_4="IMPEGNO";
    public static String id_5="NOTE";
    
    public static String id0="Linea numero";
    public static String id1="TOTALE CONTRIBUTI E ABBONAMENTI";
    public static String id2="TOTALE TRAFFICO";
    public static String id3="TOTALE ALTRI ADDEBITI E ACCREDITI";
    public static String id4="TOTALE -";
    public static String id5="TOTALE +";
    public static String id6="F.C.IVA";
    
    public static String id20="Fattura bimestrale";

    
    public static int n_row=1;  // nella prima riga ci sono le intestazioni
    public static boolean n_FCIVA=true;
    public static float val_FCIVA=0;
    public static String[][] importiFatt = new String[500][11];
    public static String[][] datiDB = new String[500][11];
    
    
    /*
    formato dell'array risultato
    La prima riga contiene l'intestazione
    [id1][id2][id3][id4][id5/6][id7]...
    */
    
    public static void scansiona(String nomeFile) {

        try {   
            // apro il file .txt in lettura
            BufferedReader inputStream = new BufferedReader( new FileReader(nomeFile+".txt"));
            Scanner in = new Scanner(inputStream);
            // apro il file -elab1.txt in cui riverso i dati elaborati
            PrintWriter outputStream = new PrintWriter(new FileWriter(nomeFile+"-elab1.txt"));
            
            //cerco i dati di intestazione
            while (in.hasNextLine()) {
                line = in.nextLine();
                if (line.contains(id20)){
                    line = in.nextLine();
                    Scanner riga = new Scanner(line);
                    String bim = riga.next();                   //bimestre
                    String anno = riga.next().replace(":","");  //anno
                    line = in.nextLine();
                    riga = new Scanner(line);
                    riga.next();riga.next();
                    String nFatt = riga.next();                 //n. fattura
                    System.out.println(bim+anno+nFatt);
                
                break;
                }
            }
            

            //salto la prima parte del documento
            while (in.hasNextLine()) {
                line = in.nextLine();
                if (line.contains(id0))
                    break;
            }
       
        
            // scansiono la parte in cui compaiono i report fattura
            while (in.hasNextLine()) {
              
                if (line.contains(id0)){
                    outputStream.println(" ");
                    outputStream.println("id0 "+line);

                   //inizializzo le celle per evitare i valori null che danno errore con la conversione in numeri
                    int i;
                    for (i=0; i<10; i++){
                        importiFatt[n_row][i]="0";
                    }                    
             
                    Scanner riga = new Scanner(line);
                    //salto i campi che non mi interressano
                    riga.next(); riga.next();
                    //memorizzo il campo 
                    String Num = riga.next();
                    //System.out.println(Num);
                    importiFatt[n_row][0]=Num;
                    
                    //dati DB
                    if (Mysql.esisteRecord(MacinaPdf.dbName,MacinaPdf.tab,MacinaPdf.nome_campo_linea,Num)) {
                        datiDB[n_row][0] = Mysql.recuperaRecord(MacinaPdf.dbName,MacinaPdf.tab,MacinaPdf.nome_campo_linea,Num,"cap_spesa");
                        datiDB[n_row][1] = Mysql.recuperaRecord(MacinaPdf.dbName,MacinaPdf.tab,MacinaPdf.nome_campo_linea,Num,"cdr");
                        datiDB[n_row][2] = Mysql.recuperaRecord(MacinaPdf.dbName,MacinaPdf.tab,MacinaPdf.nome_campo_linea,Num,"cdg");
                        datiDB[n_row][3] = Mysql.recuperaRecord(MacinaPdf.dbName,MacinaPdf.tab,MacinaPdf.nome_campo_linea,Num,"ril_iva");
                        datiDB[n_row][4] = Mysql.recuperaRecord(MacinaPdf.dbName,MacinaPdf.tab,MacinaPdf.nome_campo_linea,Num,"impegno");
                        datiDB[n_row][5] = Mysql.recuperaRecord(MacinaPdf.dbName,MacinaPdf.tab,MacinaPdf.nome_campo_linea,Num,"note");
                    } else {
                        for (i=0; i<6; i++){      
                            datiDB[n_row][i] = "dato non presente";
                        }
                    }
      
                     
                    n_row++;
                    val_FCIVA=0;    //valore somma di tutti i FCIVA relativi ad un numero
                    n_FCIVA=true;   //controllo di FCIVA multipli

                } else if (line.contains(id1)){
                    outputStream.println("id1 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next(); riga.next(); riga.next(); riga.next();
                    String Tot_Con = riga.next();
                    //System.out.println(Tot_Con);
                    importiFatt[n_row-1][1]=Tot_Con.replace(".","").replace(",",".");  //il primo elimina i punti, il secondo converte le virgole in punti

                    
                } else if (line.contains(id2)){
                    outputStream.println("id2 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next(); riga.next();
                    String Tot_Traff = riga.next();
                    //System.out.println(Tot_Traff);
                    importiFatt[n_row-1][2]=Tot_Traff.replace(".","").replace(",",".");
 
                } else if (line.contains(id3)){
                    outputStream.println("id3 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next(); riga.next(); riga.next(); riga.next(); riga.next();
                    String Tot_Altri = riga.next();
                    //System.out.println(Tot_Altri);
                    importiFatt[n_row-1][3]=Tot_Altri.replace(".","").replace(",",".");
                    
                } else if (line.contains(id4)||line.contains(id5)){
                    outputStream.println("id4/id5 "+line);
                    
                    Scanner riga = new Scanner(line);
                    riga.next();
                    String Tot = riga.next();
                    //System.out.println(Tot);
                    importiFatt[n_row-1][4]=Tot.replace(".","").replace(",",".");
                    
                } else if (line.contains(id6)){
                    outputStream.println("id6 "+line);
                    
                    Scanner riga = new Scanner(line);
                    //rilevo il valore del fuori campo iva
                    String a = riga.next();
                    String b = riga.next();
                    while (!b.equals(id6)){
                    a=b;
                    b = riga.next();                    
                    }
                    //System.out.println(a);

                    importiFatt[n_row-1][5]=a.replace(".","").replace(",",".");   // il fuori F.C.IVA occupa i campi dal 12 in su
                    
                    // sommo i F.C.IVA multipli
                    if (n_FCIVA){
                        val_FCIVA = Float.parseFloat(importiFatt[n_row-1][5]);
                    } else {
                        val_FCIVA = val_FCIVA + Float.parseFloat(importiFatt[n_row-1][5]);
                        importiFatt[n_row-1][5]=Float.toString(val_FCIVA);
                        System.out.println("FCIVA : "+val_FCIVA+" "+importiFatt[n_row-1][5]);
                    }
                    
                    n_FCIVA=false;
                }                  
            
            line = in.nextLine();
                
            }
            
        outputStream.close();        
        inputStream.close();
        
        } catch(IOException e){
            JOptionPane.showMessageDialog(null,"Scansionatore.scansiona ** "+e);
        }
                
    //intestazione
    importiFatt[0][0]=id0;    
    importiFatt[0][1]=id1;
    importiFatt[0][2]=id2;    
    importiFatt[0][3]=id3;
    importiFatt[0][4]=id4;
    importiFatt[0][5]=id5;
    importiFatt[0][6]=id6;
    importiFatt[0][7]=id6;
    importiFatt[0][8]=id6;

    //intestazione    
    datiDB[0][0]=id_0;
    datiDB[0][1]=id_1;
    datiDB[0][2]=id_2;
    datiDB[0][3]=id_3;
    datiDB[0][4]=id_4;
    datiDB[0][5]=id_5;


    }
}
  



