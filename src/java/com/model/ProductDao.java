/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Product;
import com.until.DBhelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author tomnyson
 */
public class ProductDao {

    public static boolean create(Product product) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "INSERT INTO product (name, description, price, stock, discount, createAt, categoryId)"
                    + " VALUES(?, ?, ?, ?, ?, ? ,? ,?, ?)";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, product.getName());
                pst.setString(2, product.getDescription());
                pst.setFloat(3, product.getPrice());
                pst.setInt(4, product.getStock());
                pst.setFloat(5, product.getDiscount());
                pst.setDate(5, DBhelper.getCurrentDate());
                pst.setInt(6, product.getCategoryId());
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

    public static List<Product> findAll() {
        List<Product> list = new ArrayList<Product>();
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "select * from product";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setPrice(resultSet.getFloat("price"));
                    product.setDiscount(resultSet.getFloat("discount"));
                    product.setStock(resultSet.getInt("stock"));
                    product.setStock(resultSet.getInt("categoryId"));
                    product.setCreateAt(resultSet.getDate("createAt"));
                    list.add(product);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static Product findProductById(int id) {
        Product product = new Product();
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "select * from product where id= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {

                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setPrice(resultSet.getFloat("price"));
                    product.setDiscount(resultSet.getFloat("discount"));
                    product.setStock(resultSet.getInt("stock"));
                    product.setStock(resultSet.getInt("categoryId"));
                    product.setCreateAt(resultSet.getDate("createAt"));

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public static boolean delete(int id) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "delete from product where id= ?";
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

    public static boolean update(Product product) {
        try {
            Connection conn = DBhelper.getConnection();
            String sql = "UPDATE product set name = ?, description = ?, price = ?, stock =?, discount = ?, createAt =?, categoryId= ? where id= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, product.getName());
                pst.setString(2, product.getDescription());
                pst.setFloat(3, product.getPrice());
                pst.setInt(4, product.getStock());
                pst.setFloat(5, product.getDiscount());
                pst.setDate(5, DBhelper.getCurrentDate());
                pst.setInt(6, product.getCategoryId());
                pst.setInt(6, product.getId());
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
