<%@page import="si.um.feri.ost.Oseba"%>
<%@page import="si.um.feri.ost.OsebaDao"%>
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
			
			if (request.getParameter("dodaj")!=null) {
				Oseba o=new Oseba();
				o.setIme(request.getParameter("ime"));
				o.setPriimek(request.getParameter("priimek"));
				o.setEmail(request.getParameter("email"));

				if (request.getParameter("spremeni")!=null) 
					od.spremeni(o);
					else od.shrani(o);
				
				response.sendRedirect("index.jsp");
			}
			
			Oseba obstojeca=od.najdi(request.getParameter("spremeni"));
			
		%>

		<form action="dodaj.jsp" method="post">
			<table>
				<tr>
					<td>Ime:</td>
					<td><input type="text" name="ime" <% if (obstojeca!=null) { %> value="<%=obstojeca.getIme()%>" <% } %> /></td>
				</tr>
				<tr>
					<td>Priimek:</td>
					<td><input type="text" name="priimek" <% if (obstojeca!=null) { %> value="<%=obstojeca.getPriimek()%>" <% } %> /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" <% if (obstojeca!=null) { %> value="<%=obstojeca.getEmail()%>" readonly <% } %> /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="dodaj" value="V redu" />
					<% if (obstojeca!=null) { %> 
					<input type="hidden" name="spremeni" value="<%=obstojeca.getEmail()%>" />
					<% } %>
					</td>
				</tr>
			</table>
		</form>

	</body>
</html>