package Operation;
import Connection.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class Operation extends Database{
    private Connection conn = null;
    public Operation(Connection conn) {
        this.conn = conn;
    }
    public Operation(String driver, String url, String username, String password) {
        super(driver, url, username, password);
        this.conn = super.getConnection();
    }
    public Connection getConnectServer(){
        return this.conn;
    }
    public boolean createLogin(String sql){
         try{
            if(this.conn.createStatement().executeQuery(sql).next()){return true;}
        }catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage() + "\n" 
                                + ex.getLocalizedMessage() + "\n"
                                + ex.getCause() + "\n" + Arrays.toString(ex.getSuppressed()) + "\n" 
                                + ex.getClass() + "\n" + Arrays.toString(ex.getStackTrace()));}
        return false;
    }
    public int getValueAt(String sql){
        int sno = 0;
        try{
            ResultSet rs = this.setResultSet(sql);
            while(rs.next()){sno = rs.getInt(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return sno;
    }
    public ResultSet setResultSet(String sql){
        try{
            Statement stmt = this.conn.createStatement();
            return stmt.executeQuery(sql);
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return null;
    }
    public String getStringValueAt(String sql){
        String name = "";
        try{
            ResultSet rs = this.setResultSet(sql);
            while(rs.next()){name = rs.getString(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return name;
    }
    public Date getDateValueAt(String sql){
        Date date = null;
        try{
            ResultSet rs = this.setResultSet(sql);
            while(rs.next()){date = rs.getDate(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return date;
    }
    public Float getFloatValueAt(String sql){
        float nos = 0.0f;
        try{
            ResultSet rs = this.setResultSet(sql);
            while(rs.next()){nos = rs.getFloat(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return nos;
    }
    public double getDoubleValueAt(String sql){
        double nos = 0.0D;
        try{
            ResultSet rs = this.setResultSet(sql);
            while(rs.next()){nos = rs.getDouble(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return nos;
    }
    public Object getAnyValueAt(ResultSet rs){
        Object obj = null;
        try{
            while(rs.next()){
                obj = rs.getObject(1);
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return obj;
    }
    public ArrayList<Object> getComboData(ResultSet rs, int cols){
        ArrayList<Object> list = new ArrayList();
        try{
            while(rs.next()){
                for(int i = 0; i < cols; i++){
                    list.add(rs.getObject(i+1));
                }
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return list;
    }
    public boolean insertRecord(PreparedStatement ps){      
        int insert = 0;
        try{
            this.conn.setAutoCommit(false);
            insert = ps.executeUpdate(); 
            if(insert==1){
                this.conn.commit();
                JOptionPane.showMessageDialog(null, insert + " Record inserted...", 
                "Insert", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
                return true;
            }
            else{
                this.conn.rollback();
                 JOptionPane.showMessageDialog(null, "Record not inserted...", 
                "Insert", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return false;
    }
    public boolean insertRecord(String sql){      
        int insert = 0;
        try{
            this.conn.setAutoCommit(false);
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            insert = ps.executeUpdate(); 
            if(insert==1){
                this.conn.commit();
                JOptionPane.showMessageDialog(null, insert + " Record inserted...", 
                "Insert", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
                return true;
            }
            else{
                this.conn.rollback();
                 JOptionPane.showMessageDialog(null, "Record not inserted...", 
                "Insert", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return false;
    }
    public boolean deleteRecord(String sql){
        int del = 0;
        try{
            this.conn.setAutoCommit(false);
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            del = ps.executeUpdate();
            if(del==1){
                this.conn.commit();
                JOptionPane.showMessageDialog(null, "Record deleted...", 
                "Delete Record", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
                return true;
            }
            else{
                this.conn.rollback();
                 JOptionPane.showMessageDialog(null, "Record not found...", 
                "Delete Record", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return false;
    }
    public boolean updateRecord(String sql){
        int update = 0;
        try{
            this.conn.setAutoCommit(false);
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            update = ps.executeUpdate();
            if(update==1){
                this.conn.commit();
                JOptionPane.showMessageDialog(null, "Record Updated...", 
                "Update Record", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
                return true;
            }
            else{
                this.conn.rollback();
                 JOptionPane.showMessageDialog(null, "Record not found...", 
                "Update Record", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Update Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return false;
    }
}
