/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.dao;

import com.shop.connection.DBConnection;
import com.shop.model.ProductModel;
import com.shop.model.jpa.Product;
import com.shop.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
/**
 *
 * @author ADMIN
 */
public class ProductDao {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ProductModel> getAllProduct() throws SQLException {
        List<ProductModel> list = new ArrayList<>();
        String query = "select * from Product";
        try {
            conn =  new DBConnection().GetConnection();//mo ket noi voi sql
            //ps = conn.prepareStatement(query);
          
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), 
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
  //JPA 
    public List<Product> getAllProductJPA(){
            EntityManager em = DBUtil.getEntityManager();
            try{
            Query sql = em.createQuery("SELECT p FROM Product p", Product.class);
           @SuppressWarnings("unchecked")List<Product> list = sql.getResultList();
            return list;
            }
            finally{
                em.close();
            }   
        }
    public List<ProductModel> getTop3() throws SQLException {
        List<ProductModel> list = new ArrayList<>();
        String query = "select * from Product order by pid limit 0,3;";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
  //JPA 
     public List<Product> getTop3JPA() {
            EntityManager em = DBUtil.getEntityManager();
            try{
            Query sql = em.createNativeQuery("select * from Product order by pid asc limit 0,3", Product.class);
            @SuppressWarnings("unchecked")List<Product> list = sql.getResultList();
            return list;
            }
            finally{
                em.close();
            }   
        }
    
    public List<ProductModel> getNext3Product(int amount) {
        List<ProductModel> list = new ArrayList<>();
        String query = "SELECT *\n"
                + "  FROM Product\n"
                + " ORDER BY pid\n"
                + "OFFSET ? ROWS\n"
                + " FETCH NEXT 3 ROWS ONLY";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    //JPA 
    public List<Product> getNext3ProductJPA(int amount) {
     EntityManager em = DBUtil.getEntityManager();
            try{
            Query sql = em.createNativeQuery("select * from Product order by pid asc limit ?,3", Product.class);
             sql.setParameter(1, amount);
            @SuppressWarnings("unchecked")List<Product> list = sql.getResultList();
            return list;
            }
            finally{
                em.close();
            }   
    }
    public List<ProductModel> getProductByCID(String cid) {
        List<ProductModel> list = new ArrayList<>();
        String query = "select * from Product\n"
                + "where cateID = ?";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    //JPA 
    public List<Product> getProductByCIDJPA(String cid) {
        EntityManager em = DBUtil.getEntityManager();
        try{
        Query sql = em.createNativeQuery("select * from Product where cateID = ?", Product.class);
        sql.setParameter(1, cid);
       @SuppressWarnings("unchecked") List<Product> list = sql.getResultList();
        return list;
        }
        finally{
            em.close();
        }   
    }
    public List<ProductModel> getProductBySellID(int id) {
        List<ProductModel> list = new ArrayList<>();
        String query = "select * from Product\n"
                + "where sell_ID = ?";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    //JPA
     public List<Product> getProductBySellIDJPA(int sid) {
        EntityManager em = DBUtil.getEntityManager();
        try{
        Query sql = em.createNativeQuery("select * from Product where sell_ID = ?", Product.class);
        sql.setParameter(1, sid);
        @SuppressWarnings("unchecked")List<Product> list = sql.getResultList();
        return list;
        }
        finally{
            em.close();
        }   
    }
    public List<ProductModel> searchByName(String txtSearch) {
        List<ProductModel> list = new ArrayList<>();
        String query = "select * from Product\n"
                + "where name like ?";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
      //JPA
     public List<Product> searchByNameJPA(String txtSearch) {
        EntityManager em = DBUtil.getEntityManager();
        try{
        Query sql = em.createNativeQuery("select * from Product where name like '%"+txtSearch+"%'", Product.class);
        //sql.setParameter(1, txtSearch);
        @SuppressWarnings("unchecked")List<Product> list = sql.getResultList();
        return list;
        }
        finally{
            em.close();
        }   
    }
    public ProductModel getProductByID(int id) {
        String query = "select * from Product\n"
                + "where pid = ?";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }
        //JPA 
    public Product  getProductByIdJPA (int id){
        EntityManager em = DBUtil.getEntityManager();
        try {
            Product product = em.find(Product.class, id);
            return product;
        }finally{
            em.close();
        }
    }
    public ProductModel getLast() {
        String query = "select  * from Product\n"
                + "order by pid desc limit 0,1;";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ProductModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }
    //JPA
    public Product getLastJPA() {
    EntityManager em = DBUtil.getEntityManager();
    try {
        Query sql = em.createNativeQuery("select * from Product order by pid desc limit 0,1", Product.class);
        Product product = (Product) sql.getSingleResult();
        return product;
        }finally{
            em.close();
        }
    }

    public void deleteProduct(String pid) {
        String query = "delete from Product\n"
                + "where pid = ?";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    //JPA
        public void deleteProductJPA(int id){
        EntityManager em = DBUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            Product product = em.find(Product.class, id);
            if (product != null) {
                em.remove(product);
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
    public void insertProduct(String name, String image, String price,
        String title, String description, String category, int sid) {
        String query = "INSERT Product \n"
                + "(name, image, price, title, description, cateID, sell_ID)\n"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    //JPA
    public void insertProductJPA(Product product) {
       EntityManager em = DBUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(product);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    public void editProduct(String name, String image, String price,
            String title, String description, String category, String pid) {
        String query = "update Product\n"
                + "set name = ?,\n"
                + "image = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "description = ?,\n"
                + "cateID = ?\n"
                + "where pid = ?";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
        //JPA 
        public void editProductJPA(Product product) {
        EntityManager em = DBUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
           em.merge(product);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }finally{
            em.close();
        }
    }
    public static void main (String[] args) throws SQLException {
        ProductDao dao = new ProductDao();
        List<Product> ls = dao.searchByNameJPA("giày");
       // Product p = dao.getProductByIdJPA(1);
        System.out.println(ls);
    }

}
