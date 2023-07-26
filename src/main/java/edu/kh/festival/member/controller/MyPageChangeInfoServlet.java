package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.festival.member.model.service.MemberService;
import edu.kh.festival.member.model.vo.Member;


@WebServlet("/member/myPage/info")
public class MyPageChangeInfoServlet extends HttpServlet {

	// 마이페이지 -> 마이인포 클릭시 요청(GET)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/member/myPage-info.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	// post방식 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 파라미터 얻어오기
		String memberRegion = req.getParameter("memberRegion");
		String memberEmail = req.getParameter("memberEmail");
		String memberPhone = req.getParameter("memberPhone");
		String memberPw = req.getParameter("memberPw");
		String newPw = req.getParameter("newPw");
		String memberNickname = req.getParameter("memberNickname");

		// *** 세션에서 로그인한 회원 정보 얻어오기 ***
		HttpSession session = req.getSession();

		// 얕은 복사(세션에 있는 회원 정보 객체 주소)
		// -> loginMember를 수정하면 세션에 저장된 내용이 수정된다.
		Member loginMember = (Member) session.getAttribute("loginMember");

		int memberNo = loginMember.getMemberNo(); // 회원번호 얻어오기 성공
		System.out.println(memberNo);
		// 업데이트에 필요한 정보를 모아둔 Member객체 생성
		Member mem = new Member();

		mem.setMemberNo(memberNo);

		mem.setMemberRegion(memberRegion);
		mem.setMemberEmail(memberEmail);
		mem.setMemberPhone(memberPw);
		mem.setMemberPw(memberPw);
		mem.setMemberNickname(memberNickname);

		try {
			MemberService service = new MemberService();

			int result = service.updateMember(mem, newPw);
			
			System.out.println(result);
			// 수정 성공 / 실패에 따른 메세지 출력 제어
			if (result > 0) { // 성공
				session.setAttribute("message", "회원 정보가 수정되었습니다");

				// DB는 수정되었지만
				// 로그인한 회원 정보가 담겨있는 Session의 정보는 그대로다!
				// -> 동기화 작업
				loginMember.setMemberRegion(memberRegion);
				loginMember.setMemberEmail(memberEmail);
				loginMember.setMemberPhone(memberPhone);
				loginMember.setMemberPw(newPw);
				loginMember.setMemberNickname(memberNickname);

			} else { // 실패
				session.setAttribute("message", "회원 정보 수정실패");
			}

			// 성공/실패 여부 관계 없이 " 내 정보 " 화면 재요청

			// 절대 경로
			resp.sendRedirect(req.getContextPath() + "/member/myPage/info");

			// 상대 경로
			// resp.sendRedirect("info");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
