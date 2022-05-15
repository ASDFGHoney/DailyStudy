<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>jsp 예제 request2.jsp</title>
  </head>
  <body>
    <% request.setCharacterEncoding("euc-kr"); %> <% String studentNum =
    request.getParameter("studentNum"); String[] majors =
    request.getParameterValues("major"); %>

    <h2>학생 정보 입력 결과</h2>

    학번: <%= studentNum%><br />
    전공: <% if(majors == null){ out.println("전공없음."); }else{ for(int
    i=0;i<majors.length;i++){ out.println(majors[i] +" "); } } %>
    <h2>요청 정보</h2>
    요청방식: <%= request.getMethod()%><br />
    요청 url : <%= request.getRequestURL()%><br />
    요청 uri : <%= request.getRequestURI()%><br />
    클라이언트 주소 : <%= request.getRemoteAddr()%><br />
    클라이언트 호스트 : <%= request.getRemoteHost()%><br />
    프로토콜 방식 : <%= request.getProtocol()%><br />
    서버이름 : <%= request.getServerName()%><br />
    서버 포트 번호 : <%= request.getServerPort()%><br />
  </body>
</html>
