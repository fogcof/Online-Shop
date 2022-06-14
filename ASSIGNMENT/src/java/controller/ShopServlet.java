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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
public class ShopServlet extends HttpServlet {

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
            out.println("<title>Servlet ShopServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopServlet at " + request.getContextPath() + "</h1>");
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
        String cid_raw = request.getParameter("cid");
        String xpage = request.getParameter("page");
        int page, numpage, numperpage = 8;
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        CategoryDAO cd = new CategoryDAO();
        ProductDAO pd = new ProductDAO();
        int cid = 0;
        List<Category> listc = cd.getAll();
        if (cid_raw == null) {
            List<Product> listpa = pd.getAll();
            int num = listpa.size();
            numpage = (num % numperpage == 0 ? (num / numperpage) : (num / numperpage + 1));
            int start = (page - 1) * numperpage;
            int end = Math.min(page * numperpage, num);
            List<Product> listp = pd.getListByPage(listpa, start, end);
//            request.setAttribute("cid", cid);
            request.setAttribute("listp", listp);
            request.setAttribute("size", num);
        } else {
            cid = Integer.parseInt(cid_raw);
            List<Product> listpa = pd.getProductByCid(cid);
            int num = listpa.size();
            numpage = (num % numperpage == 0 ? (num / numperpage) : (num / numperpage + 1));
            int start = (page - 1) * numperpage;
            int end = Math.min(page * numperpage, num);
            List<Product> listp = pd.getListByPage(listpa, start, end);
            request.setAttribute("cid", cid);
            request.setAttribute("listp", listp);
            request.setAttribute("size", num);
        }
        request.setAttribute("page", page);
        request.setAttribute("num", numpage);
        request.setAttribute("listc", listc);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
