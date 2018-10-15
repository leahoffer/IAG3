<%@ page import="servlet.LoginUtils, java.util.*, controller.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGISTICA</title>
</head>
<body>
<h3><center> LOGISTICA GRUPO 3</h3></center>

<br>



<fieldset> 
<a href=ControladorAdmin?action=ArmarRuta>Armar Hoja de Ruta</a><br></fieldset>
<br>
<fieldset>
<a href=ControladorAdmin?action=Estados>Actualizar estado pedidos</a><br></fieldset>
<br>
<fieldset>
<a href=ControladorAdmin?action=Listar>Listar Hojas de Ruta</a><br></fieldset>
<br>
<fieldset>
<a href=ControladorAdmin?action=Entrega>Entregar Pedidos</a><br>
</fieldset>
<br>
<br>

<fieldset>
<center></a><a href=ControladorAdmin?action=Salir>Salir</a><br></center></fieldset>





<hr>

</body>
</html>
