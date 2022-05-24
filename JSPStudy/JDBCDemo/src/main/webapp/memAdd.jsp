<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>
  <body>
    <h3>member add</h3>
    <hr />

    <form action="memAdd2.jsp" method="post">
      namee : <input type="text" id="name" name="name" /><br />
      sex : <input type="text" id="sex" name="sex" /><br />
      hobby : <input type="text" id="hobby" name="hobby" /><br />
      phone_num : <input type="text" id="phone_num" name="phone_num" /><br />
      <input type="submit" value="insert" /><br/>
    </form>
    <form action="memprint.jsp" method="get">
      <input type="submit" value="All" />
    </form>
  </body>
</html>
