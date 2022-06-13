/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.model;

public class CartItem {
    private ProductModel product;
    private int amount;

    public CartItem(ProductModel product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" + "product=" + product + ", amount=" + amount + '}';
    }

    
    
}
