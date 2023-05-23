/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pi.views;

import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.mycompany.pi.database.ClientesDAO;

/**
 *
 * @author igor
 */
public class AlteraCliente extends javax.swing.JFrame {

    /**
     * Creates new form AlteraCliente
     */
    public AlteraCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        selecionaEstado = new javax.swing.JComboBox<>();
        cadastrarBtn = new javax.swing.JButton();
        txtCidade = new javax.swing.JTextField();
        txtNumero = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        msgValidacao = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        cancelaAlteracaoCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Cliente");

        jLabel2.setText("Nome:");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jLabel4.setText("Email:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        jLabel3.setText("Rua:");

        txtRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRuaActionPerformed(evt);
            }
        });
        txtRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRuaKeyReleased(evt);
            }
        });

        jLabel5.setText("Número:");

        jLabel6.setText("Cidade:");

        jLabel7.setText("Estado:");

        selecionaEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito ", "Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));
        selecionaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionaEstadoActionPerformed(evt);
            }
        });

        cadastrarBtn.setText("Salvar");
        cadastrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBtnActionPerformed(evt);
            }
        });

        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCidadeKeyReleased(evt);
            }
        });

        txtNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroKeyReleased(evt);
            }
        });

        jLabel12.setText("Telefone:");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyReleased(evt);
            }
        });

        jLabel13.setText("CPF:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCpfKeyReleased(evt);
            }
        });

        cancelaAlteracaoCliente.setBackground(new java.awt.Color(51, 51, 51));
        cancelaAlteracaoCliente.setText("Cancelar");
        cancelaAlteracaoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaAlteracaoClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtRua, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(selecionaEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cadastrarBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtCidade, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtNumero, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(msgValidacao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtCpf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cancelaAlteracaoCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtId, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msgValidacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(cancelaAlteracaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(24, 24, 24)
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(22, 22, 22)
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(51, 51, 51)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(selecionaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(21, 21, 21)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(selecionaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(msgValidacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelaAlteracaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Color vermelho = new Color(255, 128, 128); // vermelho mais claro
    private void msgValidacao(String mensagem) {
        Font globalFont = UIManager.getFont("Label.font");
        int fontSize = 14;
        Font labelFont = new Font(globalFont.getFontName(), globalFont.getStyle(), fontSize);
        msgValidacao.setFont(labelFont);
        msgValidacao.setForeground(vermelho);
        msgValidacao.setText(mensagem);
    }
    
    private boolean validaNome() {
        String nome = txtNome.getText();
        Pattern regex = Pattern.compile("^[\\p{L}\\s]+$"); // regex para verificar que o campo só tenha string
        Matcher matcher = regex.matcher(nome);
        boolean nomeOk = false;

        if (nome.isEmpty() || nome.length() < 5) {
            txtNome.setBorder(BorderFactory.createLineBorder(vermelho));
            msgValidacao("O campo nome necessita ser maior que 5 caracteres.");
        } else if (!matcher.matches()) {
            txtNome.setBorder(BorderFactory.createLineBorder(vermelho));
            msgValidacao("Símbolos ou números não são permitidos.");
        } else {
            txtNome.setBorder(UIManager.getBorder("TextField.border"));
            msgValidacao("");
            nomeOk = true;
        }
        return nomeOk;
    }

    private boolean validaCpf() {
        String cpf = txtCpf.getText();
        Pattern regex = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"); // regex para verificar formato CPF
        Matcher matcher = regex.matcher(cpf);
        boolean cpfOk = false;

        if (cpf.isEmpty()) {
            txtCpf.setBorder(BorderFactory.createLineBorder(vermelho));
            msgValidacao("O campo CPF não pode estar vazio!");
        } else {
            txtCpf.setBorder(UIManager.getBorder("TextField.border"));
            cpfOk = true;
            msgValidacao("");
        }
        return cpfOk;
    }

    private boolean validaRua() {
        String rua = txtRua.getText();
        Pattern regex = Pattern.compile("^[\\p{L}\\s]+$"); // regex para verificar que o campo só tenha string
        Matcher matcher = regex.matcher(rua);
        boolean ruaOk = false;

        if (rua.isEmpty() || rua.length() < 5) {
            msgValidacao("O campo rua necessita ser maior que 5 caracteres.");
        } else if (!matcher.matches()) {
            txtRua.setBorder(BorderFactory.createLineBorder(vermelho));
            msgValidacao("Símbolos ou números não são permitidos.");
        } else {
            txtRua.setBorder(UIManager.getBorder("TextField.border"));
            msgValidacao("");
            ruaOk = true;
        }
        return ruaOk;
    }

    private boolean validaCidade() {
        String cidade = txtCidade.getText();
        Pattern regex = Pattern.compile("^[\\p{L}\\s]+$");
        Matcher matcher = regex.matcher(cidade);
        boolean cidadeOk = false;

        if (cidade.isEmpty()) {
            msgValidacao("O campo cidade não pode ser vazio.");
        } else if (!matcher.matches()) {
            txtCidade.setBorder(BorderFactory.createLineBorder(vermelho));
            msgValidacao("Símbolos ou números não são permitidos.");
        } else {
            txtCidade.setBorder(UIManager.getBorder("TextField.border"));
            msgValidacao("");
            cidadeOk = true;
        }
        return cidadeOk;
    }

    private boolean validaEmail() {
        String email = txtEmail.getText();
        Pattern regex = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"); // regex para validar endereço de email
        Matcher matcher = regex.matcher(email);
        boolean emailOk = false;

        if (email.isEmpty()) {
            msgValidacao("O campo email não pode ser vazio.");
        } else if (!matcher.matches()) {
            txtEmail.setBorder(BorderFactory.createLineBorder(vermelho));
            msgValidacao("Digite um endereço de email válido.");
        } else {
            txtEmail.setBorder(UIManager.getBorder("TextField.border"));
            msgValidacao("");
            emailOk = true;
        }
        return emailOk;
    }

    private boolean validaNumero() {
        String numero = txtNumero.getText();
        Pattern regex = Pattern.compile("^[0-9]+$");
        Matcher matcher = regex.matcher(numero);
        boolean numeroOk = false;

        if (numero.isEmpty()) {
            msgValidacao("O campo número não pode ser vazio.");
        } else if (!matcher.matches()) {
            txtNumero.setBorder(BorderFactory.createLineBorder(vermelho));
            msgValidacao("Digite apenas números.");
        } else {
            txtNumero.setBorder(UIManager.getBorder("TextField.border"));
            msgValidacao("");
            numeroOk = true;
        }
        return numeroOk;
    }

    private boolean validaTelefone() {
        String telefone = txtTelefone.getText();
        Pattern regex = Pattern.compile("^\\(\\d{2}\\) \\d{5}-\\d{4}$"); // regex para verificar formato de telefone
        Matcher matcher = regex.matcher(telefone);
        boolean telefoneOk = false;

        if (!matcher.matches()) {
            txtTelefone.setBorder(BorderFactory.createLineBorder(vermelho));
        } else {
            txtTelefone.setBorder(UIManager.getBorder("TextField.border"));
            telefoneOk = true;
        }
        return telefoneOk;
    }
    
    public JComboBox<String> getComboBoxSelecionaEstado() {
        return selecionaEstado;
    }

    public void setTxtId(String valor) {
        txtId.setText(valor);
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtNome(String valor) {
        txtNome.setText(valor);
    }

    public void setTxtCpf(String valor) {
        txtCpf.setText(valor);
    }

    public void setTxtEmail(String valor) {
        txtEmail.setText(valor);
    }

    public void setTxtRua(String valor) {
        txtRua.setText(valor);
    }

    public void setTxtNumero(String valor) {
        txtNumero.setText(valor);
    }

    public void setTxtCidade(String valor) {
        txtCidade.setText(valor);
    }
 
    public void setTxtTelefone(String valor) {
        txtTelefone.setText(valor);
    }

    private void cancelaAlteracaoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaAlteracaoClienteActionPerformed
        dispose();
    }//GEN-LAST:event_cancelaAlteracaoClienteActionPerformed

    private void txtCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyReleased
        validaCpf();
    }//GEN-LAST:event_txtCpfKeyReleased

    private void txtTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyReleased
        validaTelefone();
    }//GEN-LAST:event_txtTelefoneKeyReleased

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        validaNumero();
    }//GEN-LAST:event_txtNumeroKeyReleased

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void txtCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyReleased
        validaCidade();
    }//GEN-LAST:event_txtCidadeKeyReleased

    private void cadastrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBtnActionPerformed
        try {
            int id_cliente = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String CPF = txtCpf.getText();
            String email = txtEmail.getText();
            String rua = txtRua.getText();
            int numero = Integer.parseInt(txtNumero.getText());
            String cidade = txtCidade.getText();
            String estadoSelecionado = (String) selecionaEstado.getSelectedItem();
            String telefone = txtTelefone.getText();

            if (validaNome() && validaCpf() && validaEmail() && validaRua() && validaNumero() && validaCidade() && validaTelefone()) {
                ClientesDAO dao = new ClientesDAO();
                dao.alterarCliente(id_cliente, nome, CPF, email, rua, numero, cidade, estadoSelecionado, telefone, evt);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha os campos 'Número', 'CPF' e 'Telefone' com valores numéricos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cadastrarBtnActionPerformed

    private void selecionaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionaEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecionaEstadoActionPerformed

    private void txtRuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRuaKeyReleased
        validaRua();
    }//GEN-LAST:event_txtRuaKeyReleased

    private void txtRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRuaActionPerformed

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        validaEmail();
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        validaNome();
    }//GEN-LAST:event_txtNomeKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlteraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlteraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlteraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlteraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarBtn;
    private javax.swing.JButton cancelaAlteracaoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLabel msgValidacao;
    private javax.swing.JComboBox<String> selecionaEstado;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtNumero;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
