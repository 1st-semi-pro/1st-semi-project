package edu.kh.festival.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import edu.kh.festival.common.wrapper.EncryptWrapper;

@WebFilter(filterName = "encryptFilter", urlPatterns = {"/member/join", "/member/login", "/member/pwConfirm/check"
														 ,"/member/myPage/chagePw"})
public class EncryptFilter extends HttpFilter implements Filter {


	public void init() throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req; // 비번은 HttpServletRequest에 담김 -> 다운캐스팅
		
		EncryptWrapper wrapper = new EncryptWrapper(request); // 오버라이드된 getParameter 메소드 사용 가능
		
		chain.doFilter(wrapper, res);
		
	}
}
