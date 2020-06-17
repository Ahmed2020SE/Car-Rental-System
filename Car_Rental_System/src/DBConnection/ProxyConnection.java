/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class ProxyConnection implements DBConnection {
    private realConnection realconnection;

    public ProxyConnection() {
        if(realconnection==null){
            realconnection = new realConnection();
        }
    }
    @Override
    public ResultSet establishStatement(String sql) {
        return realconnection.establishStatement(sql);
    }
    public static Connection returnConnection() {
        return realConnection.returnConnection();
    }

    @Override
    public ResultSet Select(String need, String table, String where, String id) {
        return realconnection.Select(need, table, where, id);
    }
    
}
