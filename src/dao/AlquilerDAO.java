package dao;

import conexion.ConexionBD;
import dto.Alquiler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlquilerDAO {

    public void insertarAlquiler(Alquiler a) {

        String sql = "INSERT INTO alquiler(fecha_inicio, fecha_fin, precio_total, id_cliente, id_vehiculo, id_empleado) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, a.getFechaInicio());
            ps.setString(2, a.getFechaFin());
            ps.setDouble(3, a.getPrecioTotal());
            ps.setInt(4, a.getIdCliente());
            ps.setInt(5, a.getIdVehiculo());
            ps.setInt(6, a.getIdEmpleado());

            ps.executeUpdate();

            System.out.println("Alquiler registrado");

        } catch (Exception e) {

            System.out.println("Error al registrar alquiler");
        }
    }

    public ArrayList<Alquiler> obtenerAlquileres() {

        ArrayList<Alquiler> lista = new ArrayList<>();

        String sql = "SELECT * FROM alquiler";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Alquiler a = new Alquiler(
                        rs.getInt("id_alquiler"),
                        rs.getString("fecha_inicio"),
                        rs.getString("fecha_fin"),
                        rs.getDouble("precio_total"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_vehiculo"),
                        rs.getInt("id_empleado")
                );

                lista.add(a);
            }

        } catch (Exception e) {

            System.out.println("Error al obtener alquileres");
        }

        return lista;
    }

    public void eliminarAlquiler(int id) {

        String sql = "DELETE FROM alquiler WHERE id_alquiler = ?";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Alquiler eliminado");

        } catch (Exception e) {

            System.out.println("Error al eliminar alquiler");
        }
    }
}