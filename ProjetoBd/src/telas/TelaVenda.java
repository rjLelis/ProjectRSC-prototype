/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JOptionPane;
import java.sql.*;
import conexao.ModuloConexao;
import java.text.DateFormat;

/**
 *
 * @author Lelis
 */
public class TelaVenda extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Creates new form TelaVenda
     */
    public TelaVenda() {
        conexao = ModuloConexao.conector();
        initComponents();
    }

    private void limparCampos() {
        txtProduto.setText(null);
        txtRepresentante.setText(null);
        txtCliente.setText(null);
        txtQuantidade.setText(null);
        txtPrevisao.setText(null);
        txtCondicoes.setText(null);
        txtFormaPagamento.setText(null);
        txtComissao.setText(null);
        txtDesconto.setText(null);
    }

    private void vender() {
        String sql = "INSERT INTO venda (quantidade,total_venda,previsao_pagamento,condicoes_pagamento,forma_pagamento,comissao,desconto,produto_id_produto,empresa_cliente_cnpj,representante_id_usuario)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtQuantidade.getText());
            pst.setString(2, txtTotal.getText());
            pst.setString(3, txtPrevisao.getText());
            pst.setString(4, txtCondicoes.getText());
            pst.setString(5, txtFormaPagamento.getText());
            pst.setString(6, txtComissao.getText());
            pst.setString(7, txtDesconto.getText());
            pst.setString(8, txtProduto.getText());
            pst.setString(9, txtCliente.getText());
            pst.setString(10, txtRepresentante.getText());
            if (txtTotal.getText().isEmpty() || txtRepresentante.getText().isEmpty() || txtProduto.getText().isEmpty() || txtCliente.getText().isEmpty()
                    || txtQuantidade.getText().isEmpty() || txtPrevisao.getText().isEmpty() || txtCondicoes.getText().isEmpty() || txtFormaPagamento.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios", "Atenção", JOptionPane.ERROR_MESSAGE);
            } else {
                if (txtDesconto.getText().isEmpty() || txtComissao.getText().isEmpty()) {
                    pst.setString(6, null);
                    pst.setString(7, null);
                }
                int cadastro = pst.executeUpdate();
                if (cadastro > 0) {
                    JOptionPane.showMessageDialog(null, "<html>Cliente: " + txtCliente.getText()
                            + "<br>Representante: " + txtRepresentante.getText()
                            + "<br>Quantidade: " + txtQuantidade.getText()
                            + "<br>Data de venda: " + txtData.getText()
                            + "<br>Forma de pagamento: " + txtFormaPagamento.getText()
                            + "<br>Precisão de pagamento: " + txtPrevisao.getText()
                            + "<br>Total da venda: " + txtTotal.getText(), "Detalhes da venda", JOptionPane.PLAIN_MESSAGE);
                    limparCampos();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private String procurarProduto(String id) {
        String sql = "Select * from produto where id_produto = ?";
        String preco = null;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtProduto.setText(rs.getString(1));
                preco = rs.getString(2);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum produto achado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            return null;
        }
        return preco;
    }

    private String procurarRepresentante(String id, int nu) {
        String sql = "Select * from representante where id_usuario = ?";
        String nome = null;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtRepresentante.setText(rs.getString(1));
                nome = rs.getString(3);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum representante achado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return nome;
    }

    private void procurarRepresentante(String email) {
        String sql = "Select * from representante where email = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtRepresentante.setText(rs.getString(1));
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum representante achado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private String procurarCliente(String id) {
        String sql = "Select * from empresa_cliente where cnpj = ?";
        String nome = null;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtCliente.setText(rs.getString(1));
                nome = rs.getString(2);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum cliente achado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return nome;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        btnProcurarProduto = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnProcurarCliente = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JTextField();
        txtCondicoes = new javax.swing.JTextField();
        txtComissao = new javax.swing.JTextField();
        txtFormaPagamento = new javax.swing.JTextField();
        txtDesconto = new javax.swing.JTextField();
        btnVender = new javax.swing.JButton();
        txtPrevisao = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txtRepresentante = new javax.swing.JTextField();
        btnRepresentante = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Nova venda");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("*Quantidade");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("*Previsao de pagamento");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("*Condições de pagamento");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("*Forma de pagamento");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Comissão");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Desconto");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("*Produto");

        btnProcurarProduto.setText("Procurar produto");
        btnProcurarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProcurarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarProdutoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("*Cliente");

        btnProcurarCliente.setText("Procurar cliente");
        btnProcurarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProcurarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarClienteActionPerformed(evt);
            }
        });

        btnVender.setText("Vender");
        btnVender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        try {
            txtPrevisao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("*Representante");

        btnRepresentante.setText("Procurar representante");
        btnRepresentante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRepresentante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepresentanteActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("*Total");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("*Data");

        txtData.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtComissao)
                                            .addComponent(txtCondicoes)
                                            .addComponent(txtQuantidade)
                                            .addComponent(txtFormaPagamento)
                                            .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel13)
                                                .addGap(28, 28, 28)
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPrevisao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRepresentante))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProcurarProduto)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnProcurarCliente))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurarProduto)
                    .addComponent(jLabel11)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRepresentante))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrevisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCondicoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVender)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        setBounds(0, 0, 580, 426);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcurarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarProdutoActionPerformed
        String procurado = JOptionPane.showInputDialog(this, "Digite o id do produto");
        procurarProduto(procurado);
    }//GEN-LAST:event_btnProcurarProdutoActionPerformed

    private void btnRepresentanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepresentanteActionPerformed
        String procurado = JOptionPane.showInputDialog(this, "Digite o E-mail do representante");
        procurarRepresentante(procurado);
    }//GEN-LAST:event_btnRepresentanteActionPerformed

    private void btnProcurarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarClienteActionPerformed
        String procurar = JOptionPane.showInputDialog(this, "Digite o CNPJ do cliente");
        procurarCliente(procurar);
    }//GEN-LAST:event_btnProcurarClienteActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        vender();
    }//GEN-LAST:event_btnVenderActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        java.util.Date data = new java.util.Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        txtData.setText(formatador.format(data));
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcurarCliente;
    private javax.swing.JButton btnProcurarProduto;
    private javax.swing.JButton btnRepresentante;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtComissao;
    private javax.swing.JTextField txtCondicoes;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtFormaPagamento;
    private javax.swing.JFormattedTextField txtPrevisao;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtRepresentante;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
