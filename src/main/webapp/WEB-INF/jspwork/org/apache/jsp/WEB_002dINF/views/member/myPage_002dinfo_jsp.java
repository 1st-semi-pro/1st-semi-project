/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-08-07 11:12:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myPage_002dinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1691062301826L));
    _jspx_dependants.put("jar:file:/C:/workspace/5_Server/semi/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/C:/workspace/5_Server/semi/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425946270000L));
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>마이페이지</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/header.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/myPage-info.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/51fc103959.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("        \r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <!-- 마이페이지 내 정보 -->\r\n");
      out.write("        <section class=\"myPage-content\">\r\n");
      out.write("\r\n");
      out.write("            <!-- 왼쪽 사이드 메뉴 -->\r\n");
      out.write("            <section class=\"left-side\">\r\n");
      out.write("                <h2>사이드 메뉴</h2>\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"list-group\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- /communty/member/myPage/info -->\r\n");
      out.write("                    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/myPage/info\">내 정보 변경</a></li>\r\n");
      out.write("                    \r\n");
      out.write("                    <!-- /communty/member/myPage/changePw-->\r\n");
      out.write("                    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/myPage/changePw\">비밀번호 변경</a></li>\r\n");
      out.write("\r\n");
      out.write("                    <!-- /communty/member/myPage/changeEmail-->\r\n");
      out.write("                    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/myPage/changeEmail\">이메일 변경</a></li>\r\n");
      out.write("\r\n");
      out.write("                    <!-- /communty/member/myPage/secession-->\r\n");
      out.write("                    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/myPage/secession\">회원 탈퇴</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </section>\r\n");
      out.write("            \r\n");
      out.write("            <!-- 오른쪽 마이페이지 주요 내용 부분 -->\r\n");
      out.write("            <section class=\"myPage-main\">\r\n");
      out.write("\r\n");
      out.write("                <h1 class=\"myPage-title\">내정보</h1>\r\n");
      out.write("                <span class=\"myPage-explanation\">원하는 회원 정보를 수정할 수 있습니다.</span>\r\n");
      out.write("                <form action=\"info\" method=\"post\" onsubmit=\"return infoValidate()\" name=\"myPage-form\">\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"dis\">\r\n");
      out.write("                    <div class=\"myPage-row\" id=\"disabled\">\r\n");
      out.write("                        <label>아이디</label>\r\n");
      out.write("                        <input type=\"text\" name=\"memberId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"30\" disabled>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"myPage-row\" id=\"disabled\">\r\n");
      out.write("                        <label>이름</label>\r\n");
      out.write("                        <input type=\"text\" name=\"memberName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"30\" disabled>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"myPage-row\" id=\"disabled\">\r\n");
      out.write("                        <label>성별</label>\r\n");
      out.write("                        <input type=\"text\" name=\"memberEmail\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberGender }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"30\" disabled>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"myPage-row\" id=\"disabled\">\r\n");
      out.write("                        <label>국가</label>\r\n");
      out.write("                        <input type=\"text\" name=\"memberNationality\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberNationality }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"30\" disabled>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                    <div class=\"myPage-row\">\r\n");
      out.write("                        <label>사는 지역</label>\r\n");
      out.write("                        <select name=\"memberRegion\" id=\"memberRegion\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberRegion }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberRegion }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberRegion}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</option>\r\n");
      out.write("                            <option value=\"서울\">서울</option>\r\n");
      out.write("                            <option value=\"경기\">경기</option>\r\n");
      out.write("                            <option value=\"인천\">인천</option>\r\n");
      out.write("                            <option value=\"강원도\">강원도</option>\r\n");
      out.write("                            <option value=\"충청도\">충청도</option>\r\n");
      out.write("                            <option value=\"전라도\">전라도</option>\r\n");
      out.write("                            <option value=\"경상도\">경상도</option>\r\n");
      out.write("                          </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"myPage-row\">\r\n");
      out.write("                        <label>닉네임</label>\r\n");
      out.write("                        <input type=\"text\" name=\"memberNickname\" id=\"memberNickname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberNickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"10\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"myPage-row\">\r\n");
      out.write("                        <label>전화번호</label>\r\n");
      out.write("                        <input type=\"text\" name=\"memberPhone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberPhone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"11\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"myPage-row\">\r\n");
      out.write("                        <label>이메일</label>\r\n");
      out.write("                        <input type=\"email\" name=\"memberEmail\" id=\"memberEmail\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberEmail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"30\">\r\n");
      out.write("                        \r\n");
      out.write("                        <button id=\"emailBtn\" type=\"button\" style=\"margin-bottom: 18px;\">인증하기</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                        <span class = \"myPage-row\" id=\"innerTextSpan\" > \r\n");
      out.write("                            <input type=\"hidden\"  id=\"authenticationInput\" name=\"authenticationInput\" placeholder=\"인증번호를 입력해주세요.\" style=\"margin: 0;\">\r\n");
      out.write("                            <input type=\"hidden\" id=\"authenticationButton\" name=\"authenticationButton\">\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <div class=\"right\">\r\n");
      out.write("                            <span id=\"timer\"></span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <span id=\"innerTextSpan2\">아이디, 이름, 성별, 국가  변경 불가능</span>\r\n");
      out.write("                    <button id=\"info-update-btn\" >수정하기</button>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("    </main>\r\n");
      out.write("        <!-- <script>\r\n");
      out.write("            const memberEmail = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberEmail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("        </script> -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.7.0.min.js\" integrity=\"sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/Changee-information.js\"></script>\r\n");
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
