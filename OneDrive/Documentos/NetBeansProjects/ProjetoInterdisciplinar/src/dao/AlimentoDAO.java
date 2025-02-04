package dao;

import factory.ConexaoBanco;
import model.Alimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {

    private final Connection connection;

    public AlimentoDAO(Connection con) {
        this.connection = con;
    }

    public List<Alimento> buscarPorCondicoes(double tempAr, double umidAr, double umidSolo) throws SQLException {
        String sql = "SELECT * FROM Alimentos WHERE ? BETWEEN temp_ar_ideal - 2 AND temp_ar_ideal + 2 " +
                     "AND ? BETWEEN umid_ar_ideal - 5 AND umid_ar_ideal + 5 " +
                     "AND ? BETWEEN umid_solo_ideal - 5 AND umid_solo_ideal + 5";
    
    /*public List<Alimento> buscarPorCondicoes() throws SQLException {*/
        
        Connection con = ConexaoBanco.getConnection();
        List<Alimento> alimentos = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, tempAr);
            stmt.setDouble(2, umidAr);
            stmt.setDouble(3, umidSolo);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    alimentos.add(new Alimento(
                            rs.getString("nome"),
                            rs.getString("genero"),
                            rs.getDouble("temp_ar_ideal"),
                            rs.getDouble("umid_ar_ideal"),
                            rs.getDouble("umid_solo_ideal"),
                            rs.getString("estacao_ideal")
                    ));
                }
            }
        }
        return alimentos;
    }
}

