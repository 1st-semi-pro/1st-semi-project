/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-08-07 07:08:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1691062301826L));
    _jspx_dependants.put("jar:file:/C:/workspace/5_Server/semi/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>메인페이지</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"resources/css/header.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"resources/css/index.css\">\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/16679b9adf.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css\" />\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    \r\n");
      out.write("    	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("        \r\n");
      out.write("      <div class=\"swiper mySwiper\">\r\n");
      out.write("         <div class=\"swiper-wrapper\">\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/22.png\"></a></div>\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/42.png\"></a></div>\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/69.png\"></a></div>\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/105.png\"></a></div>\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/106.png\"></a></div>\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/109.png\"></a></div>\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/111.png\"></a></div>\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/113.png\"></a></div>\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/115.png\"></a></div>\r\n");
      out.write("             <div class=\"swiper-slide\"><a href=\"#\"><img src=\"resources/images/festival_infomation/122.png\"></a></div>\r\n");
      out.write("         </div>\r\n");
      out.write("             <div class=\"swiper-pagination\"></div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("         <div class=\"content-1\"> <!-- 한반도 + 게시판 -->\r\n");
      out.write("            <div class=\"korea\"> <!-- 한반도 -->\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=서울특별시&festivalCat=\"><img src=\"resources/images/korea/seoul.png\" id=\"seoul\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=경기도&festivalCat=\"><img src=\"resources/images/korea/Gyeonggi.png\" id=\"gyeonggi\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festuvalDate=&festivalArea=인천&festivalCat=\"><img src=\"resources/images/korea/incheon.png\" id=\"incheon\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=강원도&festivalCat=\"><img src=\"resources/images/korea/gangwon.png\" id=\"gangwon\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=충청남도&festivalCat=\"><img src=\"resources/images/korea/chungnam.png\" id=\"chungnam\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=대전&festivalCat=\"><img src=\"resources/images/korea/daejeon.png\" id=\"daejeon\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=충청북도&festivalCat=\"><img src=\"resources/images/korea/chungbuk.png\" id=\"chungbuk\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=경상북도&festivalCat=\"><img src=\"resources/images/korea/gyeongsang.png\" id=\"gyeongsang\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=대구&festivalCat=\"><img src=\"resources/images/korea/daegu.png\" id=\"daegu\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=전라북도&festivalCat=\"><img src=\"resources/images/korea/jeonbuk.png\" id=\"jeonbuk\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=전라남도&festivalCat=\"><img src=\"resources/images/korea/jeonnam.png\" id=\"jeonnam\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=광주&festivalCat=\"><img src=\"resources/images/korea/gwangju.png\" id=\"gwangju\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=경상남도&festivalCat=\"><img src=\"resources/images/korea/gyeongnam.png\" id=\"gyeongnam\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=제주도&festivalCat=\"><img src=\"resources/images/korea/jeju.png\" id=\"jeju\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=부산&festivalCat=\"><img src=\"resources/images/korea/busan.png\" id=\"busan\"></a>\r\n");
      out.write("               <a href=\"board/festivalInfo?type=1&ft=0&pop=0&festivalDate=&festivalArea=울산&festivalCat=\"><img src=\"resources/images/korea/ulsan.png\" id=\"ulsan\"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"divide1\" id=\"divide1\">\r\n");
      out.write("               <div class=\"divide2\">\r\n");
      out.write("                  <div class=\"divide3\">\r\n");
      out.write("                     <div class=\"board-name1\"><a href=\"board/list?type=2\">공지게시판</a></div>\r\n");
      out.write("                     <div class=\"board-content1\">\r\n");
      out.write("                        <table>\r\n");
      out.write("                           <tbody id=\"bList1\"></tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"divide4\">\r\n");
      out.write("                     <div class=\"board-name2\"><a href=\"board/list?type=3\">자유게시판</a></div>\r\n");
      out.write("                     <div class=\"board-content2\">\r\n");
      out.write("                        <table>\r\n");
      out.write("                           <tbody id=\"bList2\"></tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </div>\r\n");
      out.write("               <div class=\"divide5\">\r\n");
      out.write("                  <div class=\"divide6\">\r\n");
      out.write("                     <div class=\"board-name3\"><a href=\"board/list?type=4\">축제 후기</a></div>\r\n");
      out.write("                     <div  class=\"board-content3\">\r\n");
      out.write("                        <table>\r\n");
      out.write("                           <tbody id=\"bList3\"></tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"divide7\">\r\n");
      out.write("                     <div class=\"board-name4\"><a href=\"board/companion?type=5\">동행자 구하기</a></div>\r\n");
      out.write("                     <div class=\"board-content4\">\r\n");
      out.write("                        <table>\r\n");
      out.write("                           <tbody id=\"bList4\">\r\n");
      out.write("                              <div class=\"companion\">\r\n");
      out.write("                                 <div>\r\n");
      out.write("                                 \r\n");
      out.write("                                 </div>\r\n");
      out.write("\r\n");
      out.write("                                 <div>\r\n");
      out.write("   \r\n");
      out.write("                                 </div>\r\n");
      out.write("                              \r\n");
      out.write("                                 <div>\r\n");
      out.write("                                 \r\n");
      out.write("                                 </div>\r\n");
      out.write("\r\n");
      out.write("                                 <div>\r\n");
      out.write("   \r\n");
      out.write("                                 </div>\r\n");
      out.write("                              </div>\r\n");
      out.write("                           </tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>   \r\n");
      out.write("      </div>      \r\n");
      out.write("           \r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("         \r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <script src=\"https://code.jquery.com/jquery-3.7.0.min.js\" integrity=\"sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("      <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/main.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
