<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.member_title{
	text-align: center;
	padding: 20px 0;
}

.table_top{
	background-color: #f3f5f6;
	padding: 5px 0;
}

.member_info > td{
	padding: 3px 0;
}

.member_info > td > a{
	text-decoration-line: none;
	color: black;
}

.member_info > td > a:hover{
	text-decoration-line: underline;
}

table {
	border-top: 2px solid black;
	border-bottom: 2px solid black;
	border-collapse: collapse;
	text-align: center;
	width: 600px;
	margin: 0 auto;
}

tbody > tr{
	border-bottom: 1px solid silver;
}

table > tr > td{
	padding: 20px 0;
}

.button{
	margin: 10px 0;
	text-align: center;
}

.button > input{
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

.button > input:hover {
	text-decoration-line: underline;
}

</style>
</head>
<body>
	<div class="member_title">
		<h2>회원 목록</h2>
	</div>
	<table>
		<tr class="member_top">
			<td class="table_top">아이디</td>
			<td class="table_top">이름</td>
			<td class="table_top">성별</td>
		</tr>
		<c:choose>
			<c:when test="${list.size() eq 0}">
				<tr>
					<td colspan="3">회원이 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="member">
					<tr class="member_info">
						<td>${member.memId }</td>
						<td><a href="memberToDetail.do?memId=${member.memId }">${member.memName }</a></td>
						<td>${member.memGender }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="button">
		<input type="button" value="로그인 페이지"
			onclick="location.href='login.jsp'">
	</div>
</body>
</html>