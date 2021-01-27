/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Car;
import com.model.CarDao;
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
import javax.servlet.http.Part;

/**
 *
 * @author tomnyson
 */
@WebServlet(urlPatterns = {"/oto", "/home"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50)
public class CarController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SAVE_DIRECTORY = "upload";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            List<Car> lscar = new ArrayList<Car>();
            String page = request.getParameter("page");
            int currentPage = 1;
            if (page != null) {
                currentPage = Integer.parseInt(page);
                lscar = CarDao.findAll(currentPage, 20);

            } else {
                lscar = CarDao.findAll(1, 20);
            }
            request.setAttribute("lscar", lscar);
            RequestDispatcher dis = this.getServletContext().getRequestDispatcher("/danhsachxe.jsp");
            dis.forward(request, response);
        } catch (Exception e) {
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
        String action = request.getParameter("action");
        String absolutePath = request.getServletContext().getRealPath("");
        if (action != null) {
            String description = request.getParameter("description");
            System.out.println("action" + description);
            File dir = new File(request.getServletContext().getRealPath("/upload"));
            if (!dir.exists()) { // tạo nếu chưa tồn tại
                dir.mkdirs();
            }
            System.out.println("request.getServletContext().getRealPath(\"/upload\")"+request.getServletContext().getRealPath("/upload"));
            Part mainImage = request.getPart("mainImage");
            File photoFile = new File(dir, mainImage.getSubmittedFileName());
            mainImage.write(photoFile.getAbsolutePath());
        }
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
