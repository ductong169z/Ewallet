/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.io.Serializable;

/**
 *
 * @author HAPPY
 */
public class User implements Serializable {
    
    private int id, role_id, money;
    
    private String username, fullname, phone, mail, address, gender;
    
    public User(String id, String username, String fullname, String phone, String mail, String address, String gender, String role_id, String money) {
        this.id = Integer.parseInt(id);
        this.username = username;
        this.fullname = fullname;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.gender = gender;
        this.role_id = Integer.parseInt(role_id);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    public int getRole_id() {
        return role_id;
    }
    
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getFullname() {
        return fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
