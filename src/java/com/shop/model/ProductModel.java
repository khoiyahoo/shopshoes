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
public class ProductModel implements Serializable
{
    
    private int id;
    private String pname;
    private String pimage;
    private double pprice;
    private String ptitle;
    private String pdescription;
    private int pcateid;
    private int psell_id;

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public int getPcateid() {
        return pcateid;
    }

    public void setPcateid(int pcateid) {
        this.pcateid = pcateid;
    }

    public int getPsell_id() {
        return psell_id;
    }

    public void setPsell_id(int psell_id) {
        this.psell_id = psell_id;
    }

    public ProductModel(int id, String pname, String pimage, double pprice, String ptitle, String pdescription, int pcateid, int psell_id) {
        this.id = id;
        this.pname = pname;
        this.pimage = pimage;
        this.pprice = pprice;
        this.ptitle = ptitle;
        this.pdescription = pdescription;
        this.pcateid = pcateid;
        this.psell_id = psell_id;
    }

    @Override
    public String toString() {
        return "ProductModel{" + "id=" + id + ", pname=" + pname + ", pimage=" + pimage + ", pprice=" + pprice + ", ptitle=" + ptitle + ", pdescription=" + pdescription + ", pcateid=" + pcateid + ", psell_id=" + psell_id + '}';
    }

   
  

}
