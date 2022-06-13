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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
//@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
       ProductDao productDao = new ProductDao();
       List<Product> list = productDao.getTop3JPA();
       CategoryDao categoryDao = new CategoryDao();
      List<Category> listC = categoryDao.getAllCategoryJPA();
       Product last = productDao.getLastJPA();
       request.setAttribute("listP", list);    
       request.setAttribute("listCC", listC);
      request.setAttribute("p", last);

       request.getRequestDispatcher("Home.jsp").forward(request, response);
    }
    @Override
     protected void doPost (HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
        doGet(request, respone);
    }

}
