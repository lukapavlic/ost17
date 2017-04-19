<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Vnos podatkov</title>
	</head>
	
	<body>
		<h1>Vnesite podatke</h1>
		
		<a href="seznam.jsp">Domov</a>
		
		<form action="seznam.jsp" method="post">
			Ime: <input type="text" name="ime" /> <br/>
			Priimek: <input type="text" name="priimek" /> <br/>
			<input type="submit" name="vnos" value="Vnos">
		</form>

	</body>
	
</html>