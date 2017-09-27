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

    public boolean esisteRecord (){

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://lnx023:3306";
        String user = "telefonia";
        String password = "telefonia";

        try {
            
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            //rs = st.executeQuery("SELECT VERSION()");
            rs = st.executeQuery("select * from `telefonia`.`ric_dati` where nSIM = 30204322953");
            if (rs.next()) {
                return true;
                //System.out.println(rs.getString(2));
            } else 
            

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            
            try {
                
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(Mysql.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
    

