<%@page import="si.um.feri.ost.OsebaDao"%>
<%@page import="si.um.feri.ost.Oseba"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Vnos podatkov</title>
	</head>
	
	<body>
		<h1>Seznam podatkov</h1>
		
		<a href="vnos.jsp">Dodajanje</a>
			
		<%
			OsebaDao od=new OsebaDao();
			
			if (request.getParameter("izbrisi")!=null) {
				int id=Integer.parseInt(request.getParameter("izbrisi"));
				od.delete(id); 
			}
			
			if (request.getParameter("vnos")!=null) {
				od.insert(new Oseba(request.getParameter("ime"),request.getParameter("priimek"),0));
			}
		
		%>
			
		<ul>
			<% for (Oseba o :od.select()) { %>
				<li>
					<%=o%>
					<a href="seznam.jsp?izbrisi=<%=o.getId()%>">briši</a>
				</li>
			<% } %>
		</ul>
	
	</body>
	
</html>