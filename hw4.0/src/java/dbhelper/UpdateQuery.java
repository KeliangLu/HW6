
package dbhelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cars;

/**
 *
 * @author kellu
 */
public class UpdateQuery {
    
    private Connection conn;
    
    public UpdateQuery(){
        
            Properties props= new Properties();
    InputStream instr= getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        String driver = props.getProperty("driver.name");
        String url=props.getProperty("server.name");
        String username=props.getProperty("user.name");
        String password =props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doUpdate (Cars cars){
        
        try {
            String query = "Update Cars SET CARID = ?, CARNAME = ?, CARYEAR = ?, CARMODEL = ?, CARCOLOR = ? WHERE CARID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, cars.getCARID());
            ps.setString(2, cars.getCARNAME());
            ps.setInt(3,cars.getCARYEAR());
            ps.setString(4, cars.getCARMODEL());
            ps.setString(5, cars.getCARCOLOR());
            ps.setInt(6,cars.getCARID());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
