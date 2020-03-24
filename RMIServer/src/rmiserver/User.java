/**
 *
 * @author Wibuu Group, consists of 3 members:
 * @author Nguyen Duc Tong
 * @author Quan Duc Loc
 * @author Tran Minh Thang
 *
 */
package rmiserver;

import java.io.Serializable;

public class User implements Serializable {

    private int id, role_id, money, deposit_lim, withdraw_lim, trans_lim;

    private String username, fullname, phone, mail, address, gender;

    public User() {

    }

    public User(String id, String username, String fullname, String phone, String mail, String address, String gender, String role_id, String money, String deposit_lim, String withdraw_lim, String trans_lim) {
        this.id = Integer.parseInt(id);
        this.username = username;
        this.fullname = fullname;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.gender = gender;
        this.role_id = Integer.parseInt(role_id);
        this.money = Integer.parseInt(money);
        this.deposit_lim = Integer.parseInt(deposit_lim);
        this.withdraw_lim = Integer.parseInt(withdraw_lim);
        this.trans_lim = Integer.parseInt(trans_lim);
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

    public int getDeposit_lim() {
        return deposit_lim;
    }

    public void setDeposit_lim(int deposit_lim) {
        this.deposit_lim = deposit_lim;
    }

    public int getWithdraw_lim() {
        return withdraw_lim;
    }

    public void setWithdraw_lim(int withdraw_lim) {
        this.withdraw_lim = withdraw_lim;
    }

    public int getTrans_lim() {
        return trans_lim;
    }

    public void setTrans_lim(int trans_lim) {
        this.trans_lim = trans_lim;
    }
}
