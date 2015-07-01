package br.univali.gerenciador.visao;

import br.univali.gerenciador.modelo.Conexao;
import br.univali.gerenciador.modelo.Consulta;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Principal extends javax.swing.JFrame {

    DefaultTableModel modelo;
    int idSelecionado;
    int IDUser;
    Conexao con;
    Consulta consulta;

    public Principal() {
        initComponents();
        consulta = new Consulta();
        con = new Conexao();
        atualizaTabela(comboBox_Filtro.getSelectedItem().toString());
    }

    public void atualizaTabela(String filtro) {
        modelo = consulta.geraTabelaChamados(filtro);
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
        button_Excluir = new javax.swing.JButton();
        button_Novo = new javax.swing.JButton();
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
        jMenuItem1 = new javax.swing.JMenuItem();
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

        comboBox_Filtro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Concluidos", "Abertos", "Todos" }));
        comboBox_Filtro.setSelectedIndex(2);
        comboBox_Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_FiltroActionPerformed(evt);
            }
        });

        button_Excluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Excluir.setText("Excluir");
        button_Excluir.setEnabled(false);
        button_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ExcluirActionPerformed(evt);
            }
        });

        button_Novo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Novo.setText("Novo");
        button_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_NovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_PrincipalLayout = new javax.swing.GroupLayout(panel_Principal);
        panel_Principal.setLayout(panel_PrincipalLayout);
        panel_PrincipalLayout.setHorizontalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_PrincipalLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(scrollPane_Chamados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox_Filtro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_PrincipalLayout.createSequentialGroup()
                        .addComponent(button_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(button_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(239, 239, 239)))
                .addGap(97, 97, 97))
        );
        panel_PrincipalLayout.setVerticalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(comboBox_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane_Chamados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Excluir)
                    .addComponent(button_Novo))
                .addContainerGap(137, Short.MAX_VALUE))
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

        menuItem_Relatorio1.setText("Problemas reportados ano/mês");
        menuItem_Relatorio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_Relatorio1ActionPerformed(evt);
            }
        });
        menu_Relatorio.add(menuItem_Relatorio1);

        menuItem_Relatorio2.setText("Chamados/categoria");
        menuItem_Relatorio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_Relatorio2ActionPerformed(evt);
            }
        });
        menu_Relatorio.add(menuItem_Relatorio2);

        menuItem_Relatorio3.setText("Gasto/Cliente");
        menuItem_Relatorio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_Relatorio3ActionPerformed(evt);
            }
        });
        menu_Relatorio.add(menuItem_Relatorio3);

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_Relatorio.add(jMenuItem1);

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
        button_Novo.doClick();
    }//GEN-LAST:event_menuItem_ChamadoActionPerformed

    private void menuItem_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_UsuarioActionPerformed
        Usuario usuario = new Usuario(this, true);
        usuario.setVisible(true);
    }//GEN-LAST:event_menuItem_UsuarioActionPerformed

    private void menuItem_ProgramadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_ProgramadorActionPerformed
        Programador programador = new Programador(this, true);
        programador.setVisible(true);
    }//GEN-LAST:event_menuItem_ProgramadorActionPerformed

    private void menuItem_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_ClienteActionPerformed
        Cliente cliente = new Cliente(this, true);
        cliente.setVisible(true);
    }//GEN-LAST:event_menuItem_ClienteActionPerformed

    private void table_ChamadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ChamadosMouseClicked

        if (evt.getClickCount() == 1) {
            idSelecionado = Integer.parseInt((String) table_Chamados.getValueAt(table_Chamados.getSelectedRow(), 0));
            button_Excluir.setEnabled(true);
        }

        if (evt.getClickCount() == 2) {
            int id = Integer.parseInt((String) table_Chamados.getValueAt(table_Chamados.getSelectedRow(), 0));
            Chamado chamado = new Chamado(this, true, id);
            chamado.IDUser = IDUser;
            chamado.setVisible(true);
            atualizaTabela(comboBox_Filtro.getSelectedItem().toString());
        }

    }//GEN-LAST:event_table_ChamadosMouseClicked

    private void menuItem_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_CategoriaActionPerformed
        Categoria categoria = new Categoria(this, true);
        categoria.setVisible(true);
    }//GEN-LAST:event_menuItem_CategoriaActionPerformed

    private void button_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_NovoActionPerformed
        Chamado chamado = new Chamado(this, true, "novo");
        chamado.IDUser = IDUser;
        chamado.setVisible(true);
        atualizaTabela(comboBox_Filtro.getSelectedItem().toString());
    }//GEN-LAST:event_button_NovoActionPerformed

    private void button_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ExcluirActionPerformed
        con.removerChamado(idSelecionado);
        atualizaTabela(comboBox_Filtro.getSelectedItem().toString());
        button_Excluir.setEnabled(false);
    }//GEN-LAST:event_button_ExcluirActionPerformed

    private void comboBox_FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_FiltroActionPerformed
        atualizaTabela(comboBox_Filtro.getSelectedItem().toString());
    }//GEN-LAST:event_comboBox_FiltroActionPerformed

    private void menuItem_Relatorio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_Relatorio1ActionPerformed
        JasperPrint jasperPrint = null;
        try {
            HashMap map = new HashMap();
            String arquivoJasper = "relatorios/Problemas Reportados por mes.jasper";
            jasperPrint = JasperFillManager.fillReport(arquivoJasper, new HashMap(), con.relatorioProblemasReportados());
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        JasperViewer.viewReport(jasperPrint, false);
        
    }//GEN-LAST:event_menuItem_Relatorio1ActionPerformed

    private void menuItem_Relatorio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_Relatorio3ActionPerformed
        JasperPrint jasperPrint = null;
        try {
            HashMap map = new HashMap();
            String arquivoJasper = "relatorios/Gasto por Cliente.jasper";
            jasperPrint = JasperFillManager.fillReport(arquivoJasper, new HashMap(), con.relatorioGastoCliente());
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        JasperViewer.viewReport(jasperPrint, false);
    }//GEN-LAST:event_menuItem_Relatorio3ActionPerformed

    private void menuItem_Relatorio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_Relatorio2ActionPerformed
        JasperPrint jasperPrint = null;
        HashMap map = new HashMap();
        String arquivoJasper = "relatorios/Gasto por Categoria.jasper";
        try {
            jasperPrint = JasperFillManager.fillReport(arquivoJasper, new HashMap(), con.relatorioGastoProblema());
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer.viewReport(jasperPrint, false);
    }//GEN-LAST:event_menuItem_Relatorio2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DatasRelatorio datasRelatorio = new DatasRelatorio(this,true);
        datasRelatorio.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JButton button_Excluir;
    private javax.swing.JButton button_Novo;
    private javax.swing.JComboBox comboBox_Filtro;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JMenuItem jMenuItem1;
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
    // End of variables declaration//GEN-END:variables
}
