package modelo;

import main.conector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class modelo_principal extends conector{
    private String nuevo;
    conector con = new conector();
    Connection conexion = con.conexion();
    int Vac_actuales = 0;
    public void add_vacunas(int CantidadAgregar){
        //JOptionPane.showMessageDialog(null,""+Vac_actuales);
        if (CantidadAgregar <= 0){
            JOptionPane.showMessageDialog(null,"Error al agregar vacunas","Coding cube-covid",JOptionPane.ERROR_MESSAGE);
        }else {
            try {
                PreparedStatement ps = null;
                ResultSet rs = null;
                String query = "SELECT NumeroVacunas FROM datos_vacunas WHERE ID = 1";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Vac_actuales = rs.getInt("NumeroVacunas");
                } else {
                    System.err.println("Error");
                }
            } catch (SQLException a) {
                a.printStackTrace();
            }
            try {
                PreparedStatement ps = null;
                ResultSet rs = null;
                Vac_actuales += CantidadAgregar;
                String query2 = "UPDATE datos_vacunas SET NumeroVacunas = ? WHERE ID = 1";
                ps = conexion.prepareStatement(query2);
                ps.setInt(1, Vac_actuales);
                ps.executeUpdate();
                ps = conexion.prepareStatement(query2);
                rs = ps.executeQuery();
                nuevo = "Cantidad de vacunas es: " + rs.getInt("NumeroVacunas");
            } catch (SQLException b) {
            //    b.printStackTrace();
            }
        }

    }

    public void remove_vacunas(int CantidadQuitar){
        if (CantidadQuitar <= 0){
            JOptionPane.showMessageDialog(null,"Error al quitar vacunas","Coding cube-covid",JOptionPane.ERROR_MESSAGE);
        }else {
            try {
                PreparedStatement ps = null;
                ResultSet rs = null;
                String query = "SELECT NumeroVacunas FROM datos_vacunas WHERE ID = 1";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Vac_actuales = rs.getInt("NumeroVacunas");
                } else {
                    JOptionPane.showMessageDialog(null,"Error al encontrar vacunas","Coding cube-covid",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException a) {
                a.printStackTrace();
            }
            if(Vac_actuales < CantidadQuitar){
                JOptionPane.showMessageDialog(null,"Error al quitar vacunas","Coding cube-covid",JOptionPane.ERROR_MESSAGE);
            }else {
                try {
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    Vac_actuales -= CantidadQuitar;
                    String query2 = "UPDATE datos_vacunas SET NumeroVacunas = ? WHERE ID = 1";
                    ps = conexion.prepareStatement(query2);
                    ps.setInt(1, Vac_actuales);
                    ps.executeUpdate();
                    ps = conexion.prepareStatement(query2);
                    rs = ps.executeQuery();
                    nuevo = "Cantidad de vacunas es: " + rs.getInt("NumeroVacunas");
                } catch (SQLException b) {


                }
            }
        }
    }

    public void actualizaranucio (JLabel label_status){
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "SELECT NumeroVacunas FROM datos_vacunas WHERE ID = 1";
            ps = conexion.prepareStatement(query);
            rs=ps.executeQuery();
            if(rs.next()){
                label_status.setText("Cantidad de vacunas es: "+ rs.getInt("NumeroVacunas"));
            }

        } catch (SQLException E) {
            E.printStackTrace();
        }

    }
}
