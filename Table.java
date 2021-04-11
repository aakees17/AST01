package Table;

import Operation.Operation;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Table{
    private JTable table = null;
    private DefaultTableModel model = null;
    public Table(JTable table) {
        this.table = table;
        this.model = (DefaultTableModel) this.table.getModel();
    }
    
    public void setComboBoxOnTableByColumnIndex(int columnIndex,JComboBox combobox){
        TableColumn namecolumn = this.table.getColumnModel().getColumn(columnIndex);
        namecolumn.setCellEditor(new DefaultCellEditor(combobox));
    }
    public void setCheckBoxOnTableByColumnIndex(int columnIndex,JCheckBox checkbox){
        TableColumn namecolumn = this.table.getColumnModel().getColumn(columnIndex);
        namecolumn.setCellEditor(new DefaultCellEditor(checkbox));
    }
    public void setColumnWidthByIndex(int columnIndex, int size){
        TableColumn column = this.table.getColumnModel().getColumn(columnIndex);
        column.setPreferredWidth(size);
    }
    public void setColumnFormatting(JTable table, int hieght, Color... color){
        table.setRowHeight(hieght);
        table.setBackground(color[0]);
        table.setForeground(color[1]);  
    }
    public void setColumnFormatting(int hieght, Color... color){
        this.table.setRowHeight(hieght);
        this.table.setBackground(color[0]);
        this.table.setForeground(color[1]);  
    }
    public void setColumnsOnTable(Connection conn,String tablename){
        try{
           String sql = "select column_name from INFORMATION_SCHEMA.COLUMNS where Table_Name = '"+tablename+"' ";
           this.model.setColumnCount(0);
           ResultSet rs = conn.createStatement().executeQuery(sql);
           while(rs.next())
           {
              this.model.addColumn(rs.getObject(1));
           }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : \n" + ex.getMessage() + "\n" 
                + ex.getCause() + "\n" 
                + ex.getLocalizedMessage() + "\n"
                + ex.getClass() + "\n"
                + Arrays.toString(ex.getStackTrace()), 
                "Error", JOptionPane.OK_OPTION);}
    }
    public void searchSpecificRecord(Connection conn, String sql){
        try{
            this.model.setRowCount(0);
            ResultSet rs = conn.createStatement().executeQuery(sql);;
            int r = 0;
            if(rs.next()){
                this.model.setRowCount(r+1);
                for(int cols = 0; cols<model.getColumnCount(); cols++){
                    Object obj = rs.getObject(cols+1);
                    this.model.setValueAt(obj, r, cols);
                }
                r = r + 1;
            }
            else{
                JOptionPane.showMessageDialog(null, "Record not found...");
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : \n" + ex.getMessage() + "\n" 
                + ex.getCause() + "\n" 
                + ex.getLocalizedMessage() + "\n"
                + ex.getClass() + "\n"
                + Arrays.toString(ex.getStackTrace()), 
                "Error", JOptionPane.OK_OPTION);}
    }
    @SuppressWarnings("empty-statement")
    public void searchRecord(Connection conn,String sql){
        try{
           this.model.setRowCount(0);
           ResultSet rs = conn.createStatement().executeQuery(sql);;
           int r = 0;
           while(rs.next()){
               this.model.setRowCount(r+1);
               for(int cols = 0; cols<model.getColumnCount(); cols++){
                    Object obj = rs.getObject(cols+1);
                    this.model.setValueAt(obj, r, cols);
               }
               r = r + 1;
            }
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null, "Data Error : \n" + ex.getMessage() + "\n" 
                + ex.getCause() + "\n" 
                + ex.getLocalizedMessage() + "\n"
                + ex.getClass() + "\n"
                + Arrays.toString(ex.getStackTrace()), 
                "Error", JOptionPane.OK_OPTION);}
    }
}
