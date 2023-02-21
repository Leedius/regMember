<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
}

table .info{
	background-color: #ffffff;
}

thead > tr{
	border-bottom: 1px solid silver;
}

tbody > tr{
	border-bottom: 1px solid silver;
}

tbody .info{
	text-align: left;
	padding-left: 3px;
}	

tbody > tr > td{
	padding: 10px 0;
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
	<form action="deleteBoard.do" method="post">
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
						<td class="info" colspan="5">${memberDetail.memId }</td>
					</tr>
					<tr>
						<td class="top">이름</td>
						<td class="info" colspan="5">${memberDetail.memName }</td>
					</tr>
					<tr>
						<td class="top">성별</td>
						<td class="info" colspan="5">${memberDetail.memGender }</td>
					</tr>
					<tr>
						<td class="top">가입일</td>
						<td class="info" colspan="5">${memberDetail.regDate }</td>
					</tr>
					<tr>
						<td class="top">소개글</td>
						<td class="info" colspan="5">${memberDetail.memIntro }</td>
					</tr>
			</table>
		</div>
		<div class="button">
			<input type="button" value="뒤로가기" onclick="location.href='memberList.do'"> 
			<input type="button" value="수정" onclick="location.href='memberToUpdate.do?memId=${memberDetail.memId}';"> 
			<input type="button" value="삭제" onclick="location.href='deleteMember.do?memId=${memberDetail.memId}';">
		</div>
	</div>
	</form>
</body>
</html>