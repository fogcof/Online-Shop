/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProcessServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String num = request.getParameter("num");
        String id = request.getParameter("id");

        ProductDAO pd = new ProductDAO();
        Product p = pd.getProductById(Integer.parseInt(id));

        Cookie[] cookies = request.getCookies();
        String cart = cookies[1].getValue();
        String[] items = cart.split(":");
        String cartnew = "";
        for (int i = 0; i < items.length; i++) {
            String[] item = items[i].split(",");
            if (item[0].equals(id)) {
                int n = Integer.parseInt(item[1]) + Integer.parseInt(num);
                if (n==0) {
                    continue;
                }
                if (n > p.getStock()) {
                    item[1] = String.valueOf(p.getStock());
                } else {
                    item[1] = String.valueOf(n);
                }
            }
            cartnew += item[0] + "," + item[1] + ":";
        }
        if (cartnew.equals("")) {
            Cookie cookie = new Cookie("cart", cartnew);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.sendRedirect("cart");
        } else {
            Cookie cookie = new Cookie("cart", cartnew);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            response.sendRedirect("cart");
        }
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
