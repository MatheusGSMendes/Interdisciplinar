package controller;

import dao.AlimentoDAO;
import model.Alimento;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AlimentoController {
    private final AlimentoDAO alimentoDAO;
    private double temperaturaAtual;
    private double umidadeArAtual;
    private double umidadeSoloAtual;

    // Construtor recebe a conexão e inicializa o DAO
    public AlimentoController(Connection connection) {
        this.alimentoDAO = new AlimentoDAO();
    }

    //Criar um novo alimento no banco de dados
    public void adicionarAlimento(String nome, String genero, double tempAr, double umidAr, double umidSolo, String estacao) {
        try {
            Alimento alimento = new Alimento(nome, genero, tempAr, umidAr, umidSolo, estacao);
            alimentoDAO.create(alimento);
            System.out.println("Alimento cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar alimento: " + e.getMessage());
        }
    }

    //Buscar um alimento pelo nome
    public Alimento buscarAlimento(String nome) {
        try {
            Alimento alimento = alimentoDAO.read(nome);
            if (alimento != null) {
                return alimento;
            } else {
                System.out.println("Alimento não encontrado.");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar alimento: " + e.getMessage());
            return null;
        }
    }

    //Buscar todos os alimentos cadastrados
    public List<Alimento> listarAlimentos() {
        try {
            return alimentoDAO.readAll();
        } catch (SQLException e) {
            System.err.println("Erro ao listar alimentos: " + e.getMessage());
            return null;
        }
    }

    //Atualizar um alimento existente
    public void atualizarAlimento(String nome, String genero, double tempAr, double umidAr, double umidSolo, String estacao) {
        try {
            Alimento alimento = new Alimento(nome, genero, tempAr, umidAr, umidSolo, estacao);
            alimentoDAO.update(alimento);
            System.out.println("limento atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar alimento: " + e.getMessage());
        }
    }

    //Remover um alimento do banco de dados
    public void removerAlimento(String nome) {
        try {
            alimentoDAO.delete(nome);
            System.out.println("Alimento removido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao remover alimento: " + e.getMessage());
        }
    }

    //Atualizar os valores dos sensores recebidos do Raspberry Pi
    public void atualizarCondicoesAtuais(double temperatura, double umidadeAr, double umidadeSolo) {
        this.temperaturaAtual = temperatura;
        this.umidadeArAtual = umidadeAr;
        this.umidadeSoloAtual = umidadeSolo;
    }

    //Buscar alimentos compatíveis com as condições atuais dos sensores
    /*public List<Alimento> buscarAlimentosRecomendados() {
        try {
            return alimentoDAO.buscarPorCondicoes(temperaturaAtual, umidadeArAtual, umidadeSoloAtual);
        } catch (SQLException e) {
            System.err.println("❌ Erro ao buscar alimentos recomendados: " + e.getMessage());
            return null;
        }
    }*/
}
