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
public class District {

    int maqh;
    String name;
    String type;
    int matp;

    public District() {
    }

    public District(int maqh, String name, String type, int matp) {
        this.maqh = maqh;
        this.name = name;
        this.type = type;
        this.matp = matp;
    }

    public int getMaqh() {
        return maqh;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getMatp() {
        return matp;
    }

    public void setMaqh(int maqh) {
        this.maqh = maqh;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMatp(int matp) {
        this.matp = matp;
    }

}
