/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;


import com.shop.dao.ProductDao;
import com.shop.model.jpa.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CategoryControl", urlPatterns = {"/category"})
public class CategoryController extends HttpServlet{
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cateID = request.getParameter("cid");
        //da lay dc category id ve roi
        ProductDao dao = new ProductDao();
        List<Product> list = dao.getProductByCIDJPA(cateID);
       PrintWriter out = response.getWriter();
        for(Product o : list){
            out.println("<div class=\"product col-12 col-md-6 col-lg-4\">\n" +
"                                <div class=\"card\">\n" +
"                                    <img class=\"card-img-top\" src=\""+o.getImage()+"\" alt=\"Card image cap\">\n" +
"                                    <div class=\"card-body\">\n" +
"                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid="+o.getPid()+"\" title=\"View Product\">"+o.getName()+"</a></h4>\n" +
"                                        <p class=\"card-text show_txt\">"+o.getTitle()+"</p>\n" +
"                                        <div class=\"row\">\n" +
"                                            <div class=\"col\">\n" +
"                                                <p class=\"btn btn-danger btn-block\">"+o.getPrice()+" $</p>\n" +
"                                            </div>\n" +
"                                            <div class=\"col\">\n" +
"                                                <a href=\"order?pcid="+o.getPid()+"\" class=\"btn btn-success btn-block\">Add to cart</a>\n" +
"                                            </div>\n" +
"                                        </div>\n" +
"                                    </div>\n" +
"                                </div>\n" +
"                            </div>");
        }     
    }
    @Override
     protected void doPost (HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
        
    }
}
