/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.dao;

import com.shop.connection.DBConnection;
import com.shop.model.AccountModel;
import com.shop.model.jpa.Account;
import com.shop.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ADMIN
 */
public class AccountDao {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public AccountModel login(String user, String pass) {
        String query = "select * from Account\n"
                + "where user = ?\n"
                + "and pass = ?";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AccountModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),    
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
 //JPA
    public Account loginJPA(String user, String pass) {
    EntityManager em = DBUtil.getEntityManager();
    String sql = "SELECT a FROM Account a WHERE a.user = :user and a.pass = :pass";
    TypedQuery<Account> q = em.createQuery(sql, Account.class);
    q.setParameter("user", user);
    q.setParameter("pass", pass);
    try{
        
        Account acc = q.getSingleResult();
        return acc;
    }catch (NoResultException e ){
        return null;
    }finally{
        em.close();
    }
    }
    public AccountModel checkAccountExist(String user) {
        String query = "select * from Account\n"
                + "where user = ?\n";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AccountModel(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
//JPA
    public Account checkAccountExistJPA(String user) {
        EntityManager em = DBUtil.getEntityManager();
        String sql = "SELECT a FROM Account a WHERE a.user = :user";
        TypedQuery<Account> q = em.createQuery(sql, Account.class);
        q.setParameter("user", user);
        try{
        
            Account acc = q.getSingleResult();
            return acc;
        }catch (NoResultException e ){
        return null;
        }finally{
        em.close();
        }
    }
    public void singup(String user, String pass) {
        String query = "insert into Account (user, pass, isSell, isAdmin) values (?,?,0,0)";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    //JPA 
    public void signupJPA(Account acc){
        EntityManager em = DBUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(acc);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    //JPA
    //JPA 
    public List<Account> getAllAccountJPA(){
            EntityManager em = DBUtil.getEntityManager();
            try{
            Query sql = em.createQuery("SELECT a FROM Account a", Account.class);
            @SuppressWarnings("unchecked")List<Account> list = sql.getResultList();
            return list;
            }
            finally{
                em.close();
            }   
        }
       //JPA 
        public Account getAccountByNameJPA (String user){
       EntityManager em = DBUtil.getEntityManager();
        String sql = "SELECT a FROM Account a WHERE a.user = :user";
        TypedQuery<Account> q = em.createQuery(sql, Account.class);
        q.setParameter("user", user);
        q.setMaxResults(1);
        try{   
            Account acc = q.getSingleResult();
            return acc;
        }catch (NoResultException e ){
        return null;
        }finally{
        em.close();
        }

    }
                //JPA 
    public static Account  getAccountByIdJPA (int id){
        EntityManager em = DBUtil.getEntityManager();
        try {
            Account account = em.find(Account.class, id);
            return account;
        }finally{
            em.close();
        }
    }
         //JPA 
        public void editAccountJPA(Account account) {
        EntityManager em = DBUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();   
        trans.begin();
        try{
            em.merge(account);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
        
    }
        //JPA
    public void insertAccountJPA(Account account) {
       EntityManager em = DBUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(account);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
      //JPA
        public void deleteAccountJPA(String user){
        EntityManager em = DBUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            Account username = getAccountByNameJPA(user);
            if (username != null) {
                em.remove(username);
            } else {
                throw new Exception("User can not found");
            }
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        } finally {
            em.close();
        }
    }
        
        //JPA 
    public List<Account> getNext3AccountJPA(int amount) {
     EntityManager em = DBUtil.getEntityManager();
            try{
            Query sql = em.createNativeQuery("select * from Account order by uID asc limit ?,3", Account.class);
             sql.setParameter(1, amount);
            @SuppressWarnings("unchecked")List<Account> list = sql.getResultList();
            return list;
            }
            finally{
                em.close();
            }   
    }
     //JPA 
     public List<Account> getTop5UserJPA() {
            EntityManager em = DBUtil.getEntityManager();
            try{
            Query sql = em.createNativeQuery("select * from Account order by uID asc limit 0,5", Account.class);
            @SuppressWarnings("unchecked")List<Account> list = sql.getResultList();
            return list;
            }
            finally{
                em.close();
            }   
        }
    public static void main (String[] args) {
        AccountDao dao = new AccountDao();
       // List<Account> ls = dao.getAllAccountJPA();
       //Product p = dao.getProductByIdJPA(1);
        EntityManager em = DBUtil.getEntityManager();
         EntityTransaction trans = em.getTransaction();
//       Account a = new Account();
//       a =  em.find(Account.class, 1);
//       trans.begin();
//       a.setPass("123");
//        trans.commit();
//       dao.editAccountJPA(a);
      //List<Account> acc =dao.getAllAccountJPA();
        //Account acc = dao.getAccountByIdJPA("Adam");
       //System.out.println(a.getPass()+ " " +a.getUser());
//         Account acc = dao.getAccountByNameJPA("Adam");
//           trans.begin();
//         acc.setPass("khoi");
//           trans.commit();
        Account acc = dao.getAccountByNameJPA("Adam");
        // dao.editAccountJPA(acc);
        System.out.println(acc.getPass()+ " " +acc.getUser());
  
    }

}
