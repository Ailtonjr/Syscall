/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.gerenciador.visao;

import br.univali.gerenciador.modelo.Consulta;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iPotter
 */
public class Chamado extends javax.swing.JDialog {

    /**
     * Creates new form Chamado
     */
    private DefaultTableModel modelo;


    public Chamado(java.awt.Frame parent, boolean modal, int numChamado) {
        super(parent, modal);
        initComponents();
        // Teste de conexão
        Consulta consulta = new Consulta();
        modelo = consulta.geraTabelaTopicos(numChamado);
        exibeListaClientes(consulta.geraListaClientes());
        exibeListaCategorias(consulta.geraListaCategorias());
        exibeChamado(consulta.geraVisaoChamado(numChamado));
        tabela_chamado.setModel(modelo);
    }

    public Chamado(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void exibeChamado(String[] vetor) {
        //System.out.println(vetor[0]);
        comboBox_Cliente.setSelectedItem(vetor[0]);
        comboBox_Categoria.setSelectedItem(vetor[1]);
        formatted_Data.setText(vetor[2]);
        formatted_Hora.setText(vetor[3]);
        if (vetor[4].equalsIgnoreCase("aberto")) {
            label_Status.setForeground(new Color(0, 153, 0));
        } else {
            label_Status.setForeground(new Color(204, 0, 0));
        }
        label_Status.setText(vetor[4]);

        textArea_Descricao.setText(vetor[5]);

    }
    
    private void exibeListaClientes(List<String> lista){
        for (String item : lista) {
           comboBox_Cliente.addItem(item); 
        }
    }
    
    private void exibeListaCategorias(List<String> lista){
        for (String item : lista) {
           comboBox_Categoria.addItem(item); 
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

        panel_fundo = new javax.swing.JPanel();
        label_Cliente = new javax.swing.JLabel();
        label_Categoria = new javax.swing.JLabel();
        label_Data = new javax.swing.JLabel();
        formatted_Data = new javax.swing.JFormattedTextField();
        formatted_Hora = new javax.swing.JFormattedTextField();
        label_Hora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_chamado = new javax.swing.JTable();
        Separador = new javax.swing.JSeparator();
        label_Separador = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        textArea_Descricao = new javax.swing.JTextArea();
        comboBox_Categoria = new javax.swing.JComboBox();
        comboBox_Cliente = new javax.swing.JComboBox();
        botao_Novo1 = new javax.swing.JButton();
        botao_Editar1 = new javax.swing.JButton();
        botao_Excluir1 = new javax.swing.JButton();
        botao_Confirmar1 = new javax.swing.JButton();
        label_Separador1 = new javax.swing.JLabel();
        Separador1 = new javax.swing.JSeparator();
        label_Status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Chamados - Chamados");
        setAlwaysOnTop(true);
        setResizable(false);

        label_Cliente.setText("Cliente");

        label_Categoria.setText("Categoria");

        label_Data.setText("Data");

        formatted_Data.setEditable(false);

        formatted_Hora.setEditable(false);
        formatted_Hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatted_HoraActionPerformed(evt);
            }
        });

        label_Hora.setText("Hora");

        jLabel4.setText("Descrição");

        tabela_chamado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabela_chamado);

        Separador.setForeground(new java.awt.Color(153, 153, 153));
        Separador.setToolTipText("");
        Separador.setName(""); // NOI18N

        label_Separador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Separador.setForeground(new java.awt.Color(102, 102, 102));
        label_Separador.setText("Tópicos Cadastrados");

        textArea_Descricao.setEditable(false);
        textArea_Descricao.setColumns(20);
        textArea_Descricao.setRows(5);
        scrollPane.setViewportView(textArea_Descricao);

        comboBox_Categoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboBox_Cliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        botao_Novo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botao_Novo1.setText("Novo");
        botao_Novo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_Novo1ActionPerformed(evt);
            }
        });

        botao_Editar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botao_Editar1.setText("Editar");
        botao_Editar1.setEnabled(false);

        botao_Excluir1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botao_Excluir1.setText("Excluir");
        botao_Excluir1.setEnabled(false);

        botao_Confirmar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botao_Confirmar1.setText("Confirmar");
        botao_Confirmar1.setEnabled(false);

        label_Separador1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Separador1.setForeground(new java.awt.Color(102, 102, 102));
        label_Separador1.setText("Informaçoes do chamado");

        Separador1.setForeground(new java.awt.Color(153, 153, 153));
        Separador1.setToolTipText("");
        Separador1.setName(""); // NOI18N

        label_Status.setText("jLabel1");

        javax.swing.GroupLayout panel_fundoLayout = new javax.swing.GroupLayout(panel_fundo);
        panel_fundo.setLayout(panel_fundoLayout);
        panel_fundoLayout.setHorizontalGroup(
            panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fundoLayout.createSequentialGroup()
                .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fundoLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(botao_Novo1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(botao_Editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(botao_Excluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(botao_Confirmar1))
                    .addGroup(panel_fundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_Separador1)
                        .addGap(13, 13, 13)
                        .addComponent(Separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_fundoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_fundoLayout.createSequentialGroup()
                                .addComponent(label_Separador)
                                .addGap(13, 13, 13)
                                .addComponent(Separador, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panel_fundoLayout.createSequentialGroup()
                            .addComponent(label_Data)
                            .addGap(104, 104, 104)
                            .addComponent(label_Hora))
                        .addGroup(panel_fundoLayout.createSequentialGroup()
                            .addComponent(formatted_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(formatted_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label_Status))
                        .addComponent(jLabel4)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fundoLayout.createSequentialGroup()
                            .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboBox_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_Cliente))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_Categoria)
                                .addComponent(comboBox_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panel_fundoLayout.setVerticalGroup(
            panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Separador1)
                    .addGroup(panel_fundoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Cliente)
                    .addComponent(label_Categoria))
                .addGap(6, 6, 6)
                .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBox_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Data)
                    .addComponent(label_Hora))
                .addGap(6, 6, 6)
                .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatted_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(formatted_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_Status)))
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Separador)
                    .addGroup(panel_fundoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Separador, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_Novo1)
                    .addComponent(botao_Editar1)
                    .addComponent(botao_Excluir1)
                    .addComponent(botao_Confirmar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formatted_HoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatted_HoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formatted_HoraActionPerformed

    private void botao_Novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_Novo1ActionPerformed
        Topico topico = new Topico(this,true);
        topico.setVisible(true);
    }//GEN-LAST:event_botao_Novo1ActionPerformed

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
            java.util.logging.Logger.getLogger(Chamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Chamado dialog = new Chamado(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separador;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JButton botao_Confirmar1;
    private javax.swing.JButton botao_Editar1;
    private javax.swing.JButton botao_Excluir1;
    private javax.swing.JButton botao_Novo1;
    private javax.swing.JComboBox comboBox_Categoria;
    private javax.swing.JComboBox comboBox_Cliente;
    private javax.swing.JFormattedTextField formatted_Data;
    private javax.swing.JFormattedTextField formatted_Hora;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_Categoria;
    private javax.swing.JLabel label_Cliente;
    private javax.swing.JLabel label_Data;
    private javax.swing.JLabel label_Hora;
    private javax.swing.JLabel label_Separador;
    private javax.swing.JLabel label_Separador1;
    private javax.swing.JLabel label_Status;
    private javax.swing.JPanel panel_fundo;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabela_chamado;
    private javax.swing.JTextArea textArea_Descricao;
    // End of variables declaration//GEN-END:variables
}
