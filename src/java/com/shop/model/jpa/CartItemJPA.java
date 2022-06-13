/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.model.jpa;

/**
 *
 * @author ADMIN
 */
public class CartItemJPA {
    private Product product;
    private int amount; 

    public CartItemJPA(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public CartItemJPA() {
       
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CartItemJPA{" + "product=" + product + ", amount=" + amount + '}';
    }
}
