<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="controller.*" %>
<%@ page import ="model.*" %>

<%@ page import ="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Elaborados</title>
</head>
<body>
<form action="HojaRuta">
	<% List<Repartidor> repartidores = (List<Repartidor>)SistemaLogistica.getInstancia().getallRep(); %>
	<select name="Repartidores">
	
		<%for (Repartidor rep : repartidores){%>
			<option value=<%=rep.getId()%>><%=rep.getId()%></option>
		<%} %>
		
		</select>
		<br>
		<br>
		<br>
	<% 	 List<OrdenExpedicion> ordenes = (List<OrdenExpedicion>)SistemaLogistica.getInstancia().getall(); %>
	<select name="OrdenExpedicion">
		<%for (OrdenExpedicion or : ordenes){%>
			<option value=<%=or.getNro()%>><%=or.getNro()%></option>
		<%} %>
		
	</select>
	
<br>
<br>
<br>
<input type="submit" value="Seleccionar">


</form>

</body>
</html>