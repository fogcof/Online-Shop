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
public class FilterServlet extends HttpServlet {

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
            out.println("<title>Servlet FilterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterServlet at " + request.getContextPath() + "</h1>");
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
        String key_raw = request.getParameter("key");
        String order = request.getParameter("order");
        String cid_raw = request.getParameter("cid");
        String from_raw = request.getParameter("from");
        String to_raw = request.getParameter("to");
        if(key_raw==null){
            key_raw="";
        }
        if (order==null||order.equals("")) {
            order="default";
        }
        int cid = 0;
        if (cid_raw == null||cid_raw.equals("")) {
            cid=0;
        }else{
            cid=Integer.parseInt(cid_raw);
        }
        int from=Integer.parseInt(from_raw);
        int to=Integer.parseInt(to_raw);
        ProductDAO pd=new ProductDAO();
        List<Product> listpa=pd.getProductByPrice(order, cid, key_raw, from, to);
        
        String xpage = request.getParameter("page");
        int numpage, page, numperpage = 8;
        int num = listpa.size();
        numpage = (num % numperpage == 0 ? (num / numperpage) : (num / numperpage + 1));
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start = (page - 1) * numperpage;
        int end = Math.min(page * numperpage, num);
        List<Product> listp = pd.getListByPage(listpa, start, end);
        
        CategoryDAO cd = new CategoryDAO();
        List<Category> listc = cd.getAll();
        
        request.setAttribute("num", numpage);
        request.setAttribute("page", page);
        request.setAttribute("listc", listc);
        request.setAttribute("listp", listp);
        request.setAttribute("key", key_raw);
        request.setAttribute("order", order);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("cid", cid);
        
        request.setAttribute("size", num);
        request.getRequestDispatcher("filter.jsp").forward(request, response);

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
