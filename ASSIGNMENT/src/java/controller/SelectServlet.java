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
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
public class SelectServlet extends HttpServlet {

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
            out.println("<title>Servlet SelectServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SelectServlet at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        String cid_raw = request.getParameter("cid");
        String order_raw = request.getParameter("order");
        String key_raw = request.getParameter("key");
        String key = key_raw;// fixxx when key=null --> select and order by cid, when key!=null --> select and order by key search
        int cid;
        if (cid_raw == null || cid_raw.equals("")) {
            cid = 0;
        } else {
            cid = Integer.parseInt(cid_raw);
        }
        CategoryDAO cd = new CategoryDAO();
        List<Category> listc = cd.getAll();
        ProductDAO pd = new ProductDAO();
        if (key_raw == null) {
            key_raw = "";// convert if null to access Database
        }
        List<Product> listpo = pd.getProductByOrder(order_raw, cid, key_raw);

        String xpage = request.getParameter("page");
        int numpage, page, numperpage = 8;
        int num = listpo.size();
        numpage = (num % numperpage == 0 ? (num / numperpage) : (num / numperpage + 1));
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start = (page - 1) * numperpage;
        int end = Math.min(page * numperpage, num);
        List<Product> listp = pd.getListByPage(listpo, start, end);

        request.setAttribute("num", numpage);
        request.setAttribute("page", page);
        request.setAttribute("listc", listc);
        request.setAttribute("listp", listp);

        request.setAttribute("order", order_raw);
        request.setAttribute("cid", cid);
        request.setAttribute("key", key);// send original key for order from cid OR order after serach

        request.setAttribute("size", num);
        request.getRequestDispatcher("select.jsp").forward(request, response);
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
