package Operation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

    public interface OP_Interface{
    public default boolean Login(Connection conn, String sql){
        try{
            if(conn.createStatement().executeQuery(sql).next()){return true;}
        }catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage() + "\n" 
                                + ex.getLocalizedMessage() + "\n"
                                + ex.getCause() + "\n" + Arrays.toString(ex.getSuppressed()) + "\n" 
                                + ex.getClass() + "\n" + Arrays.toString(ex.getStackTrace()));}
        return false;
    }
    public default int getValueAt(ResultSet rs){
        int sno = 0;
        try{
            while(rs.next()){sno = rs.getInt(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return sno;
    }
    public default ResultSet setResultSet(Connection conn, String sql){
        try{
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return null;
    }
    public default String getStringValueAt(ResultSet rs){
        String name = "";
        try{
            while(rs.next()){name = rs.getString(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return name;
    }
    public default Date getDateValueAt(ResultSet rs){
        Date date = null;
        try{
            while(rs.next()){date = rs.getDate(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return date;
    }
    public default Float getFloatValueAt(ResultSet rs){
        float nos = 0.0f;
        try{
            while(rs.next()){nos = rs.getFloat(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return nos;
    }
    public default double getDoubleValueAt(ResultSet rs){
        double nos = 0.0D;
        try{
            while(rs.next()){nos = rs.getDouble(1);}
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Result not generated : " + ex.getMessage(), 
                "SQL Error", JOptionPane.OK_OPTION);}
        return nos;
    }
    public default Object getAnyValueAt(ResultSet rs){
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
    public default ArrayList<Object> getComboData(ResultSet rs, int cols){
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
    public default boolean insertRecord(Connection conn, PreparedStatement ps){      
        int insert = 0;
        try{
            conn.setAutoCommit(false);
            insert = ps.executeUpdate(); 
            if(insert==1){
                conn.commit();
                JOptionPane.showMessageDialog(null, insert + " Record inserted...", 
                "Insert", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
                return true;
            }
            else{
                conn.rollback();
                 JOptionPane.showMessageDialog(null, "Record not inserted...", 
                "Insert", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return false;
    }
    public default boolean insertRecord(Connection conn, String sql){      
        int insert = 0;
        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            insert = ps.executeUpdate(); 
            if(insert==1){
                conn.commit();
                JOptionPane.showMessageDialog(null, insert + " Record inserted...", 
                "Insert", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
                return true;
            }
            else{
                conn.rollback();
                 JOptionPane.showMessageDialog(null, "Record not inserted...", 
                "Insert", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return false;
    }
    public default boolean deleteRecord(Connection conn, String sql){
        int del = 0;
        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            del = ps.executeUpdate();
            if(del==1){
                conn.commit();
                JOptionPane.showMessageDialog(null, "Record deleted...", 
                "Delete Record", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
                return true;
            }
            else{
                conn.rollback();
                 JOptionPane.showMessageDialog(null, "Record not found...", 
                "Delete Record", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return false;
    }
    public default boolean updateRecord(Connection  conn, String sql){
        int update = 0;
        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            update = ps.executeUpdate();
            if(update==1){
                conn.commit();
                JOptionPane.showMessageDialog(null, "Record Updated...", 
                "Update Record", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
                return true;
            }
            else{
                conn.rollback();
                 JOptionPane.showMessageDialog(null, "Record not found...", 
                "Update Record", JOptionPane.INFORMATION_MESSAGE+JOptionPane.OK_OPTION);
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Update Error : " + ex.getMessage(), 
                "Error", JOptionPane.OK_OPTION);}
        return false;
    }
}
