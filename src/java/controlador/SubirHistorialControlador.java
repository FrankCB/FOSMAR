package controlador;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.DBConnection;

@WebServlet(name = "SubirHistorialControlador", urlPatterns = {"/SubirHistorialControlador"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50   // 50MB
)
public class SubirHistorialControlador extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = (int) request.getSession().getAttribute("idUsuario");
        String descripcion = request.getParameter("descripcion");
        Part archivo = request.getPart("archivoHistorial");
        String filePath = null;

        // Manejo del archivo subido
        if (archivo != null && archivo.getSize() > 0) {
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String fileName = new File(archivo.getSubmittedFileName()).getName();
            filePath = UPLOAD_DIR + File.separator + fileName;
            archivo.write(uploadPath + File.separator + fileName);
        }

        // Actualizar historial médico en la base de datos
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO historial_medico (id_usuario, descripcion, documento_adjunto) "
                       + "VALUES (?, ?, ?) "
                       + "ON DUPLICATE KEY UPDATE descripcion = VALUES(descripcion), documento_adjunto = VALUES(documento_adjunto)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.setString(2, descripcion);
            ps.setString(3, filePath);
            ps.executeUpdate();

            // Redirigir con mensaje de éxito
            request.getSession().setAttribute("success", "Historial médico subido correctamente.");
            response.sendRedirect("DashboardPacienteControlador");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", "Error al subir el historial médico.");
            response.sendRedirect("DashboardPacienteControlador");
        }
    }
}
