<%@page import="java.util.ArrayList"%>
<%@page import="entidad.producto"%>
<%@page import="entidad.producto"%>
<%
    if (session.getAttribute("listaproducto") != null) {
        ArrayList<producto> lista_producto = (ArrayList<producto>) session.getAttribute("listaproducto");
        for (int x = 0; x < lista_producto.size(); x++) {
            out.println("<div class='col-sm-3 tabla3'>");
            out.println("<IMG class='imagenlistar2 circular' SRC='./imagen/producto/" + lista_producto.get(x).getImagen() + "' ALT='producto'>");
            out.println("</div>");
        }
        out.println("</div>");
    }
%>