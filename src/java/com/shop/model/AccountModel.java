/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class AccountModel implements Serializable{
    
    private int id;
    private String auser;
    private String apass;
    private int aisSell;
    private int aisAdmin;

    public AccountModel(int id, String auser, String apass, int aisSell, int aisAdmin) {
        this.id = id;
        this.auser = auser;
        this.apass = apass;
        this.aisSell = aisSell;
        this.aisAdmin = aisAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuser() {
        return auser;
    }

    public void setAuser(String auser) {
        this.auser = auser;
    }

    public String getApass() {
        return apass;
    }

    public void setApass(String apass) {
        this.apass = apass;
    }

    public int getAisSell() {
        return aisSell;
    }

    public void setAisSell(int aisSell) {
        this.aisSell = aisSell;
    }

    public int getAisAdmin() {
        return aisAdmin;
    }

    public void setAisAdmin(int aisAdmin) {
        this.aisAdmin = aisAdmin;
    }

    @Override
    public String toString() {
        return "AccountModel{" + "id=" + id + ", auser=" + auser + ", apass=" + apass + ", aisSell=" + aisSell + ", aisAdmin=" + aisAdmin + '}';
    }

   
}
