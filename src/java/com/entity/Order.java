package com.entity;

import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomnyson
 */
public class Order {
    int id;
    int id_customer;
    double total;
    int status;
    String addressShipping;
    String note;
    ArrayList<Item> items;
    Date createAt;

    public Order(int id_customer, double total, int status, String addressShipping, String note, ArrayList<Item> items) {
        this.id_customer = id_customer;
        this.total = total;
        this.status = status;
        this.addressShipping = addressShipping;
        this.note = note;
        this.items = items;
    }

    public Order(int id, int id_customer, double total, int status, String addressShipping, String note, ArrayList<Item> items, Date createAt) {
        this.id = id;
        this.id_customer = id_customer;
        this.total = total;
        this.status = status;
        this.addressShipping = addressShipping;
        this.note = note;
        this.items = items;
        this.createAt = createAt;
    }

    public String getAddressShipping() {
        return addressShipping;
    }

    public String getNote() {
        return note;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setAddressShipping(String addressShipping) {
        this.addressShipping = addressShipping;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    

    public Order() {
    }

    public int getId() {
        return id;
    }

    public int getId_customer() {
        return id_customer;
    }

    public double getTotal() {
        return total;
    }

    public int getStatus() {
        return status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    
}
