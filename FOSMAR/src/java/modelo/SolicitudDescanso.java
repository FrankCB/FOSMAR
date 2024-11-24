package modelo;

import java.util.Date;

public class SolicitudDescanso {
    private int id;
    private int idUsuario;
    private Date fechaInicio;
    private int duracionDias;
    private String motivo;
    private String estado;

    public SolicitudDescanso(int id, int idUsuario, Date fechaInicio, int duracionDias, String motivo, String estado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fechaInicio = fechaInicio;
        this.duracionDias = duracionDias;
        this.motivo = motivo;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public int getDuracionDias() { return duracionDias; }
    public void setDuracionDias(int duracionDias) { this.duracionDias = duracionDias; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
