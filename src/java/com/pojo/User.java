/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import org.mindrot.jbcrypt.BCrypt;
import java.io.Serializable;
/**
 *
 * @author tomnyson
 */
public class User implements Serializable {

    public String username;
    public String password;
    public String role;
    public int Id;

    public User(String username, String password, String role, int Id) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.Id = Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

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
     public User(){
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
//        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        this.password = password;
    }

}
