package controlador;

import entidad.producto;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.productoM;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "crearProductoServlets", urlPatterns = {"/crearProductoServlets"})
public class crearProductoServlets extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet crearProductoServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet crearProductoServlets at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String ruta_imagen() {
        String ruta = getServletContext().getRealPath("/");
        String[] parte = ruta.split("build");
        String rutaProducto = parte[0] + "web\\imagen\\producto\\";
        return rutaProducto;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession lista = request.getSession();
        try {
            producto producto_crear = new producto();
            PrintWriter out = response.getWriter();
            String rutaProducto = ruta_imagen();

            /*FileItemFactory es una interfaz para crear FileItem*/
            FileItemFactory file_factory = new DiskFileItemFactory();

            /*ServletFileUpload esta clase convierte los input file a FileItem*/
            ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
            /*sacando los FileItem del ServletFileUpload en una lista */
            List items = servlet_up.parseRequest(request);

            for (int i = 0; i < items.size(); i++) {
                /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
                FileItem item = (FileItem) items.get(i);
                /*item.isFormField() false=input file; true=text field*/
                if (!item.isFormField()) {
                    /*cual sera la ruta al archivo en el servidor*/
                    File archivo_server = new File(rutaProducto + item.getName());
                    /*y lo escribimos en el servido*/
                    item.write(archivo_server);
//                    out.print("Nombre --> " + item.getName());
//                    out.print("<br> Tipo --> " + item.getContentType());
//                    out.print("<br> tamaño --> " + (item.getSize() / 1240) + "KB");
//                    out.print("<br>");
                    producto_crear.setImagen(item.getName());
                } else {
                    switch (item.getFieldName()) {
                        case "nombre":
                            producto_crear.setNombre(item.getString());
                            break;
                        case "descripcion":
                            producto_crear.setDescripcion(item.getString());
                            break;
                        case "precio":
                            producto_crear.setPrecio(Integer.parseInt(item.getString()));
                            break;
                        case "submit":
                            break;
                        default:
                            throw new AssertionError();
                    }
//                    String campo = item.getFieldName();
//                    //producto_crear.setNombre(campo);
//                    out.print("<br>");
//                    out.print(campo);
//                    out.print("<br>");
                }
            }
                    boolean insertar;

                    try {
                        insertar = new productoM().insertarProducto(producto_crear);

                        if (insertar == true) {
                            out.println("<script>");
                            out.println("alert(\"Producto insertado correctamente!\");");
                            out.println("window.location=\"productoServlet?pagina=0\";");
                            out.println("</script>");
                        } else {
                            out.println("<script>");
                            out.println("alert(\"Error al insertar producto!\");");
                            out.println("window.location=\"index.jsp\";");
                            out.println("</script>");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (Exception ex) {
            Logger.getLogger(crearProductoServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
