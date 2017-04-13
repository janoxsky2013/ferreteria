package controlador;

import entidad.producto;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.productoM;

@MultipartConfig
@WebServlet(name = "productoServlet", urlPatterns = {"/productoServlet"})
public class productoServlet extends HttpServlet {

    public double numero_productos_mostrar(){
        return 12.0; //numero de productos a mostrar por hoja
    }
    
    public String ruta_imagen() {
        String ruta = getServletContext().getRealPath("/");
        String[] parte = ruta.split("build");
        String rutaProducto = parte[0] + "web\\imagen\\producto\\";
        return rutaProducto;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //listar productos en sessiones y redirigir a pagina correspondiente
        HttpSession lista = request.getSession();
        String get = request.getParameter("lista");
        String get2 = request.getParameter("producto_modificar");
        String get3 = request.getParameter("producto_eliminar");
        String get4 = request.getParameter("pagina");
        if (get != null) {
            ArrayList<producto> p;
            try {      
                p = new productoM().listarProducto();
                lista.setAttribute("listaproducto", p);
                switch (get) {
                    case "producto":
                        int numero = new productoM().contarProducto();
                        double num_prod = numero_productos_mostrar();
                        int num_pagina = (int) Math.ceil(numero/num_prod);
                        lista.setAttribute("numero_hojas", num_pagina);
                        response.sendRedirect("listarProducto.jsp");
                        break;
                    case "producto_index":
                        int numero2 = new productoM().contarProducto();
                        double num_prod2 = numero_productos_mostrar();
                        int num_pagina2 = (int) Math.ceil(numero2/num_prod2);
                        lista.setAttribute("numero_hojas", num_pagina2);
                        response.sendRedirect("index.jsp");
                        break;
                    case "producto_eliminar":
                        response.sendRedirect("eliminarProducto.jsp");
                        break;
                    case "producto_modificar":
                        response.sendRedirect("modificarProducto.jsp");
                        break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (get2 != null) {
            producto producto_modificar_menu = new producto();
            producto_modificar_menu.setId_producto(Integer.parseInt(get2));
            try {
                producto_modificar_menu = new productoM().UnProducto(producto_modificar_menu);
                lista.setAttribute("unproducto", producto_modificar_menu);
                response.sendRedirect("modificarProductoMenu.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (get3 != null) {
            producto producto_eliminar_menu = new producto();
            producto_eliminar_menu.setId_producto(Integer.parseInt(get3));
            try {
                producto_eliminar_menu = new productoM().UnProducto(producto_eliminar_menu);
                lista.setAttribute("unproducto", producto_eliminar_menu);
                response.sendRedirect("eliminarProductoMenu.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (get4 != null) {
            ArrayList<producto> p;
            try {   
                int numero = new productoM().contarProducto();
                double num_prod = numero_productos_mostrar();
                int num_pagina = (int) Math.ceil(numero/num_prod);
                lista.setAttribute("numero_hojas", num_pagina);
                p = new productoM().listarProductoHoja(Integer.parseInt(get4), (int) numero_productos_mostrar());
                lista.setAttribute("listaproducto", p);
                response.sendRedirect("index.jsp");
            }catch (SQLException ex) {
                Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();       
        String submit = request.getParameter("submit");
        switch (submit) {
            case "crear":
                //crear producto
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                String imagen = request.getParameter("imagen");
                String precio = request.getParameter("precio");
                producto producto_crear = new producto();
                producto_crear.setNombre(nombre);
                producto_crear.setDescripcion(descripcion);
                producto_crear.setImagen(imagen);
                producto_crear.setPrecio(Integer.parseInt(precio));
//                String ruta = getServletContext().getRealPath("/");
//                String[] parte = ruta.split("build");
//                String rutaProducto = parte[0] + "web\\imagen\\producto";
                boolean insertar;
                try {
                    insertar = new productoM().insertarProducto(producto_crear);
                    if (insertar == true) {
                        out.println("<script>");
                        out.println("alert(\"Producto insertado correctamente!\");");
                        out.println("window.location=\"index.jsp\";");
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
                break;
            case "eliminar":
                //eliminar producto
                String id_producto = request.getParameter("producto");
                producto producto_eliminar = new producto();
                producto_eliminar.setId_producto(Integer.parseInt(id_producto));
                Boolean eliminar;
                try {
                    eliminar = new productoM().eliminarProducto(producto_eliminar);
                    if (eliminar == true) {
                        String img = ruta_imagen();
                        String img2 = request.getParameter("file_imagen");
                        File fichero = new File(img+img2);
                        fichero.delete();
                        out.println("<script>");
                        out.println("alert(\"Producto eliminado!\");");
                        out.println("window.location=\"productoServlet?pagina=0\";");
                        out.println("</script>");

                    } else {
                        out.println("<script>");
                        out.println("alert(\"Imposible eliminar producto!\");");
                        out.println("window.location=\"index.jsp\";");
                        out.println("</script>");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "modificar":
                //modificar producto
                String id_producto2 = request.getParameter("producto");
                String nombre3 = request.getParameter("nombre");
                String descripcion3 = request.getParameter("descripcion");
                String imagen3 = request.getParameter("file_imagen");
                String precio3 = request.getParameter("precio");
                producto producto_modificar = new producto();
                producto_modificar.setId_producto(Integer.parseInt(id_producto2));
                producto_modificar.setNombre(nombre3);
                producto_modificar.setDescripcion(descripcion3);
                producto_modificar.setImagen(imagen3);
                producto_modificar.setPrecio(Integer.parseInt(precio3));
                Boolean modificar;
                try {
                    modificar = new productoM().modificarProducto(producto_modificar);
                    if (modificar == true) {
                        out.println("<script>");
                        out.println("alert(\"Producto modificado!\");");
                        out.println("window.location=\"index.jsp\";");
                        out.println("</script>");

                    } else {
                        out.println("<script>");
                        out.println("alert(\"Imposible modificar producto!\");");
                        out.println("window.location=\"index.jsp\";");
                        out.println("</script>");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "buscar":
                //buscar producto  
                String nombre2 = request.getParameter("nombre");
                producto producto_buscar = new producto();
                producto_buscar.setNombre(nombre2);
                ArrayList<producto> p;
                try {
                    HttpSession lista = request.getSession();
                    p = new productoM().buscarProducto(producto_buscar);
                    if (!p.isEmpty()) {
                        lista.setAttribute("listaproducto_buscar", p);
                        out.println("<script>");
                        //out.println("alert(\"Busqueda exitosa!\");");
                        out.println("window.location=\"buscarProducto.jsp\";");
                        out.println("</script>");

                    } else {
                        lista.setAttribute("listaproducto_buscar", null);
                        out.println("<script>");
                        out.println("alert(\"No se encontraron resultados!\");");
                        out.println("window.location=\"buscarProducto.jsp\";");
                        out.println("</script>");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(productoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
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
