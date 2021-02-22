/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.jpa;

import com.entity.Car;
import com.pojo.Cars;
import com.until.DBhelper;
import com.until.JpaUntils;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author tomnyson
 */
public class CarsDao {

    private static EntityManager em = JpaUntils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        em.close(); // close khi thoát chương trình
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Cars> findAll(int start, int total) {
        List<Cars> list = new ArrayList<Cars>();
        try {
//            String jpql = "SELECT o from Cars o";
//            TypedQuery<Cars> query = em.createQuery(jpql, Cars.class);
            // dùng theo kiểu name query 
//            Query query = em.createNamedQuery("Cars.findAll");
//            query.setFirstResult(start);
//            query.setMaxResults(total);
//            list = query.getResultList();
// dùng theo kiểu soạn query bình thường
//            list = query.getResultList();
            list = em.createQuery("SELECT distinct c from Cars c join c.cat cat").getResultList();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static Cars findAllbyId(int id) {
        Cars car = new Cars();
        try {
            car = em.find(Cars.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return car;
    }

    public static boolean create(Cars car) {
        boolean result = false;
        try {
            em.persist(car);
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

    public static boolean remove(Cars car) {
        boolean result = false;
        try {
            em.remove(car);
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

    public static boolean update(Cars car) {
        boolean result = false;
        try {
            em.merge(car);
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

}
