<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> <title>Insert title here</title> </head>
<body>

	<%	
  String name = request.getParameter("name");
  String sex = request.getParameter("sex");
  String hobby = request.getParameter("hobby");
  String phone_num = request.getParameter("phone_num");

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hwdb","root","open9711@@");
	String sql_2 = "insert into members values (?,?,?,?)";
	PreparedStatement pstmt = connect.prepareStatement(sql_2);
	pstmt.setString(1,name);
	pstmt.setString(2,sex);
	pstmt.setString(3,hobby);
	pstmt.setString(4,phone_num);
	
	pstmt.executeUpdate();
	
	pstmt.close();
	connect.close();
	
	response.sendRedirect("memAdd.jsp");
	%>

</body> 
</html>