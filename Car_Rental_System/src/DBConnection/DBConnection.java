/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

/**
 *
 * @author Admin
 */
import java.sql.ResultSet;
public interface DBConnection {
     ResultSet establishStatement(String sql);
     ResultSet Select(String need,String table,String where,String id);
}
