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
public class Item {
    private int maSp;
    private String image; 
    private int soluong;
    private double dongia;
    private String title ;

    public Item(int maSp, String image, int soluong, double dongia, String title ) {
        this.maSp = maSp;
        this.image = image;
        this.soluong = soluong;
        this.dongia = dongia;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getMaSp() {
        return maSp;
    }

    public String getImage() {
        return image;
    }

    public int getSoluong() {
        return soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
    
}
