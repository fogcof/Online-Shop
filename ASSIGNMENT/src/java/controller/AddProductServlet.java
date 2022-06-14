/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.Customer;
import model.Product;

/**
 *
 * @author Admin
 */
public class AddProductServlet extends HttpServlet {

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
            out.println("<title>Servlet AddProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductServlet at " + request.getContextPath() + "</h1>");
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
            CategoryDAO cd = new CategoryDAO();
            List<Category> listc = cd.getAll();
            ProductDAO pd = new ProductDAO();
            List<Product> listp = pd.getAll();
            request.setAttribute("listc", listc);
            request.setAttribute("size", listp.size());
            request.getRequestDispatcher("addPro.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        String id_raw = request.getParameter("id");
        String name_raw = request.getParameter("name");
        String desc_raw = request.getParameter("desc");
        String image_raw = request.getParameter("image");
        String price_raw = request.getParameter("price");
        String stock_raw = request.getParameter("stock");
        String cate_raw = request.getParameter("category");

        CategoryDAO cd = new CategoryDAO();
        List<Category> listc = cd.getAll();
        ProductDAO pd = new ProductDAO();
        List<Product> listp = pd.getAll();
        request.setAttribute("listc", listc);
        request.setAttribute("size", listp.size());

        try {
            int id = Integer.parseInt(id_raw);
            int price = Integer.parseInt(price_raw);
            int stock = Integer.parseInt(stock_raw);
            int cate = Integer.parseInt(cate_raw);
            Product p = new Product(id, name_raw, desc_raw, image_raw, price, stock, new CategoryDAO().getCategoryById(cate));
            pd.insertProduct(p);

            request.setAttribute("mess", "ADD SUCCESSFUL.");
            request.setAttribute("p", p);
            request.getRequestDispatcher("addPro.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mess", "ADD FAILED.");
            request.getRequestDispatcher("addPro.jsp").forward(request, response);
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
