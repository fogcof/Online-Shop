package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Home</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"\n");
      out.write("              integrity=\"sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p\" crossorigin=\"anonymous\" />\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <style>\n");
      out.write("            .account-page {\n");
      out.write("                padding: 100px 0;\n");
      out.write("                background: radial-gradient(#fff, #ffd6d6);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .list-group-item {\n");
      out.write("                font-weight: 550;\n");
      out.write("                opacity: 1;\n");
      out.write("                transition: 0.3s all;\n");
      out.write("                text-align: center;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .select {\n");
      out.write("                background-color: #fb774b;\n");
      out.write("                color: aliceblue;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .list-group-item:hover {\n");
      out.write("                color: aliceblue;\n");
      out.write("                background-color: #1d1d1d;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table{\n");
      out.write("                width: 100%;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                table-layout: fixed;\n");
      out.write("                white-space: nowrap;\n");
      out.write("                overflow-x: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table img{\n");
      out.write("                width: 70px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table td:nth-child(1){\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table thead{\n");
      out.write("                border: 2px solid #acc2a9;\n");
      out.write("                border-left: none;\n");
      out.write("                border-right: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            thead td{\n");
      out.write("                font-weight: 700;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                font-size: 13px;\n");
      out.write("                padding: 18px 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            tr:not(:last-child){\n");
      out.write("                border: 1px solid #bbc9b9;\n");
      out.write("                border-left: none;\n");
      out.write("                border-right: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            td{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            tbody tr td{\n");
      out.write("                padding-top: 15px;\n");
      out.write("                padding-bottom: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            tbody td{\n");
      out.write("                font-size: 15px;\n");
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
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"shop\" id=\"navbarDropdown\" role=\"button\"\n");
      out.write("                               data-bs-toggle=\"dropdown-toggle\" aria-expanded=\"false\">\n");
      out.write("                                C???A H??NG\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\">LI??N H???</a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <!-- <i class=\"fal fa-search\"></i> -->\n");
      out.write("                            <i class=\"fal fa-shopping-bag\"></i>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                    <form action=\"search\" class=\"form-inline my-2 my-lg-0 ml-auto\"> <!-- fix -->\n");
      out.write("                        <input class=\"form-control mr-sm-2\" type=\"search\" name=\"key\" placeholder=\"Search\" aria-label=\"Search\">\n");
      out.write("                        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"mt-5 account-page\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 col-sm-12\">\n");
      out.write("                        <div class=\"list-group\" id=\"list-tab\" role=\"tablist\">\n");
      out.write("                            <a class=\"list-group-item list-group-item-action select\" id=\"list-home-list\" data-toggle=\"list\"\n");
      out.write("                               href=\"#list-home\" role=\"tab\" aria-controls=\"home\">Customer</a>\n");
      out.write("                            <a class=\"list-group-item list-group-item-action\" id=\"list-profile-list\" data-toggle=\"list\"\n");
      out.write("                               href=\"#list-profile\" role=\"tab\" aria-controls=\"profile\">Category</a>\n");
      out.write("                            <a class=\"list-group-item list-group-item-action\" id=\"list-messages-list\" data-toggle=\"list\"\n");
      out.write("                               href=\"#list-messages\" role=\"tab\" aria-controls=\"messages\">Product</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-10 col-md-8 col-sm-12\">\n");
      out.write("                        <div class=\"tab-content\" id=\"nav-tabContent\">\n");
      out.write("                            <div class=\"tab-pane fade show active\" id=\"list-home\" role=\"tabpanel\"\n");
      out.write("                                 aria-labelledby=\"list-home-list\"> <!-- set active and show class to visible-->\n");
      out.write("                                <table width=\"100%\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>ID</td>\n");
      out.write("                                            <td>Email</td>\n");
      out.write("                                            <td>Username</td>\n");
      out.write("                                            <td>Password</td>\n");
      out.write("                                            <td>Action</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>1</td>\n");
      out.write("                                            <td>Mark</td>\n");
      out.write("                                            <td>Otto</td>\n");
      out.write("                                            <td><img src=\"Image/8.jpg\" alt=\"\"></td>\n");
      out.write("                                            <td><a href=\"#\"><i\n");
      out.write("                                                        class=\"far fa-times-circle\"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a\n");
      out.write("                                                    href=\"\"><i class=\"far fa-wrench\"></i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>1</td>\n");
      out.write("                                            <td>Mark</td>\n");
      out.write("                                            <td>Otto</td>\n");
      out.write("                                            <td><img src=\"Image/8.jpg\" alt=\"\"></td>\n");
      out.write("                                            <td><a href=\"#\"><i\n");
      out.write("                                                        class=\"far fa-times-circle\"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a\n");
      out.write("                                                    href=\"\"><i class=\"far fa-wrench\"></i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>1</td>\n");
      out.write("                                            <td>Mark</td>\n");
      out.write("                                            <td>Otto</td>\n");
      out.write("                                            <td><img src=\"Image/8.jpg\" alt=\"\"></td>\n");
      out.write("                                            <td><a href=\"#\"><i\n");
      out.write("                                                        class=\"far fa-times-circle\"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a\n");
      out.write("                                                    href=\"\"><i class=\"far fa-wrench\"></i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>1</td>\n");
      out.write("                                            <td>Mark</td>\n");
      out.write("                                            <td>Otto</td>\n");
      out.write("                                            <td><img src=\"Image/8.jpg\" alt=\"\"></td>\n");
      out.write("                                            <td><a href=\"#\"><i\n");
      out.write("                                                        class=\"far fa-times-circle\"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a\n");
      out.write("                                                    href=\"\"><i class=\"far fa-wrench\"></i></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"tab-pane fade\" id=\"list-profile\" role=\"tabpanel\"\n");
      out.write("                                 aria-labelledby=\"list-profile-list\">ok</div>\n");
      out.write("                            <div class=\"tab-pane fade\" id=\"list-messages\" role=\"tabpanel\"\n");
      out.write("                                 aria-labelledby=\"list-messages-list\">...</div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <footer class=\"mt-5 py-4\"><!-- fix -->\n");
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
      out.write("                        <li><a href=\"shop\">C???A H??NG</a></li>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.listc}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("listc");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <li><a class=\"dropdown-item\" href=\"shop?cid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listc.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listc.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <li class=\"nav-item dropdown\">\n");
        out.write("                                <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdown\" role=\"button\"\n");
        out.write("                                   data-bs-toggle=\"dropdown-toggle\" aria-expanded=\"false\">\n");
        out.write("                                    T??I KHO???N\n");
        out.write("                                </a>\n");
        out.write("                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
        out.write("                                    <li><a class=\"dropdown-item\" href=\"updatecus\">C???P NH???T</a></li>\n");
        out.write("                                        ");
        if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                    <li><a class=\"dropdown-item\" href=\"logout\">????NG XU???T</a></li>\n");
        out.write("                                </ul>\n");
        out.write("                            </li>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account.username eq 'chieu'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <li><a class=\"dropdown-item\" href=\"manage\">QU???N L??</a></li>\n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.account==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <li class=\"nav-item\">\n");
        out.write("                                <a class=\"nav-link\" href=\"login\">????NG NH???P</a>\n");
        out.write("                            </li>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }
}
