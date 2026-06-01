package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import conexion.ConexionBD;
import dto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {

    public void insertarCliente(Cliente c) {

        String sql = "INSERT INTO cliente(nombre, dni, telefono) VALUES (?, ?, ?)";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDni());
            ps.setString(3, c.getTelefono());

            ps.executeUpdate();

            System.out.println("Cliente insertado");

        } catch (Exception e) {

            System.out.println("Error al insertar cliente");
        }
    }
    public ArrayList<Cliente> obtenerClientes() {

        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono")
                );

                lista.add(c);
            }

        } catch (Exception e) {

            System.out.println("Error al obtener clientes");
        }

        return lista;
    }
    public void eliminarCliente(int id) {

        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Cliente eliminado");

        } catch (Exception e) {

            System.out.println("Error al eliminar cliente");
        }
    }
    public void actualizarCliente(Cliente c) {

        String sql = "UPDATE cliente SET nombre = ?, dni = ?, telefono = ? WHERE id_cliente = ?";

        try {

            Connection con = ConexionBD.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDni());
            ps.setString(3, c.getTelefono());
            ps.setInt(4, c.getId());

            ps.executeUpdate();

            System.out.println("Cliente actualizado");

        } catch (Exception e) {

            System.out.println("Error al actualizar cliente");
        }
    }
}