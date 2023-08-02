package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.festival.board.model.service.BoardService;
import edu.kh.festival.board.model.vo.BoardDetail;
import edu.kh.festival.member.model.vo.Member;
import edu.kh.festival.board.model.vo.BoardImage;
import edu.kh.festival.common.MyRenamePolicy;

@WebServlet("/board/write") // 글쓰기 onclick="location.href='write?mode=insert&type=${param.type}'"
public class BoardWriteController extends HttpServlet {

	// 수정, 삭제 받기
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			try {
				
				String mode = req.getParameter("mode"); //  onclick="location.href='write?mode=insert&type=${param.type}'"
				//  insert인지 update인지 구분 insert의 경우는 바로 jsp로
				
				if(mode.equals("update")) {
					
					int boardNo = Integer.parseInt(req.getParameter("no"));
					
					BoardDetail detail = new BoardService().selectBoardDetail(boardNo);
					
					detail.setBoardContent(detail.getBoardContent().replaceAll("<br>", "\n"));
					
					req.setAttribute("detail", detail);
					
				}
				
				String path = "/WEB-INF/views/board/boardWriteForm.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// enctype="multipart/form-data" method="POST"
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			try {
				
				int maxSize = 1024 * 1024 * 50; 
				
				HttpSession session = req.getSession(); 
		         
				String root = session.getServletContext().getRealPath("/"); 
				// /festival/src/main/webapp
				
				System.out.println(session.getServletContext());
				
		        String folderPath = "/resources/images/board/"; 

		        String filePath = root + folderPath; 
		        // /festival/src/main/webapp + /resources/images/board/ 
		        System.out.println(root);
		        System.out.println(filePath);
		        
		        String encoding = "UTF-8";
				
		        System.out.println("test1");
		        MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
				// 객체가 생성됨과 동시에 파라미터로 전달된 파일이 지정된 경로에 저장됨 그냥 이 객체는 그렇게 해줌
				System.out.println("test2");
				System.out.println(mpReq);
		        Enumeration<String> files = mpReq.getFileNames();
		        
		        List<BoardImage> imageList = new ArrayList<BoardImage>();
		        
		        while(files.hasMoreElements()) { // 다음 요소가 있으면 true 
		        	String name = files.nextElement(); 
		        	
		        	// file 타입 태그의 name 속성 값이 얻어와진다. + 업로드가 안된 file 타입 태그의 name도 얻어와진다.
		        	
		        	String rename = mpReq.getFilesystemName(name); // 변경된 파일명 ex) 20230725111026_95415.png
		        	String original = mpReq.getOriginalFileName(name); // 원본 파일명 ex) dog3.jpg
		        	
		        	if(rename != null) {
		        		// 이미지 정보를 담은 객체(BoardImage)를 생성
		        		BoardImage image = new BoardImage();
		  
		        		image.setImageReName(folderPath + rename); 
		        		image.setImageLevel(Integer.parseInt(name)); 
		        		
		        		imageList.add(image); // 리스트에 추가
		        		
						/* public class BoardImage {
								private int imageNo;
								private String imageReName;
								private int imageLevel
						}*/
		        		
		        	} // if문 끝
		        	
		        } // while문 끝
		        
		        // boardList에서 map에 세팅된거 쓰나
		        String boardTitle = mpReq.getParameter("boardTitle");  
				
		        String boardContent = mpReq.getParameter("boardContent");
		        
		        int boardCode = Integer.parseInt(mpReq.getParameter("type")); // boardNo 쿼리 스트링
		        
		        Member loginMember = (Member)session.getAttribute("loginMember");
		        
		        int memberNo = loginMember.getMemberNo(); // 회원 번호
		        
		        // 게시글 관련 정보를 하나의 객체(BoardDetail)에 담기
		        BoardDetail detail = new BoardDetail();
		        
		        detail.setBoardTitle(boardTitle);
		        detail.setBoardContent(boardContent);
		        detail.setMemberNo(memberNo);
		        
		        BoardService service = new BoardService();
		        
		        String mode = mpReq.getParameter("mode"); // <input type="hidden" name="mode" value="${param.mode}">
		        
		        
		        if(mode.equals("insert")) { // 삽입
		        	
		        	// 게시글 삽입 서비스 호출 후 결과 반환 받기
		        	// -> 반환된 게시글 번호를 이용해서 상세조회로 redirect 예정
		        	int boardNo = service.insertBoard(detail, imageList, boardCode);
		        	
		        	String path = null;
		        	
		        	if(boardNo > 0 ) { // 성공
		        		session.setAttribute("message", "게시글이 등록되었습니다.");
		        		
		        		// detail?no=2000&type=2
		        		path = "detail?no=" + boardNo + "&type=" + boardCode;
		        		
		        		//http://localhost:8080/community/board/detail?no=1000 까지만 있으면 해당 게시글 가지고 뒤는 쿼리스트링이라 상관 x
		        		// 그냥 게시글 들어갈 땐 cp가 있는데 만들었을 때의 주소는 cp가 없음. 그차이밖에 업슴
		        		
		        	}else { // 실패
		        		session.setAttribute("message", "게시글 등록 실패");
		        		
		        		// write?mode=insert&type=2 실패했을 때 이 위치로 돌아가야함
		        		path = "write?mode=" + mode + "&type=" + boardCode;
		        		
		        	}
		        	
		        	resp.sendRedirect(path); // 리다이렉트
		        	
		        }
		        
		        if(mode.equals("update")) {
		        	
		        	int boardNo = Integer.parseInt(mpReq.getParameter("no"));
		        	
		        	int cp = Integer.parseInt(mpReq.getParameter("cp"));
		        	
		        	String deleteList = mpReq.getParameter("deleteList");
		        	
		        	detail.setBoardNo(boardNo);
		        	
		        	int result = service.updateBoard(detail, imageList, deleteList);
		        	
		        	String path = null;
		        	String message = null;
		        	
		        	if(result > 0 ) { // 성공
		        		
		        		// detail?no=1000&type=1&cp=20
		        		path = "detail?no=" + boardNo + "&type=" + boardCode + "&cp=" + cp; // 상세조회 페이지 요청 주소
		        		
		        		message = "게시글이 수정되었습니다.";
		        	
		        	}else { 
		        		path = req.getHeader("referer");
		        		
		        		message = "게시글 수정 실패";
		        		
		        	}	
		        	
		        	session.setAttribute("message", message);
		        	resp.sendRedirect(path);
		        }
		        
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}

		
		
	}	
	

