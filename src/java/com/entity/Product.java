/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Date;

/**
 *
 * @author tomnyson
 */
public class Product {
    public int id;
    public String name;
    public String description;
    public Float price;
    public int stock;
    public  Float discount;
    public Date createAt;
    public int categoryId;

    public Product() {
    }

    public Product(String name, String description, Float price, int stock, Float discount, Date createAt, int categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.discount = discount;
        this.createAt = createAt;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Float getDiscount() {
        return discount;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
}
