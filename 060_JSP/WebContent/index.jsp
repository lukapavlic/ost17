<%@page import="java.net.URLEncoder"%>
<%@page import="si.um.feri.ost.OsebaDao"%>
<%@page import="si.um.feri.ost.Oseba"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Osebe</title>
	</head>
	
	<body>
		<h1>Osebe</h1>
		<a href="index.jsp">Vse osebe</a> | <a href="dodaj.jsp">Dodajanje oseb</a> 
		<hr/>
		
		<%
			OsebaDao od=(OsebaDao)session.getAttribute("osebe");
			if (od==null) {
				od=new OsebaDao();
				session.setAttribute("osebe", od);
			}
			if (request.getParameter("izbrisi")!=null) {
				od.izbrisi(request.getParameter("izbrisi"));
			}
		%>

		<table>
			<tr>
				<th>Ime</th>
				<th>Priimek</th>
				<th>Email</th>
				<th>Čas vpisa</th>
			</tr>
			<% for (Oseba o : od.vrniVse()) { %>
			
				<tr>
					<td><%=o.getIme()%></td>
					<td><%=o.getPriimek()%></td>
					<td><%=o.getEmail()%></td>
					<td><%=o.getDatumVpisaString()%></td>
					
					<td>[ <a href="dodaj.jsp?spremeni=<%=URLEncoder.encode(o.getEmail())%>">Spremeni</a> ]
						[ <a href="index.jsp?izbrisi=<%=URLEncoder.encode(o.getEmail())%>">Izbriši</a> ]
					</td>
				</tr>
			
			<% } %>
		</table>

	</body>
</html>