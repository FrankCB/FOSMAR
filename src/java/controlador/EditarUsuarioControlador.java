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

@WebServlet(name = "EditarUsuarioControlador", urlPatterns = {"/EditarUsuarioControlador"})
public class EditarUsuarioControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String rol = request.getParameter("rol");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE usuarios SET nombre = ?, correo = ?, rol = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, rol);
            ps.setInt(4, id);
            ps.executeUpdate();

            response.sendRedirect("ListarUsuariosControlador");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("CargarUsuarioControlador?id=" + id + "&error=1");
        }
    }
}
