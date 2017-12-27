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
    public static String queryRecuperaRecord (String db, String tabella, String campo, String record_ricercato, String campo_recupero){
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
        Mysql oggettoMysql = new Mysql(Main.dbUrl, Main.dbUser, Main.dbPwd);
        
        for (riga=1; riga < (Scansionatore.n_row) ; riga++){
            Num=data[riga][0];
            //System.out.println(Num);
            if (Mysql.esisteRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num)) {
                    data[riga][12] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"CapSpesa");
                    if (data[riga][12]==null || data[riga][12].equals(""))
                        data[riga][12]="CapSpesa non presente";
                    data[riga][13] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Cdr");
                    data[riga][14] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Cdg");
                    data[riga][15] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Ril_iva");
                    data[riga][16] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Impegno");
                
                    //recupero il campo "Sede"
                    String queryTemp=null;
                    queryTemp=  " select C.Sede " +
                                " from "+Main.dbName+".fisso_linee A " +
                                " left join "+Main.dbName+".fisso_linee_indirizzi_sedi B " +
                                "       on A.IDLinea=B.`FK-IDlinea` " +
                                " left join "+Main.dbName+".fisso_sedi C " +
                                "	on B.`FK-IDsede`=C.IDsede" +
                                " where A.NLinea='"+ Num +"' ";
                    oggettoMysql.executeQueryRecupera(queryTemp,"Sede");
                    data[riga][17]=oggettoMysql.result;
                                                                             
                    
                    //query per verifica linea cessata
                    queryTemp=  " select * " +
                                " from "+Main.dbName+".fisso_linee a " +
                                " join "+Main.dbName+".fisso_linee_indirizzi_sedi b " +
                                " on a.IDLinea=b.`FK-IDlinea` " +
                                " where b.Cessazione=1 and a.NLinea='"+ Num +"' ";
                    
                    if (oggettoMysql.executeQueryBoolean(queryTemp)){
                        //recupero campo "Nota"
                        queryTemp =  " select b.Nota " +
                                        " from "+Main.dbName+".fisso_linee a " +
                                        " join "+Main.dbName+".fisso_linee_indirizzi_sedi b " +
                                        " on a.IDLinea=b.`FK-IDlinea` " +
                                        " where a.NLinea='"+ Num +"'";
                        oggettoMysql.executeQueryRecupera(queryTemp, "Nota");
                    
                        data[riga][18]="cessata "+oggettoMysql.result;
                    } else {
                        data[riga][18]="";
                    } 
            } else {                
                data[riga][12] = "Linea non presente nel DB";              
            }             
        }
        oggettoMysql.closeCon();
        return data;
        
    }
    public static String[][] completaArrayConQueryBIs (String[][] data){
        int riga,i;
        String Num;
        Mysql oggettoMysql = new Mysql(Main.dbUrl, Main.dbUser, Main.dbPwd);
        String queryTemp=null;
        queryTemp=  " select    A.CapSpesa, A.Cdr, A.Cdg, A.Ril_iva, A.Impegno, " +
                    "		B.Cessazione, B.Nota, " +
                    "		C.Sede " +
                    " from      "+Main.dbName+".fisso_linee A " +
                    " left join "+Main.dbName+".fisso_linee_indirizzi_sedi B " +
                    "       on A.IDLinea=B.`FK-IDlinea` " +
                    " left join "+Main.dbName+".fisso_sedi C " +
                    "	on B.`FK-IDsede`=C.IDsede";
        
                    
            pst = con.prepareStatement("SELECT * FROM Authors");
            rs = pst.executeQuery();

            while (rs.next()) {
                
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }
        
        
        for (riga=1; riga < (Scansionatore.n_row) ; riga++){
            Num=data[riga][0];
            //System.out.println(Num);
            if (Mysql.esisteRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num)) {
                    data[riga][12] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"CapSpesa");
                    if (data[riga][12]==null || data[riga][12].equals(""))
                        data[riga][12]="CapSpesa non presente";
                    data[riga][13] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Cdr");
                    data[riga][14] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Cdg");
                    data[riga][15] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Ril_iva");
                    data[riga][16] = Mysql.recuperaRecord(Main.dbName,Main.tab_linee,Main.nome_campo_linea,Num,"Impegno");
                
                    //recupero il campo "Sede"
                    String queryTemp=null;
                    queryTemp=  " select C.Sede " +
                                " from "+Main.dbName+".fisso_linee A " +
                                " left join "+Main.dbName+".fisso_linee_indirizzi_sedi B " +
                                "       on A.IDLinea=B.`FK-IDlinea` " +
                                " left join "+Main.dbName+".fisso_sedi C " +
                                "	on B.`FK-IDsede`=C.IDsede" +
                                " where A.NLinea='"+ Num +"' ";
                    oggettoMysql.executeQueryRecupera(queryTemp,"Sede");
                    data[riga][17]=oggettoMysql.result;
                                                                             
                    
                    //query per verifica linea cessata
                    queryTemp=  " select * " +
                                " from "+Main.dbName+".fisso_linee a " +
                                " join "+Main.dbName+".fisso_linee_indirizzi_sedi b " +
                                " on a.IDLinea=b.`FK-IDlinea` " +
                                " where b.Cessazione=1 and a.NLinea='"+ Num +"' ";
                    
                    if (oggettoMysql.executeQueryBoolean(queryTemp)){
                        //recupero campo "Nota"
                        queryTemp =  " select b.Nota " +
                                        " from "+Main.dbName+".fisso_linee a " +
                                        " join "+Main.dbName+".fisso_linee_indirizzi_sedi b " +
                                        " on a.IDLinea=b.`FK-IDlinea` " +
                                        " where a.NLinea='"+ Num +"'";
                        oggettoMysql.executeQueryRecupera(queryTemp, "Nota");
                    
                        data[riga][18]="cessata "+oggettoMysql.result;
                    } else {
                        data[riga][18]="";
                    } 
            } else {                
                data[riga][12] = "Linea non presente nel DB";              
            }             
        }
        oggettoMysql.closeCon();
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
    public Statement pst = null;
    public ResultSet rs = null;
    public String result = null;
    
    public Mysql(String dbUrl, String dbUser, String dbPwd){
        
        try {
        con = DriverManager.getConnection(Main.dbUrl, Main.dbUser, Main.dbPwd);      
        st = con.createStatement();
        
        
        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } 
        
        
    }
    public Boolean executeQueryBoolean(String query){
        Boolean a=false;
        try {
            
            this.rs = this.st.executeQuery(query);
            a = this.rs.next();
        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return a;
    }
    public void executeQueryRecupera(String query, String campo_recupero){
        try {
            
            
            this.rs = this.st.executeQuery(query);
            if (this.rs.next()){
                result=rs.getString(campo_recupero);
            }
 
        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Mysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }
    public void executeQueryRecuperaMulti(String query){
        try {
            
            pst=this.con.prepareStatement(query);
            rs = pst.executeQuery();
            if (this.rs.next()){
                result=rs.getString(campo_recupero);
            }
 
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
    


    

