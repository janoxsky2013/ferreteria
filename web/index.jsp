<%@page import="java.util.ArrayList"%>
<%@page import="entidad.producto"%>
<%@page import="entidad.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("numero_hojas") == null) {
%>
<jsp:include page="productoServlet?pagina=0" flush="true"/>
<%        
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12 text-center titulo">
                        Lista de Productos
                        <a href="crearProducto.jsp" class="btn btn-info">Nuevo</a>
                    </div>
                    <%@ include file="modulo/listar.jsp" %>
                    <%@ include file="modulo/paginacion.jsp" %>
                    <script>
                        $(document).ready(function () {
                            $('[data-toggle="tooltip"]').tooltip();
                        });
                    </script>
                </div>
            </div>
            <%@ include file="modulo/contacto.jsp" %>
    </body>
</html>