/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author tomnyson
 */
public class Car implements java.io.Serializable {

    private int id;
    private String image;
    private String title;
    private String url;
    private Double price;
    private String description;
    private String contact;
    private int categoryId;

    public Car(String title, String image, String url, Double price, String description, String contact) {
        this.title = title;
        this.image = image;
        this.url = url;
        this.price = price;
        this.description = description;
        this.contact = contact;
    }

    public Car(int id, String image, String title, String url, Double price, String description, String contact, int categoryId) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.url = url;
        this.price = price;
        this.description = description;
        this.contact = contact;
        this.categoryId = categoryId;
    }

    public Car(int id, String title, String image, String url, Double price, String description, String contact) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.url = url;
        this.price = price;
        this.description = description;
        this.contact = contact;
    }

    public Car(String image, String title, String url, Double price, String description, String contact, int categoryId) {
        this.image = image;
        this.title = title;
        this.url = url;
        this.price = price;
        this.description = description;
        this.contact = contact;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Car() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
