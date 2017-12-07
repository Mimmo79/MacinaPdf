/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macinapdf;

   

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static macinapdf.Excel.rownum;

public class Mysql {

    
    public static boolean esisteRecord (String db, String tabella, String campo, String record){

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            
            con = DriverManager.getConnection(Main.dbUrl, Main.dbUser, Main.dbPwd);
            st = con.createStatement();
            rs = st.executeQuery("select * from "+db+"."+tabella+" where "+campo+"="+record+"");
            result = rs.next();

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            
            try {
                
                if (rs != null)
                    rs.close();
                
                if (st != null)
                    st.close();
                            
                if (con != null) 
                    con.close();
                              
            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(Mysql.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    
        return result;
    }
        
    public static void inserisciRecord (String db, String tabella, String campo, String record){
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            
            con = DriverManager.getConnection(Main.dbUrl, Main.dbUser, Main.dbPwd);
            st = con.createStatement();
            st.executeUpdate("INSERT INTO " + db + "." + tabella + " ( "+campo+" ) VALUES ("+record+")");
            

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            
            try {
                
                if (rs != null)
                    rs.close();
                
                if (st != null)
                    st.close();
                            
                if (con != null) 
                    con.close();
                              
            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(Mysql.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
    }
    
    public static String recuperaRecord (String db, String tabella, String campo, String record_ricercato, String campo_recupero){
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String result = null;

        try {
            
            con = DriverManager.getConnection(Main.dbUrl, Main.dbUser, Main.dbPwd);
            st = con.createStatement();
            rs = st.executeQuery("select * from "+db+"."+tabella+" where "+campo+"="+record_ricercato+"");
            if (rs.next()){
                result=rs.getString(campo_recupero);
            }
            
            

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            
            try {
                
                if (rs != null)
                    rs.close();
                
                if (st != null)
                    st.close();
                            
                if (con != null) 
                    con.close();
                              
            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(Mysql.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        return result;
        
    }
        
    public static String recuperaRecordJoin (String db, String tabellaA, String tabellaB, String campo, String record_ricercato, String campo_recupero){
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String result = null;

        try {
            
            con = DriverManager.getConnection(Main.dbUrl, Main.dbUser, Main.dbPwd);
            st = con.createStatement();
            //System.out.println( );
            rs = st.executeQuery(   "SELECT a.* " +
                        "FROM " + db + "." + tabellaA + " AS a " +
                        "INNER JOIN " + db + "." + tabellaB + " AS b " +
                        "ON a.id=b." + campo_recupero + 
                        " WHERE " + campo +
                        "=" + record_ricercato +"");

            if (rs.next()){
                result=rs.getString(campo_recupero);
            }
            

            
            

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            
            try {
                
                if (rs != null)
                    rs.close();
                
                if (st != null)
                    st.close();
                            
                if (con != null) 
                    con.close();
                              
            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(Mysql.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        return result;
        
    }

    
    public static String[][] completaArrayConQuery (String[][] data){
        int riga,i;
        String Num;
        for (riga=1; riga < (Scansionatore.n_row) ; riga++){
            Num=data[riga][0];
            System.out.println(Num);
            if (Mysql.esisteRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num)) {
                data[riga][12] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"CapSpesa");
                data[riga][13] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Cdr");
                data[riga][14] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Cdg");
                data[riga][15] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Ril_iva");
                data[riga][16] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Impegno");

            } else {
                for (i=12; i<17; i++){      
                    data[riga][i] = "dato non presente";
                }
            }             
        }
        
        return data;
        
    }
    
    public static void caricaFatturaSuDMBS (String[][] data){
        int riga,colonna;
        String query="";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
            if (Mysql.esisteRecord(Main.dbName,Main.tab_fatture,"Bim",data[1][9])){
                System.out.println("Bimestre già caricato!!!");
                return;
            }

        try {
            
            con = DriverManager.getConnection(Main.dbUrl, Main.dbUser, Main.dbPwd);
            st = con.createStatement();

            for (riga=1; riga < (Scansionatore.n_row) ; riga++){
                for (colonna=0; colonna < 11 ; colonna++){
                    query=query+"INSERT INTO `telefonia`.`fisso_fatturazioni` "+
                        "(`NLinea`, `Bim`, `Anno`, `Nfattura`, `TotaleContributiEAbbonamenti`, `TotaleTraffico`, `TotaleAltriAddebitiEAccrediti`, `Totale`)" +
                        " VALUES ('054362661', '2', '2017', '0XFCCDDD', '25,2', '25,2', '25,2', '25,2');";
                 }
            }
            
            
            st.executeUpdate(query);
            
            

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            
            try {
                
                if (rs != null)
                    rs.close();
                
                if (st != null)
                    st.close();
                            
                if (con != null) 
                    con.close();
                              
            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(Mysql.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
        
        
        
        

        
    }
    
}
    


    

