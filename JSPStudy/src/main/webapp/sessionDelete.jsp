<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Home > 세션 삭제 후 로그아웃<hr>
<%
    long last_time = session.getLastAccessedTime();
    long start_time = session.getCreationTime();
    long keping_time = ((last_time - start_time)/1000);

    out.println("* 로그인 접속 시간 : "+ keping_time + "초<hr>");
    out.println("~ 로그아웃하였습니다. ~");
    session.invalidate();

  %>
</body>
</html>