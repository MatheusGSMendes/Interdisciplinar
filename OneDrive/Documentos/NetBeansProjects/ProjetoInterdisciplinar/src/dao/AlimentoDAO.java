package dao;

import com.mysql.cj.xdevapi.Result;
import factory.ConexaoBanco;
import model.Alimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlimentoDAO {

    private Connection connection = null;

    public AlimentoDAO() {
        this.connection = ConexaoBanco.getConnection();
    }

    public int pegaId(String nome) throws SQLException {
    String sql = "SELECT id FROM alimentos WHERE nome = ?";
    
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, nome); // Corrigido: Passa o nome no WHERE
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id"); // Retorna o ID encontrado
            }
        }
    }
    
    return -1; // Retorna -1 caso o alimento não seja encontrado
}


    //CREATE - Inserir um novo alimento no banco de dados
    public void create(Alimento alimento) throws SQLException {
        String sql = "INSERT INTO alimentos (nome, genero, temp_ar_ideal, umid_ar_ideal, umid_solo_ideal, estacao_ideal) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, alimento.getNome());
            stmt.setString(2, alimento.getGenero());
            stmt.setDouble(3, alimento.getTempArIdeal());
            stmt.setDouble(4, alimento.getUmidArIdeal());
            stmt.setDouble(5, alimento.getUmidSoloIdeal());
            stmt.setString(6, alimento.getEstacaoIdeal());
            stmt.executeUpdate();
            System.out.println("Alimento inserido com sucesso!");
        }
    }

    //READ - Buscar um alimento pelo gênero
    public Alimento read(String genero) throws SQLException {
        String sql = "SELECT * FROM alimentos WHERE genero = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, genero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Alimento(
                            rs.getString("nome"),
                            rs.getString("genero"),
                            rs.getDouble("temp_ar_ideal"),
                            rs.getDouble("umid_ar_ideal"),
                            rs.getDouble("umid_solo_ideal"),
                            rs.getString("estacao_ideal")
                    );
                }
            }
        }
        return null; // Retorna null se o alimento não for encontrado
    }

    //READ - Buscar todos os alimentos da tabela
    public List<Alimento> readAll() throws SQLException {
        String sql = "SELECT * FROM alimentos";
        List<Alimento> alimentos = new ArrayList<>();

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

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
        return alimentos;
    }

    //UPDATE - Atualizar os dados de um alimento
    public void update(Alimento alimento) throws SQLException {
        String sql = "UPDATE alimentos SET nome = ?, genero = ?, temp_ar_ideal = ?, umid_ar_ideal = ?, umid_solo_ideal = ?, estacao_ideal = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, alimento.getNome());
            stmt.setString(2, alimento.getGenero());
            stmt.setDouble(3, alimento.getTempArIdeal());
            stmt.setDouble(4, alimento.getUmidArIdeal());
            stmt.setDouble(5, alimento.getUmidSoloIdeal());
            stmt.setString(6, alimento.getEstacaoIdeal());
            stmt.setInt(7, pegaId(alimento.getNome()));
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Alimento atualizado com sucesso!");
            } else {
                System.out.println("Nenhum alimento encontrado para atualização.");
            }
        }
    }

    //DELETE - Excluir um alimento pelo nome
    public void delete(String nome) throws SQLException {
        String sql = "DELETE FROM alimentos WHERE nome = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Alimento removido com sucesso!");
            } else {
                System.out.println("Nenhum alimento encontrado para exclusão.");
            }
        }
    }

    public void fecharConexao() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
