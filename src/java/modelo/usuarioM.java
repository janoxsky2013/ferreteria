/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.conexion;
import entidad.usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alejandro
 */
public class usuarioM extends conexion{
    public boolean registrarUsuario(usuario u) throws SQLException {
        String sql="insert into usuario (nombre,clave) values ('"+u.getNombre()+"','"+u.getClave()+"');";
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
    public boolean identificarUsuario(usuario u) throws SQLException {
        String sql = "select * from usuario WHERE nombre='"+u.getNombre()+"' and clave='"+u.getClave()+"';";
        Connection con = null;
        try{
            con = this.ConectorBd();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
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
}
