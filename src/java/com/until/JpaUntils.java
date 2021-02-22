/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.until;

import javax.persistence.*;

/**
 *
 * @author tomnyson
 */
public class JpaUntils {
    private static EntityManagerFactory factory;
    public static EntityManager getEntityManager() {
     if(factory == null || !factory.isOpen()) {
         factory = Persistence.createEntityManagerFactory("BanHangPU");
     }
     return factory.createEntityManager();
    }
    public  static void  shutdown() {
     if(factory != null && factory.isOpen()) {
         factory.close();
     }
     factory = null;
    }
}
