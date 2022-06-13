/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;

import com.shop.dao.AccountDao;
import com.shop.model.jpa.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie arr[] = request.getCookies();
        if(arr != null){
            for(Cookie o : arr){
                if(o.getName().equals("userC")){
                    request.setAttribute("username", o.getValue());
                }
                if(o.getName().equals("passC")){
                    request.setAttribute("password", o.getValue());
                }
             }
        }     
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        String username  = request.getParameter("user");
        String password  = request.getParameter("pass");
        String remember = request.getParameter("remember"); 
        AccountDao dao = new AccountDao();
        Account a = dao.loginJPA(username, password);
        if( a == null) {
            request.setAttribute("mess", "Wrong user or password");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            
            //luu account tren cookie
            Cookie u = new Cookie("userC", username);
            Cookie p = new Cookie("passC",password);
            u.setMaxAge(60*60*24*365);
            if(remember != null){
                 p.setMaxAge(60*60*24*365);
            }else {
                p.setMaxAge(0);
            }     
            response.addCookie(u); //luu u vs p len browser
            response.addCookie(p);
            response.sendRedirect("home");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
