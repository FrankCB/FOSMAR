package modelo;

public class SolicitudDescanso {
    private int id;
    private String fechaInicio;
    private int duracion;
    private String motivo;
    private String estado;
    private String documentoAdjunto;
    private int idPaciente; // ID del paciente asociado
    private String pacienteNombre; // Nombre del paciente asociado

    public SolicitudDescanso() {
    }

    public SolicitudDescanso(int id, String fechaInicio, int duracion, String motivo, String estado, String documentoAdjunto, int idPaciente, String pacienteNombre) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.motivo = motivo;
        this.estado = estado;
        this.documentoAdjunto = documentoAdjunto;
        this.idPaciente = idPaciente;
        this.pacienteNombre = pacienteNombre;
    }



// (Otros getters y setters ya creados antes)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumentoAdjunto() {
        return documentoAdjunto;
    }

    public void setDocumentoAdjunto(String documentoAdjunto) {
        this.documentoAdjunto = documentoAdjunto;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }
}
