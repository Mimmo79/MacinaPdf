/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macinapdf;

/**
 *
 * @author Massi
 */
public class lancio {
    public static void main(String[] args){
    
        String risultato;
        
        //db-tab-campo-record
        if (Mysql.esisteRecord("telefonia_fissa","linee_fatture_completo","n_linea","054363508")) {
            risultato = Mysql.recuperaRecord("telefonia_fissa","linee_fatture_completo","n_linea","054363508","cdvg");
            System.out.println(risultato);
        }
    }
    
}
