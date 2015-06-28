/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.gerenciador.visao;

import br.univali.gerenciador.modelo.Conexao;
import br.univali.gerenciador.modelo.Consulta;
import java.util.List;

/**
 *
 * @author iPotter
 */
public class Topico extends javax.swing.JDialog {

    /**
     * Creates new form Topico
     */
    private Conexao con;
    private int numChamado;

    public Topico(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    Topico(Chamado parent, boolean modal, int numChamado) {
        super(parent, modal);
        initComponents();
        con = new Conexao();
        this.numChamado = numChamado;
        Consulta consulta = new Consulta();
        exibeListaProgramadores(consulta.geraListaProgramadores());
        
    }

    private void exibeListaProgramadores(List<String> lista) {
        for (String item : lista) {
            comboBox_Programador.addItem(item);
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

        panel_Principal = new javax.swing.JPanel();
        comboBox_Programador = new javax.swing.JComboBox();
        label_Programador = new javax.swing.JLabel();
        label_HorasTrabalhadas = new javax.swing.JLabel();
        formattedTextField_Horas = new javax.swing.JFormattedTextField();
        checkBox_Solucionado = new javax.swing.JCheckBox();
        scrollPane_Descricao = new javax.swing.JScrollPane();
        textArea_Descricao = new javax.swing.JTextArea();
        label_Descricao = new javax.swing.JLabel();
        button_salvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        label_Programador.setText("Programador");

        label_HorasTrabalhadas.setText("Horas Trabalhadas");

        formattedTextField_Horas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formattedTextField_HorasActionPerformed(evt);
            }
        });

        checkBox_Solucionado.setText("Solucionado");

        textArea_Descricao.setColumns(20);
        textArea_Descricao.setRows(5);
        scrollPane_Descricao.setViewportView(textArea_Descricao);

        label_Descricao.setText("Descrição");

        button_salvar.setText("Salvar");
        button_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_PrincipalLayout = new javax.swing.GroupLayout(panel_Principal);
        panel_Principal.setLayout(panel_PrincipalLayout);
        panel_PrincipalLayout.setHorizontalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Descricao)
                    .addComponent(label_HorasTrabalhadas)
                    .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(button_salvar)
                        .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                                .addComponent(formattedTextField_Horas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkBox_Solucionado))
                            .addComponent(label_Programador, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBox_Programador, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane_Descricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panel_PrincipalLayout.setVerticalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_Programador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox_Programador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_HorasTrabalhadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formattedTextField_Horas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBox_Solucionado))
                .addGap(18, 18, 18)
                .addComponent(label_Descricao)
                .addGap(1, 1, 1)
                .addComponent(scrollPane_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_salvar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formattedTextField_HorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formattedTextField_HorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formattedTextField_HorasActionPerformed

    private void button_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_salvarActionPerformed
        
        if(checkBox_Solucionado.isSelected()){
            //fecha chamado
        }
        int idProgramador  = (con.consultaIdProgramador((String) comboBox_Programador.getSelectedItem()));
        con.inserirTopico(numChamado, textArea_Descricao.getText(),idProgramador, formattedTextField_Horas.getText());
        
    }//GEN-LAST:event_button_salvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Topico dialog = new Topico(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton button_salvar;
    private javax.swing.JCheckBox checkBox_Solucionado;
    private javax.swing.JComboBox comboBox_Programador;
    private javax.swing.JFormattedTextField formattedTextField_Horas;
    private javax.swing.JLabel label_Descricao;
    private javax.swing.JLabel label_HorasTrabalhadas;
    private javax.swing.JLabel label_Programador;
    private javax.swing.JPanel panel_Principal;
    private javax.swing.JScrollPane scrollPane_Descricao;
    private javax.swing.JTextArea textArea_Descricao;
    // End of variables declaration//GEN-END:variables

}
