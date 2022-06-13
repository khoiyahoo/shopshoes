/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;

import com.shop.dao.CartDao;
import com.shop.dao.CartItemDao;

import com.shop.model.jpa.Account;
import com.shop.model.jpa.Cart;
import com.shop.model.jpa.Cartitem;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

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
@WebServlet(name = "PaymentController", urlPatterns = {"/pay"})
public class PaymentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
        String user = request.getParameter("check-login");
        if(user == null || user.equals("")){
            response.sendRedirect("Login.jsp");
        }
        else{     
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        String name = request.getParameter("infor-name");
        String phone = request.getParameter("infor-phone");
        String address = request.getParameter("infor-address");
        Cart cart = new Cart();
        cart.setAccountID(acc);
        cart.setName(name);
        cart.setPhone(phone);
        cart.setAddress(address);       
        CartDao dao = new CartDao();
        dao.insertCartJPA(cart);   
        List<Cartitem> listcartItem =  (List)session.getAttribute("ses");
        for(Cartitem  c : listcartItem){
           Cartitem cartitem = new Cartitem(); 
           cartitem.setCartid(cart);
           cartitem.setAmount(c.getAmount());
           cartitem.setProductid(c.getProductid());
           CartItemDao cartitemdao = new CartItemDao();          
           cartitemdao.insertCartItemJPA(cartitem);
          
        }
        session.removeAttribute("ses"); 
        session.removeAttribute("totalamount");
        //response.sendRedirect("home");
        PrintWriter out = response.getWriter();
        out.println(" <div style=\"width: 100%; height: 70px; background-color: rgb(36, 136, 62);\">\n" +
"            <h1 style=\"text-align: center; font-size: 33px;  color: #ffffff;padding-top: 15px;\">\n" +
"                Oder successfully\n" +
"            </h1>\n" +
"        </div>");
            out.println(" <a style=\"margin-left: 680px; \"href=\"home\"><button style=\"margin-top: 30px;width: 150px; height: 40px; font-size: 15px; background-color: #0076ad; border: none;\n" +
"            border-radius: 5px; color: #ffffff;cursor: pointer;\"type=\"button\" class=\"btn btn-primary\">Back to Home</button></a> ");       

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
