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
public class City {
    int matp;
    String name;
    String type;

    public City(int matp, String name, String type) {
        this.matp = matp;
        this.name = name;
        this.type = type;
    }

    public City() {
    }

    public int getMatp() {
        return matp;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setMatp(int matp) {
        this.matp = matp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
