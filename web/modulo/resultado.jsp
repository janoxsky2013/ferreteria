<%@page import="java.util.ArrayList"%>
<%@page import="entidad.producto"%>
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
        if (session.getAttribute("listaproducto_buscar") != null) {
            ArrayList<producto> lista_producto = (ArrayList<producto>) session.getAttribute("listaproducto_buscar");
            for (int x = 0; x < lista_producto.size(); x++) {
                out.println("<tr class='color2'>");
                out.println("<th scope='col'><a class='btn btn-danger' href='productoServlet?producto_eliminar=" + lista_producto.get(x).getId_producto() + "'>Eliminar</a></th>");
                out.println("<th scope='col'><a class='btn btn-warning' href='productoServlet?producto_modificar=" + lista_producto.get(x).getId_producto() + "'>Modificar</a></th>");
                out.println("<th scope='col'>" + lista_producto.get(x).getNombre() + "</th>");
                out.println("<th scope='col'>" + lista_producto.get(x).getDescripcion() + "</th>");
                out.println("<th scope='col'>" + lista_producto.get(x).getPrecio() + "</th>");
                out.println("<th scope='col'>" + lista_producto.get(x).getImagen() + "</th>");
                out.println("</tr>");
            }
        }
    %>              
</table> 
