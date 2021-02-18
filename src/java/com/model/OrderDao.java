/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Car;
import com.entity.Item;
import com.entity.Order;
import com.entity.OrderItem;
import static com.model.CarDao.conn;
import com.until.DBhelper;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomnyson
 */
public class OrderDao {

    static Connection conn = DBhelper.getConnection();

    public static boolean createOder(Order order) {
        try {
            // b1 create order of customer 

            //b2 create order detail 
            // khái báo câu query insert
            String sql = "INSERT INTO orders (customerId, total, orderStatus, address, note, createAt) VALUES (?, ?, ?, ?, ?, ?)";
            if (conn != null) {
                // return id vừa tạo order thành công
                conn.setAutoCommit(false);
                PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setInt(1, order.getId_customer());
                pst.setDouble(2, order.getTotal());
                pst.setInt(3, order.getStatus());
                pst.setString(4, order.getAddressShipping());
                pst.setString(5, order.getNote());
                pst.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
                int result = pst.executeUpdate();
                long orderId = -1;
                if (result > 0) {
                    //excute get order Id from update list item order
                    ResultSet generatedKeys = pst.getGeneratedKeys();

                    if (generatedKeys.next()) {
                        orderId = generatedKeys.getLong(1);
                    }
                    // crete order Items
                    String sql1 = "INSERT INTO order_details (orderId, productId, quantity, price, total) VALUES(?, ?, ?, ?, ?)";
                    int count = 0;
                    PreparedStatement pst1 = conn.prepareStatement(sql1);
                    ArrayList<Item> list = order.getItems();
                    Integer orderIdConvert = (int) (long) orderId;
                    for (Item item : list) {
                        pst1.setInt(1, orderIdConvert);
                        pst1.setInt(2, item.getMaSp());
                        pst1.setInt(3, item.getSoluong());
                        pst1.setDouble(4, item.getDongia());
                        pst1.setDouble(5, item.getDongia() * item.getSoluong());
                        pst1.addBatch();
                        count++;
                        // execute every 100 rows or less
                        if (count % 100 == 0 || count == list.size()) {
                            pst1.executeBatch();
                        }
                    }
                    conn.commit();
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static List<Order> findAll(int start, int total) {
        List<Order> list = new ArrayList<Order>();
        try {
            String sql = "select * from orders order by id desc limit ?, ? ";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, (start - 1) * total);
                pst.setInt(2, total);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setId(resultSet.getInt("id"));
                    order.setId_customer(resultSet.getInt("customerId"));
                    order.setNote(resultSet.getString("note"));
                    order.setTotal(resultSet.getDouble("total"));
                    order.setStatus(resultSet.getInt("orderStatus"));
                    order.setCreateAt(resultSet.getDate("createAt"));
                    list.add(order);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static List<OrderItem> findOrderItemById(int id) {
        List<OrderItem> list = new ArrayList<OrderItem>();
        try {
            String sql = "select * from order_details where orderId = ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setId(resultSet.getInt("id"));
                    orderItem.setOrderId(resultSet.getInt("orderId"));
                    orderItem.setProductId(resultSet.getInt("productId"));
                    orderItem.setQuantity(resultSet.getInt("quantity"));
                    orderItem.setTotal(resultSet.getDouble("total"));
                    orderItem.setPrice(resultSet.getDouble("price"));
                    list.add(orderItem);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
