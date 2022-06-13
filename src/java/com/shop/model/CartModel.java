/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.model;

/**
 *
 * @author ADMIN
 */
public class CartModel {
    private int id ;
    private int cartaccountID;
    private int cartproductID;
    private int cartamount;

    public CartModel(int id, int cartaccountID, int cartproductID, int cartamount) {
        this.id = id;
        this.cartaccountID = cartaccountID;
        this.cartproductID = cartproductID;
        this.cartamount = cartamount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartaccountID() {
        return cartaccountID;
    }

    public void setCartaccountID(int cartaccountID) {
        this.cartaccountID = cartaccountID;
    }

    public int getCartproductID() {
        return cartproductID;
    }

    public void setCartproductID(int cartproductID) {
        this.cartproductID = cartproductID;
    }

    public int getCartamount() {
        return cartamount;
    }

    public void setCartamount(int cartamount) {
        this.cartamount = cartamount;
    }

    public CartModel() {
    }
 
    
   
    
}
