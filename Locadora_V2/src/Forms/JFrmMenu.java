package Forms;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JFrmMenu extends javax.swing.JFrame {

    public JFrmMenu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBMenu = new javax.swing.JMenuBar();
        JArquivo = new javax.swing.JMenu();
        jExit = new javax.swing.JMenuItem();
        JCadastrar = new javax.swing.JMenu();
        jAutor = new javax.swing.JMenuItem();
        jCliente = new javax.swing.JMenuItem();
        jDiretor = new javax.swing.JMenuItem();
        jFornecedor = new javax.swing.JMenuItem();
        jMidia = new javax.swing.JMenuItem();
        JMovimento = new javax.swing.JMenu();
        jDevolucao = new javax.swing.JMenuItem();
        jLocacao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JArquivo.setText("Arquivo");

        jExit.setText("Exit");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });
        JArquivo.add(jExit);

        jBMenu.add(JArquivo);

        JCadastrar.setText("Cadastro");

        jAutor.setText("Autor");
        jAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAutorActionPerformed(evt);
            }
        });
        JCadastrar.add(jAutor);

        jCliente.setText("Cliente");
        jCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClienteActionPerformed(evt);
            }
        });
        JCadastrar.add(jCliente);

        jDiretor.setText("Diretor");
        jDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDiretorActionPerformed(evt);
            }
        });
        JCadastrar.add(jDiretor);

        jFornecedor.setText("Fornecedor");
        jFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFornecedorActionPerformed(evt);
            }
        });
        JCadastrar.add(jFornecedor);

        jMidia.setText("Midia");
        jMidia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMidiaActionPerformed(evt);
            }
        });
        JCadastrar.add(jMidia);

        jBMenu.add(JCadastrar);

        JMovimento.setText("Movimento");

        jDevolucao.setText("Devolução");
        jDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDevolucaoActionPerformed(evt);
            }
        });
        JMovimento.add(jDevolucao);

        jLocacao.setText("Locação");
        jLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLocacaoActionPerformed(evt);
            }
        });
        JMovimento.add(jLocacao);

        jBMenu.add(JMovimento);

        setJMenuBar(jBMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAutorActionPerformed
        JFrmAutor dialog = new JFrmAutor();
        dialog.setVisible(true);
    }//GEN-LAST:event_jAutorActionPerformed

    private void jClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClienteActionPerformed
        JFrmCliente dialog = new JFrmCliente();
        dialog.setVisible(true);
    }//GEN-LAST:event_jClienteActionPerformed

    private void jDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDiretorActionPerformed
        JFrmDiretor dialog = new JFrmDiretor();
        dialog.setVisible(true);
    }//GEN-LAST:event_jDiretorActionPerformed

    private void jFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFornecedorActionPerformed
        JFrmFornecedor dialog = new JFrmFornecedor();
        dialog.setVisible(true);
    }//GEN-LAST:event_jFornecedorActionPerformed

    private void jMidiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMidiaActionPerformed
        JFrmMidia dialog = new JFrmMidia();
        dialog.setVisible(true);
    }//GEN-LAST:event_jMidiaActionPerformed

    private void jDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDevolucaoActionPerformed
        JFrmDevolucao dialog = new JFrmDevolucao();
        dialog.setVisible(true);
    }//GEN-LAST:event_jDevolucaoActionPerformed

    private void jLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLocacaoActionPerformed
        JFrmLocacao dialog = new JFrmLocacao();
        dialog.setVisible(true);
    }//GEN-LAST:event_jLocacaoActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        dispose();
    }//GEN-LAST:event_jExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(null, "Deseja sair",null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try{
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
                }catch(Exception ex){}
                new JFrmMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JArquivo;
    private javax.swing.JMenu JCadastrar;
    private javax.swing.JMenu JMovimento;
    private javax.swing.JMenuItem jAutor;
    private javax.swing.JMenuBar jBMenu;
    private javax.swing.JMenuItem jCliente;
    private javax.swing.JMenuItem jDevolucao;
    private javax.swing.JMenuItem jDiretor;
    private javax.swing.JMenuItem jExit;
    private javax.swing.JMenuItem jFornecedor;
    private javax.swing.JMenuItem jLocacao;
    private javax.swing.JMenuItem jMidia;
    // End of variables declaration//GEN-END:variables
}
