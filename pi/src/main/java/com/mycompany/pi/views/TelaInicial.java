/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pi.views;

import javax.swing.JFrame;

/**
 *
 * @author igor
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrirDashboardCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        abrirDashboardProduto = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        abrirTelaVenda = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        abrirRelatorioAnalitico = new javax.swing.JMenuItem();
        abrirRelatorioSintetico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Nimbus Sans", 0, 36)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(579, 56));

        jMenu1.setText("Cliente");
        jMenu1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(3, 8, 3, 8));

        abrirDashboardCliente.setText("Painel de Clientes");
        abrirDashboardCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirDashboardClienteActionPerformed(evt);
            }
        });
        jMenu1.add(abrirDashboardCliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Produtos");
        jMenu2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(3, 8, 3, 8));

        abrirDashboardProduto.setText("Painel de Produtos");
        abrirDashboardProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirDashboardProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(abrirDashboardProduto);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Vendas");
        jMenu3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jMenu3.setMargin(new java.awt.Insets(3, 8, 3, 8));

        abrirTelaVenda.setText("Efetuar Venda");
        abrirTelaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirTelaVendaActionPerformed(evt);
            }
        });
        jMenu3.add(abrirTelaVenda);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Relatórios");
        jMenu4.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jMenu4.setMargin(new java.awt.Insets(3, 8, 3, 8));

        abrirRelatorioAnalitico.setText("Analítico");
        abrirRelatorioAnalitico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirRelatorioAnaliticoActionPerformed(evt);
            }
        });
        jMenu4.add(abrirRelatorioAnalitico);

        abrirRelatorioSintetico.setText("Sintético");
        abrirRelatorioSintetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirRelatorioSinteticoActionPerformed(evt);
            }
        });
        jMenu4.add(abrirRelatorioSintetico);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirDashboardProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirDashboardProdutoActionPerformed
        DashboardProduto dashBoardProduto = new DashboardProduto();
        dashBoardProduto.setLocationRelativeTo(this);
        dashBoardProduto.setVisible(true);
    }//GEN-LAST:event_abrirDashboardProdutoActionPerformed

    private void abrirDashboardClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirDashboardClienteActionPerformed
        DashboardCliente dashBoardCliente = new DashboardCliente();
        dashBoardCliente.setLocationRelativeTo(this);
        dashBoardCliente.setVisible(true);
    }//GEN-LAST:event_abrirDashboardClienteActionPerformed

    private void abrirTelaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirTelaVendaActionPerformed
        Venda venda = new Venda();
        venda.setLocationRelativeTo(null);
        venda.setVisible(true);
    }//GEN-LAST:event_abrirTelaVendaActionPerformed

    private void abrirRelatorioAnaliticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirRelatorioAnaliticoActionPerformed
        RelatorioAnalitico relatorioAnalitico = new RelatorioAnalitico();
        relatorioAnalitico.setLocationRelativeTo(this);
        relatorioAnalitico.setVisible(true);
    }//GEN-LAST:event_abrirRelatorioAnaliticoActionPerformed

    private void abrirRelatorioSinteticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirRelatorioSinteticoActionPerformed
        RelatorioSintetico relatorioSintetico = new RelatorioSintetico();
        relatorioSintetico.setLocationRelativeTo(this);
        relatorioSintetico.setVisible(true);
    }//GEN-LAST:event_abrirRelatorioSinteticoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        TelaInicial telaInicial = new TelaInicial();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaInicial.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirDashboardCliente;
    private javax.swing.JMenuItem abrirDashboardProduto;
    private javax.swing.JMenuItem abrirRelatorioAnalitico;
    private javax.swing.JMenuItem abrirRelatorioSintetico;
    private javax.swing.JMenuItem abrirTelaVenda;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
