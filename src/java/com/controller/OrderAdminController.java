/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Category;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.User;
import com.model.CategoryDao;
import com.model.OrderDao;
import com.model.UserDao;
import com.sun.mail.handlers.image_gif;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author tomnyson
 */
@WebServlet(name = "order", urlPatterns = {"/admin/order", "/admin/order/*"})
public class OrderAdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * category list danh sach them category xoa category update category
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equals("GET")) {
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            if (id != null) {
                List<OrderItem> currentOrder = new ArrayList<>();
                currentOrder = OrderDao.findOrderItemById(Integer.parseInt(id));
                request.setAttribute("currentOrder", currentOrder);
                session.setAttribute("view", "include/orderDetail.jsp");
                request.getRequestDispatcher("../admin/dashboard.jsp").forward(request, response);
                return;
            }
            List<Order> listOder = new ArrayList<Order>();
            listOder = OrderDao.findAll(1, 20);
            request.setAttribute("listOder", listOder);
            request.setAttribute("title", "danh sách user");
            request.setAttribute("tabSelected", "order");
            session.setAttribute("view", "include/order.jsp");
            request.getRequestDispatcher("../admin/dashboard.jsp").forward(request, response);
            return;
        } else {
            String action = request.getParameter("action");
            // handel sự kiện xảy ra khi user đã click vào form có thể là thêm , xoá , xửa
            if (action != null) {
                switch (action) {
                    case "Add":
                        AddUser(request, response);
                        break;
                    case "Delete":
                        DeleteUser(request, response);
                        break;
                    case "Update":
                        EditUser(request, response);
                        break;
                }
            }

        }

    }

    public void AddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordconfirm");
        String role = request.getParameter("role");
        if (!password.equals(passwordConfirm)) {
            System.out.println("go here");
            session.setAttribute("message", "Thêm ko thành công");
            response.sendRedirect(request.getContextPath() + "/admin/user");
            return;
        }
        User user = new User(username, password, role);
        boolean result = UserDao.createUser(user);
        if (result) {
            session.setAttribute("message", "Thêm thành công");
        } else {
            session.setAttribute("message", "Thêm ko thành công");
        }
        response.sendRedirect(request.getContextPath() + "/admin/user");
    }

    public void EditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = null;
        Category cat = new Category(Integer.parseInt(id), name, description, image);
        boolean result = CategoryDao.update(cat);
        HttpSession session = request.getSession();
        if (result) {
            session.setAttribute("message", "Cập nhật thành công");
        } else {
            session.setAttribute("message", "Cập nhật Ko thành công");
        }

        response.sendRedirect(request.getContextPath() + "/admin/category");
    }

    public void DeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            boolean result = CategoryDao.delete(Integer.parseInt(id));
            HttpSession session = request.getSession();
            if (result) {
                session.setAttribute("message", "Xoá thành công");
            } else {
                session.setAttribute("message", "Xoá ko thành công");
            }

            response.sendRedirect(request.getContextPath() + "/admin/category");
        } catch (Exception e) {
            throw e;
        }

    }

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
