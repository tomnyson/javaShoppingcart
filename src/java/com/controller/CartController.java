/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Car;
import com.entity.Cart;
import com.entity.Item;
import com.model.CarDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tomnyson
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        //kiểm tra xem người dùng đã click vào nút mua 
        String action = request.getParameter("cart");
        // khỏi tạo session để làm 
        HttpSession session = request.getSession();
        if (action != null) {
            // user đã click vào nút mua mới xử lý
            // lấy cart từ session
            Cart cart = (Cart) session.getAttribute("cart");
            // lấy thông tin chi tiết của sản phẩm dựa vào mã id đã chuyển ở b1
            String masp = request.getParameter("masp");
            System.out.println("masp" + masp);
            // lấy thông tin chi tiết sản phẩm dựa vào id
            Car car = CarDao.findProductById(Integer.parseInt(masp));
            // khoi tao item de chuan bi add vao gio hang
            Item item = new Item(Integer.parseInt(masp), car.getImage(), 1, car.getPrice(), car.getTitle());
            // check trường hợp cần thêm vào add
            if (action.equals("add")) {
                if (cart == null) {
                    cart = new Cart();
                }
                cart.addCart(item);
            } else if (action.equals("remove")) {
                cart.removeCart(item);
            }
            // update lại session
            session.setAttribute("cart", cart);
              // chuyển đến trang giỏ hàng
            response.sendRedirect("./giohang.jsp");
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
