<%
    if (session.getAttribute("numero_hojas") != null) {
        int numero_hoja = (Integer) session.getAttribute("numero_hojas");
        out.println("<div class='row'>");
        for (int x = 0; x < numero_hoja; x++) {
            out.println("<div class='col-sm-1'>");
            out.println("<a class='pagina borde' href='productoServlet?pagina=" + x + "'>" + (x + 1) + "</a>");
            out.println("</div>");
        }
        out.println("</div>");
    }
%>