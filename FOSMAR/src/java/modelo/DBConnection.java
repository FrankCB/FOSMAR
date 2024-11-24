package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/fosmar?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";  // Cambia si tu usuario MySQL es diferente
    private static final String PASSWORD = "";   // Cambia según tu configuración

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Cargar el driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver MySQL. Asegúrate de que el JAR esté en el classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
            throw e;  // Relanza la excepción para manejarla en el DAO
        }
        return connection;
    }
}

