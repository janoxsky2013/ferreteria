<%@page import="java.util.ArrayList"%>
<%@page import="entidad.producto"%>
<%
    if (session.getAttribute("listaproducto") != null) {
        ArrayList<producto> lista_producto = (ArrayList<producto>) session.getAttribute("listaproducto");
        for (int x = 0; x < lista_producto.size(); x++) {
            out.println("<div class='col-sm-3 tabla3'>");
            out.println("<IMG class='imagenlistar2 circular' SRC='./imagen/producto/" + lista_producto.get(x).getImagen() + "' ALT='producto'>");
            out.println("<a href='#' data-toggle='tooltip' data-placement='top' title='" + lista_producto.get(x).getDescripcion() + "'><h3 class='titulo2'>" + lista_producto.get(x).getNombre() + "</h3></a>");
            out.println("<h3 class=''>Precio: $" + lista_producto.get(x).getPrecio() + "</h3>");
            out.println("<a class='btn btn-warning' href='productoServlet?producto_modificar=" + lista_producto.get(x).getId_producto() + "'>Modificar</a>");
            out.println("<a class='btn btn-danger' href='productoServlet?producto_eliminar=" + lista_producto.get(x).getId_producto() + "'>Eliminar</a>");
            out.println("</div>");
        }
        out.println("</div>");
    }
%>