<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 생성</title>
</head>
<body>
  Home > 로그인 접속 완료
  <hr>
  <%
    String u_id = request.getParameter("id");
    String u_pw = request.getParameter("passwd");

    session.setAttribute("memberId", u_id);
    session.setAttribute("memberPw", u_pw);
    session.setMaxInactiveInterval(60*5);

    out.println("[ "+u_id+"]님 환영합니다. <hr>");
    out.println("<form name='loginForm' action='sessionDelete.jsp' method='post'>");
    out.println("<input type='submit' value='Logout'>");
    out.println("</form>");
  %>
</body>
</html>