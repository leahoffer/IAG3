<%@page import="enummeration.EstadoOE"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="controller.*" %>
<%@ page import ="model.*" %>

<%@ page import ="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos</title>
</head>
<body>
<form action="ActualizarEstado">

Por favor seleccione el DNI del cliente que hizo la entrega:

<br><br>

<% List<OrdenExpedicion> ordenes = (List<OrdenExpedicion>)SistemaLogistica.getInstancia().getall(); %>
 
<%for (OrdenExpedicion rep : ordenes){%>
<%if(rep.getEstado() == EstadoOE.Despachado){ %>
<%out.println("************************");%>
<br>
		<%out.println("DNI:   " + rep.getCliente().getClienteId() + "---Nombre Cliente:  " +rep.getCliente().getNombre()+ "---Direccion:  " +rep.getCliente().getDireccion() + "---Producto:  " +rep.getDetalle().getProducto().getNombre()); %>
		<br>  
		
		<%}}%>
		<br>
		<%out.println("No hay mas pedidos despachados..."); %>

<br><br>
<select name="pedidoscli">

	<%for (OrdenExpedicion rep : ordenes){%>
	
	<%if(rep.getEstado() == EstadoOE.Despachado){ %>
		
		<option value=<%=rep.getCliente().getClienteId()%>><%=rep.getCliente().getDni()%></option>
		
	<%}}%>

	</select>
	
<br>
<br>
<br>
<input type="submit" name= "Select" value="Seleccionar">


</form>

</body>
</html>