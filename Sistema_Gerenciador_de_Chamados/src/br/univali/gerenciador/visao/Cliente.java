
package br.univali.gerenciador.visao;


public class Cliente extends javax.swing.JDialog {

    /**
     * Creates new form NovoCliente
     */
    public Cliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cliente dialog = new Cliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
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
        botao_Login6 = new javax.swing.JButton();
        botao_Login5 = new javax.swing.JButton();
        botao_Login3 = new javax.swing.JButton();
        botao_Login4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fild_User1 = new javax.swing.JTextField();
        label_Password = new javax.swing.JLabel();
        label_Login = new javax.swing.JLabel();
        fild_User = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Chamados - Clientes");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        jPanel1.setToolTipText("");
        jPanel1.setMaximumSize(new java.awt.Dimension(480, 420));
        jPanel1.setMinimumSize(new java.awt.Dimension(480, 420));
        jPanel1.setName("dfd"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(480, 420));

        botao_Login6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botao_Login6.setText("Novo");
        botao_Login6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_Login6ActionPerformed(evt);
            }
        });

        botao_Login5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botao_Login5.setText("Editar");
        botao_Login5.setEnabled(false);
        botao_Login5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_Login5ActionPerformed(evt);
            }
        });

        botao_Login3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botao_Login3.setText("Confirmar");
        botao_Login3.setEnabled(false);
        botao_Login3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_Login3ActionPerformed(evt);
            }
        });

        botao_Login4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botao_Login4.setText("Excluir");
        botao_Login4.setEnabled(false);
        botao_Login4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_Login4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "E-Mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        fild_User1.setEditable(false);
        fild_User1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fild_User1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fild_User1ActionPerformed(evt);
            }
        });

        label_Password.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        label_Password.setText("E-Mail");

        label_Login.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        label_Login.setText("Nome");

        fild_User.setEditable(false);
        fild_User.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fild_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fild_UserActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setToolTipText("");
        jSeparator1.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Clientes Cadastrados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_Login)
                            .addComponent(fild_User, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Password)
                            .addComponent(fild_User1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botao_Login6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(botao_Login5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(botao_Login4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(botao_Login3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(label_Login)
                .addGap(6, 6, 6)
                .addComponent(fild_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(label_Password)
                .addGap(6, 6, 6)
                .addComponent(fild_User1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_Login6)
                    .addComponent(botao_Login5)
                    .addComponent(botao_Login4)
                    .addComponent(botao_Login3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fild_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fild_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fild_UserActionPerformed

    private void fild_User1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fild_User1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fild_User1ActionPerformed

    private void botao_Login4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_Login4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botao_Login4ActionPerformed

    private void botao_Login3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_Login3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botao_Login3ActionPerformed

    private void botao_Login5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_Login5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botao_Login5ActionPerformed

    private void botao_Login6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_Login6ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botao_Login6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Login3;
    private javax.swing.JButton botao_Login4;
    private javax.swing.JButton botao_Login5;
    private javax.swing.JButton botao_Login6;
    private javax.swing.JTextField fild_User;
    private javax.swing.JTextField fild_User1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_Login;
    private javax.swing.JLabel label_Password;
    // End of variables declaration//GEN-END:variables
}
