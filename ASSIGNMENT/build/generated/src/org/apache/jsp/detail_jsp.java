package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Product Details</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"\n");
      out.write("              integrity=\"sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p\" crossorigin=\"anonymous\" />\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <style>\n");
      out.write("            .sproduct input{\n");
      out.write("                width: 50px;\n");
      out.write("                height: 40px;\n");
      out.write("                padding-left: 10px;\n");
      out.write("                font-size: 16px;\n");
      out.write("                margin-right: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .sproduct input:focus{\n");
      out.write("                outline: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .buy-btn{\n");
      out.write("                background-color: #fb774b;\n");
      out.write("                opacity: 1;\n");
      out.write("                transition: 0.3s all;\n");
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
      out.write("                            <a class=\"nav-link active\" href=\"#\">TRANG CH???</a>\n");
      out.write("                        </li>\n");
      out.write("                        <!-- <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\">GI???I THI???U</a>\n");
      out.write("                        </li> -->\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle active\" href=\"shop\" id=\"navbarDropdown\" role=\"button\"\n");
      out.write("                               data-bs-toggle=\"dropdown-toggle\" aria-expanded=\"false\">\n");
      out.write("                                C???A H??NG\n");
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
      out.write("                            <a class=\"nav-link\" href=\"#\">LI??N H???</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\">????NG NH???P</a>\n");
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
      out.write("        <section class=\"container sproduct my-5 pt-5\">\n");
      out.write("            <div class=\"row mt-5\">\n");
      out.write("                <div class=\"col-lg-5 col-md-12 col-12\">\n");
      out.write("                    <img class=\"img-fluid w-100 pb-1\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-lg-5 col-md-12 col-12\">\n");
      out.write("                    <h6>Trang ch??? / Chi ti???t</h6>\n");
      out.write("                    <h3 class=\"py-4\">T??? QU???N ??O 4 C??NH G??? XOAN ????O HGS568</h3>\n");
      out.write("                    <h2 class=\"pb-3\">8,954,000 ???</h2>\n");
      out.write("                    <input type=\"number\" value=\"1\">\n");
      out.write("                    <button class=\"buy-btn\">TH??M V??O GI???</button>\n");
      out.write("                    <h4 class=\"mt-4 mb-4\">M?? T???</h4>\n");
      out.write("                    <span>G??? Xoan ????o t??? nhi??n ???? ???????c t???m s???y ?????m b???o ch???c, b???n, ?????p, kh??ng s??? n?????c, kh??ng m???t hay n???t n???.\n");
      out.write("                        B??? m???t: Ph??? s??n PU m??? gi??? m??u s???c v?? v??n g??? t??? nhi??n lu??n t????i m???i, b???n ?????p. Quy c??ch: Ngang 200cm x\n");
      out.write("                        Cao 200cm x S??u 60cm.</span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <section id=\"featured\" class=\"my-5 pb-5\">\n");
      out.write("            <div class=\"container text-center mt-5 py-5\">\n");
      out.write("                <h2>S???N PH???M T????NG T???</h2>  <!-- fix -->\n");
      out.write("                <hr class=\"mx-auto\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row mx-auto container-fluid\">\n");
      out.write("                <div class=\"product text-center col-lg-3 col-md-6 col-12\">  <!-- fix -->\n");
      out.write("                    <img class=\"img-fluid mb-3\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                    <div class=\"star\">\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <h5 class=\"p-name\">T??? QU???N ??O 4 C??NH G??? XOAN ????O HGS568</h5>\n");
      out.write("                    <h4 class=\"p-price\">8,954,000 ???</h4>\n");
      out.write("                    <button class=\"buy-btn\">MUA NGAY</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"product text-center col-lg-3 col-md-6 col-12\">\n");
      out.write("                    <img class=\"img-fluid mb-3\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                    <div class=\"star\">\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <h5 class=\"p-name\">T??? QU???N ??O 4 C??NH G??? XOAN ????O HGS568</h5>\n");
      out.write("                    <h4 class=\"p-price\">8,954,000 ???</h4>\n");
      out.write("                    <button class=\"buy-btn\">MUA NGAY</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"product text-center col-lg-3 col-md-6 col-12\">\n");
      out.write("                    <img class=\"img-fluid mb-3\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                    <div class=\"star\">\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <h5 class=\"p-name\">T??? QU???N ??O 4 C??NH G??? XOAN ????O HGS568</h5>\n");
      out.write("                    <h4 class=\"p-price\">8,954,000 ???</h4>\n");
      out.write("                    <button class=\"buy-btn\">MUA NGAY</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"product text-center col-lg-3 col-md-6 col-12\">\n");
      out.write("                    <img class=\"img-fluid mb-3\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                    <div class=\"star\">\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <h5 class=\"p-name\">T??? QU???N ??O 4 C??NH G??? XOAN ????O HGS568</h5>\n");
      out.write("                    <h4 class=\"p-price\">8,954,000 ???</h4>\n");
      out.write("                    <button class=\"buy-btn\">MUA NGAY</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <footer class=\"mt-5 py-4\">\n");
      out.write("            <!-- fix -->\n");
      out.write("            <div class=\"row container mx-auto pt-5\">\n");
      out.write("                <div class=\"footer-one col-lg-3 col-md-6 col-12 mb-3\">\n");
      out.write("                    <img src=\"Image/KITN.png\" alt=\"\" style=\"width: 50px;\">\n");
      out.write("                    <p class=\"pt-3\">KITN s??? mang l???i cho b???n tr???i nghi???m nh???ng kh??ng gian v???i nh???ng\n");
      out.write("                        thi???t k??? ti???n nghi, tho???i m??i v?? gi?? th??nh h???p l?? nh???t.\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-one col-lg-3 col-md-6 col-12 mb-3\">\n");
      out.write("                    <h5 class=\"pb-2\">??I???U H?????NG</h5>\n");
      out.write("                    <ul class=\"text-uppercase list-unstyled\">\n");
      out.write("                        <li><a href=\"#\">TRANG CH???</a></li>\n");
      out.write("                        <li><a href=\"#\">C???A H??NG</a></li>\n");
      out.write("                        <li><a href=\"#\">LI??N H???</a></li>\n");
      out.write("                        <li><a href=\"#\">????NG NH???P</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-one col-lg-3 col-md-6 col-12 mb-3\">\n");
      out.write("                    <h5 class=\"pb-2\">LI??N H???</h5>\n");
      out.write("                    <div>\n");
      out.write("                        <h6 class=\"text-uppercase\">?????a ch???</h6>\n");
      out.write("                        <p>Wherever you need us!</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <h6 class=\"text-uppercase\">S??? ??i???n tho???i</h6>\n");
      out.write("                        <p>0969180735</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <h6 class=\"text-uppercase\">Email</h6>\n");
      out.write("                        <p>kitn0204@gmail.com</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-one col-lg-3 col-md-6 col-12\">\n");
      out.write("                    <h5 class=\"pb-2\">S???N PH???M</h5>\n");
      out.write("                    <ul class=\"row\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/8.jpg\" alt=\"\">\n");
      out.write("                        <img class=\"img-fluid w-25 h-100 m-2\" src=\"Image/8.jpg\" alt=\"\">\n");
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
