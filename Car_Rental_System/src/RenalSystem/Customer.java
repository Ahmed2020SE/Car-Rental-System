/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RenalSystem;

import DBConnection.ProxyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Customer implements Rules{

    @Override
    public int add(ArrayList<String> inputs){
        PreparedStatement pstmt;
        int i=0;
        try {
            pstmt = ProxyConnection.returnConnection().
                    prepareStatement("insert into customer(cust_id,name,address,mobile) values (?,?,?,?)");
            pstmt.setString(1,inputs.get(0));
            pstmt.setString(2,inputs.get(1));
            pstmt.setString(3,inputs.get(2));
            pstmt.setString(4, inputs.get(3));
            i=pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    }

    @Override
    public int update(ArrayList<String> inputs) {
       PreparedStatement pstmt;
        int i=0;
        try {
            pstmt = ProxyConnection.returnConnection().
            prepareStatement("update customer set name=?,address=?,mobile=? where cust_id=?");
            pstmt.setString(1,inputs.get(0));
            pstmt.setString(2,inputs.get(1));
            pstmt.setString(3,inputs.get(2));
            pstmt.setString(4, inputs.get(3));
            i=pstmt.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
    
}
