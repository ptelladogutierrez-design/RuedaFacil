package vista;

import dao.VehiculoDAO;
import dto.Vehiculo;
import dao.ClienteDAO;
import dto.Cliente;
import dao.AlquilerDAO;
import dto.Alquiler;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    VehiculoDAO dao = new VehiculoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    AlquilerDAO alquilerDAO = new AlquilerDAO();

    public void iniciar() {

        int opcion;

        do {

            System.out.println("\n=== RUEDAFACIL ===");
            System.out.println("1. Gestionar vehículos");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Gestionar alquileres");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    menuVehiculos();

                    break;

                case 2:

                    menuClientes();

                    break;

                case 3:

                    menuAlquileres();

                    break;

                case 4:

                    System.out.println("Saliendo...");

                    break;

                default:

                    System.out.println("Opción no válida");
            }

        } while (opcion != 4);
    }

    public void menuVehiculos() {

        int opcion;

        do {

            System.out.println("\n--- VEHÍCULOS ---");
            System.out.println("1. Ver vehículos");
            System.out.println("2. Añadir vehículo");
            System.out.println("3. Modificar vehículo");
            System.out.println("4. Eliminar vehículo");
            System.out.println("5. Buscar por categoría");
            System.out.println("6. Volver");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    mostrarVehiculos();

                    break;

                case 2:

                    insertarVehiculo();

                    break;

                case 3:

                    actualizarVehiculo();

                    break;

                case 4:

                    eliminarVehiculo();

                    break;

                case 5:

                    buscarVehiculosCategoria();

                    break;

                case 6:

                    break;

                default:

                    System.out.println("Opción no válida");
            }

        } while (opcion != 6);
    }

    public void mostrarVehiculos() {

        ArrayList<Vehiculo> vehiculos = dao.obtenerVehiculos();

        System.out.println("\n--- LISTA DE VEHÍCULOS ---");

        for (Vehiculo v : vehiculos) {

            System.out.println(v);
        }
    }
    public void buscarVehiculosCategoria() {

        System.out.print("ID de la categoría: ");

        int idCategoria = sc.nextInt();

        ArrayList<Vehiculo> vehiculos =
                dao.obtenerVehiculosPorCategoria(idCategoria);

        System.out.println("\n--- VEHÍCULOS DE LA CATEGORÍA ---");

        for (Vehiculo v : vehiculos) {

            System.out.println(v);
        }
    }

    public void insertarVehiculo() {

        sc.nextLine();

        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Precio por día: ");
        double precio = sc.nextDouble();

        Vehiculo v = new Vehiculo(
                0,
                matricula,
                marca,
                modelo,
                precio,
                "Disponible",
                1
        );

        dao.insertarVehiculo(v);
    }

    public void eliminarVehiculo() {

        System.out.print("ID del vehículo a eliminar: ");

        int id = sc.nextInt();

        dao.eliminarVehiculo(id);
    }
    public void menuClientes() {

        int opcion;

        do {

            System.out.println("\n--- CLIENTES ---");
            System.out.println("1. Ver clientes");
            System.out.println("2. Añadir cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Volver");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    mostrarClientes();

                    break;

                case 2:

                    insertarCliente();

                    break;

                case 3:

                    eliminarCliente();

                    break;

                case 4:

                    break;

                default:

                    System.out.println("Opción no válida");
            }

        } while (opcion != 4);
    }

    public void mostrarClientes() {

        ArrayList<Cliente> clientes = clienteDAO.obtenerClientes();

        System.out.println("\n--- LISTA DE CLIENTES ---");

        for (Cliente c : clientes) {

            System.out.println(c);
        }
    }

    public void insertarCliente() {

        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("DNI: ");
        String dni = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Cliente c = new Cliente(0, nombre, dni, telefono);

        clienteDAO.insertarCliente(c);
    }

    public void eliminarCliente() {

        System.out.print("ID del cliente a eliminar: ");

        int id = sc.nextInt();

        clienteDAO.eliminarCliente(id);
    }
    public void menuAlquileres() {

        int opcion;

        do {

            System.out.println("\n--- ALQUILERES ---");
            System.out.println("1. Ver alquileres");
            System.out.println("2. Registrar alquiler");
            System.out.println("3. Historial cliente");
            System.out.println("4. Devolver vehículo");
            System.out.println("5. Eliminar alquiler");
            System.out.println("6. Volver");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    mostrarAlquileres();

                    break;

                case 2:

                    insertarAlquiler();

                    break;

                case 3:

                    historialCliente();

                    break;

                case 4:

                    devolverVehiculo();

                    break;

                case 5:

                    eliminarAlquiler();

                    break;

                case 6:

                    break;

                default:

                    System.out.println("Opción no válida");
            }

        } while (opcion != 6);
    }

    public void mostrarAlquileres() {

        ArrayList<Alquiler> alquileres = alquilerDAO.obtenerAlquileres();

        System.out.println("\n--- LISTA DE ALQUILERES ---");

        for (Alquiler a : alquileres) {

            System.out.println(a);
        }
    }

    public void insertarAlquiler() {

        sc.nextLine();

        System.out.print("Fecha inicio (YYYY-MM-DD): ");
        String fechaInicio = sc.nextLine();

        System.out.print("Fecha fin (YYYY-MM-DD): ");
        String fechaFin = sc.nextLine();

        System.out.print("Precio total: ");
        double precio = sc.nextDouble();

        System.out.print("ID cliente: ");
        int idCliente = sc.nextInt();

        System.out.print("ID vehículo: ");
        int idVehiculo = sc.nextInt();

        System.out.print("ID empleado: ");
        int idEmpleado = sc.nextInt();

        Alquiler a = new Alquiler(
                0,
                fechaInicio,
                fechaFin,
                precio,
                idCliente,
                idVehiculo,
                idEmpleado
        );

        alquilerDAO.insertarAlquiler(a);
        dao.cambiarEstado(idVehiculo, "Alquilado");
    }

    public void eliminarAlquiler() {

        System.out.print("ID del alquiler a eliminar: ");

        int id = sc.nextInt();

        alquilerDAO.eliminarAlquiler(id);
    }

    public void devolverVehiculo() {

        System.out.print("ID del vehículo: ");

        int idVehiculo = sc.nextInt();

        dao.cambiarEstado(idVehiculo, "Disponible");

        System.out.println("Vehículo devuelto");
    }
    public void actualizarVehiculo() {

        System.out.print("ID del vehículo: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Nueva matrícula: ");
        String matricula = sc.nextLine();

        System.out.print("Nueva marca: ");
        String marca = sc.nextLine();

        System.out.print("Nuevo modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Nuevo precio por día: ");
        double precio = sc.nextDouble();

        sc.nextLine();

        System.out.print("Nuevo estado: ");
        String estado = sc.nextLine();

        Vehiculo v = new Vehiculo(
                id,
                matricula,
                marca,
                modelo,
                precio,
                estado,
                1
        );

        dao.actualizarVehiculo(v);
    }
    public void historialCliente() {

        System.out.print("ID del cliente: ");

        int idCliente = sc.nextInt();

        ArrayList<Alquiler> alquileres =
                alquilerDAO.obtenerAlquileresCliente(idCliente);

        for (Alquiler a : alquileres) {

            System.out.println(a);
        }
    }

}
