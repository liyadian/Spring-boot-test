package com.lyd.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue
    private String username;
    private String password;
    private int isAllowedGrant;
    private int isAllowedUp;
    private int isAllowedDele;
    private int isAllowedCheck;


    public UserEntity() {}

    public UserEntity(String username, String password){
        this.username = username;
        this.password = password;
        this.isAllowedGrant = 0;
        this.isAllowedUp = 0;
        this.isAllowedDele = 0;
        this.isAllowedCheck = 0;
    }

    @Override
    public String toString(){
        return "UserEntity [ username:" + username + "  password:" + password + " isAllowedGrant:" + isAllowedGrant +
                " isAllowedUp:" + isAllowedUp + " isAllowedDele:" + isAllowedDele + "  isAllowedCheck:" + isAllowedCheck + "]";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsAllowedGrant(int isAllowedGrant) {
        this.isAllowedGrant = isAllowedGrant;
    }

    public void setIsAllowedUp(int isAllowedUp) {
        this.isAllowedUp = isAllowedUp;
    }

    public void setIsAllowedDele(int isAllowedDele) {
        this.isAllowedDele = isAllowedDele;
    }

    public void setIsAllowedCheck(int isAllowedCheck) {
        this.isAllowedCheck = isAllowedCheck;
    }

    public String getPassword() {
        return password;
    }

    public int getIsAllowedGrant() {
        return isAllowedGrant;
    }

    public int getIsAllowedUp() {
        return isAllowedUp;
    }

    public int getIsAllowedDele() {
        return isAllowedDele;
    }

    public int getIsAllowedCheck() {
        return isAllowedCheck;
    }

    public String getUsername() {
        return username;
    }
}
