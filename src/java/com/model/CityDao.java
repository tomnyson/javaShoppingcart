/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.City;
import com.entity.Product;
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
public class CityDao {

    static Connection conn = DBhelper.getConnection();

    public static List<City> findAll() {
        List<City> list = new ArrayList<City>();
        try {
            String sql = "select * from tinhthanhpho";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    City city = new City();
                    city.setMatp(resultSet.getInt("matp"));
                    city.setName(resultSet.getString("name"));
                    city.setType(resultSet.getString("type"));
                    list.add(city);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
