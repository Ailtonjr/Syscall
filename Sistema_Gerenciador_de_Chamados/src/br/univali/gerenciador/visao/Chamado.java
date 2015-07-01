package br.univali.gerenciador.visao;

import br.univali.gerenciador.modelo.Conexao;
import br.univali.gerenciador.modelo.Consulta;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Chamado extends javax.swing.JDialog {
    private DefaultTableModel modelo;
    private int numChamado;
    private String operacao = "editar";
    private Conexao con;
    private Consulta consulta;
    private int idSelecionado;
    public int IDUser;

    public Chamado(java.awt.Frame parent, boolean modal, int numChamado) {
        super(parent, modal);
        initComponents();
        this.numChamado = numChamado;
        con = new Conexao();
        consulta = new Consulta();
        atualizaTabela();
        exibeListaClientes(consulta.geraListaClientes());
        exibeListaCategorias(consulta.geraListaCategorias());
        exibeChamado();
        setarBotoesSalvarChamado();
        verificaStatus();
    }

    public Chamado(JFrame parent, boolean modal, String operacao) {
        super(parent, modal);
        initComponents();
        this.operacao = operacao;
        con = new Conexao();
        consulta = new Consulta();
        exibeListaClientes(consulta.geraListaClientes());
        exibeListaCategorias(consulta.geraListaCategorias());
        button_EditarChamado.setEnabled(false);
        button_SalvarChamado.setEnabled(true);
        button_Novo.setEnabled(false);
        button_Editar.setEnabled(false);
        button_Excluir.setEnabled(false);
        modelo = new DefaultTableModel(null, new String[]{"ID","Cliente","Categoria","Data","Hora","Status"});
        table_Topicos.setModel(modelo);
    }

    public Chamado(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void verificaStatus() {
        if (label_Status.getText().equalsIgnoreCase("Fechado")) {
            button_EditarChamado.setEnabled(false);
            button_Novo.setEnabled(false);
            button_Editar.setEnabled(false);
            button_Excluir.setEnabled(false);
        }
    }

    private void exibeChamado() {
        String[] vetor = consulta.geraVisaoChamado(numChamado);
        comboBox_Cliente.setSelectedItem(vetor[0]);
        comboBox_Categoria.setSelectedItem(vetor[1]);
        label_Status.setText(vetor[4]);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = (Date) formatter.parse(vetor[2]);
        } catch (ParseException ex) {
            Logger.getLogger(Chamado.class.getName()).log(Level.SEVERE, null, ex);
        }
        formatted_Data.setDate(date);
        formatted_Hora.setValue(vetor[3]);
        if (vetor[4].equalsIgnoreCase("aberto")) {
            label_Status.setForeground(new Color(0, 153, 0));
        } else {
            label_Status.setForeground(new Color(204, 0, 0));
        }
        

        textArea_Descricao.setText(vetor[5]);
    }

    private void exibeListaClientes(List<String> lista) {
        for (String item : lista) {
            comboBox_Cliente.addItem(item);
        }
    }

    private void exibeListaCategorias(List<String> lista) {
        for (String item : lista) {
            comboBox_Categoria.addItem(item);
        }
    }

    public void atualizaTabela() {
        modelo = consulta.geraTabelaTopicos(numChamado);
        table_Topicos.setModel(modelo);
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
        label_Cliente = new javax.swing.JLabel();
        label_Categoria = new javax.swing.JLabel();
        label_Data = new javax.swing.JLabel();
        formatted_Hora = new javax.swing.JFormattedTextField();
        formatted_Hora.setValue("00:00");
        label_Hora = new javax.swing.JLabel();
        label_Descricao = new javax.swing.JLabel();
        scrollPane_Topicos = new javax.swing.JScrollPane();
        table_Topicos = new javax.swing.JTable();
        separator = new javax.swing.JSeparator();
        label_Separador = new javax.swing.JLabel();
        scrollPane_Descricao = new javax.swing.JScrollPane();
        textArea_Descricao = new javax.swing.JTextArea();
        comboBox_Categoria = new javax.swing.JComboBox();
        comboBox_Cliente = new javax.swing.JComboBox();
        button_Novo = new javax.swing.JButton();
        button_Editar = new javax.swing.JButton();
        button_Excluir = new javax.swing.JButton();
        label_Separador1 = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        button_SalvarChamado = new javax.swing.JButton();
        button_EditarChamado = new javax.swing.JButton();
        formatted_Data = new org.jdesktop.swingx.JXDatePicker();
        formatted_Data.setFormats(new String[]{"yyyy-MM-dd"});
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_Status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Chamados - Chamados");
        setAlwaysOnTop(true);
        setResizable(false);

        label_Cliente.setText("Cliente");

        label_Categoria.setText("Categoria");

        label_Data.setText("Data");

        try {
            formatted_Hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatted_Hora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        formatted_Hora.setPreferredSize(new java.awt.Dimension(22, 22));

        label_Hora.setText("Hora");

        label_Descricao.setText("Descrição");

        table_Topicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Categoria", "Data", "Hora", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Topicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_TopicosMouseClicked(evt);
            }
        });
        scrollPane_Topicos.setViewportView(table_Topicos);

        separator.setForeground(new java.awt.Color(153, 153, 153));
        separator.setToolTipText("");
        separator.setName(""); // NOI18N

        label_Separador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Separador.setForeground(new java.awt.Color(102, 102, 102));
        label_Separador.setText("Tópicos Cadastrados");

        textArea_Descricao.setColumns(20);
        textArea_Descricao.setRows(5);
        scrollPane_Descricao.setViewportView(textArea_Descricao);

        comboBox_Categoria.setSelectedItem(null);

        comboBox_Cliente.setSelectedItem(null);
        comboBox_Cliente.setToolTipText("");

        button_Novo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Novo.setText("Novo");
        button_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_NovoActionPerformed(evt);
            }
        });

        button_Editar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Editar.setText("Editar");
        button_Editar.setEnabled(false);
        button_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_EditarActionPerformed(evt);
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

        label_Separador1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Separador1.setForeground(new java.awt.Color(102, 102, 102));
        label_Separador1.setText("Informaçoes do chamado");

        separator1.setForeground(new java.awt.Color(153, 153, 153));
        separator1.setToolTipText("");
        separator1.setName(""); // NOI18N

        button_SalvarChamado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_SalvarChamado.setText("Salvar");
        button_SalvarChamado.setEnabled(false);
        button_SalvarChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SalvarChamadoActionPerformed(evt);
            }
        });

        button_EditarChamado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_EditarChamado.setText("Editar");
        button_EditarChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_EditarChamadoActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/gerenciador/visao/imagens/Create.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/gerenciador/visao/imagens/Create.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_PrincipalLayout = new javax.swing.GroupLayout(panel_Principal);
        panel_Principal.setLayout(panel_PrincipalLayout);
        panel_PrincipalLayout.setHorizontalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(label_Separador1)
                .addGap(13, 13, 13)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(570, 570, 570)
                .addComponent(label_Status))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(label_Cliente)
                .addGap(282, 282, 282)
                .addComponent(label_Categoria))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(comboBox_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(comboBox_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(label_Descricao))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(scrollPane_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(button_EditarChamado)
                .addGap(7, 7, 7)
                .addComponent(button_SalvarChamado))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(label_Separador)
                .addGap(13, 13, 13)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(button_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(button_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(button_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(scrollPane_Topicos, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Data)
                    .addComponent(formatted_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatted_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_Hora)))
        );
        panel_PrincipalLayout.setVerticalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Separador1)
                    .addGroup(panel_PrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(label_Status)
                .addGap(11, 11, 11)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Cliente)
                    .addComponent(label_Categoria))
                .addGap(1, 1, 1)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panel_PrincipalLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBox_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(comboBox_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Data)
                    .addGroup(panel_PrincipalLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(label_Hora)))
                .addGap(3, 3, 3)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatted_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatted_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(label_Descricao)
                .addGap(13, 13, 13)
                .addComponent(scrollPane_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_EditarChamado)
                    .addComponent(button_SalvarChamado))
                .addGap(14, 14, 14)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Separador)
                    .addGroup(panel_PrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_Novo)
                    .addComponent(button_Editar)
                    .addComponent(button_Excluir))
                .addGap(18, 18, 18)
                .addComponent(scrollPane_Topicos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setarBotoesConfirmar() {
        button_Novo.setEnabled(true);
        button_Editar.setEnabled(true);
        button_Excluir.setEnabled(true);
    }

    private void setarBotoesExcuir() {
        button_Editar.setEnabled(false);
        button_Excluir.setEnabled(false);
    }

    private void setarBotoesEditarChamado() {
        comboBox_Categoria.setEnabled(true);
        comboBox_Cliente.setEnabled(true);
        formatted_Data.setEnabled(true);
        formatted_Hora.setEnabled(true);
        textArea_Descricao.setEnabled(true);
        button_SalvarChamado.setEnabled(true);
        button_EditarChamado.setEnabled(false);
    }

    private void setarBotoesSalvarChamado() {
        comboBox_Categoria.setEnabled(false);
        comboBox_Cliente.setEnabled(false);
        formatted_Data.setEnabled(false);
        formatted_Hora.setEnabled(false);
        textArea_Descricao.setEnabled(false);
        button_SalvarChamado.setEnabled(false);
        button_EditarChamado.setEnabled(true);
    }

    private void button_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_NovoActionPerformed
        Topico topico = new Topico(this, true, numChamado);
        topico.setVisible(true);
        exibeChamado();
        verificaStatus();
        atualizaTabela();
        
    }//GEN-LAST:event_button_NovoActionPerformed

    private void button_SalvarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SalvarChamadoActionPerformed
        int idCliente = (con.consultaIdCliente((String) comboBox_Cliente.getSelectedItem()));
        int idCategoria = (con.consultaIdCategoria((String) comboBox_Categoria.getSelectedItem()));
        Date date = formatted_Data.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String data = formato.format(date);
        if (operacao.equalsIgnoreCase("novo")) {
            try {
                con.inserirChamado(textArea_Descricao.getText(), idCategoria, idCliente, IDUser, data, formatted_Hora.getText() + ":00");
                JOptionPane.showMessageDialog(this, "Chamado inserido com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao criar chamado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            con.atualizarChamado(numChamado, textArea_Descricao.getText(), idCategoria, idCliente, IDUser, data, formatted_Hora.getText() + ":00");
        }
        setarBotoesSalvarChamado();
    }//GEN-LAST:event_button_SalvarChamadoActionPerformed

    private void button_EditarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_EditarChamadoActionPerformed
        setarBotoesEditarChamado();
    }//GEN-LAST:event_button_EditarChamadoActionPerformed

    private void button_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ExcluirActionPerformed
        con.removerTopico(idSelecionado);
        setarBotoesExcuir();
        atualizaTabela();
    }//GEN-LAST:event_button_ExcluirActionPerformed

    private void table_TopicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_TopicosMouseClicked
        if (evt.getClickCount() == 1) {
            idSelecionado = Integer.parseInt((String) table_Topicos.getValueAt(table_Topicos.getSelectedRow(), 0));
            setarBotoesConfirmar();
            verificaStatus();
        }

    }//GEN-LAST:event_table_TopicosMouseClicked

    private void button_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_EditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_EditarActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Cliente cliente = new Cliente(this, true);
        cliente.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Categoria categoria = new Categoria(this, true);
        categoria.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked


    public static void main(String args[]) {

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
    private javax.swing.JButton button_Editar;
    private javax.swing.JButton button_EditarChamado;
    private javax.swing.JButton button_Excluir;
    private javax.swing.JButton button_Novo;
    private javax.swing.JButton button_SalvarChamado;
    private javax.swing.JComboBox comboBox_Categoria;
    private javax.swing.JComboBox comboBox_Cliente;
    private org.jdesktop.swingx.JXDatePicker formatted_Data;
    private javax.swing.JFormattedTextField formatted_Hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_Categoria;
    private javax.swing.JLabel label_Cliente;
    private javax.swing.JLabel label_Data;
    private javax.swing.JLabel label_Descricao;
    private javax.swing.JLabel label_Hora;
    private javax.swing.JLabel label_Separador;
    private javax.swing.JLabel label_Separador1;
    private javax.swing.JLabel label_Status;
    private javax.swing.JPanel panel_Principal;
    private javax.swing.JScrollPane scrollPane_Descricao;
    private javax.swing.JScrollPane scrollPane_Topicos;
    private javax.swing.JSeparator separator;
    private javax.swing.JSeparator separator1;
    private javax.swing.JTable table_Topicos;
    private javax.swing.JTextArea textArea_Descricao;
    // End of variables declaration//GEN-END:variables
}
