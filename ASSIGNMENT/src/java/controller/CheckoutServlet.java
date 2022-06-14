/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDAO;
import dal.OrderDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.Customer;
import model.Order;
import model.OrderDetail;
import model.Product;

/**
 *
 * @author Admin
 */
public class CheckoutServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckoutServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Customer a = (Customer) session.getAttribute("account");
        if (a == null) {
            response.sendRedirect("login");
        } else {
            CategoryDAO cd = new CategoryDAO();
            List<Category> listc = cd.getAll();
            String total = request.getParameter("total");
            request.setAttribute("total", total);
            request.setAttribute("listc", listc);
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
        request.setCharacterEncoding("utf-8");
        String total = request.getParameter("total");
        String address = request.getParameter("address");
        String desc = request.getParameter("desc");

        HttpSession session = request.getSession();
        Customer a = (Customer) session.getAttribute("account");
        OrderDAO od = new OrderDAO();
        List<Order> listo = od.getAll();
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        String shipdate = curDate.plusDays(5).toString();
        Order neworder = new Order(listo.size() + 1, a, Integer.parseInt(total), address, desc, date, shipdate, false);
        
        Cookie[] cookies = request.getCookies();
        String cart = cookies[1].getValue();
        String[] items = cart.split(":");
        List<OrderDetail> listod = new ArrayList<>();
        int size = od.getAllDetail().size();
        for (int i = 0; i < items.length; i++) {
            String item[] = items[i].split(",");
            size++;
            Product p = new ProductDAO().getProductById(Integer.parseInt(item[0]));
            listod.add(new OrderDetail(size, p, neworder, p.getPrice(), Integer.parseInt(item[1])));
        }

        od.addOrder(neworder, listod);
        request.setAttribute("mess", "Đặt hàng thành công");

        CategoryDAO cd = new CategoryDAO();
        List<Category> listc = cd.getAll();
        request.setAttribute("listc", listc);
        
        Cookie cookie = new Cookie("cart", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        
        request.setAttribute("status", "done");
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
