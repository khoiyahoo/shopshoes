/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;

import com.shop.dao.AccountDao;
import com.shop.model.jpa.Account;
import com.shop.utils.SendEmailUtil;
import java.io.IOException;
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
@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       String user = request.getParameter("user");
       String pass = request.getParameter("pass");
       String re_pass = request.getParameter("repass");
       String email = request.getParameter("email");
       if(!pass.equals(re_pass)){
           request.setAttribute("mess", "Password and confirm password do not match!");
           request.getRequestDispatcher("Login.jsp").forward(request, response);
       }else {
           AccountDao dao = new AccountDao();
           Account a = dao.checkAccountExistJPA(user);
           if(a == null) {
              Account acc = new Account();
              SendEmailUtil sm = new SendEmailUtil();
              String code = sm.getRandom();
              acc.setUser(user);
              acc.setPass(pass);
              acc.setIsSell(0);
              acc.setIsAdmin(0);
              acc.setEmail(email);
              acc.setCode(code);             
              boolean test = sm.sendEmail(acc);
              if(test){
                  dao.signupJPA(acc);
                  HttpSession session = request.getSession();
                  session.setAttribute("auth", acc);    
                  request.getRequestDispatcher("VerifyCode.jsp").forward(request, response);
              }   
              else {
                   request.getRequestDispatcher("Login.jsp").forward(request, response);
              }
           } else {
              request.setAttribute("mess", "Account already exist!");
              request.getRequestDispatcher("Login.jsp").forward(request, response);
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
