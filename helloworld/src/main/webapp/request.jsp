<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>JSP 예제</title>
  </head>
  <body>
    <% request.setCharacterEncoding("euc-kr"); %> 
    <% 
    String name = request.getParameter("name"); 
    String studentNum = request.getParameter("studentNum"); 
    String sex = request.getParameter("sex"); 
    String country = request.getParameter("country"); 
    if(sex.equalsIgnoreCase("man")){ sex ="남자"; }
    else{ sex = "여자"; } 
    %>

    <h2>학생 정보 입력 결과</h2>

    성명: <%= name%><br />
    학번: <%= studentNum%><br />
    성별: <%= sex%><br />
    국적: <%= country%><br />
  </body>
</html>
