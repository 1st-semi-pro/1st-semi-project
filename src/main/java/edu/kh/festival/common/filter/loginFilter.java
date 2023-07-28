package edu.kh.festival.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//게시글 등록, 수정, 삭제 
//마이페이지 관련 부분 전부
//댓글 등록, 수정, 삭제

// 관리자 필터도 넣어야 할듯

@WebFilter(filterName = "loginFilter",
		   urlPatterns = {"/member/myPage/*"}) // 일단 마이페이지만 넣음
public class loginFilter extends HttpFilter implements Filter {
       
	
	public void init(FilterConfig fConfig) throws ServletException {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 세션을 얻어오기 위한 다운캐스팅 (메소드 쓸려고)
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		
		if(session.getAttribute("loginMember") != null) {
			
			chain.doFilter(request, response);
			
		} else {
			
			session.setAttribute("message", "로그인 후 이용해주세요.");
			
			resp.sendRedirect(req.getContextPath());
			
		}
	
	
	
	
	}

}
