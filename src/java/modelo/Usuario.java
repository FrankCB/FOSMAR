package modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol;
    private String estado;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(int id, String nombre, String correo, String contrasena, String rol, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        // Validar formato del correo
        if (correo.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo inválido.");
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
