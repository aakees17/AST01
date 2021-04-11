package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Database {
    private Connection conn;
    private String driver;
    private String url;
    private String user;
    private String pass;
    
    public Database() {
        this.conn = null;
        this.driver = "";
        this.url = "";
        this.user = "";
        this.pass = "";
    }

    public Database(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }
    public Database(String driver, String url) {
        this.driver = driver;
        this.url = url;
    }
    public Connection getConnection() {return conn;}
    public void setConnection() {
        try{
            Class.forName(this.driver);
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        }
        catch(ClassNotFoundException ex){JOptionPane.showMessageDialog(null, "Driver not found : " + ex.getMessage(), 
                "Driver Error", JOptionPane.OK_OPTION);} 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connection failed : " + ex.getMessage(), 
                "Connection Error", JOptionPane.OK_OPTION);
        }
        
    }
    public String getDriver() {return driver;}
    public void setDriver(String driver) {this.driver = driver;}
    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}
    public String getUser() {return user;}
    public void setUser(String user) {this.user = user;}
    public String getPass() {return pass;}
    public void setPass(String pass) {this.pass = pass;}
    
}
    