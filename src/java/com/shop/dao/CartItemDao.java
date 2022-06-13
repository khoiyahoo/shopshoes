/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.dao;

import com.shop.model.CartItem;
import com.shop.model.ProductModel;
import com.shop.model.jpa.Cartitem;
import com.shop.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CartItemDao {
      
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public CartItem getCartItemByID(int id) throws SQLException {
        //CartItem cartItem = new CartItem();
        ProductDao dao = new ProductDao();
        ProductModel product = dao.getProductByID(id);        
        return new CartItem(product, 1);
    } 
    
    //JPA
        public Cartitem  getCartitemByIdJPA (int id){
        EntityManager em = DBUtil.getEntityManager();
        try {
            Cartitem cartitem = em.find(Cartitem.class, id);
            return cartitem;
        }finally{
            em.close();
        }
    }
        
      public void insertCartItemJPA(Cartitem cartitem) {
        EntityManager em = DBUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(cartitem);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    public static void main(String[] args) throws SQLException{
        CartItem cart = new CartItem();
        
        CartItemDao dao = new CartItemDao();
       // cart = dao.getCartItemByID(1);
        System.out.println(cart.toString());
    }
}
