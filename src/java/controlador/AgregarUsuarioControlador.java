package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DBConnection;

@WebServlet(name = "AgregarUsuarioControlador", urlPatterns = {"/AgregarUsuarioControlador"})
public class AgregarUsuarioControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String rol = request.getParameter("rol");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO usuarios (nombre, correo, contrasena, rol, estado) VALUES (?, ?, ?, ?, 'activo')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, contrasena); // Nota: Usa encriptación para producción
            ps.setString(4, rol);
            ps.executeUpdate();

            response.sendRedirect("ListarUsuariosControlador");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("agregar_usuario.jsp?error=1");
        }
    }
}
