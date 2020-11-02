package acoesbackend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class ConexaoBD {
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/controleacoes?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
            String usuario = "root";
            String senha = "Senha";
            return DriverManager.getConnection(url,usuario,senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
