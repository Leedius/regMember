<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}

.board_title{
	text-align: center;
	padding: 20px 0;
}

table{
   border-top: 2px solid black;
   border-bottom: 2px solid black;
   border-collapse: collapse;
   text-align: center;
   width: 600px;
   margin: 0 auto;
}

table .top{
	background-color: #f3f5f6;
	padding: 5px 0;
}

table .info{
	background-color: #ffffff;
	text-align: left;
}

.info{
	vertical-align: middle;
}

.info > input{
	width: 100%;
	height: 23px;
}

.gender{
	text-align: left;
}

tbody > tr{
	border-bottom: 1px solid silver;
}

.button{
	margin-top: 30px;
	text-align: center;
	font-size: 0;
}


.button > input {
	display: inline-block;
	min-width: 30px;
	margin-left: 10px;
	padding: 5px;
	border: 1px solid black;
	border-radius: 5px;
	font-size: 1rem;
	background: white;	
	color: black;
}

.button > input{
	background: white;	
	color: black;
}

.button > input:hover {
	text-decoration-line: underline;
}

</style>
</head>
<body>
	<div class="board_title">
		<h2>회원 상세 조회</h2>
	</div>
	<form action="memberUpdate.do" method="post">
	<div class="content_wrap">
		<div class="content_table">
			<table>
				<colgroup>
					<col width="16%">
					<col width="16%">
					<col width="16%">
					<col width="16%">
					<col width="16%">
					<col width="*">
				</colgroup>			
					<tr>
						<td class="top">아이디</td>
						<td class="info" colspan="5">
							<input type="text" name="memId" value="${memberDetail.memId }">
						</td>
					</tr>
					<tr>
						<td class="top">비밀번호</td>
						<td class="info" colspan="5">
							<input type="text" name="memPw" value="${memberDetail.memPw }">
						</td>
					</tr>
					<tr>
						<td class="top">이름</td>
						<td class="info" colspan="5">
							<input type="text" name="memName" value="${memberDetail.memName }">
						</td>
					</tr>
					<tr>
						<td class="top">성별</td>
						<td class="gender" colspan="5">
							<c:choose>
								<c:when test="${memberDetail.memGender eq '남'}">
									<input type="radio" name="memGender" value="남" checked>남자
									<input type="radio" name="memGender" value="여">여자
								</c:when>
								<c:otherwise>
									<input type="radio" name="memGender" value="남">남자
									<input type="radio" name="memGender" value="여" checked>여자
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="top">가입일</td>
						<td class="info" colspan="5">
							<input type="text" name="regDate" value="${memberDetail.regDate }" readonly> 
						</td>
					</tr>
					<tr>
						<td class="top">소개글</td>
						<td class="info" colspan="5">
							<textarea rows="5" cols="50" name="memIntro" style="resize: none; width: 100%">${memberDetail.memIntro }</textarea>
						</td>
					</tr>
			</table>
		</div>
		<div class="button">
			<input type="submit" value="등록"> 
		</div>
	</div>
	</form>
</body>
</html>