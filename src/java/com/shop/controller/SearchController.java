    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;

import com.shop.dao.CategoryDao;
import com.shop.dao.ProductDao;
import com.shop.model.CategoryModel;
import com.shop.model.ProductModel;
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
@WebServlet(name="SearchController", urlPatterns={"/search"})
public class SearchController extends HttpServlet{

     @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        ProductDao productDao =  new ProductDao();
        List<ProductModel> list = productDao.searchByName(txtSearch);
        CategoryDao categoryDao = new CategoryDao();
        List<CategoryModel> listC = categoryDao.getAllCategory();
        ProductModel last = productDao.getLast();
        request.setAttribute("listP", list);
        request.setAttribute("listCC", listC);
        request.setAttribute("p", last);
        request.setAttribute("txtS", txtSearch);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
         } catch (Exception e) {
         }       
    }
    @Override
     protected void doPost (HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
         doGet(request, respone);
     }
       
 }
   

