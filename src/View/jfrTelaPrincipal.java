package View;

import Controller.ControllerLista;

public class jfrTelaPrincipal extends javax.swing.JFrame {

    public jfrTelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jButtonSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jButtonAddTarefa = new javax.swing.JMenuItem();
        jButtonListarTarefas = new javax.swing.JMenuItem();
        jButtonProcurarID = new javax.swing.JMenuItem();
        jAtualizarTarefa = new javax.swing.JMenuItem();
        jExcluirTarefa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jMenu1.setText("Sair");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jMenu1.add(jButtonSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tarefas");

        jButtonAddTarefa.setText("Adicionar Tarefa");
        jButtonAddTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTarefaActionPerformed(evt);
            }
        });
        jMenu2.add(jButtonAddTarefa);

        jButtonListarTarefas.setText("Listar Tarefas");
        jButtonListarTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarTarefasActionPerformed(evt);
            }
        });
        jMenu2.add(jButtonListarTarefas);

        jButtonProcurarID.setText("Procurar por ID");
        jButtonProcurarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcurarIDActionPerformed(evt);
            }
        });
        jMenu2.add(jButtonProcurarID);

        jAtualizarTarefa.setText("Atualizar Tarefa");
        jAtualizarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtualizarTarefaActionPerformed(evt);
            }
        });
        jMenu2.add(jAtualizarTarefa);

        jExcluirTarefa.setText("Excluir Tarefa");
        jExcluirTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExcluirTarefaActionPerformed(evt);
            }
        });
        jMenu2.add(jExcluirTarefa);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTarefaActionPerformed
        jfrAdicionarLista addLista = new jfrAdicionarLista();
        addLista.setVisible(true);
    }//GEN-LAST:event_jButtonAddTarefaActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonListarTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarTarefasActionPerformed
        ControllerLista controllerLista = new ControllerLista();
        controllerLista.mostrarLista();
    }//GEN-LAST:event_jButtonListarTarefasActionPerformed

    private void jButtonProcurarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProcurarIDActionPerformed
        jfrProcurarIDLista procuraIDLista = new jfrProcurarIDLista();
        procuraIDLista.setVisible(true);
    }//GEN-LAST:event_jButtonProcurarIDActionPerformed

    private void jAtualizarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtualizarTarefaActionPerformed
        jfrAtualizarLista atualizarLista = new jfrAtualizarLista();
        atualizarLista.setVisible(true);
    }//GEN-LAST:event_jAtualizarTarefaActionPerformed

    private void jExcluirTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirTarefaActionPerformed
        jfrExcluirLista excluirLista = new jfrExcluirLista();
        excluirLista.setVisible(true);
    }//GEN-LAST:event_jExcluirTarefaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrTelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAtualizarTarefa;
    private javax.swing.JMenuItem jButtonAddTarefa;
    private javax.swing.JMenuItem jButtonListarTarefas;
    private javax.swing.JMenuItem jButtonProcurarID;
    private javax.swing.JMenuItem jButtonSair;
    private javax.swing.JMenuItem jExcluirTarefa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
