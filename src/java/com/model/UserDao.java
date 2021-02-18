/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Car;
import com.entity.Category;
import com.entity.User;
import static com.model.CategoryDao.conn;
import com.until.DBhelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static boolean createUser(User user) {
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
                System.out.println("username" + username);
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

    public static User findUserByEmail(String email) {
        User user = new User();
        try {
            Connection conn = DBhelper.getConnection();

            String sql = "SELECT * FROM users where email= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                }
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
     public static List<User> findAll() {
        List<User> list = new ArrayList<User>();
        try {
            String sql = "select * from users";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("email"));
                    user.setRole(resultSet.getString("role"));
                    user.setPassword(resultSet.getString("password"));
                    list.add(user);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
     
      public static boolean updateUser(User user) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "update users set email= ?, password = ?, role = ? where id = ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getPassword());
                pst.setString(3, user.getRole());
                 pst.setInt(4, user.getId());
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

}
