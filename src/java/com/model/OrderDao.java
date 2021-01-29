/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Car;
import com.entity.Item;
import com.entity.Order;
import static com.model.CarDao.conn;
import com.until.DBhelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            String sql = "INSERT INTO order (userId, total, status, address, note, createAt)"
                    + " VALUES(?, ?,?,?,?,?)";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                System.out.println("order"+ order);
                pst.setInt(1, order.getId_customer());
                pst.setFloat(2, (float)order.getTotal());
                pst.setInt(3, order.getStatus());
                pst.setString(4, order.getAddressShipping());
                pst.setString(5, order.getNote());
                pst.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
                int result = pst.executeUpdate();
//                 long orderId=-1;
//                if (result > 0) {
//                    //excute get order Id from update list item order
//                    ResultSet generatedKeys = pst.getGeneratedKeys();
//                   
//                    if (generatedKeys.next()) {
//                        orderId = generatedKeys.getLong(1);
//                    }
//                    // crete order Items
//                    String sql1 = "INSERT INTO order_detail (orderId, productId, quantity, price, total)"
//                            + " VALUES(?, ?,?,?, ?)";
//                    int count = 0;
//                     PreparedStatement pst1 = conn.prepareStatement(sql1);
//                    ArrayList<Item> list = order.getItems();
//                    Integer orderIdConvert = (int) (long)orderId;
//                    for (Item item : list) {
//                        pst1.setInt(1, orderIdConvert);
//                        pst1.setInt(2, item.getMaSp());
//                        pst1.setInt(2, item.getSoluong());
//                        pst1.setDouble(2, item.getDongia());
//                        pst1.setDouble(2, item.getDongia()*item.getSoluong());
//                        pst1.addBatch();
//                        count++;
//                        // execute every 100 rows or less
//                        if (count % 100 == 0 || count == list.size()) {
//                            pst1.executeBatch();
//                        }
//                    }
//                    return true;
//                } else {
//                    return false;
//                }
return  true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
