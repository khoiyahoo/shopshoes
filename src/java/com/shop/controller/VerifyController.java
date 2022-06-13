/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;

import com.shop.model.jpa.Account;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "VerifyController", urlPatterns = {"/Verify"})
public class VerifyController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           HttpSession session = request.getSession();
           Account acc = (Account) session.getAttribute("auth");
           String code  = request.getParameter("authcode");
           if(code.equals(acc.getCode())){
            out.println(" <div style=\"width: 100%; height: 70px; background-color: rgb(36, 136, 62);\">\n" +
"            <h1 style=\"text-align: center; font-size: 33px;  color: #ffffff;padding-top: 15px;\">\n" +
"                Verification Done\n" +
"            </h1>\n" +
"        </div>");
            out.println(" <a style=\"margin-left: 680px; \"href=\"Login.jsp\"><button style=\"margin-top: 30px;width: 150px; height: 40px; font-size: 15px; background-color: #0076ad; border: none;\n" +
"            border-radius: 5px; color: #ffffff;cursor: pointer;\"type=\"button\" class=\"btn btn-primary\">Back to Login</button></a> ");       
           }
           else{
               out.println(" <div style=\"width: 100%; height: 70px; background-color: rgb(167, 36, 47);\">\n" +
"            <h1 style=\"text-align: center; font-size: 33px;  color: #ffffff;padding-top: 15px;\">\n" +
"               Incorrect verification code\n" +
"            </h1>\n" +
"        </div>");
        
           }
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
