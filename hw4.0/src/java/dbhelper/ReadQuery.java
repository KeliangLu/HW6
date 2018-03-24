
package dbhelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import model.Cars;


public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery(){
    Properties props= new Properties();
    InputStream instr= getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        String driver = props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password =props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public void doRead(){
        try {
            String query = "Select * from Cars";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getHTMLTable(){
        String table = "";
        table += "<table border=1>";
        try {
            while(this.results.next()){
                Cars cars = new Cars();
                cars.setCARID(this.results.getInt("CARID"));
                cars.setCARNAME(this.results.getString("CARNAME"));
                cars.setCARYEAR(this.results.getInt("CARYEAR"));
                cars.setCARMODEL(this.results.getString("CARMODEL"));
                cars.setCARCOLOR(this.results.getString("CARCOLOR"));
                
                table += "<tr>";
                    table += "<td>";
                    table += cars.getCARID();  
                    table += "</td>";
                
                    table += "<td>";
                    table += cars.getCARNAME();  
                    table += "</td>";
                
                    table += "<td>";
                    table += cars.getCARYEAR();  
                    table += "</td>";
                        
                    table += "<td>";
                    table += cars.getCARMODEL();  
                    table += "</td>";
                
                    table += "<td>";
                    table += cars.getCARCOLOR();  
                    table += "</td>";
                    
                    table +="<td>";
                    table +="<a href=delete?CARID=" + cars.getCARID()+"> Delete </a>";
                
                table += "</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
                return table;

    }            
          
    
    
}
