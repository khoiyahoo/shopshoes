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
@WebServlet(name = "SubController", urlPatterns = {"/sub"})
public class SubController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
         response.setContentType("text/html;charset=UTF-8");
         int pid = Integer.parseInt(request.getParameter("psubid"));
         ProductDao pdao = new ProductDao();
         Product product = pdao.getProductByIdJPA(pid);
        Cartitem cartitem = new Cartitem();
        HttpSession session = request.getSession();
        List<Cartitem> list = (List) session.getAttribute("ses");
        for (int i=0;i<list.size();i++) {
            if (Objects.equals(list.get(i).getProductid().getPid(), product.getPid())) {
                if (list.get(i).getAmount() == 1) {
                     list.remove(i);
                } else {
                    list.get(i).setAmount(list.get(i).getAmount() - 1);
                }
               
            }
        }
        session.setAttribute("ses", list);
        response.sendRedirect("show");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
