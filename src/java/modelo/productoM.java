package modelo;

import conexion.conexion;
import entidad.producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class productoM extends conexion {
    public boolean insertarProducto(producto p) throws SQLException {
        String sql="insert into producto (nombre,descripcion,imagen,precio) values ('"+p.getNombre()+"','"+p.getDescripcion()+"','"+p.getImagen()+"',"+p.getPrecio()+");";
        Connection con = null;
        try{
            con = this.ConectorBd();
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(sql);
            if(rs > 0){
                stmt.close();
                return true;
            }else{
                stmt.close();
                return false;
            }
        }catch(Exception e){
            return false;
        }finally{
            if(!con.isClosed()){
                con.close();
            }            
        }        
    }
    public boolean eliminarProducto(producto p) throws SQLException {
        String sql = "DELETE FROM producto WHERE id_producto = "+p.getId_producto()+";";
        Connection con = null;
        try{
            con = this.ConectorBd();
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(sql);
            if(rs > 0){
                stmt.close();
                return true;
            }else{
                stmt.close();
                return false;
            }
        }catch(Exception e){
            return false;
        }finally{
            if(!con.isClosed()){
                con.close();
            }            
        }
    }
    public ArrayList<producto> listarProducto() throws SQLException {
        String sql = "select * from producto";
        Connection con = null;
        ArrayList<producto> listaProducto = new ArrayList();
        try{
            con = this.ConectorBd();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                producto p = new producto();
                p.setId_producto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setImagen(rs.getString("imagen"));
                p.setPrecio(rs.getInt("precio"));
                listaProducto.add(p);
            }
            stmt.close();
            return listaProducto;
        }catch(Exception e){
            return null;
        }finally{
            if(!con.isClosed()){
                con.close();
            }            
        }
    }
    public boolean modificarProducto(producto p) throws SQLException {
        String sql = "UPDATE producto set nombre='"+p.getNombre()+"', descripcion='"+p.getDescripcion()+"', imagen='"+p.getImagen()+"', precio="+p.getPrecio()+" WHERE id_producto="+p.getId_producto()+";";
        Connection con = null;
        try{
            con = this.ConectorBd();
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(sql);
            if(rs > 0){
                stmt.close();
                return true;
            }else{
                stmt.close();
                return false;
            }
        }catch(Exception e){
            return false;
        }finally{
            if(!con.isClosed()){
                con.close();
            }            
        }        
    }
    public ArrayList<producto> buscarProducto(producto producto) throws SQLException {
        String sql = "select * from producto WHERE nombre LIKE '"+producto.getNombre()+"%';";
        Connection con = null;
        ArrayList<producto> listaProducto = new ArrayList();
        try{
            con = this.ConectorBd();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                producto p = new producto();
                p.setId_producto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setImagen(rs.getString("imagen"));
                p.setPrecio(rs.getInt("precio"));
                listaProducto.add(p);
            }
            stmt.close();
            return listaProducto;
        }catch(Exception e){
            return null;
        }finally{
            if(!con.isClosed()){
                con.close();
            }            
        }
    }
    public producto UnProducto(producto producto) throws SQLException {
        String sql = "select * from producto WHERE id_producto="+producto.getId_producto()+";";
        Connection con = null;
        producto p = new producto();
        try{
            con = this.ConectorBd();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                p.setId_producto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setImagen(rs.getString("imagen"));
                p.setPrecio(rs.getInt("precio"));
            }
            stmt.close();
            return p;
        }catch(Exception e){
            return null;
        }finally{
            if(!con.isClosed()){
                con.close();
            }            
        }
    }
    public ArrayList<producto> listarProductoHoja(int hoja, int num_prod) throws SQLException {
        int offset = (hoja) * num_prod;
        String sql = "select * from producto limit "+num_prod+" offset "+offset+";";
        Connection con = null;
        ArrayList<producto> listaProducto = new ArrayList();
        try{
            con = this.ConectorBd();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                producto p = new producto();
                p.setId_producto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setImagen(rs.getString("imagen"));
                p.setPrecio(rs.getInt("precio"));
                listaProducto.add(p);
            }
            stmt.close();
            return listaProducto;
        }catch(Exception e){
            return null;
        }finally{
            if(!con.isClosed()){
                con.close();
            }            
        }
    }
    public int contarProducto() throws SQLException {
        String sql = "select count(*) as numero from producto;";
        int numero = 0;
        Connection con = null;
        try{
            con = this.ConectorBd();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                numero = rs.getInt("numero");
            }
            stmt.close();
            return numero;
        }catch(Exception e){
            return 0;
        }finally{
            if(!con.isClosed()){
                con.close();
            }            
        }
    }
}

