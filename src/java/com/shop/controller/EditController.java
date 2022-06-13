/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controller;

import com.shop.dao.CategoryDao;
import com.shop.dao.ProductDao;
import com.shop.model.jpa.Account;
import com.shop.model.jpa.Category;
import com.shop.model.jpa.Product;
import java.io.IOException;
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
@WebServlet(name = "EditController", urlPatterns = {"/edit"})
public class EditController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       request.setCharacterEncoding("UTF-8");
       String pid = request.getParameter("id");
       int Pids = Integer.parseInt(pid);
       String pnames = request.getParameter("name");
       String pimages  =request.getParameter("image");
       String pprices =request.getParameter("price");
       int Pprices = Integer.parseInt(pprices);
       String ptitles =request.getParameter("title");
       String pdescriptions =request.getParameter("description");
       String pcategorys = request.getParameter("category");
       int Pcategorys = Integer.parseInt(pcategorys);
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getUID();
       CategoryDao categoryDao = new CategoryDao();
       List<Category> listC = categoryDao.getAllCategoryJPA();
       ProductDao dao = new ProductDao();
       Product p = new Product();
       p.setPid(Pids);
       p.setName(pnames);
       p.setImage(pimages);
       p.setPrice(Pprices);
       p.setTitle(ptitles);
       p.setDescription(pdescriptions);
       Category cate = new Category();
       cate.setCid(Pcategorys);
       p.setCateID(cate);
       Account account = new Account();
       account.setUID(id);
       p.setSellID(account);
       dao.editProductJPA(p);
       request.setAttribute("listCC", listC);
       //request.getRequestDispatcher("manager").forward(request, response)
       response.sendRedirect("manager");
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