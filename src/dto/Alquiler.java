package dto;

public class Alquiler {

    private int id;
    private String fechaInicio;
    private String fechaFin;
    private double precioTotal;
    private int idCliente;
    private int idVehiculo;
    private int idEmpleado;

    public Alquiler(int id, String fechaInicio, String fechaFin,
                    double precioTotal, int idCliente,
                    int idVehiculo, int idEmpleado) {

        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
        this.idEmpleado = idEmpleado;
    }

    public int getId() {
        return id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }
}