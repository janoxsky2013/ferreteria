<%@page import="java.util.ArrayList"%>
<%@page import="entidad.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Producto</title>
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
                Modificar Producto
            </div> 
            <div class="tabla">
                <form action="productoServlet" method="POST" enctype=""> 
                    <table class="normal2" summary="Tabla genérica">
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">
                                <select class="region" name="producto">
                                    <%
                                        if (session.getAttribute("listaproducto") != null) {
                                            ArrayList<producto> lista_producto = (ArrayList<producto>) session.getAttribute("listaproducto");
                                            for (int x = 0; x < lista_producto.size(); x++) {
                                                out.println("<option value='" + lista_producto.get(x).getId_producto() + "'>" + lista_producto.get(x).getNombre() + "</option>");
                                            }
                                        }
                                    %>
                                </select>
                            </th>
                        </tr>
                    </table> 
                    <h1 class="titulo2">Nuevos Datos</h1>
                    <table class="normal" summary="Tabla genérica">
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col"><input type="text" name="nombre" /></th>
                        </tr>
                        <tr>
                            <th scope="col">Descripción</th>
                            <th scope="col"><textarea rows="4" cols="50" name="descripcion"></textarea></th>
                        </tr>
                        <tr>
                            <th scope="col">Precio</th>
                            <th scope="col"><input type="text" name="precio" /></th>
                        </tr>
                        <tr>
                            <th scope="col">Imagen</th>
                            <th scope="col"><input type="file" name="imagen" /></th>
                        </tr>
                        <tr>
                            <th scope="col"><input class="input_boton" type="submit" name="submit" value="modificar" /></th>
                            <th scope="col"><a class="submit2" href="index.jsp">Volver</a></th>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <%@ include file="modulo/contacto.jsp" %>
    </body>
</html>