package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao  {
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        // TODO: Deve-se implementar um mecanismo de reuso
        // de conexoes!
        Class.forName("org.postgresql.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres",
                "postgres",
                "vidabela");


        return conn;
    }
}
