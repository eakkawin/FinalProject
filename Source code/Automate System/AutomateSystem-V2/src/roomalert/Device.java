/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomalert;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class Device {

    public static List<String> getCMD(int id) {
        ArrayList<String> d = null;
        try {
            Connection con = ConnectionBuilder.connect();
            String sql = "select CMD from device where room_id = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (d == null) {
                    d = new ArrayList<>();
                }
                d.add(rs.getString("CMD"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return d;
    }

    public static void upDateStatus(int id, boolean isOpen) {
        try {
            Connection con = ConnectionBuilder.connect();
            String sql = "update device set status = ? where room_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, isOpen ? "ON" : "OFF");
            st.setInt(2, id);
            int x = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public  static void insertTransaction(int id , boolean isOpen) {
        ArrayList<Integer> deviceId = new ArrayList<>();
        try {
            Connection con = ConnectionBuilder.connect();
            String sql = "select device_id from device where room_id = " + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                deviceId.add(rs.getInt("device_id"));
            }
            sql = "update log set log_desc = ? where device_id = ?";
            PreparedStatement s = con.prepareStatement(sql);
            for (int x : deviceId) {

                s.setString(1, "devcie has been"+ (isOpen ? "ON" : "OFF") +" by system at " + new Date());
                s.setInt(2, x);
                s.addBatch();
            }
           int x[]=  s.executeBatch();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        List<String> a = getCMD(1);
        for(String k : a){
            System.out.println(k);
        }
    }
    
    
    
    
}
