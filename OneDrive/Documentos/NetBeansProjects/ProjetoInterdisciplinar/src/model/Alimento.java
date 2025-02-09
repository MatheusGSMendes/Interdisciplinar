package model;

public class Alimento {

    //private int id;
    private String nome;
    private String genero;
    private double tempArIdeal;
    private double umidArIdeal;
    private double umidSoloIdeal;
    private String estacaoIdeal;

    public Alimento(String nome, String genero, double tempArIdeal, double umidArIdeal, double umidSoloIdeal, String estacaoIdeal) {
        this.nome = nome;
        this.genero = genero;
        this.tempArIdeal = tempArIdeal;
        this.umidArIdeal = umidArIdeal;
        this.umidSoloIdeal = umidSoloIdeal;
        this.estacaoIdeal = estacaoIdeal;
    }

    public Alimento() {
    }

    // Getters e Setters
   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getTempArIdeal() {
        return tempArIdeal;
    }

    public void setTempArIdeal(double tempArIdeal) {
        this.tempArIdeal = tempArIdeal;
    }

    public double getUmidArIdeal() {
        return umidArIdeal;
    }

    public void setUmidArIdeal(double umidArIdeal) {
        this.umidArIdeal = umidArIdeal;
    }

    public double getUmidSoloIdeal() {
        return umidSoloIdeal;
    }

    public void setUmidSoloIdeal(double umidSoloIdeal) {
        this.umidSoloIdeal = umidSoloIdeal;
    }

    public String getEstacaoIdeal() {
        return estacaoIdeal;
    }

    public void setEstacaoIdeal(String estacaoIdeal) {
        this.estacaoIdeal = estacaoIdeal;
    }

    @Override
    public String toString() {
        return "Alimento{"
                + "nome='" + nome + '\''
                + ", genero='" + genero + '\''
                + ", tempArIdeal=" + tempArIdeal
                + ", umidArIdeal=" + umidArIdeal
                + ", umidSoloIdeal=" + umidSoloIdeal
                + ", estacaoIdeal='" + estacaoIdeal + '\''
                + '}';
    }
}
