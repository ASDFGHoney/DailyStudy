<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> <title>Insert title here</title> </head>
<body>

	<%	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hwdb","root","open9711@@");
	Statement stat = connect.createStatement();
	String sql_2 = "select * from websites";
	ResultSet rs = stat.executeQuery(sql_2);
	
	
	out.println("ID"+" "+"Name "+" "+"URL <br>");
	while (rs.next()) {
		
		out.println(rs.getInt("id")+"  "+rs.getString("name")+"  "+rs.getString("url")+" <br>");
	
	} stat.close();
	connect.close(); %>

</body> 
</html>