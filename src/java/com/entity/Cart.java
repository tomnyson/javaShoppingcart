/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tomnyson
 */
public class Cart {

    private ArrayList<Item> cart;
    
    public Cart() {
        this.cart = new ArrayList<Item>();
    }
    public Cart(ArrayList<Item> cart) {
        this.cart = cart;
    }

    public void addCart(Item item) {
        try {
            System.out.println("add cart"+cart.size());
        if (cart.contains(item)) {
            Item hang = cart.get(cart.indexOf(item));
            hang.setSoluong(item.getSoluong() + item.getSoluong());
        } else {
            cart.add(item);
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public void removeCart(Item item) {
        if (cart.contains(item)) {
            Item hang = cart.get(cart.indexOf(item));
            cart.remove(item);
        }
    }

    public double TotalOrder() {
        double tongtien = 0;
        for (Item item : cart) {
            tongtien += item.getSoluong() * item.getDongia();
        }
        return  tongtien;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }
     public int kichThuoc() {
        return cart.size();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cart);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cart other = (Cart) obj;
        if (!Objects.equals(this.cart, other.cart)) {
            return false;
        }
        return true;
    }
    

}
