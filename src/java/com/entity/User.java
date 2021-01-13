/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author tomnyson
 */
public class User {

    public String username;
    public String password;
    public String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {

        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println("BCrypt hash: " + hash);
        this.password = hash;
    }

}
