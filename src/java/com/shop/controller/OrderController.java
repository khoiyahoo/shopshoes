/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;


import com.shop.dao.ProductDao;

import com.shop.model.jpa.Cartitem;
import com.shop.model.jpa.Product;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "OrderController", urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String qnt = request.getParameter("amount");
        int quantity = 1;
        int id = Integer.parseInt(request.getParameter("pcid"));
         ProductDao pdao = new ProductDao();
         Product product = pdao.getProductByIdJPA(id);
        if (product != null) {
            HttpSession session = request.getSession();
            List<Cartitem> list = new ArrayList<Cartitem>();
            if (session.getAttribute("ses") == null) {
                Cartitem cartitem = new Cartitem();
                cartitem.setProductid(product);
                cartitem.setAmount(quantity);
                list.add(cartitem);
                session.setAttribute("ses", list);
            } else {
                list = (List) session.getAttribute("ses");
                Cartitem cartitem = new Cartitem();
                Boolean check = false;
                for (Cartitem c : list) {
                    if ((Objects.equals(c.getProductid().getPid(), product.getPid()))) {
                        c.setAmount(c.getAmount() + quantity);
                        check = true;
                    }
                }
                if (check == false) {
                    cartitem.setProductid(product);
                    cartitem.setAmount(quantity);
                    list.add(cartitem);
                    
                }
                session.setAttribute("ses", list);
            }
            response.sendRedirect("show");
        }
        else{
        response.sendRedirect("Home.jsp");
        }
       

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
