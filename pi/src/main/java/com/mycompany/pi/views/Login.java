package com.mycompany.pi.views;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.UIManager;

/**
 *
 * @author brand
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form CadastroLogin
     */
    public Login() {
        initComponents();
        acessarBtn.setEnabled(false);
        Color vermelho = new Color(255, 128, 128);
        msgValidacaoUsuario.setForeground(vermelho); // mudando a cor da mensagem de validação
        msgValidacaoUsuario.setVisible(false);
        msgValidacaoSenha.setForeground(vermelho);
        msgValidacaoSenha.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        acessarBtn = new javax.swing.JButton();
        senhaTxt = new javax.swing.JPasswordField();
        usuarioTxt = new javax.swing.JTextField();
        sairBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        msgValidacaoUsuario = new javax.swing.JLabel();
        msgValidacaoSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("Usuário:");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel2.setText("Senha:");

        acessarBtn.setText("Acessar");
        acessarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acessarBtnActionPerformed(evt);
            }
        });

        senhaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaTxtActionPerformed(evt);
            }
        });
        senhaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                senhaTxtKeyReleased(evt);
            }
        });

        usuarioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioTxtKeyReleased(evt);
            }
        });

        sairBtn.setBackground(new java.awt.Color(51, 51, 51));
        sairBtn.setText("Sair");
        sairBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Dados de Autenticação");

        msgValidacaoUsuario.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        msgValidacaoUsuario.setText("Usuário necessita ser maior que 5 caracteres.");

        msgValidacaoSenha.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        msgValidacaoSenha.setText("Senha necessita ser maior que 5 caracteres.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(senhaTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(usuarioTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(msgValidacaoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(msgValidacaoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(sairBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(acessarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(164, 164, 164))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 472, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgValidacaoUsuario)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(senhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgValidacaoSenha)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sairBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acessarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioTxtKeyReleased
        verificaCamposHabilitaBotao();
    }//GEN-LAST:event_usuarioTxtKeyReleased

    private void senhaTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaTxtKeyReleased
        verificaCamposHabilitaBotao();
    }//GEN-LAST:event_senhaTxtKeyReleased

    private void sairBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sairBtnActionPerformed
        dispose();
    }// GEN-LAST:event_sairBtnActionPerformed

    private void acessarBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_acessarBtnActionPerformed
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setExtendedState(TelaInicial.MAXIMIZED_BOTH);
        telaInicial.setVisible(true);
        DashboardCliente dashBoardCliente = new DashboardCliente();
        dashBoardCliente.setLocationRelativeTo(null);
        dashBoardCliente.setVisible(true);
        dispose();
    }// GEN-LAST:event_acessarBtnActionPerformed

    private void senhaTxtActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_senhaTxtActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_senhaTxtActionPerformed

    private void verificaCamposHabilitaBotao() {
        String usuario = usuarioTxt.getText().trim();
        String senha = new String(senhaTxt.getPassword()).trim();
        boolean senhaOk = senha.length() >= 5 && !senha.isEmpty();
        Color vermelho = new Color(255, 128, 128);
        boolean camposValidos = true;
        
        if (usuario.length() < 5 || usuario.isEmpty()) {
            usuarioTxt.setBorder(BorderFactory.createLineBorder(vermelho));
            msgValidacaoUsuario.setVisible(true);
            camposValidos = false;
        } else {
            usuarioTxt.setBorder(UIManager.getBorder("TextField.border"));
            msgValidacaoUsuario.setVisible(false);
        }
        
        if (!senhaOk) {
            senhaTxt.setBorder(BorderFactory.createLineBorder(vermelho));
            msgValidacaoSenha.setVisible(true);
            camposValidos = false;
        } else {
            senhaTxt.setBorder(UIManager.getBorder("TextField.border"));
            msgValidacaoSenha.setVisible(false);
        }
        
        acessarBtn.setEnabled(camposValidos);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acessarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel msgValidacaoSenha;
    private javax.swing.JLabel msgValidacaoUsuario;
    private javax.swing.JButton sairBtn;
    private javax.swing.JPasswordField senhaTxt;
    private javax.swing.JTextField usuarioTxt;
    // End of variables declaration//GEN-END:variables
}
