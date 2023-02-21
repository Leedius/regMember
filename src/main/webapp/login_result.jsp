<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인이 성공하면 alert으로 '로그인 성공' 이라는 메시지를 띄우고 -->
<!-- 회원 목록 페이지로 이동 -->
<!-- 로그인이 실패하면 -->
<!-- 로그인 실패. 아이디 비밀번호를 확인하세요.를 띄운 후, -->
<!-- 다시 로그인을 할 수 있는 페이지로 이동 -->
<c:if test="${result = 1 }">
	<script type="text/javascript">
	alert('로그인 성공!');
	location.href='memberList.do';
	</script>
</c:if>
<c:if test="${result = 0 }">
	<script type="text/javascript">
	alert('로그인 실패\n비밀번호를 확인하세요');
	location.href='login.jsp';
	</script>
</c:if>
<c:if test="${result = -1 }">
	<script type="text/javascript">
		alert('로그인 실패\n아이디가 없습니다.');
		location.href='login.jsp';
	</script>
</c:if>
</body>
</html>