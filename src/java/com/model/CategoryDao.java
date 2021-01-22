/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Category;
import com.until.DBhelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomnyson
 */
public class CategoryDao {
    public static boolean create(Category product) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "INSERT INTO category (name, description)"
                    + " VALUES(?, ?)";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, product.getName());
                pst.setString(2, product.getDescription());
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

    public static List<Category> findAll() {
        List<Category> list = new ArrayList<Category>();
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "select * from category";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    Category category = new Category();
                    category.setId(resultSet.getInt("id"));
                    category.setName(resultSet.getString("name"));
                    category.setDescription(resultSet.getString("description"));
                    list.add(category);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static Category findProductById(int id) {
        Category category = new Category();
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "select * from category where id= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {

                    category.setId(resultSet.getInt("id"));
                    category.setName(resultSet.getString("name"));
                    category.setDescription(resultSet.getString("description"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return category;
    }

    public static boolean delete(int id) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "delete from category id= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                int result = pst.executeUpdate();
                if (result > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean update(Category category) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "UPDATE product set name = ?, description = ?, price = ?, stock =?, discount = ?, createAt =?, categoryId= ? where id= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, category.getName());
                pst.setString(2, category.getDescription());
                pst.setInt(6, category.getId());
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
