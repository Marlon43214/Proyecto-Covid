package modelo;

import main.conector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modelo_funcionario extends conector{

    conector con = new conector();
    Connection conexion = con.conexion();

    public boolean Registro_funcionario(personas per){

        String query = "INSERT INTO datos_personas (Codigo, Nombre, Genero, Direccion, Correo, Facultad, Cargo, Puntaje, Vacunado) VALUES (?,?,?,?,?,?,?,?,?)";

        try{
            PreparedStatement preparedStatement = conexion().prepareStatement(query);
            preparedStatement.setString(1, per.getCodigo());
            preparedStatement.setString(2, per.getNombre());
            preparedStatement.setString(3, per.getGenero());
            preparedStatement.setString(4, per.getDireccion());
            preparedStatement.setString(5, per.getCorreo());
            preparedStatement.setString(6, per.getFacultad());
            preparedStatement.setString(7, per.getCargo());
            preparedStatement.setInt(8, per.getPuntaje());
            preparedStatement.setString(9, per.getVacunado());
            preparedStatement.executeUpdate();

            return true;
        }catch(SQLException a){
            System.err.println(a);
            return false;
        }finally {
            try{
                conexion.close();
            }catch (SQLException a){
                System.err.println(a);
            }
        }
    }
}
