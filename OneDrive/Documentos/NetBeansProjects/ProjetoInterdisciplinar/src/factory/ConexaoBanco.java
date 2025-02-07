package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://195.200.2.145:3306/BD_Interdisciplinar";
    private static final String USER = "arthur_matheus";
    private static final String SENHA = "S&nh@:Inter25";

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
//teste commit