package dao;

import conexion.ConexionBD;
import dto.Vehiculo;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    public ArrayList<Vehiculo> obtenerVehiculos() {

        ArrayList<Vehiculo> lista = new ArrayList<>();

        String sql = "SELECT * FROM vehiculo";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Vehiculo v = new Vehiculo(
                        rs.getInt("id_vehiculo"),
                        rs.getString("matricula"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getDouble("precio_dia"),
                        rs.getString("estado"),
                        rs.getInt("id_categoria")
                );

                lista.add(v);
            }

        } catch (Exception e) {

            System.out.println("Error al obtener vehículos");
        }

        return lista;
    }
    public void eliminarVehiculo(int id) {

        String sql = "DELETE FROM vehiculo WHERE id_vehiculo = ?";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Vehículo eliminado");

        } catch (Exception e) {

            System.out.println("Error al eliminar");
        }
    }
    public void actualizarVehiculo(Vehiculo v) {

        String sql = "UPDATE vehiculo SET matricula = ?, marca = ?, modelo = ?, precio_dia = ?, estado = ? WHERE id_vehiculo = ?";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, v.getMatricula());
            ps.setString(2, v.getMarca());
            ps.setString(3, v.getModelo());
            ps.setDouble(4, v.getPrecioDia());
            ps.setString(5, v.getEstado());
            ps.setInt(6, v.getId());

            ps.executeUpdate();

            System.out.println("Vehículo actualizado");

        } catch (Exception e) {

            System.out.println("Error al actualizar");
        }
    }
    public void cambiarEstado(int idVehiculo, String estado) {

        String sql = "UPDATE vehiculo SET estado = ? WHERE id_vehiculo = ?";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, estado);
            ps.setInt(2, idVehiculo);

            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error al cambiar estado");
        }
    }
    public ArrayList<Vehiculo> obtenerVehiculosPorCategoria(int idCategoria) {

        ArrayList<Vehiculo> lista = new ArrayList<>();

        String sql = "SELECT * FROM vehiculo WHERE id_categoria = ?";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idCategoria);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Vehiculo v = new Vehiculo(
                        rs.getInt("id_vehiculo"),
                        rs.getString("matricula"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getDouble("precio_dia"),
                        rs.getString("estado"),
                        rs.getInt("id_categoria")
                );

                lista.add(v);
            }

        } catch (Exception e) {

            System.out.println("Error al buscar vehículos");
        }

        return lista;
    }
}