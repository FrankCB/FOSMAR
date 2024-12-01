package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DBConnection;

@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id, nombre, rol FROM usuarios WHERE correo = ? AND contrasena = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // Usuario autenticado
                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", rs.getInt("id"));
                session.setAttribute("nombreUsuario", rs.getString("nombre"));
                session.setAttribute("rolUsuario", rs.getString("rol"));
                response.sendRedirect("dashboard.jsp");
            } else {
                // Credenciales inválidas
                request.setAttribute("error", "Correo o contraseña incorrectos.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
