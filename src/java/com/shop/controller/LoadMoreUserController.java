/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;

import com.shop.dao.AccountDao;
import com.shop.model.jpa.Account;
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
@WebServlet(name = "LoadMoreUserController", urlPatterns = {"/loaduser"})
public class LoadMoreUserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String amount = request.getParameter("exits");
        int iamount = Integer.parseInt(amount);
        AccountDao dao = new AccountDao();
        List<Account> list = dao.getNext3AccountJPA(iamount);
        PrintWriter out  = response.getWriter();
          for (Account o :list){
              out.println("<tr class=\"user\">\n" +
"                                <td>\n" +
"                                    <span class=\"custom-checkbox\">\n" +
"                                        <input type=\"checkbox\" id=\"checkbox1\" name=\"options[]\" value=\"1\">\n" +
"                                        <label for=\"checkbox1\"></label>\n" +
"                                    </span>\n" +
"                                </td>\n" +
"                                 <td><img style=\"width: 50px; height: 50px\"src=\"https://cdn.onlinewebfonts.com/svg/img_227643.png\"></td>\n" +
"                                <td>"+o.getUser()+"</td>\n" +
"                                <td>\n" +
"                                  "+o.getPass()+" \n" +
"                                </td>\n" +
"                                <td>\n" +
"                                  "+o.getEmail()+" \n" +
"                                </td>\n" +                              
"                                <td>"+o.getIsSell()+" </td>\n" +
"                                <td>\n" +
"                                    <a href=\"loadUser?uname="+o.getUser()+"\"  class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>\n" +
"                                    <a href=\"deleteUser?uname="+o.getUser()+"\" class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a>\n" +
"                                </td>\n" +
"                            </tr>");
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
