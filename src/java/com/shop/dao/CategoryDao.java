/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.dao;

import com.shop.connection.DBConnection;
import com.shop.model.CategoryModel;
import com.shop.model.jpa.Category;
import com.shop.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ADMIN
 */
public class CategoryDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<CategoryModel> getAllCategory() {
        List<CategoryModel> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBConnection().GetConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CategoryModel(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
 //JPA
       public List<Category> getAllCategoryJPA(){
            EntityManager em = DBUtil.getEntityManager();
            try{
            Query sql = em.createQuery("SELECT c FROM Category c", Category.class);
            @SuppressWarnings("unchecked")List<Category> list = sql.getResultList();
            return list;
            }
            finally{
                em.close();
            }   
        }
       public static void main(String[] args){
           CategoryDao dao = new CategoryDao();
           List<Category> list = dao.getAllCategoryJPA();
           System.out.println(list);
       }
}
