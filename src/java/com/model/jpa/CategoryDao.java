/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.jpa;

import com.pojo.Cars;
import com.pojo.Category;
import com.until.JpaUntils;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author tomnyson
 */
public class CategoryDao {

    private static EntityManager em = JpaUntils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        em.close(); // close khi thoát chương trình
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Category> findAll(int start, int total) {
        List<Category> cats = new ArrayList<Category>();
        try {
            cats = em.createQuery("SELECT distinct c from Category c join fetch c.cars car")
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cats;
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
