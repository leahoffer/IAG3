<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="controller.*" %>
<%@ page import ="model.*" %>

<%@ page import ="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de hojas de Ruta</title>
</head>
<body>
<form action="ControladorAdmin">


<br><br>

<% List<HojaRuta> hojas = (List<HojaRuta>)SistemaLogistica.getInstancia().getallHojas(); %>


<%for (HojaRuta rep : hojas){%>

	<%out.println("************************");%>
	<br>
	<% out.println("Estado:  " + rep.getPedidos().getEstado()); %>
	<br>
	<%out.println("Id Repartidor:   " + rep.getRepartidor().getId() + "---Nombre Repartidor:  " +rep.getRepartidor().getNombre());%>
	<br>
	<%out.println("Id Hoja De Ruta:   "   + rep.getId() + "----Fecha:  " + rep.getFecha()+ "----DNI Cliente:   "  + rep.getPedidos().getCliente().getClienteId() + "----Direccion Cliente:   " +rep.getPedidos().getCliente().getDireccion()); %>
		<br> 
		<%out.println("************************");%> 
		<%}%>
		<br>

	
<br>
<br>
<br>
<input type="submit" name= "VolverAtras" value="Volver">


</form>

</body>
</html>