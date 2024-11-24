package modelo;

public class HistorialMedico {
    private int id;
    private int idUsuario;
    private int idSolicitud;
    private String descripcion;

    public HistorialMedico(int id, int idUsuario, int idSolicitud, String descripcion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idSolicitud = idSolicitud;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdSolicitud() { return idSolicitud; }
    public void setIdSolicitud(int idSolicitud) { this.idSolicitud = idSolicitud; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
