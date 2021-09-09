<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data</title>
<style>
	.p{
		padding : 10px;
		margin : 10px;
	}
	table, th, td {
  border: 1px solid black;
  border-radius: 10px;
   table-layout: fixed;
}
th, td {
  background-color: #96D4D4;
  text-align:center;
}
}
</style>
</head>
<body style="background : #F1F774 ; margin-top : 50px ; font-size : 20px ">
	<%@ page import="java.sql.*" %>
    <%@ page import="com.apisero.*" %>
    <center><h1 style="color:red">Record present in Employee Table : </h1></center>
    <%
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = CreateConnection.getJDBCConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee");
		while(rs.next())
		{
			%>
				<table width="70%"  margin="10px" style="margin-left : auto ; margin-right : auto" >
					<tr>
						<td><p><%=rs.getString(1)%></p></td>
						<td><p><%=rs.getString(2)%></p></td>
						<td><p><%=rs.getString(3)%></p></td>
						<td><p><%=rs.getString(4)%></p></td>
				    </tr>
				</table>
				
			
			 <%
		}
		rs.close();
		st.close();
		con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	%>
</body>
</html>