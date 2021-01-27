/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.City;
import com.entity.District;
import com.entity.Village;
import com.google.gson.Gson;
import com.model.CityDao;
import com.model.DistrictDao;
import com.model.VillageDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tomnyson
 */
@WebServlet(name = "ajax", urlPatterns = {"/ajax/city", "/ajax/district", "/ajax/village"})
public class AjaxController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if (uri.contains("city")) {
            List<City> cities = new ArrayList<City>();
            cities = CityDao.findAll();
            String json = new Gson().toJson(cities);
            response.getWriter().write(json);
        }
        if (uri.contains("district")) {
            String matp = request.getParameter("matp");
            List<District> district = new ArrayList<District>();
            district = DistrictDao.findAllByTp(Integer.parseInt(matp));
            String json = new Gson().toJson(district);
            response.getWriter().write(json);
        }
          if (uri.contains("village")) {
            String mah = request.getParameter("mah");
            List<Village> district = new ArrayList<Village>();
            district = VillageDao.findAllByQuan(Integer.parseInt(mah));
            String json = new Gson().toJson(district);
            response.getWriter().write(json);
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
