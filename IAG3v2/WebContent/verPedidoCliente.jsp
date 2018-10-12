<%@page import="model.OrdenExpedicion"%>
<%@page import="model.ClientePedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="controller.*" %>
<%@ page import ="model.*" %>
<%@ page import ="java.util.List" %>

<%@ page import ="servlet.LoginUtils" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos</title>
</head>
<body>
<form action="Estados">
 
<% List<OrdenExpedicion> ordenes = (List<OrdenExpedicion>)SistemaLogistica.getInstancia().getall(); %>
<%for (OrdenExpedicion rep : ordenes){%>
		<%out.println("DNI:   " + rep.getCliente().getClienteId() + "---Nombre Cliente:  " +rep.getCliente().getNombre()+ "---Producto:  " +rep.getDetalle().getProducto().getNombre()); %>
		<br>  
		<%}%>
		<br>
		
		
	Por favor Seleccionar el ID para enviar el ESTADO DEL PEDIDO:
	
	<br>	
		
<select name="Ordenes">

	<%for (OrdenExpedicion rep : ordenes){%>
		
		<option value=<%=rep.getNro()%>><%=rep.getCliente().getDni()%></option>
		
	<%}%>

	</select>
	
	

<br>
<input type="submit" value="Seleccionar">




</form>

</body>
</html>
