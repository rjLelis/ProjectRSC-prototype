/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import conexao.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lelis
 */
public class TelaRepresentante extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Creates new form TelaUsuario
     */
    public TelaRepresentante() {
        conexao = ModuloConexao.conector();
        initComponents();
    }

    private void limparCampos() {
        txtIdUsuario.setText(null);
        txtNome.setText(null);
        txtEmail.setText(null);
        txtSenha.setText(null);
        txtTelefone.setText(null);
        txtBairro.setText(null);
        txtCep.setText(null);
        txtCidade.setText(null);
        txtIdSupervisor.setText(null);
        btnCadastrar.setEnabled(true);
    }

    private void cadastrar() {
        String sql = "INSERT INTO representante (senha,nome,telefone,email,CEP,bairro,cidade,representante_id_usuario)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtSenha.getText());
            pst.setString(2, txtNome.getText());
            pst.setString(3, txtTelefone.getText());
            pst.setString(4, txtEmail.getText());
            pst.setString(5, txtCep.getText());
            pst.setString(6, txtBairro.getText());
            pst.setString(7, txtCidade.getText());
            pst.setString(8, txtIdSupervisor.getText());
            if (txtNome.getText().isEmpty() || txtEmail.getText().isEmpty()
                    || txtSenha.getText().isEmpty() || txtBairro.getText().isEmpty() || txtCep.getText().isEmpty() || txtCidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios", "Atenção", JOptionPane.ERROR_MESSAGE);
            } else {
                if (txtIdSupervisor.getText().isEmpty()) {
                    pst.setString(8, null);
                }
                int cadastro = pst.executeUpdate();
                if (cadastro > 0) {
                    JOptionPane.showMessageDialog(this, "Representante cadastrado com sucesso", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                    limparCampos();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void remover(String email) {
        String sql = "DELETE FROM representante where email = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, email);
            int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este representante?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                int remover = pst.executeUpdate();
                if (remover > 0) {
                    JOptionPane.showMessageDialog(this, "Representante removido com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void procurar(String email) {
        String sql = "Select * from representante where email = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtIdUsuario.setText(rs.getString(1));
                txtSenha.setText(rs.getString(2));
                txtNome.setText(rs.getString(3));
                txtTelefone.setText(rs.getString(4));
                txtEmail.setText(rs.getString(5));
                txtCep.setText(rs.getString(6));
                txtBairro.setText(rs.getString(7));
                txtCidade.setText(rs.getString(8));
                txtIdSupervisor.setText(rs.getString(10));
                btnCadastrar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum representante achado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void atualizar() {
        String sql = "UPDATE representante SET senha = ?, nome = ?, telefone = ?, email = ?, CEP = ?, bairro = ?, cidade = ?, representante_id_usuario = ? WHERE id_usuario = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtSenha.getText());
            pst.setString(2, txtNome.getText());
            pst.setString(3, txtTelefone.getText());
            pst.setString(4, txtEmail.getText());
            pst.setString(5, txtCep.getText());
            pst.setString(6, txtBairro.getText());
            pst.setString(7, txtCidade.getText());
            pst.setString(8, txtIdSupervisor.getText());
            pst.setString(9, txtIdUsuario.getText());
            if (txtNome.getText().isEmpty() || txtEmail.getText().isEmpty()
                    || txtSenha.getText().isEmpty() || txtBairro.getText().isEmpty() || txtCep.getText().isEmpty() || txtCidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios", "Atenção", JOptionPane.ERROR_MESSAGE);
            } else {
                if (txtIdSupervisor.getText().isEmpty()) {
                    pst.setString(8, null);
                }
                int cadastro = pst.executeUpdate();
                if (cadastro > 0) {
                    JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                    limparCampos();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        llblSenha = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCidade = new javax.swing.JTextField();
        lblObg = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        lblCoordenadas = new javax.swing.JLabel();
        lblIdSupervisor = new javax.swing.JLabel();
        txtCoordenadas = new javax.swing.JFormattedTextField();
        txtIdSupervisor = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        lblIdUsuario = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setTitle("Cadastro de Representante");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("*Nome");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmail.setText("*E-mail");

        llblSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        llblSenha.setText("*Senha");

        lblCep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCep.setText("*CEP");

        lblCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCidade.setText("*Cidade");

        lblBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBairro.setText("*Bairro");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblObg.setText("* Campos obrigatórios");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblCoordenadas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCoordenadas.setText("Coordenadas");

        lblIdSupervisor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIdSupervisor.setText("Id do supervisor");

        try {
            txtCoordenadas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCoordenadas.setEnabled(false);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnProcurar.setText("Procurar");
        btnProcurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProcurar.setDefaultCapable(false);
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        btnLimparCampos.setText("Limpar campos");
        btnLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        lblIdUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIdUsuario.setText("ID");

        txtIdUsuario.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(llblSenha)
                            .addComponent(lblCidade))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtIdSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(99, 99, 99)
                                .addComponent(btnLimparCampos)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIdSupervisor)
                        .addGap(77, 467, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblObg))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTelefone)
                                            .addComponent(lblBairro))
                                        .addGap(266, 266, 266)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCoordenadas)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCoordenadas))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCep)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(309, 309, 309)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblIdUsuario)
                                            .addComponent(lblNome))
                                        .addGap(33, 33, 33)
                                        .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 71, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblObg)
                        .addGap(38, 38, 38)
                        .addComponent(btnLimparCampos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdUsuario)
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(llblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCep)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCoordenadas)
                    .addComponent(txtCoordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdSupervisor)
                    .addComponent(txtIdSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnCadastrar)
                    .addComponent(btnProcurar)
                    .addComponent(btnAtualizar))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        setBounds(0, 0, 580, 426);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        String deletado = JOptionPane.showInputDialog(this, "Digite o E-mail do representante para exclui-lo");
        remover(deletado);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        String procurar = JOptionPane.showInputDialog(this, "Digite o E-mail do representante");
        procurar(procurar);
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCoordenadas;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIdSupervisor;
    private javax.swing.JLabel lblIdUsuario;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblObg;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel llblSenha;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCoordenadas;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdSupervisor;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
