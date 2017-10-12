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
    
}
    


    

