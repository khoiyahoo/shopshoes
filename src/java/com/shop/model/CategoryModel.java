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
public class CategoryModel implements Serializable
 {
    private int cid;
    private String cname;

    public CategoryModel() {
    }

    public CategoryModel(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "CategoryModel{" + "cid=" + cid + ", cname=" + cname + '}';
    }

   

}
