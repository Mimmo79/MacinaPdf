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
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            //System.out.println(Num);
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
    
    public static void caricaFattureSuDMBS (String[][] data){
        
        int riga;
        String query=null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            //apro la connessione
            con = DriverManager.getConnection(Main.dbUrl, Main.dbUser, Main.dbPwd);
            //verifico che le fatture non siano già state caricate
            query="select * from "+Main.dbName+"."+Main.tab_fatture+" where Bim="+data[1][9]+" and  Anno="+data[1][10]+" ;";               
            pst = con.prepareStatement(query);
            rs=pst.executeQuery();
            if (rs.next()){
                System.out.println("Almeno un record di questo bimestre è già stato caricato!!!");
                return;
            }
            
            
            
            query=null;
            rs=null;
            query="INSERT INTO " + Main.dbName + "." + Main.tab_fatture + 
                " (             NLinea, Bim,    Anno,   Nfattura,   TotaleContributiEAbbonamenti,   TotaleTraffico, FCIva,  TotaleAltriAddebitiEAccrediti,  Totale)" +
                " VALUES (      ?,      ?,      ?,      ?,          ?,                              ?,              ?,      ?,                              ?)";         
            pst = con.prepareStatement(query);
            
            for (riga=1; riga < (Scansionatore.n_row) ; riga++){
                pst.setString(1, data[riga][0]);
                pst.setString(2, data[riga][9]);
                pst.setString(3, data[riga][10]);
                pst.setString(4, data[riga][11]);
                pst.setString(5, data[riga][1]);
                pst.setString(6, data[riga][2]);
                pst.setString(7, data[riga][4]);
                pst.setString(8, data[riga][3]);
                pst.setString(9, data[riga][5]);
     
                pst.executeUpdate();
                
            }
            
        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            
            try {
                
                if (rs != null)
                    rs.close();
                
                if (pst != null)
                    pst.close();
                            
                if (con != null) 
                    con.close();
                              
            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(Mysql.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        
    }
    
    
    
    public Connection con = null;
    public Statement st = null;
    public ResultSet rs = null;
    public boolean result = false;
    
    public Mysql(String dbUrl, String dbUser, String dbPwd){
        
        try {
        con = DriverManager.getConnection(Main.dbUrl, Main.dbUser, Main.dbPwd);
        st = con.createStatement();
        
        
        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } 
        
        
    }
    public void executeQuery(String query){
        try {
            
            this.rs = this.st.executeQuery(query);
            this.result = this.rs.next();
        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }
    public void closeCon(){
        try {       
                if (this.rs != null)
                    this.rs.close();            
            
                if (this.st != null)
                    this.st.close();
                
                if (this.con != null) 
                    this.con.close();
                              
            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(Mysql.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        
    }
    
}
    


    

