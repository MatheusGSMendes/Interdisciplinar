package controller;

import dao.AlimentoDAO;
import model.Alimento;

import java.sql.Connection;
import java.util.List;

public class AlimentoController {

    private final AlimentoDAO alimentoDAO;

    public AlimentoController(Connection connection) {
        this.alimentoDAO = new AlimentoDAO(connection);
    }

    public List<Alimento> obterRecomendacoes(double tempAr, double umidAr, double umidSolo) throws Exception {
        return alimentoDAO.buscarPorCondicoes(tempAr, umidAr, umidSolo);
    }
}
