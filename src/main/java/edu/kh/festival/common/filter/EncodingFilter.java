package edu.kh.festival.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "encodingFilter", urlPatterns="/*") 
public class EncodingFilter extends HttpFilter implements Filter {   

	public void init(FilterConfig fConfig) throws ServletException {}


	public void destroy() {}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * HttpServletRequest httpRequest = (HttpServletRequest) request;
		 * HttpServletResponse httpResponse = (HttpServletResponse) response;
		 */
		
		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");

		ServletContext application = request.getServletContext();

		String contextpath = ((HttpServletRequest)request).getContextPath(); 
		
		// 헤더 아이콘
		String icon = ((HttpServletRequest)request).getServletPath();
		String Id = "/member/findId";
		String Pw = "/member/findPw";
		
		// 세팅
		application.setAttribute("contextPath", contextpath);
		
		
		application.setAttribute("icon", icon);
		application.setAttribute("Id", Id);
		application.setAttribute("Pw", Pw);


		chain.doFilter(request, response);
		
	}

}

