/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Village;
import static com.model.CityDao.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomnyson
 */
public class VillageDao {
      public static List<Village> findAllByQuan(int maH) {
        List<Village> list = new ArrayList<Village>();
        try {
            String sql = "select * from xaphuongthitran where maqh = ?";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                 pst.setInt(1, maH);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    Village village = new Village();
                    village.setMaqh(resultSet.getInt("maqh"));
                    village.setName(resultSet.getString("name"));
                    village.setType(resultSet.getString("type"));
                    village.setXaid(resultSet.getInt("xaid"));
                    list.add(village);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
