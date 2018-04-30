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

public class userReadQuery {

    private Connection conn;
    private ResultSet results;

    public userReadQuery() {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(userReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(userReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(userReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void douserRead() {

        try {
            String query = "SELECT * FROM Cars ORDER BY CARID ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(userReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHTMLTable1() {
        String table1 = "";
        table1 += "<table1>";

        table1 += "<tr>";
        table1 += "<th>Car ID</th>";
        table1 += "<th>Car Name</th>";
        table1 += "<th>Car Year</th>";
        table1 += "<th>Car Model</th>";
        table1 += "<th>Car Color</th>";
        table1 += "<th>Car Price</th>";
        table1 += "<th>Tax rate(%)</th>";

        table1 += "<th> </th>";
        try {
            while (this.results.next()) {
                Cars cars = new Cars();
                cars.setCARID(this.results.getInt("CARID"));
                cars.setCARNAME(this.results.getString("CARNAME"));
                cars.setCARYEAR(this.results.getInt("CARYEAR"));
                cars.setCARMODEL(this.results.getString("CARMODEL"));
                cars.setCARCOLOR(this.results.getString("CARCOLOR"));
                cars.setCARPRICE(this.results.getInt("CARPRICE"));
                cars.setTAXASPERCENT(this.results.getInt("TAXASPERCENT"));

                table1 += "<tr>";

                table1 += "<td>";
                table1 += cars.getCARID();
                table1 += "</td>";

                table1 += "<td>";
                table1 += cars.getCARNAME();
                table1 += "</td>";

                table1 += "<td>";
                table1 += cars.getCARYEAR();
                table1 += "</td>";

                table1 += "<td>";
                table1 += cars.getCARMODEL();
                table1 += "</td>";

                table1 += "<td>";
                table1 += cars.getCARCOLOR();
                table1 += "</td>";
                
                table1 += "<td>";
                table1 += cars.getCARPRICE();
                table1 += "</td>";
                
                table1 += "<td>";
                table1 += cars.getTAXASPERCENT();
                table1 += "</td>";

                table1 += "<td>";
                table1 += "<a href=update?CARID=" + cars.getCARID() + "> Update </a>";

                table1 += "</tr>";

            }
        } catch (SQLException ex) {
            Logger.getLogger(userReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        table1 += "</table1>";
        return table1;

    }

}