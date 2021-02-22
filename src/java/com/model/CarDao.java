/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Car;
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
public class CarDao {

    static Connection conn = DBhelper.getConnection();

    public static boolean create(Car product) {
        try {
            String sql = "INSERT INTO cars (title, description, image, contact, url, price, categoryId)"
                    + " VALUES(?, ?, ?, ?, ?, ?,?)";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, product.getTitle());
                pst.setString(2, product.getDescription());
                pst.setString(3, product.getImage());
                pst.setString(4, product.getContact());
                pst.setString(5, product.getUrl());
                pst.setDouble(6, product.getPrice());
                pst.setInt(7, product.getCategoryId());
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

    public static List<Car> findAll(int start, int total) {
        List<Car> list = new ArrayList<Car>();
        try {
            String sql = "select * from cars order by id desc limit ?, ? ";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, (start - 1) * total);
                pst.setInt(2, total);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    Car car = new Car();
                    car.setId(resultSet.getInt("id"));
                    car.setTitle(resultSet.getString("title"));
                    car.setDescription(resultSet.getString("description"));
                    car.setImage(resultSet.getString("image"));
                    car.setPrice(resultSet.getDouble("price"));
                    car.setContact(resultSet.getString("contact"));
                    car.setUrl(resultSet.getString("url"));
                    list.add(car);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static Car findProductById(int id) {
        Car car = new Car();
        try {
            String sql = "select * from cars c inner join category cat on c.categoryId = cat.id  where c.id= ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    car.setId(resultSet.getInt("c.id"));
                    car.setTitle(resultSet.getString("c.title"));
                    car.setDescription(resultSet.getString("c.description"));
                    car.setContact(resultSet.getString("c.description"));
                    car.setImage(resultSet.getString("c.image"));
                    car.setPrice(resultSet.getDouble("c.price"));
                    car.setUrl(resultSet.getString("c.url"));
                    car.setCategoryId(resultSet.getInt("cat.id"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return car;
    }

    public static List<Car> findProductByCategory(int catId) {
        List<Car> list = new ArrayList<Car>();
        try {
            String sql = "select * from cars inner join category on cars.categoryId = category.id where cars.categoryId = ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, catId);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    Car car = new Car();
                    System.out.println("info" + resultSet.getInt("cars.id"));
                    car.setId(resultSet.getInt("cars.id"));
                    car.setTitle(resultSet.getString("cars.title"));
                    car.setDescription(resultSet.getString("cars.description"));
                    car.setContact(resultSet.getString("cars.contact"));
                    car.setImage(resultSet.getString("cars.image"));
                    car.setPrice(resultSet.getDouble("cars.price"));
                    car.setUrl(resultSet.getString("cars.url"));
                    list.add(car);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static boolean delete(int id) {
        try {
            String sql = "delete from cars id= ?";
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

    public static boolean update(Car car) {
        try {
            String sql = "update cars set title = ?, description = ? , image = ?, "
                    + "contact = ?, url = ?, price = ?, categoryId = ? where id = ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, car.getTitle());
                pst.setString(2, car.getDescription());
                pst.setString(3, car.getImage());
                pst.setString(4, car.getContact());
                pst.setString(5, car.getUrl());
                pst.setDouble(6, car.getPrice());
                pst.setInt(7, car.getCategoryId());
                pst.setInt(8, car.getId());
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
