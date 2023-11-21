package dataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
 
public class MetodosUsuario {
    
    private Connection con;
    int id=0;
    String nombre,correo,usuario,password;
    
    Conexion conex=new Conexion();
    PreparedStatement stmt;
    ResultSet rs;
        
    public void insertar(String nombre,String correo,String usuario,String password){
        
        this.nombre=nombre;
        this.correo=correo;
        this.usuario=usuario;
        this.password=password;
        
        try{
            con=conex.getConexion();
            stmt= con.prepareStatement("insert into usuarios(nombre,correo,usuario,contrasenia) values(?,?,?,?)");
            stmt.setString(1,nombre);
            stmt.setString(2,correo);
            stmt.setString(3,usuario);
            stmt.setString(4,password);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    public int Consultar(String correo){
        
        this.correo=correo;
        String clave="" ;
        
        try{
            con=conex.getConexion();
            stmt= con.prepareStatement("select id from usuarios where correo=?");
            stmt.setString(1,correo);
            rs=stmt.executeQuery();
            
            if (rs.next()) {
            clave=rs.getString("id");
            JOptionPane.showMessageDialog(null, "El id es :" +clave);
            id=Integer.parseInt(clave);//valor para return
            
            } else {
            JOptionPane.showMessageDialog(null, "No existe una persona con ese correo");
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }       
        return id;
    }
    
    public void eliminar(int id){
        
        this.id=id;
        
        try{
            con=conex.getConexion();
            stmt= con.prepareStatement("Delete from usuarios where id=?");
            stmt.setInt(1,id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario eliminado");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    public void modificar(int id,String password){
        
        this.id=id;
        
        try{
            con=conex.getConexion();
            stmt= con.prepareStatement("update usuarios set contrasenia=? where id=?");
            stmt.setString(1,password);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contraseña cambiada");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    public void ConsultarUsuario(String usuario,String contrasenia){
        
        try{
            con=conex.getConexion();
            stmt= con.prepareStatement("select usuario,contrasenia from usuarios where usuario=? and contrasenia=?");
            stmt.setString(1,usuario);
            stmt.setString(2,contrasenia);
            rs=stmt.executeQuery();
            
            if (rs.next()) {
            this.usuario=rs.getString("usuario");
            this.password=rs.getString("contrasenia");
            JOptionPane.showMessageDialog(null,"BIENVENIDO AL SISTEMA");  
            
            } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto ");
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }       
    }
}


