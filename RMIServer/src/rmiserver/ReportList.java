/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

/**
 *
 * @author HAPPY
 */
import java.io.Serializable;

public class ReportList implements Serializable {

    private String created_at, user_id, user_id2, description, id, money, type,fullname;

    public ReportList(String id, String money, String type, String created_at, String user_id, String user_id2, String description,String fullname) {
        this.id = id;
        this.money = money;
        this.type = type;
        this.created_at = created_at;
        this.user_id = user_id;
        this.user_id2 = user_id2;
        this.description = description;
        this.fullname=fullname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id2() {
        return user_id2;
    }

    public void setUser_id2(String user_id2) {
        this.user_id2 = user_id2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
