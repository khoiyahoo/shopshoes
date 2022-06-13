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
@WebServlet(name = "LoadMoreController", urlPatterns = {"/load"})
public class LoadMoreController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String amount = request.getParameter("exits");
        int iamount = Integer.parseInt(amount);
        ProductDao dao = new ProductDao();
        List<Product> list = dao.getNext3ProductJPA(iamount);
        PrintWriter out  = response.getWriter();
        for (Product o :list){
            out.println(" <div class=\"product col-12 col-md-6 col-lg-4\">\n" +
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
