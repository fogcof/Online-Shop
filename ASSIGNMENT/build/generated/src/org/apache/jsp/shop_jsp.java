package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Shop</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"\n");
      out.write("              integrity=\"sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p\" crossorigin=\"anonymous\" />\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <style>\n");
      out.write("            .product img {\n");
      out.write("                width: 100%;\n");
      out.write("                height: auto;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                object-fit: cover;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #featured>div.row.mx-auto.container>nav>ul>li.page-item.active>a {\n");
      out.write("                background-color: black;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #featured>div.row.mx-auto.container>nav>ul>li:nth-child(n):hover>a {\n");
      out.write("                background-color: coral;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .pagination a {\n");
      out.write("                color: #000;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            select {\n");
      out.write("                border: 1px solid coral;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- NAVIGATION -->\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light py-3 fixed-top\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a href=\"home\"><img src=\"Image/KITN.png\" alt=\"\" width=\"50px\"></a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\n");
      out.write("                        data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n");
      out.write("                        aria-label=\"Toggle navigation\">\n");
      out.write("                    <span><i id=\"bar\" class=\"fas fa-bars\"></i></span>\n");
      out.write("                </button>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                    <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" href=\"home\">TRANG CHỦ</a>\n");
      out.write("                        </li>\n");
      out.write("                        <!-- <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\">GIỚI THIỆU</a>\n");
      out.write("                        </li> -->\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"shop\" id=\"navbarDropdown\" role=\"button\"\n");
      out.write("                               data-bs-toggle=\"dropdown-toggle\" aria-expanded=\"false\">\n");
      out.write("                                CỬA HÀNG\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.listc}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"listc\">\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listc.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("                                </c:forEach>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\">LIÊN HỆ</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\">ĐĂNG NHẬP</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <!-- <i class=\"fal fa-search\"></i> -->\n");
      out.write("                            <i class=\"fal fa-shopping-bag\"></i>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                    <form class=\"form-inline my-2 my-lg-0 ml-auto\"> <!-- fix -->\n");
      out.write("                        <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n");
      out.write("                        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <section id=\"featured\" class=\"my-5 py-5\">\n");
      out.write("            <div class=\"container mt-5 py-5 d-flex justify-content-between\">\n");
      out.write("                <div>\n");
      out.write("                    <h2 class=\"font-weight-bold\">TỦ GỖ</h2> <!-- fix -->\n");
      out.write("                    <hr>\n");
      out.write("                    <p>Mẫu mã đa dạng phù hợp nhiều phòng cách thiết kế nội thất.</p>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <form action=\"\">\n");
      out.write("                        <select class=\"form-select p-2\" aria-label=\"Default select example\">\n");
      out.write("                            <option selected>Open this select menu</option>\n");
      out.write("                            <option value=\"1\">One</option>\n");
      out.write("                            <option value=\"2\">Two</option>\n");
      out.write("                            <option value=\"3\">Three</option>\n");
      out.write("                        </select>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row mx-auto container\">\n");
      out.write("                <div onclick=\"window.location.href = 'sproduct.html'\" class=\"product text-center col-lg-3 col-md-6 col-12\">\n");
      out.write("                    <!-- fix -->\n");
      out.write("                    <img class=\"img-fluid mb-3\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                    <div class=\"star\">\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <h5 class=\"p-name\">TỦ QUẦN ÁO 4 CÁNH GỖ XOAN ĐÀO HGS568</h5>\n");
      out.write("                    <h4 class=\"p-price\">8,954,000 ₫</h4>\n");
      out.write("                    <button class=\"buy-btn\">MUA NGAY</button>\n");
      out.write("                </div>\n");
      out.write("                <nav aria-label=\"...\">\n");
      out.write("                    <ul class=\"pagination mt-5\">\n");
      out.write("                        <li class=\"page-item disabled\">\n");
      out.write("                            <a class=\"page-link\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Previous</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"page-item active\"><a class=\"page-link\" href=\"#\">1</a></li>\n");
      out.write("                        <li class=\"page-item\" aria-current=\"page\">\n");
      out.write("                            <a class=\"page-link\" href=\"#\">2</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"page-item\"><a class=\"page-link\" href=\"#\">3</a></li>\n");
      out.write("                        <li class=\"page-item\">\n");
      out.write("                            <a class=\"page-link\" href=\"#\">Next</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <footer class=\"mt-5 py-4\"><!-- fix -->\n");
      out.write("            <div class=\"row container mx-auto pt-5\">\n");
      out.write("                <div class=\"footer-one col-lg-3 col-md-6 col-12 mb-3\">\n");
      out.write("                    <img src=\"Image/KITN.png\" alt=\"\" style=\"width: 50px;\">\n");
      out.write("                    <p class=\"pt-3\">KITN sẽ mang lại cho bạn trải nghiệm những không gian với những\n");
      out.write("                        thiết kế tiện nghi, thoải mái và giá thành hợp lý nhất.\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-one col-lg-3 col-md-6 col-12 mb-3\">\n");
      out.write("                    <h5 class=\"pb-2\">ĐIỀU HƯỚNG</h5>\n");
      out.write("                    <ul class=\"text-uppercase list-unstyled\">\n");
      out.write("                        <li><a href=\"#\">TRANG CHỦ</a></li>\n");
      out.write("                        <li><a href=\"#\">CỬA HÀNG</a></li>\n");
      out.write("                        <li><a href=\"#\">LIÊN HỆ</a></li>\n");
      out.write("                        <li><a href=\"#\">ĐĂNG NHẬP</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-one col-lg-3 col-md-6 col-12 mb-3\">\n");
      out.write("                    <h5 class=\"pb-2\">LIÊN HỆ</h5>\n");
      out.write("                    <div>\n");
      out.write("                        <h6 class=\"text-uppercase\">Địa chỉ</h6>\n");
      out.write("                        <p>Wherever you need us!</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <h6 class=\"text-uppercase\">Số điện thoại</h6>\n");
      out.write("                        <p>0969180735</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <h6 class=\"text-uppercase\">Email</h6>\n");
      out.write("                        <p>kitn0204@gmail.com</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-one col-lg-3 col-md-6 col-12\">\n");
      out.write("                    <h5 class=\"pb-2\">SẢN PHẨM</h5>\n");
      out.write("                    <ul class=\"row\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/17.jpg\" alt=\"\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/4.jpg\" alt=\"\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/6-1.jpg\" alt=\"\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/5.jpg\" alt=\"\">\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js\"\n");
      out.write("                integrity=\"sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js\"\n");
      out.write("                integrity=\"sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("                function doDetail(id) {\n");
      out.write("                    window.location = \"detail?id=\" + id;\n");
      out.write("                }\n");
      out.write("</script>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
