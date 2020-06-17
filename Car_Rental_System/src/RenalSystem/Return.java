/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RenalSystem;

import DBConnection.ProxyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Return implements Rules{

    @Override
    public int add(ArrayList<String> inputs) {
        PreparedStatement pstmt;
        Connection con= ProxyConnection.returnConnection();
        int i=0;
         try {
            pstmt = con.prepareStatement
        ("insert into returncar(car_id,cust_id,return_date,elap,fine) values (?,?,?,?,?)");
            pstmt.setString(1,inputs.get(0));
            pstmt.setString(2,inputs.get(1));
            pstmt.setString(3,inputs.get(2));
            pstmt.setString(4, inputs.get(3));
            pstmt.setString(5, inputs.get(4));
            i=pstmt.executeUpdate();
            pstmt =con.prepareStatement("update carregistration set available='Yes' where car_no=?");
            pstmt.setString(1,inputs.get(0));
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("delete from rental where car_id=?");
            pstmt.setString(1, inputs.get(0));
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
         return i;
    }

    @Override
    public int update(ArrayList<String> inputs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
