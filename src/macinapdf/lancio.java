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
    
        
        //db-tab-campo-record
        System.out.println(Mysql.esisteRecord("telefonia","linee_fatture","num_linea","11111"));
        if (!Mysql.esisteRecord("telefonia","linee_fatture","num_linea","11111")) 
            Mysql.inserisciRecord("telefonia","linee_fatture","num_linea","11111");
    }
    
}
