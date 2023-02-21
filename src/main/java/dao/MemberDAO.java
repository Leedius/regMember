package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.print.DocFlavor.STRING;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;

import dto.MemberDTO;


public class MemberDAO {
	//oracle과 자바를 연결시켜줄 수 있는 객체
	private Connection conn = null;
	
	MemberDTO memberDTO = new MemberDTO();
	

	// 실행할 쿼리문 작성
	private String sql = "";

	// 쿼리를 실행시켜주는 객체
	private PreparedStatement pstmt = null;
	
	// 조회된 데이터를 저장하는 객체
	private ResultSet rs = null;
	
	// 회원 목록 리스트 페이지로 이동(ID 오름차순으로 정렬)
	public List<MemberDTO> selectMemberList() {
		List<MemberDTO> memberList = new ArrayList<>();
			//실행할 쿼리
			sql = "SELECT "
					+ "MEM_ID"
					+ ", MEM_NAME"
					+ ", MEM_GENDER "
				+ "FROM "
					+ "BASIC_MEMBER "
					+ "ORDER "
					+ "BY "
					+ "MEM_ID "
					+ "ASC";
					
			try {
				// 자바와 디비를 연결
				conn = DBUtil.getConnection();

				// 쿼리를 실행시킬 객체를 생성
				pstmt = conn.prepareStatement(sql);

				// ?값을 채워줘야 함

				// 쿼리 실행(조회이기때문에 execute뒤에 Query()를 씀.
				rs = pstmt.executeQuery();
					
					while(rs.next()) {
						String memId = rs.getString("MEM_ID");
						String memName = rs.getString("MEM_NAME");
						String memGender = rs.getString("MEM_GENDER");
						
						//조회된 데이터에는 null로 넣는다
						MemberDTO member = new MemberDTO(memId, null, memName, null, memGender , null);
						memberList.add(member);
					}
				
			} catch (Exception e) {
				System.out.println("게시글 목록 조회 오류");
				e.printStackTrace();
			} finally {
				DBUtil.close(rs, pstmt, conn);
			}
			//조회된 모든 데이터를 지닌 boardList 객체 리턴
			return memberList;
		}
	
	//로그인 확인
	public int login(String memId, String memPw) {
		String dbPW = "";
		int x = -1;
		
		sql = "SELECT "
		        + "MEM_ID"
		        + ", MEM_PW"
		        + ", MEM_NAME"
		        + ", MEM_GENDER "
		    + "FROM "
		        + "BASIC_MEMBER "
		    + "WHERE "
		        + "MEM_ID = ?";
				
		try {
			// 자바와 디비를 연결
			conn = DBUtil.getConnection();

			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// ?값을 채워줘야 함
			pstmt.setString(1, memId);

			// 쿼리 실행(조회이기때문에 execute뒤에 Query()를 씀.
			rs = pstmt.executeQuery();
			
			
			boolean result = rs.next();
			
			if(result) { //입력된 아이디에 해당하는 비번 있을경우
				dbPW = rs.getString("MEM_PW");
				
				if(dbPW.equals(memPw)) {
					x = 1; // 넘겨받은 비번과 꺼내온 비번 비교, 같으면 인증성공
				}
				else {
					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
				}
			}
			else {
				x = -1; // 해당 아이디가 없을경우
			}
			
		} catch (Exception e) {
			System.out.println("게시글 목록 조회 오류");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		System.out.println(x);
		//조회된 모든 데이터를 지닌 boardList 객체 리턴
		return x;
	}
		
	
	
	//회원등록
	public int regMember(String memId,
			String memPw, 
			String memName,
			String memGender,
			String memIntro) {
		
		int result = 0;
		//실행할 쿼리
			sql = "INSERT INTO BASIC_MEMBER ("
					+ "MEM_ID"
					+ ", MEM_PW"
					+ ", MEM_NAME"
					+ ", MEM_GENDER"
					+ ", MEM_INTRO"
					+ ") "
					+ "VALUES ("
					+ "?"
					+ ", ?"
					+ ", ?"
					+ ", ?"
					+ ", ?)";
						
			try {
				// 자바와 디비를 연결
				conn = DBUtil.getConnection();

				// 쿼리를 실행시킬 객체를 생성
				pstmt = conn.prepareStatement(sql);
					
				// ?값을 채워줘야 함
				pstmt.setString(1, memId);
				pstmt.setString(2, memPw);
				pstmt.setString(3, memName);
				pstmt.setString(4, memGender);
				pstmt.setString(5, memIntro);
					
				// 쿼리 실행(몇 행이 삽입되었는지 result에 저장)
				rs = pstmt.executeQuery();
				
					
			} catch (Exception e) {
				System.out.println("게시글 목록 조회 오류");
				e.printStackTrace();
			} finally {
				DBUtil.close(rs, pstmt, conn);
			}
			return result;
		}
	
	//회원 상세 조회
	public MemberDTO selectMemberDetail(String memId) {
		//리턴할 객체를 담을 통생성
		MemberDTO memberDetail = null;
		
		sql = "SELECT "
		        + "MEM_ID"
		        + ", MEM_PW"
		        + ", MEM_NAME"
		        + ", REG_DATE"
		        + ", MEM_GENDER"
		        + ", MEM_INTRO "
		    + "FROM "
		        + "BASIC_MEMBER "
		    + "WHERE "
		        + "MEM_ID = ?";
		
		try {
			// 자바와 디비를 연결
			conn = DBUtil.getConnection();
	
			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);
	
			// ?값을 채워줘야 함
			pstmt.setString(1, memId);
	
			// 쿼리 실행(조회이기때문에 execute뒤에 Query()를 씀.
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				String memPw = rs.getString("MEM_PW");
				String memName = rs.getString("MEM_NAME");
				String regDate = rs.getString("REG_DATE");
				String memGender = rs.getString("MEM_GENDER");
				String memIntro = rs.getString("MEM_INTRO");
	
				// 조회된 데이터에는 content가 없어서 마지막 항목은 null로 넣는다
				memberDetail = new MemberDTO(memId, memPw, memName, regDate, memGender, memIntro);
			}
	
		} catch (Exception e) {
			System.out.println("게시글 목록 조회 오류");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		// 조회된 모든 데이터를 지닌 객체 리턴
		return memberDetail;
	}
	
	//회원 상세 페이지에서 데이터 받아서 수정페이지로 이동
	public MemberDTO detailToUpdate(String memId) {
		
		MemberDTO memberDetail = null;
		
		sql = "SELECT "
		        + "MEM_ID"
		        + ", MEM_PW"
		        + ", MEM_NAME"
		        + ", REG_DATE"
		        + ", MEM_GENDER"
		        + ", MEM_INTRO "
		    + "FROM "
		        + "BASIC_MEMBER "
		    + "WHERE "
		        + "MEM_ID = ?";
	
		try {
			// 자바와 디비를 연결
			conn = DBUtil.getConnection();
	
			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);
	
			// ?값을 채워줘야 함
			pstmt.setString(1, memId);
	
			// 쿼리 실행(조회이기때문에 execute뒤에 Query()를 씀.
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				String memPw = rs.getString("MEM_PW");
				String memName = rs.getString("MEM_NAME");
				String regDate = rs.getString("REG_DATE");
				String memGender = rs.getString("MEM_GENDER");
				String memIntro = rs.getString("MEM_INTRO");
	
				// 조회된 데이터에는 content가 없어서 마지막 항목은 null로 넣는다
				memberDetail = new MemberDTO(memId, memPw, memName, regDate, memGender, memIntro);
			}
		} catch (Exception e) {
			System.out.println("게시글 목록 조회 오류");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return memberDetail;
	}
	
	//회원 정보 수정
	public void memberUpdate(String memId,
			String memPw, 
			String memName,
			String memGender,
			String memIntro) {
		
		sql = "UPDATE "
				+ "BASIC_MEMBER "
				+ "SET " 
				+ "MEM_ID = ?"
				+ ", MEM_PW = ?"
				+ ", MEM_NAME = ?"
				+ ", MEM_GENDER = ?"
				+ ", MEM_INTRO = ? "
			+ "WHERE "
				+ "MEM_ID = ?";

		try {
			// 자바와 디비를 연결
			conn = DBUtil.getConnection();

			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// ?값을 채워줘야 함
			pstmt.setString(1, memId);
			pstmt.setString(2, memPw);
			pstmt.setString(3, memName);
			pstmt.setString(4, memGender);
			pstmt.setString(5, memIntro);
			pstmt.setString(6, memId);

			// 쿼리 실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("게시글 목록 조회 오류");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}
	
	//회원 정보 삭제
	public void deleteMember(String memId) {

		// 실행할 쿼리
		sql = "DELETE BASIC_MEMBER "
				+ "WHERE "
				+ "MEM_ID = ?";

		try {
			// 자바와 디비를 연결
			conn = DBUtil.getConnection();

			// 쿼리를 실행시킬 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// ?값을 채워줘야 함
			pstmt.setString(1, memId);

			// 쿼리 실행(몇 행이 삽입되었는지 result에 저장)
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("게시글 목록 조회 오류");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
	
	}
	
}



