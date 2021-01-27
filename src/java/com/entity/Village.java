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
public class Village {
    int xaid;
    String name;
    String type;
    int maqh;

    public int getXaid() {
        return xaid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getMaqh() {
        return maqh;
    }

    public void setXaid(int xaid) {
        this.xaid = xaid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMaqh(int maqh) {
        this.maqh = maqh;
    }

    public Village() {
    }

    public Village(int xaid, String name, String type, int maqh) {
        this.xaid = xaid;
        this.name = name;
        this.type = type;
        this.maqh = maqh;
    }
    
}
