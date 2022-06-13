/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.dao;

import com.shop.model.jpa.Account;
import com.shop.model.jpa.Cart;
import com.shop.utils.DBUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author ADMIN
 */
public class CartDao {
        //JPA
    public void insertCartJPA(Cart cart) {
        EntityManager em = DBUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(cart);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
    public static void main (String[] args){
        Account  acc = new Account();
       acc.setUID(1);
       acc.setUser("khoi1");
       acc.setPass("123");
       acc.setIsSell(0);
       acc.setIsAdmin(0);
       acc.setEmail("19110010@student.hcmute.edu.vn");
       acc.setCode("196767");
       Cart cart = new Cart();
       cart.setAccountID(acc);
       cart.setName("Khoi");
       cart.setPhone("09323232");
        cart.setAddress("Ben tre");       
        CartDao dao = new CartDao();
        dao.insertCartJPA(cart); 
        
    }
}
