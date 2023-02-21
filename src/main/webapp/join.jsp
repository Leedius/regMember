<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

.reg_wrap .title{
	text-align: center;
	padding-bottom: 20px;
}

table{
	margin: 100px auto;
	text-align: left;
	background-color: #f3f5f6;
	border-radius: 10px;
	padding-top: 70px;
	padding-bottom: 90px;
	padding-left: 100px;
	padding-right: 100px;
}

.input_info{
	padding-top: 5px;
	padding-bottom: 5px;
}

.intro{
	vertical-align: top;
}

.reg_wrap{
	text-align: center;
}

.wrapper_button{
	text-align: center;
	padding-top: 10px;
}

.wrapper_button > input {
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

</style>
</head>
<body>
<div class="reg_wrap">
	<form action="regMember.do" method="post">
	<table>
		<tr>
			<td colspan="2">
				<div>
				<h2 class="title">회원 등록 페이지</h2>
				</div>
			</td>
		</tr>
		<tr class="input_info">
			<td>아이디</td>
			<td><input type="text" name="memId" required></td>
		</tr>
		<tr class="input_info">
			<td><span>비번</span></td>
			<td><input type="password" name="memPw" required></td>
		</tr>
		<tr class="input_info">
			<td>이름</td>
			<td><input type="text" name="memName" required></td>
		</tr>
		<tr class="input_info">
			<td>가입일</td>
			<td><input type="date" name="regDate" required></td>
		</tr>
		<tr class="input_info">
			<td>성별</td>
			<td>
				<input type="radio" name="memGender" value="남" checked>남자
				<input type="radio" name="memGender" value="여">여자
			</td>
		</tr>
		<tr class="input_info">
			<td class="intro">자기소개</td>
			<td><textarea name="memIntro" rows="5" cols="30" style="resize: none"></textarea></td>
		</tr>
		<tr>
			<td class="wrapper_button" colspan="2">
				<input type="submit" value="등록">
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>