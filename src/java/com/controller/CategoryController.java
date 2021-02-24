/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Category;
import com.model.CategoryDao;
import java.io.File;
import java.io.IOException;
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
@WebServlet(name = "category", urlPatterns = {"/admin/category", "/admin/category/*"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50)
public class CategoryController extends HttpServlet {

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
        // chia hai trường hợp get/post
        String method = request.getMethod();
        if (method.equals("GET")) {
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            if (id != null && !id.isEmpty()) {
                Category currentCat = CategoryDao.findCategoryById(Integer.parseInt(id));
                request.setAttribute("currentCat", currentCat);
                session.setAttribute("view", "include/editDanhMuc.jsp");
                request.getRequestDispatcher("../admin/dashboard.jsp").forward(request, response);
                return;
            }
            List<Category> listCat = new ArrayList<Category>();
            listCat = CategoryDao.findAll();
            request.setAttribute("listCat", listCat);
            request.setAttribute("title", "danh sách category");
            request.setAttribute("tabSelected", "danhmuc");
            session.setAttribute("view", "include/danhmuc.jsp");
            request.getRequestDispatcher("../admin/dashboard.jsp").forward(request, response);
            return;
        } else {
            String action = request.getParameter("action");
            // handel sự kiện xảy ra khi user đã click vào form có thể là thêm , xoá , xửa
            if (action != null) {
                switch (action) {
                    case "Add":
                        AddCategory(request, response);
                        break;
                    case "Delete":
                        DeleteCategory(request, response);
                        break;
                    case "Update":
                        EditCategory(request, response);
                        break;
                }
            }

        }

    }

    public void AddCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String path = System.getProperty("user.dir") + "/upload";
        File dir = new File(request.getServletContext().getRealPath("/upload"));
        if (!dir.exists()) { // tạo nếu chưa tồn tại
            dir.mkdirs();
        }
        Part mainImage = request.getPart("image");
        File photoFile = new File(dir, mainImage.getSubmittedFileName());
        mainImage.write(photoFile.getAbsolutePath());
        String image = photoFile.getName();
        Category cat = new Category(name, description, image);
        boolean result = CategoryDao.create(cat);
        HttpSession session = request.getSession();
        if (result) {
            session.setAttribute("message", "Thêm thành công");
        } else {
            session.setAttribute("message", "Thêm ko thành công");
        }
        response.sendRedirect(request.getContextPath() + "/admin/category");
    }

    public void EditCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    public void DeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
