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

/**
 *
 * @author kellu
 */
public class userReadRecord {

    private Connection conn;
    private ResultSet results;

    private Cars cars = new Cars();
    private int CARID;

    public userReadRecord(int CARID) {

        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(userReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(userReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");

        this.CARID = CARID;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(userReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void douserRead() {

        try {
            //set up a string to hold our query
            String query = "SELECT * FROM Cars WHERE CARID = ?";
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            //fill in the preparedstatement
            ps.setInt(1, CARID);
            //execute the query
            this.results = ps.executeQuery();

            this.results.next();

            cars.setCARID(this.results.getInt("CARID"));
            cars.setCARNAME(this.results.getString("CARNAME"));
            cars.setCARYEAR(this.results.getInt("CARYEAR"));
            cars.setCARMODEL(this.results.getString("CARMODEL"));
            cars.setCARCOLOR(this.results.getString("CARCOLOR"));
            cars.setCARPRICE(this.results.getInt("CARPRICE"));
            cars.setTAXASPERCENT(this.results.getInt("TAXASPERSENT"));

        } catch (SQLException ex) {
            Logger.getLogger(userReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cars getCARID() {

        return this.cars;
    }

}
