/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Cars;



public class SearchQuery {
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        Properties props= new Properties();
        InputStream instr= getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        String driver = props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password =props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSearch(String CARNAME){
        
        try {
            String query = "SELECT * FROM Cars WHERE UPPER(CARNAME) LIKE ? ORDER BY CARID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,"%" + CARNAME.toUpperCase() + "%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
public String getHTMLTable(){
        String table = "";
        table += "<table>";
        
        table += "<tr>";
        table += "<th>Car ID</th>";
        table += "<th>Car Name</th>";

        table += "<th>Car Year</th>";

        table += "<th>Car Model</th>";

        table += "<th>Car Color</th>";
                
        table += "<th>Delete it?</th>";
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
                    table += "<a href=update?CARID=" + cars.getCARID()+ "> Update </a>" + "<a href=delete?CARID=" + cars.getCARID()+"> Delete </a>";
                
                table += "</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
                return table;

    }            
    
    
}
