package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/smart_farm";
    private static final String USER = "root";
    private static final String SENHA = "Inter2024";

    public static Connection getConnection() {

        try {
            //busca pela do Drive
            Class.forName(DRIVER);

            //fazer a conexao com o banco
            return DriverManager.getConnection(URL, USER, SENHA);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na Conexão!", ex);
        }

    }

}
