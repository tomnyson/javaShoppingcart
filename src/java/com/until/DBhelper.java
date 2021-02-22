/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tomnyson
 */
public class DBhelper {
      public static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String dbURL = "jdbc:mysql://192.168.64.2:3306/shopping";
    private static final String userName = "dev";
    private static final String password = "dev";
    private static Connection conn = null;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    public static EntityManager getJpaConnect() {
        EntityManager em = null;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("BanHangPU");
            em = factory.createEntityManager();
        } catch (Exception e) {
        }
        return em;
    }
}
