<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="controller.*" %>
<%@ page import ="model.*" %>

<%@ page import ="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hoja de Ruta</title>
</head>
<body>
<form action="HojaRuta">

Por favor seleccione el ID del repartidor para confeccionarle la Hoja de Ruta

<br><br>

<% List<Repartidor> repartidores = (List<Repartidor>)SistemaLogistica.getInstancia().getallRep(); %>
<%for (Repartidor rep : repartidores){%>
		<%out.println("Id Repartidor:   " + rep.getId() + "---Nombre Repartidor:  " +rep.getNombre()+ "---Capaidad Camioneta:  " +rep.getCamioneta().getCapacidad()); %>
		<br>  
		<%}%>
		<br>

<br><br>
	<% List<Repartidor> repartidores1 = (List<Repartidor>)SistemaLogistica.getInstancia().getallRep(); %>
	<select name="Repartidores">
	
		<%for (Repartidor rep : repartidores1){%>
			<option value=<%=rep.getId()%>><%=rep.getId()%></option>
		<%} %>
		
		</select>
		<br>
		<br>
		<br>
		Por favor seleccione el ID de la OrdenDeExpedicion para confeccionarle la Hoja de Ruta al Repartidor.
<br><br>

<% List<OrdenExpedicion> ordenes = (List<OrdenExpedicion>)SistemaLogistica.getInstancia().getPendientes(); %>
<%for (OrdenExpedicion rep : ordenes){%>
		<%out.println("DNI:   " + rep.getCliente().getClienteId() + "---Direccion Cliente:  " +rep.getCliente().getDireccion()+ "---Producto:  " +rep.getDetalle().getProducto().getNombre() + "----Cantidad " + rep.getDetalle().getCantidad()); %>
		<br>  
		<%}%>
		<br>
		
	<% 	 List<OrdenExpedicion> ordenes1 = (List<OrdenExpedicion>)SistemaLogistica.getInstancia().getPendientes(); %>
	<select name="OrdenExpedicion">
		<%for (OrdenExpedicion or : ordenes1){%>
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