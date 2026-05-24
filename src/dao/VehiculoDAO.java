package dao;

import conexion.ConexionBD;
import dto.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VehiculoDAO {

    public void insertarVehiculo(Vehiculo v) {

        String sql = "INSERT INTO vehiculo(matricula, marca, modelo, precio_dia, estado) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, v.getMatricula());
            ps.setString(2, v.getMarca());
            ps.setString(3, v.getModelo());
            ps.setDouble(4, v.getPrecioDia());
            ps.setString(5, v.getEstado());

            ps.executeUpdate();

            System.out.println("Vehiculo insertado");

        } catch (Exception e) {

            System.out.println("Error al insertar");
        }
    }

    public void mostrarVehiculos() {

        String sql = "SELECT * FROM vehiculo";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            var rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id_vehiculo") + " - " +
                                rs.getString("matricula") + " - " +
                                rs.getString("marca") + " - " +
                                rs.getString("modelo")
                );
            }

        } catch (Exception e) {

            System.out.println("Error al mostrar");
        }
    }
}