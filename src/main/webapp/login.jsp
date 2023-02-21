<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function checkValue()
{
    inputForm = eval("document.loginInfo");
    if(!inputForm.memId.value)
    {
        alert("아이디를 입력하세요");    
        inputForm.memId.focus();
        return false;
    }
    if(!inputForm.memPw.value)
    {
        alert("비밀번호를 입력하세요");    
        inputForm.memPw.focus();
        return false;
    }
}
</script>
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.title {
	text-align: center;
	padding: 20px 0;
}

.title > h2 {
	color:#99ff00;
}

.wrapper_box {
	text-align: center;
}

.input_box {
	border: none;
	border-bottom: 1px solid silver;
	height: 30px;
}

table {
	margin: 100px auto;
	background-color: #f3f5f6;
	border-radius: 10px;
	text-align: left;
	padding-top: 70px;
	padding-bottom: 100px;
	padding-left: 100px;
	padding-right: 100px;
}

.wrapper_button {
	text-align: center;
	padding-top: 10px;
}


.wrapper_button .login > input{
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

.login > input:hover{
	text-decoration-line: underline;
}

.wrapper_button .join > a > input{
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

a > input:hover {
	text-decoration-line: underline;
}

.id_wrap {
	padding: 10px 0;
}

.id_text {
	padding-right: 15px;
}

.pw_wrap {
	padding: 10px 0;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td>
			<div class="title">
				<h2>첫 페이지(로그인)</h2>
			</div>
			<form action="login.do" name="loginInfo" method="post" onsubmit="return checkValue()">
					<div class="wrapper_box">
						<div class="id_wrap">
							<span> 
								<input class="input_box" type="text" name="memId" placeholder="ID">
							</span>
						</div>
						<div class="pw_wrap">
							<span> 
								<input class="input_box" type="password" name="memPw" placeholder="PASSWORD">
							</span>
						</div>
					</div>
				<div class="wrapper_button">
					<span class="login"><input type="submit" value="로그인"></span>
					<span class="join"><a href="join.jsp"><input type="button" value="회원가입"></a></span>
				</div>
			</form>
		</td>
		</tr>
	</table>
</body>
</html>