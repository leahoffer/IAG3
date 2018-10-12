<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="controller.*" %>
<%@ page import ="model.*" %>
<%@ page import ="servlet.*" %>

<%@ page import ="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mensaje de actualiación</title>
</head>
<body>
<form action="Estados">
<% 
	Integer clienteId = LoginUtils.getInstancia().getClienteBySession(request.getRequestedSessionId());
%>
<br><br>
Se envió correctamente el estado de los pedidos del cliente:
<br>
<br>
<br>
	<% List<String> prueba1 = SistemaLogistica.getInstancia().EnviarEstadoPedido(clienteId); %>
	
		<%for (String rep : prueba1){%>
			<%out.println(rep);  %>
			<%out.println("\n"); %>
			<%out.println("\n"); %>
		<%} %>
		
		

	
<br>
<br>
<br>
<input type="submit" value="Volver">


</form>

</body>
</html>