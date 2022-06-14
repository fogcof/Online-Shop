/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDAO;
import dal.CustomerDAO;
import dal.OrderDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
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
public class ManageServlet extends HttpServlet {

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
            out.println("<title>Servlet ManageServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageServlet at " + request.getContextPath() + "</h1>");
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
        Customer c = (Customer) session.getAttribute("account");
        if (c == null) {
            response.sendRedirect("login");
        } else {
            String xpage = request.getParameter("page");
            String type = request.getParameter("type");
            if (type == null || type.equals("customer")) {
                CustomerDAO cmd = new CustomerDAO();
                List<Customer> lista = cmd.getAll();
                CategoryDAO cd = new CategoryDAO();
                List<Category> listc = cd.getAll();
                request.setAttribute("lista", lista);
                request.setAttribute("listc", listc);
                request.setAttribute("type", "customer");

                request.getRequestDispatcher("manage.jsp").forward(request, response);
            }
            if (type.equals("product")) {
                int page;
                if (xpage == null) {
                    page = 1;
                } else {
                    page = Integer.parseInt(xpage);
                }
                ProductDAO pd = new ProductDAO();
                List<Product> list = pd.getAll();

                int num = list.size();
                int numperpage = 4;
                int numpage = (num % numperpage == 0 ? (num / numperpage) : (num / numperpage + 1));
                int start = (page - 1) * numperpage;
                int end = Math.min(page * numperpage, num);
                List<Product> listp = pd.getListByPage(list, start, end);

                CategoryDAO cd = new CategoryDAO();
                List<Category> listc = cd.getAll();

                request.setAttribute("page", page);
                request.setAttribute("num", numpage);
                request.setAttribute("listp", listp);
                request.setAttribute("listc", listc);
                request.setAttribute("type", "product");

                request.getRequestDispatcher("manage.jsp").forward(request, response);
            }
            if (type.equals("category")) {
                OrderDAO od = new OrderDAO();
                List<OrderDetail> listod = od.getAllDetail();

                CategoryDAO cd = new CategoryDAO();
                List<Category> listc = cd.getAll();
                List<Integer> listnum = new ArrayList<>();
                List<Integer> listtotal = new ArrayList<>();
                for (Category category : listc) {
                    int n = 0;
                    int x = 0;
                    for (OrderDetail orderDetail : listod) {
                        if (category.getId() == orderDetail.getProduct().getCategory().getId()) {
                            n += orderDetail.getQuantity();
                            x += orderDetail.getPrice() * orderDetail.getQuantity();
                        }
                    }
                    listnum.add(n);
                    listtotal.add(x);
                }
                request.setAttribute("listtotal", listtotal);
                request.setAttribute("listnum", listnum);
                request.setAttribute("listc", listc);
                request.setAttribute("type", "category");

                request.getRequestDispatcher("manage.jsp").forward(request, response);
            }
            if (type.equals("order")) {
                int page;
                if (xpage == null) {
                    page = 1;
                } else {
                    page = Integer.parseInt(xpage);
                }
                OrderDAO od = new OrderDAO();
                List<Order> list = od.getAll();

                int num = list.size();
                int numperpage = 6;
                int numpage = (num % numperpage == 0 ? (num / numperpage) : (num / numperpage + 1));
                int start = (page - 1) * numperpage;
                int end = Math.min(page * numperpage, num);
                List<Order> listo = od.getListByPage(list, start, end);

                CategoryDAO cd = new CategoryDAO();
                List<Category> listc = cd.getAll();
                request.setAttribute("listo", listo);
                request.setAttribute("listc", listc);
                request.setAttribute("type", "order");
                request.setAttribute("page", page);
                request.setAttribute("num", numpage);

                request.getRequestDispatcher("manage.jsp").forward(request, response);
            }
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
