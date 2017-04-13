<%@page import="java.util.ArrayList"%>
<%@page import="entidad.producto"%>
<%@page import="entidad.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Producto</title>
        <link rel="StyleSheet" media="screen" type="text/css" href="./css/newcss.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="./js/menu.js"></script>
    </head>
    <body>
        <div id="caja_superior" class="principal circular">
            <%@ include file="modulo/logo.jsp" %>
            <%@ include file="modulo/menu.jsp" %>
        </div>
        <div class="principal circular">  
            <div class="titulo">
                Buscar Producto
            </div> 
            <div class="tabla">
                <%@ include file="modulo/buscar.jsp" %>
            </div>
            <div class="titulo">
                Resultado
            </div> 
            <div class="">
                    <%@ include file="modulo/resultado.jsp" %>
                    <a class="submit" href="index.jsp">Volver</a>
                </div>
        </div>
        <%@ include file="modulo/contacto.jsp" %>
    </body>
</html>

