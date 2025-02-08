/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.AlimentoDAO;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Alimento;
import java.sql.*;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Cliente
 */
public class MIDremadd extends javax.swing.JInternalFrame {

    AlimentoDAO daoAlimento = new AlimentoDAO();
    //private int idSelecionado = -1; // Armazena o ID do item selecionado

    /**
     * Creates new form MIDremadd
     */
    public MIDremadd() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);

        this.listagemTabela();

        // Esse trecho do código adiciona um listener (um objeto que fica escutando) para detectar um evento na linha
        // da tabela (uma seleção). Ao selecionar um item da tabela, um evento é disparado e os
        // dados do produto volta para os campos para que atualizações sejam feitas
        jTableadd.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override

            public void valueChanged(ListSelectionEvent le) {

                int r = jTableadd.getSelectedRow();

                if (r != -1) {

                    txtNome.setText(jTableadd.getModel().getValueAt(r, 0).toString());
                    txtGenero.setText(jTableadd.getModel().getValueAt(r, 1).toString());
                    txtTempAr.setText(jTableadd.getModel().getValueAt(r, 2).toString());
                    txtUmidAr.setText(jTableadd.getModel().getValueAt(r, 3).toString());
                    txtUmidSolo.setText(jTableadd.getModel().getValueAt(r, 4).toString());
                    txtEstacao.setText(jTableadd.getModel().getValueAt(r, 5).toString());

                }
                /*try {
                    daoAlimento.pegaId(jTableadd.getModel().getValueAt(r, 0).toString());
                } catch (SQLException ex) {
                    Logger.getLogger(MIDremadd.class.getName()).log(Level.SEVERE, null, ex);
                }*/

            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLGenero = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        jLUmidAr = new javax.swing.JLabel();
        txtUmidAr = new javax.swing.JTextField();
        jLUmidSolo = new javax.swing.JLabel();
        txtUmidSolo = new javax.swing.JTextField();
        jLEstacao = new javax.swing.JLabel();
        txtEstacao = new javax.swing.JTextField();
        jLTempAr = new javax.swing.JLabel();
        txtTempAr = new javax.swing.JTextField();
        jTButtonAdicionar = new javax.swing.JToggleButton();
        jTButtonDeletar = new javax.swing.JToggleButton();
        jTButtonAtualizar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableadd = new javax.swing.JTable();

        setClosable(true);

        jLNome.setText("Nome:");

        jLGenero.setText("Genero:");

        jLUmidAr.setText("Umidade do ar:");

        jLUmidSolo.setText("Umidade do solo:");

        jLEstacao.setText("Estação:");

        jLTempAr.setText("Temp do ar ideal:");

        jTButtonAdicionar.setText("Adicionar");
        jTButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTButtonAdicionarActionPerformed(evt);
            }
        });

        jTButtonDeletar.setText("Deletar");
        jTButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTButtonDeletarActionPerformed(evt);
            }
        });

        jTButtonAtualizar.setText("Atualizar");
        jTButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTButtonAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTButtonAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(jTButtonDeletar)
                        .addGap(18, 18, 18)
                        .addComponent(jTButtonAtualizar)
                        .addGap(0, 327, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNome)
                            .addComponent(jLGenero)
                            .addComponent(jLTempAr))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTempAr)
                            .addComponent(txtGenero)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLUmidSolo)
                            .addComponent(jLUmidAr)
                            .addComponent(jLEstacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUmidSolo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUmidAr, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLUmidAr)
                    .addComponent(txtUmidAr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLGenero)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLUmidSolo)
                    .addComponent(txtUmidSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEstacao)
                    .addComponent(txtEstacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTempAr)
                    .addComponent(txtTempAr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTButtonAdicionar)
                    .addComponent(jTButtonDeletar)
                    .addComponent(jTButtonAtualizar)))
        );

        jTableadd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Gênero", "Temp do ar ideal", "Umidade do ar ideal", "Umidade do solo ideal:", "Estação ideal"
            }
        ));
        jScrollPane1.setViewportView(jTableadd);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listagemTabela() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableadd.getModel();
            model.setRowCount(0); // Limpa a tabela antes de recarregar os dados

            List<Alimento> alimentos = daoAlimento.readAll();
            for (Alimento alimento : alimentos) {
                model.addRow(new Object[]{
                    //alimento.getId(),
                    alimento.getNome(),
                    alimento.getGenero(),
                    alimento.getTempArIdeal(),
                    alimento.getUmidArIdeal(),
                    alimento.getUmidSoloIdeal(),
                    alimento.getEstacaoIdeal()
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(MIDremadd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jTButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTButtonAdicionarActionPerformed

        try {
            Alimento f = new Alimento();
            f.setNome(txtNome.getText());
            f.setGenero(txtGenero.getText());
            f.setTempArIdeal(Double.parseDouble(txtTempAr.getText()));
            f.setUmidArIdeal(Double.parseDouble(txtUmidAr.getText()));
            f.setUmidSoloIdeal(Double.parseDouble(txtUmidSolo.getText()));
            f.setEstacaoIdeal(txtEstacao.getText());

            daoAlimento.create(f);
            JOptionPane.showMessageDialog(this, "Alimento adicionado com sucesso!");
            listagemTabela(); // Atualiza a tabela após adicionar

        } catch (SQLException ex) {
            // Verifica se a exceção é devido à restrição UNIQUE
            if (ex.getErrorCode() == 1062) { // Código 1062 = entrada duplicada no MySQL
                JOptionPane.showMessageDialog(this, "Erro: Esse alimento já está cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao adicionar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTButtonAdicionarActionPerformed

    private void jTButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTButtonDeletarActionPerformed

        int row = jTableadd.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um alimento para deletar!");
            return;
        }
        /*if (idSelecionado == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um alimento para deletar!");
            return;
        }*/

        String nome = jTableadd.getModel().getValueAt(row, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja deletar esse item?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                daoAlimento.delete(nome);
                JOptionPane.showMessageDialog(this, "Alimento removido com sucesso!");
                listagemTabela(); // Atualiza a tabela após remoção
                //idSelecionado = -1;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao deletar: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jTButtonDeletarActionPerformed

    private void jTButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTButtonAtualizarActionPerformed
        // TODO add your handling code here:

        int row = jTableadd.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um alimento para atualizar!");
            return;
        }

        try {
            // Criando o objeto Alimento e preenchendo com os dados dos campos de texto
            Alimento alimento = new Alimento();
            alimento.setNome(txtNome.getText());
            alimento.setGenero(txtGenero.getText());
            alimento.setTempArIdeal(Double.parseDouble(txtTempAr.getText()));
            alimento.setUmidArIdeal(Double.parseDouble(txtUmidAr.getText()));
            alimento.setUmidSoloIdeal(Double.parseDouble(txtUmidSolo.getText()));
            alimento.setEstacaoIdeal(txtEstacao.getText());

            // Obtendo o nome antigo para a atualização no banco
            String nomeAntigo = (String) jTableadd.getValueAt(row, 0);

            // Chama o método update para atualizar os dados no banco de dados
            daoAlimento.update(alimento, nomeAntigo);

            JOptionPane.showMessageDialog(this, "Alimento atualizado com sucesso!");

            // Atualiza a tabela após edição
            listagemTabela();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + ex.getMessage());
        }

    }//GEN-LAST:event_jTButtonAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLEstacao;
    private javax.swing.JLabel jLGenero;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLTempAr;
    private javax.swing.JLabel jLUmidAr;
    private javax.swing.JLabel jLUmidSolo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jTButtonAdicionar;
    private javax.swing.JToggleButton jTButtonAtualizar;
    private javax.swing.JToggleButton jTButtonDeletar;
    private javax.swing.JTable jTableadd;
    private javax.swing.JTextField txtEstacao;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTempAr;
    private javax.swing.JTextField txtUmidAr;
    private javax.swing.JTextField txtUmidSolo;
    // End of variables declaration//GEN-END:variables
}
