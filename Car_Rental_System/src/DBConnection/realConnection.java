/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import RenalSystem.Rental;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
    class realConnection implements DBConnection{
    private static Connection con = null;
    public realConnection() {
        connection();
    }

    @Override
    public ResultSet establishStatement(String sql) {
        ResultSet rs= null;
        try {
            Statement s=con.createStatement();
            rs=s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(realConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void connection(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/car_rent_system","root","");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found exception handling");
        } catch (SQLException ex) {
            System.out.println("Sql exception handling in real connection");
        }
    }
    public ResultSet Select(String need,String table,String where,String id){
        ResultSet rs=null;
        PreparedStatement pstmt;
        try {
            pstmt=ProxyConnection.returnConnection().
                    prepareStatement("select $need from $table where $where=?".
                            replace("$table", table).replace("$need", need).replace("$where", where));
            pstmt.setString(1, id);
            rs=pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Rental.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static Connection returnConnection() {
       return con;
    }
    
}
