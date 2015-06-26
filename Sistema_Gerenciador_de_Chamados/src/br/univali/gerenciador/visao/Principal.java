
package br.univali.gerenciador.visao;

import br.univali.gerenciador.modelo.Consulta;
import javax.swing.table.DefaultTableModel;


public class Principal extends javax.swing.JFrame {


    DefaultTableModel modelo;

    public Principal() {
        initComponents();
        // Teste de conexão
        Consulta consulta = new Consulta();
        modelo = consulta.geraTabelaChamados();
        table_Chamados.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox();
        panel_Principal = new javax.swing.JPanel();
        scrollPane_Chamados = new javax.swing.JScrollPane();
        table_Chamados = new javax.swing.JTable();
        comboBox_Filtro = new javax.swing.JComboBox();
        textField_Buscar = new javax.swing.JTextField();
        botao_Buscar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menu_Gerenciar = new javax.swing.JMenu();
        menuItem_Programador = new javax.swing.JMenuItem();
        menuItem_Cliente = new javax.swing.JMenuItem();
        menuItem_Chamado = new javax.swing.JMenuItem();
        menuItem_Categoria = new javax.swing.JMenuItem();
        menuItem_Usuario = new javax.swing.JMenuItem();
        menu_Relatorio = new javax.swing.JMenu();
        menuItem_Relatorio1 = new javax.swing.JMenuItem();
        menuItem_Relatorio2 = new javax.swing.JMenuItem();
        menuItem_Relatorio3 = new javax.swing.JMenuItem();
        menu_Sobre = new javax.swing.JMenu();
        menu_Sair = new javax.swing.JMenu();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Chamados - Início");

        table_Chamados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Categoria", "Data", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Chamados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ChamadosMouseClicked(evt);
            }
        });
        scrollPane_Chamados.setViewportView(table_Chamados);

        comboBox_Filtro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Somente Abertos", "Somente Concluidos", "Todos" }));

        textField_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_BuscarActionPerformed(evt);
            }
        });

        botao_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/gerenciador/visao/imagens/Find 2.png"))); // NOI18N
        botao_Buscar.setText("Buscar");
        botao_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_PrincipalLayout = new javax.swing.GroupLayout(panel_Principal);
        panel_Principal.setLayout(panel_PrincipalLayout);
        panel_PrincipalLayout.setHorizontalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_PrincipalLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollPane_Chamados, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_PrincipalLayout.createSequentialGroup()
                        .addComponent(comboBox_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(98, 98, 98))
        );
        panel_PrincipalLayout.setVerticalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_Buscar)
                    .addComponent(textField_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(scrollPane_Chamados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        menu_Gerenciar.setText("Gerenciar");

        menuItem_Programador.setText("Programador");
        menuItem_Programador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_ProgramadorActionPerformed(evt);
            }
        });
        menu_Gerenciar.add(menuItem_Programador);

        menuItem_Cliente.setText("Cliente");
        menuItem_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_ClienteActionPerformed(evt);
            }
        });
        menu_Gerenciar.add(menuItem_Cliente);

        menuItem_Chamado.setText("Chamado");
        menuItem_Chamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_ChamadoActionPerformed(evt);
            }
        });
        menu_Gerenciar.add(menuItem_Chamado);

        menuItem_Categoria.setText("Categoria");
        menuItem_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_CategoriaActionPerformed(evt);
            }
        });
        menu_Gerenciar.add(menuItem_Categoria);

        menuItem_Usuario.setText("Usuário");
        menuItem_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_UsuarioActionPerformed(evt);
            }
        });
        menu_Gerenciar.add(menuItem_Usuario);

        menuBar.add(menu_Gerenciar);

        menu_Relatorio.setText("Relatórios");

        menuItem_Relatorio1.setText("Relatorio 1");
        menu_Relatorio.add(menuItem_Relatorio1);

        menuItem_Relatorio2.setText("Relatorio 2");
        menu_Relatorio.add(menuItem_Relatorio2);

        menuItem_Relatorio3.setText("Relatorio 3");
        menu_Relatorio.add(menuItem_Relatorio3);

        menuBar.add(menu_Relatorio);

        menu_Sobre.setText("Sobre");
        menuBar.add(menu_Sobre);

        menu_Sair.setText("Sair");
        menuBar.add(menu_Sair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItem_ChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_ChamadoActionPerformed
        Chamado chamado = new Chamado(this, true);
        chamado.setVisible(true);
    }//GEN-LAST:event_menuItem_ChamadoActionPerformed

    private void menuItem_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_UsuarioActionPerformed
        Usuario usuario = new Usuario(this,true);
        usuario.setVisible(true);
    }//GEN-LAST:event_menuItem_UsuarioActionPerformed

    private void menuItem_ProgramadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_ProgramadorActionPerformed
        Programador programador = new Programador(this,true);
        programador.setVisible(true);
    }//GEN-LAST:event_menuItem_ProgramadorActionPerformed

    private void textField_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_BuscarActionPerformed

    private void botao_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botao_BuscarActionPerformed

    private void menuItem_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_ClienteActionPerformed
        Cliente cliente = new Cliente(this,true);
        cliente.setVisible(true);
    }//GEN-LAST:event_menuItem_ClienteActionPerformed

    private void table_ChamadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ChamadosMouseClicked
        if (evt.getClickCount() == 2) {
            int id = Integer.parseInt((String) table_Chamados.getValueAt(table_Chamados.getSelectedRow(), 0));
            Chamado chamado = new Chamado(this, true, id);
            chamado.setVisible(true);
        }
    }//GEN-LAST:event_table_ChamadosMouseClicked

    private void menuItem_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_CategoriaActionPerformed
        Categoria categoria = new Categoria(this,true);
        categoria.setVisible(true);
    }//GEN-LAST:event_menuItem_CategoriaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_Buscar;
    private javax.swing.JComboBox comboBox_Filtro;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItem_Categoria;
    private javax.swing.JMenuItem menuItem_Chamado;
    private javax.swing.JMenuItem menuItem_Cliente;
    private javax.swing.JMenuItem menuItem_Programador;
    private javax.swing.JMenuItem menuItem_Relatorio1;
    private javax.swing.JMenuItem menuItem_Relatorio2;
    private javax.swing.JMenuItem menuItem_Relatorio3;
    private javax.swing.JMenuItem menuItem_Usuario;
    private javax.swing.JMenu menu_Gerenciar;
    private javax.swing.JMenu menu_Relatorio;
    private javax.swing.JMenu menu_Sair;
    private javax.swing.JMenu menu_Sobre;
    private javax.swing.JPanel panel_Principal;
    private javax.swing.JScrollPane scrollPane_Chamados;
    private javax.swing.JTable table_Chamados;
    private javax.swing.JTextField textField_Buscar;
    // End of variables declaration//GEN-END:variables
}
