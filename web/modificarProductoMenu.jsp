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
        <script src="./js/funciones.js"></script>
        <script src="./js/menu.js"></script>
        <%
            producto p = (producto) session.getAttribute("unproducto");
        %>
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
                <form action="productoServlet" method="POST" id='form_modificar' enctype=""> 
                    <input type="Hidden" name="producto" value="<%= p.getId_producto()%>">
                    <input type="Hidden" name="file_imagen" value="<%= p.getImagen()%>">
                    <table class="normal2" summary="Tabla genérica">
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">
                        <H1>
                            <%
                                out.println(p.getNombre());
                            %>
                        </H1>
                        </th>
                        </tr>
                    </table> 
                    <h1 class="titulo2">Nuevos Datos</h1>
                    <table class="normal" summary="Tabla genérica">
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col"><input type="text" id='nombre' name="nombre" value="<%= p.getNombre()%>" /></th>
                        </tr>
                        <tr>
                            <th scope="col">Descripción</th>
                            <th scope="col"><textarea rows="4" id='descripcion' cols="50" name="descripcion"><%= p.getDescripcion()%></textarea></th>
                        </tr>
                        <tr>
                            <th scope="col">Precio</th>
                            <th scope="col"><input type="text" id='precio' name="precio" value="<%= p.getPrecio()%>" /></th>
                        </tr>
                        <tr>
                            <th scope="col">Imagen:</th>
                            <th scope="col">
                                <select id="opcion">
                                    <option value="1">Actual</option>
                                    <option value="2">Nueva</option>
                                    <option value="3">Elegir</option>
                                </select>
                            </th>
                        </tr>
                        <tr id='imagen_actual'>
                            <th scope="col">Imagen actual</th>
                            <th scope="col"><IMG class='imagenlistar' SRC='./imagen/producto/<%= p.getImagen()%>' ALT='producto'></th>
                        </tr>
                        <tr id='imagen_nueva'>
                            <th scope="col">Imagen nueva</th>
                            <th scope="col"><input id='input_imagen' type="file" name="imagen"/></th>
                        </tr>
                        <tr id='imagen_elegir'>
                            <th scope="col">Elegir imagen</th>
                            <th scope="col">
                        <div class="global">
                            <div class="servidor_imagen">
                                <%@ include file="modulo/imagen.jsp" %>
                            </div>
                        </div>
                        </th>
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