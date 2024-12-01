package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DBConnection;
import modelo.Usuario;

@WebServlet(name = "ListarUsuariosControlador", urlPatterns = {"/ListarUsuariosControlador"})
public class ListarUsuariosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id, nombre, correo, rol, estado FROM usuarios";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("listaUsuarios", listaUsuarios);
        request.getRequestDispatcher("dashboard_administrador.jsp").forward(request, response);
    }
}
