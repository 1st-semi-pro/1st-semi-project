package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.festival.member.model.service.MemberService;
import edu.kh.festival.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String path = "/WEB-INF/views/member/login.jsp";
      
      req.getRequestDispatcher(path).forward(req, resp);

   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      // 로그인창에 아이디 입력하고 입력하고 로그인 누르면 값 담김
      String inputId = req.getParameter("inputId");
      String inputPw = req.getParameter("inputPw");
      
      // 입력한 아이디, 비번 Member VO에 세팅
      Member mem = new Member();
      mem.setMemberId(inputId);
      mem.setMemberPw(inputPw);
      
      try {
         
            // 서비스 객체 만들기 (서비스 메소드 쓸려고)
            MemberService service = new MemberService();
            
            // 이메일, 비번 일치하는 회원 있는지 조회하고 결과 반환받으러 가기
            Member loginMember = service.login(mem);
         
            // Session에 set할려고 객체 얻어온다
            HttpSession session = req.getSession();
            
            if(loginMember != null) {
               // System.out.println("성공"); // 테스트
               
               // DB에서 일치해서 모든 정보 loginMember(Member VO 객체)로 가져오면 그 정보들을 SessionScope 범위로 설정하겠다.
               session.setAttribute("loginMember", loginMember);
               
               session.setAttribute("message", loginMember.getMemberId() + "님 환영합니다.");
               
               // 30분동안 요청이 아무것도 없으면 세션 만료
               session.setMaxInactiveInterval(1800);
               
               // ----------------------------쿠키 -------------------------------- //
               Cookie cookie = new Cookie("idSave", inputId);
                           // ("클라이언트쪽에 저장될 쿠키 이름", "쿠키 내용" )
               
               if(req.getParameter("idSave") != null) {
            	   cookie.setMaxAge(60 * 60 * 24 * 7); // 7일
            	   System.out.println("성공");
               
               }else {
            	   cookie.setMaxAge(0);
            	   System.out.println("실패");
               }
               
               cookie.setPath(req.getContextPath() + "/member/login");
               
               resp.addCookie(cookie);
               
               
               // ----------------------------쿠키 -------------------------------- //
               
               // 아이디 비번 DB에 있으면 메인페이지로 가겠다.
               resp.sendRedirect(req.getContextPath());
               
               }else {
               System.out.println("실패"); // 테스트
               
               session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
               // footer 없어서 jsp에 jstl로 message 출력
         
               // 아이디 비번이 DB에 없으면 다시 같은화면으로 가겠다.
               resp.sendRedirect(req.getContextPath() + "/member/login");
               
            }
         
      }catch(Exception e) {
         e.printStackTrace();
      }
      
   }
   
}