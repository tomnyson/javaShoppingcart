/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.District;
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
public class DistrictDao {
    static Connection conn = DBhelper.getConnection();

    public static List<District> findAllByTp(int maTp) {
        List<District> list = new ArrayList<District>();
        try {
            String sql = "select * from quanhuyen where matp = ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, maTp);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    District district = new District();
                    district.setMaqh(resultSet.getInt("maqh"));
                    district.setMatp(resultSet.getInt("matp"));
                    district.setName(resultSet.getString("name"));
                    district.setType(resultSet.getString("type"));
                    list.add(district);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
