package dto;

public class Cliente {

    private int id;
    private String nombre;
    private String dni;
    private String telefono;

    public Cliente(int id, String nombre, String dni, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return nombre + " - " + dni;
    }
}