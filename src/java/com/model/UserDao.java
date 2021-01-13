/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.User;
import com.until.DBhelper;
import java.sql.*;

/**
 *
 * @author tomnyson
 */
public class UserDao {

    public static boolean isLogin(User user) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "SELECT * FROM users where email= ? and password= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getPassword());
                ResultSet rs = pst.executeQuery();;
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static  boolean createUser(User user) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "INSERT INTO users (email, password, role) VALUES(?, ?, ?)";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getPassword());
                pst.setString(3, user.getRole());
                int result = pst.executeUpdate();
                if (result > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean isExistUser(String username) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "SELECT * FROM users where email= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                System.out.println("username"+username);
                pst.setString(1, username);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
