<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="controller.*" %>
<%@ page import ="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seguimiento</title>
</head>
<body>
<form action="Seguimiento">

	<%	List<String> prueba1 = SistemaLogistica.getInstancia().EnviarEstadoPedido(1); %>
	

		<%for(String la : prueba1) {%>
		<% if(la!=null) %>
		<%out.println(la); %>
			
		<%} %>
	

<br>
<a href=Seguimiento?action=Salir>Salir</a><br>




</form>

</body>
</html>