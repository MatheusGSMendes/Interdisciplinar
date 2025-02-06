package view;

import dao.AlimentoDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alimento;

/**
 * thor Cliente
 */
public class View {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            /*try {
            // TODO code application logic here
            AlimentoDAO ad = new AlimentoDAO();
            Alimento a = ad.read("Frutas");
            System.out.println("Consulta realizada com sucesso! Alimento retornado: "+a);
            ad.fecharConexao();
            } catch (SQLException ex) {
            System.out.println("Erro: "+ex.getMessage());
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            //RODA ESSA BOSTA AÍ CESAR
            }*/

            AlimentoDAO ad = new AlimentoDAO();
            List<Alimento> a = ad.readAll();
            for (Alimento al : a) {
                System.out.println("Consulta realizada com sucesso! Alimento retornado: " + al);
            }
            ad.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());

            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
