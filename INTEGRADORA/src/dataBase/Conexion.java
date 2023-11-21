/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    public static final String URL = "jdbc:mysql://localhost:3306/proyecto";
    public static final String USER = "root";
    public static final String CLAVE = "";
    
    
    public Connection getConexion(){
        /*Declaramos una variable para almacenar la conexión que nos va a
    devolver el método getConexion(). Primero la iniciamos en null.*/
        Connection con = null;
        try{
            //Registrar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creamos una conexión a la Base de Datos
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("La conexión fue exitosa");
        // Si hay errores informamos al usuario.
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
