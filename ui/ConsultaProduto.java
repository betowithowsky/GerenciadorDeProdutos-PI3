/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.beta.gerenciadordeprodutos.ui;

import br.senac.tads.pi3.beta.gerenciadordeprodutos.model.Produto;
import br.senac.tads.pi3.beta.gerenciadordeprodutos.services.produto.ServicoProduto;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Beto
 */
public class ConsultaProduto extends javax.swing.JFrame {

    private CadastroProduto telaCadastroProduto;

    /**
     * Creates new form ConsultaProduto
     */
    public ConsultaProduto() {
        initComponents();
        setTitle("Consultar Produtos");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextFieldBuscaNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BotaoConsultar = new javax.swing.JButton();
        BotaoAlterar = new javax.swing.JButton();
        BotaoRemover = new javax.swing.JButton();
        BotaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Nome:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Descrição", "Preço Compra", "Preço Venda", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BotaoConsultar.setText("Buscar");
        BotaoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConsultarActionPerformed(evt);
            }
        });

        BotaoAlterar.setText("Alterar");
        BotaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAlterarActionPerformed(evt);
            }
        });

        BotaoRemover.setText("Remover");
        BotaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRemoverActionPerformed(evt);
            }
        });

        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBuscaNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoConsultar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(BotaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoAlterar)
                    .addComponent(BotaoRemover)
                    .addComponent(BotaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConsultarActionPerformed
        String pesquisa = jTextFieldBuscaNome.getText();
        try {
            ArrayList<Produto> produtos = new ArrayList<Produto>();
            if (pesquisa.equals("")) {
                produtos = ServicoProduto.listar();
            } else {
                produtos = ServicoProduto.procurarPeloNome(pesquisa);
            }

            if (produtos.size() > 0) {
                atualizarTabela(produtos);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Nenhum produto encontrado", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotaoConsultarActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRemoverActionPerformed
        try {
            int[] selecteds = jTable1.getSelectedRows();

            for (int i = 0; i < selecteds.length; i++) {
                int row = selecteds[i] - i;
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                Integer codigo = (Integer) model.getValueAt(row, 0);
                ServicoProduto.excluirProduto(codigo);
                model.removeRow(row);
            }

            JOptionPane.showMessageDialog(rootPane, "Produtos Removidos com Sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotaoRemoverActionPerformed

    private void BotaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAlterarActionPerformed
        int selected = jTable1.getSelectedRow();
        if (jTable1.getSelectedRowCount() > 0) {
            try {
                if (telaCadastroProduto == null || !telaCadastroProduto.isDisplayable()) {
                    telaCadastroProduto = new CadastroProduto();
                    telaCadastroProduto.pack();
                    telaCadastroProduto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    telaCadastroProduto.setLocationRelativeTo(null);
                    telaCadastroProduto.setVisible(true);
                }
                telaCadastroProduto.toFront();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                Integer codigo = (Integer)model.getValueAt(selected, 0);
                Produto produto = ServicoProduto.buscarIdProduto(codigo);

                telaCadastroProduto.alterarProduto(produto);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_BotaoAlterarActionPerformed
    }

    private void atualizarTabela(ArrayList<Produto> produtos) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Produto produto : produtos) {
            Object[] row = {
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                "R$ " + produto.getPrecoCompra(),
                "R$ " + produto.getPrecoVenda(),
                produto.getQuantidade()
            };
            model.addRow(row);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAlterar;
    private javax.swing.JButton BotaoCancelar;
    private javax.swing.JButton BotaoConsultar;
    private javax.swing.JButton BotaoRemover;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldBuscaNome;
    // End of variables declaration//GEN-END:variables
}
