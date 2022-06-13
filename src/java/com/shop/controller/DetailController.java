/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;

import com.shop.dao.CategoryDao;
import com.shop.dao.ProductDao;
import com.shop.model.jpa.Category;
import com.shop.model.jpa.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
 
@WebServlet(name = "DetailController", urlPatterns = {"/detail"})

public class DetailController extends HttpServlet{
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("pid"));
        ProductDao dao = new ProductDao();
        Product p = dao.getProductByIdJPA(id);
        CategoryDao categoryDao = new CategoryDao();
        List<Category> listC = categoryDao.getAllCategoryJPA();
        Product last = dao.getLastJPA();

        request.setAttribute("detail", p);
        request.setAttribute("listCC", listC);
        request.setAttribute("p", last);
        request.getRequestDispatcher("Detail.jsp").forward(request, response);

         } catch (Exception e) {
         }       
    }
    @Override
     protected void doPost (HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
        
    }
}
