package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;


@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberDAO memberDAO = new MemberDAO();
    
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//어떤 페이지에서 요청이 왓는지 확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		

		
		//응답 페이지
		String page = "";
		boolean isRedirect = false;
		
		//member_list 데이터를 받아 오름차순으로 정렬할 쿼리로 이동
		if(command.equals("/memberList.do")) {
			List<MemberDTO> member = memberDAO.selectMemberList();
			
			request.setAttribute("list", member);
			
			page = "member_list.jsp";
		}
		
		//로그인 확인
		if(command.equals("/login.do")) {
			String memId = request.getParameter("memId");
			String memPw = request.getParameter("memPw");
			if (memberDAO.login(memId, memPw) == 1) {
				PrintWriter out = response.getWriter();
				isRedirect = true;
				out.println("<script>alert('로그인 성공!'); location.href='memberList.do'</script>");
				out.flush();
				return;
			} 
			else if (memberDAO.login(memId, memPw) == 0) {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인 실패 \n비밀번호가 다릅니다'); location.href='login.jsp';</script>");
				out.flush();
				return;
			} 
			else if (memberDAO.login(memId, memPw) == -1) {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인 실패 \n아이디가 없습니다.'); location.href='login.jsp';</script>");
				out.flush();				
				return;
			}
		}
		
		//회원가입
		if(command.equals("/regMember.do")) {
			String memId = request.getParameter("memId");
			String memPw = request.getParameter("memPw");
			String memName = request.getParameter("memName");
			String memGender = request.getParameter("memGender");
			String memIntro = request.getParameter("memIntro");
			
			memberDAO.regMember(memId, memPw, memName, memGender, memIntro);
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원가입 성공!'); location.href='memberList.do'</script>");
			out.flush();
			
			page = "login.jsp";
			
			return;
		}
		
		//아이디 정보를 받아서 회원 상세 조회 화면으로 페이지 이동
		if(command.equals("/memberToDetail.do")) {
			String memId = request.getParameter("memId");
			
			MemberDTO member = memberDAO.selectMemberDetail(memId);
			
			request.setAttribute("memberDetail", member);
			
			page = "member_detail.jsp";
		}
		
		//회원 상세 조회화면에서 memId데이터를 가져와 조회한 정보를 가지고 
		//수정페이지로 이동
		if(command.equals("/memberToUpdate.do")) {
			String memId = request.getParameter("memId");
			
			MemberDTO member = memberDAO.selectMemberDetail(memId);
			
			request.setAttribute("memberDetail", member);
			
			page = "member_update_form.jsp";
			
		}
		
		//회원 정보 수정
		if(command.equals("/memberUpdate.do")){
			String memId = request.getParameter("memId");
			String memPw = request.getParameter("memPw");
			String memName = request.getParameter("memName");
			String memGender = request.getParameter("memGender");
			String memIntro = request.getParameter("memIntro");
			
			memberDAO.memberUpdate(memId, memPw, memName, memGender, memIntro);
			
			request.setAttribute("memId", memId);
			page = "memberToDetail.do";
		}
		
		//회원 정보 삭제
		if(command.equals("/deleteMember.do")) {
			String memId = request.getParameter("memId");
			
			memberDAO.deleteMember(memId);
			
			page = "memberList.do";
			isRedirect = true;
			
		}
		
		
		//페이지 이동
		if(isRedirect) {
			response.sendRedirect(page);
		}
		
		else if(!isRedirect){
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);	
		}
	}
}
