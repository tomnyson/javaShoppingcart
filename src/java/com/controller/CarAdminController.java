/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Car;
import com.entity.Category;
import com.model.CarDao;
import com.model.CategoryDao;
import com.until.Helper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
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
@WebServlet(name = "product", urlPatterns = {"/admin/product", "/admin/product/*"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50)
public class CarAdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();

        if (method.equals("GET")) {
            String id = request.getParameter("id");
            HttpSession session = request.getSession();
            if (id != null) {
                Car currentProd = CarDao.findProductById(Integer.parseInt(id));
                List<Category> listCat = new ArrayList<Category>();
                listCat = CategoryDao.findAll();
                request.setAttribute("listCat", listCat);
                listCat = CategoryDao.findAll();
                request.setAttribute("currentProd", currentProd);
                request.setAttribute("title", "sửa sản phẩm");
                request.setAttribute("tabSelected", "sanpham");
                session.setAttribute("view", "include/editProduct.jsp");
                request.getRequestDispatcher("../admin/dashboard.jsp").forward(request, response);
                return;
            }
            List<Car> listProd = new ArrayList<Car>();
            List<Category> listCat = new ArrayList<Category>();
            listProd = CarDao.findAll(1, 20);
            listCat = CategoryDao.findAll();
            request.setAttribute("listCat", listCat);
            request.setAttribute("listProd", listProd);
            request.setAttribute("title", "danh sách sản phẩm");
            request.setAttribute("tabSelected", "sanpham");
            session.setAttribute("view", "include/product.jsp");
            request.getRequestDispatcher("../admin/dashboard.jsp").forward(request, response);
            return;
        } else {
            String action = request.getParameter("action");
            // handel sự kiện xảy ra khi user đã click vào form có thể là thêm , xoá , xửa
            if (action != null) {
                switch (action) {
                    case "Add":
                        AddProduct(request, response);
                        break;
                    case "Delete":
                        DeleteProduct(request, response);
                        break;
                    case "Update":
                        EditProduct(request, response);
                        break;
                }
            }

        }

    }

    public void AddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String contact = request.getParameter("contact");
        String price = request.getParameter("price");
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
        //Car(String image, String title, String url, Double price, String description, String contact, int categoryId)
        Car car = new Car(image, title, null, Double.parseDouble(price), description, contact, 1);
        boolean result = CarDao.create(car);
        HttpSession session = request.getSession();
        session.setAttribute("message", "Thêm thành công");
        response.sendRedirect(request.getContextPath() + "/admin/category");
    }

    public void EditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String contact = request.getParameter("contact");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("categoryCar");
        String path = System.getProperty("user.dir") + "/upload";

        String image = null;
        try {
            File dir = new File(request.getServletContext().getRealPath("/upload"));
            if (!dir.exists()) { // tạo nếu chưa tồn tại
                dir.mkdirs();
            }
            Part mainImage = request.getPart("image");
            if (mainImage != null) {
                File photoFile = new File(dir, mainImage.getSubmittedFileName());
                mainImage.write(photoFile.getAbsolutePath());
                image = photoFile.getName();
            }
        } catch (Exception e) {
        }

//        public Car(int id, String image, String title, String url, Double price, String description, String contact, int categoryId)
        Car car = new Car(Integer.parseInt(id), image, title, null, Double.parseDouble(price), description, contact, Integer.parseInt(categoryId));
        boolean result = CarDao.update(car);
        HttpSession session = request.getSession();
        if (result) {
            session.setAttribute("message", "Sửa thành công");
        } else {
            session.setAttribute("message", "Sửa ko thành công");
        }
        session.setAttribute("message", "Thêm thành công");
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }

    public void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            boolean result = CarDao.delete(Integer.parseInt(id));
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
