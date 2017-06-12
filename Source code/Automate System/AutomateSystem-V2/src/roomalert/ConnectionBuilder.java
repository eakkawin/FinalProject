/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomalert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ConnectionBuilder {
     public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://171.101.237.226/senior", "autotask", "autotask1234");
        } catch (SQLException e) {
            System.out.println(e);

        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return con;

    }
    public static void main(String[] args) throws SQLException {
         Connection con = ConnectionBuilder.connect();
         System.out.println("Complete !!");
    }
}
