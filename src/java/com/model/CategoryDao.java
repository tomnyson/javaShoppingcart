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
 * @author tomnyson CRUD/get
 */
public class CategoryDao {

    static Connection conn = DBhelper.getConnection();

    public static boolean create(Category product) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "INSERT INTO category (name, description, image)"
                    + " VALUES(?, ?, ?)";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, product.getName());
                pst.setString(2, product.getDescription());
                pst.setString(3, product.getImage());
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
            String sql = "select * from category";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    Category category = new Category();
                    category.setId(resultSet.getInt("id"));
                    category.setName(resultSet.getString("name"));
                    category.setDescription(resultSet.getString("description"));
                    category.setImage(resultSet.getString("image"));
                    list.add(category);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static Category findCategoryById(int id) {
        Category cat = new Category();
        try {
            String sql = "select * from category where id= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    cat.setId(resultSet.getInt("id"));
                    cat.setName(resultSet.getString("name"));
                    cat.setDescription(resultSet.getString("description"));
                    cat.setImage(resultSet.getString("image"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cat;
    }

    public static boolean delete(int id) {
        try {
            String sql = "delete from category where id= ?";
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
            String sql = "UPDATE category set name = ?, description = ?, image = ? where id= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, category.getName());
                pst.setString(2, category.getDescription());
                pst.setString(3, category.getImage());
                pst.setInt(4, category.getId());
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
