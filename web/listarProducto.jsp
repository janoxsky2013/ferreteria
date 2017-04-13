<%@page import="java.util.ArrayList"%>
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
            <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 text-center titulo">
                    Lista de Productos
                    <a href="crearProducto.jsp" class="btn btn-info">Nuevo</a>
                </div> 
                <div class="">
                    <table class="normal3" summary="Tabla genérica">
                        <tr class="color1">
                            <th scope="col">Eliminar</th>
                            <th scope="col">Modificar</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Imagen</th>           
                        </tr>
                        
                        <%
                            if (session.getAttribute("listaproducto") != null) {
                                ArrayList<producto> lista_producto = (ArrayList<producto>) session.getAttribute("listaproducto");
                                for (int x = 0; x < lista_producto.size(); x++) {
                                    out.println("<tr class='color2'>");
                                    out.println("<th scope='col'><a class='btn btn-danger' href='productoServlet?producto_eliminar=" + lista_producto.get(x).getId_producto() + "'>Eliminar</a></th>");
                                    out.println("<th scope='col'><a class='btn btn-warning' href='productoServlet?producto_modificar=" + lista_producto.get(x).getId_producto() + "'>Modificar</a></th>");
                                    out.println("<th scope='col'>" + lista_producto.get(x).getNombre() + "</th>");
                                    out.println("<th scope='col'>" + lista_producto.get(x).getDescripcion() + "</th>");
                                    out.println("<th scope='col'>" + lista_producto.get(x).getPrecio() + "</th>");
                                    out.println("<th scope='col'><IMG class='imagenlistar' SRC='./imagen/producto/"+ lista_producto.get(x).getImagen() + "' ALT='producto'></th>");
                                    out.println("</tr>");
                                }
                            }
                        %>              
                    </table> 
                    <a class="submit" href="index.jsp">Volver</a>
                </div>
            </div>
        </div>
        </div>
        <%@ include file="modulo/contacto.jsp" %>
    </body>
</html>

