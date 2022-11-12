/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ComputadoraController {

    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    
    
    public void abrirConexion(){
        conectorBD= new ConexionBaseDeDatos();
        conexion=conectorBD.conectar();
    }    
   
    
    public String guardarAlumno2(Computadora alumno){        
        String sql = "INSERT INTO final_progra.computadora(marca_codigo, tamaño_pantalla, cantidad_ram, almacenamiento, sistema_operativo) ";
             sql += " VALUES(?,?,?,?,?,?,?,?,?,?)";              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            statement.setInt(1, alumno.getCodigo());
            statement.setString(2, alumno.getNombre());
            statement.setString(3, alumno.getApellido());
            statement.setString(4, alumno.getCorreo());
            statement.setString(5, alumno.getDireccion());
            statement.setInt(6, alumno.getTelefono());
            statement.setString(7, alumno.getSucursal());
            statement.setString(8, alumno.getGrado());
            statement.setString(9, alumno.getNivel());
            statement.setString(10, alumno.getFecha());
            
                int resultado = statement.executeUpdate(); 
                if(resultado > 0){
                    return String.valueOf(resultado);
                }else{
                    return String.valueOf(resultado);
                }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    
    
   
    
    
}
