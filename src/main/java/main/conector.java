package main;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Conector se utiliza para dar una coneccion entre la base datos y el programa
 */
public class conector {
    Connection con;
    public Connection conexion(){

        String urlMysql = "jdbc:mysql://localhost:3306/covid_ud";

        try{
            //Para decirle al programa que base de datos conectarse
            con = DriverManager.getConnection(urlMysql,"root","admin");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Conexion no establecida");
        }

        return con;
    }
}