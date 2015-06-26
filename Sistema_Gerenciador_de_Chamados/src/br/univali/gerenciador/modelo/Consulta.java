package br.univali.gerenciador.modelo;

import br.univali.gerenciador.visao.Login;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ailton Cardoso Jr
 */
public class Consulta {

    Conexao con;
    //private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };

    private ResultSet rs;

    public Consulta() {
        this.con = new Conexao();
    }

    public DefaultTableModel geraTabelaChamados() {
        rs = con.consultaChamados("status = true or status = false");
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int qtdColunas = rsmt.getColumnCount();
            String vetor[] = new String[qtdColunas];

            modelo.addColumn("ID");
            modelo.addColumn("Cliente");
            modelo.addColumn("Categoria");
            modelo.addColumn("Data");
            modelo.addColumn("Hora");
            modelo.addColumn("Status");

            while (rs.next()) {

                for (int i = 1; i <= qtdColunas; i++) {
                    if (i == 6) {
                        if (rs.getString(i).equalsIgnoreCase("t")) {
                            vetor[i - 1] = "Aberto";
                        } else {
                            if (rs.getString(i).equalsIgnoreCase("f")) {
                                vetor[i - 1] = "Fechado";
                            }
                        }
                    } else {
                        vetor[i - 1] = rs.getString(i);
                    }

                }
                modelo.addRow(vetor);
                System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;

    }

    public DefaultTableModel geraTabelaTopicos(int idChamado) {
        rs = con.consultaTopicos(idChamado);
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int qtdColunas = rsmt.getColumnCount();
            String vetor[] = new String[qtdColunas];

            modelo.addColumn("ID");
            modelo.addColumn("Descrição");
            modelo.addColumn("Programador");
            modelo.addColumn("Tempo Trabalhado");
            modelo.addColumn("Status");

            while (rs.next()) {

                for (int i = 1; i <= qtdColunas; i++) {
                    if (i == 5) {
                        if (rs.getString(i).equalsIgnoreCase("f")) {
                            vetor[i - 1] = "Aberto";
                        } else {
                            if (rs.getString(i).equalsIgnoreCase("t")) {
                                vetor[i - 1] = "Fechado";
                            }
                        }
                    } else {
                        vetor[i - 1] = rs.getString(i);
                    }

                }
                modelo.addRow(vetor);
                System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;

    }

    public DefaultTableModel geraTabelaClientes() {
        rs = con.consultaClientes();
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int qtdColunas = rsmt.getColumnCount();
            String vetor[] = new String[qtdColunas];

            modelo.addColumn("ID");
            modelo.addColumn("Nome");
            modelo.addColumn("E-Mail");

            while (rs.next()) {
                for (int i = 1; i <= qtdColunas; i++) {
                    vetor[i - 1] = rs.getString(i);
                }
                modelo.addRow(vetor);
                System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;

    }

    public String[] geraVisaoChamado(int idChamado) {
        rs = con.consultaChamado(idChamado);
        String vetor[] = null;
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int qtdColunas = rsmt.getColumnCount();
            vetor = new String[qtdColunas];
            rs.next();
            for (int i = 1; i <= qtdColunas; i++) {
                if (i == 5) {
                    if (rs.getString(i).equalsIgnoreCase("t")) {
                        vetor[i - 1] = "Aberto";
                    } else {
                        if (rs.getString(i).equalsIgnoreCase("f")) {
                            vetor[i - 1] = "Fechado";
                        }
                    }
                } else {
                    vetor[i - 1] = rs.getString(i);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vetor;

    }

    public String[] geraVisaoCliente(int idCliente) {
        rs = con.consultaCliente(idCliente);
        String vetor[] = null;
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int qtdColunas = rsmt.getColumnCount();
            vetor = new String[qtdColunas];
            rs.next();
            for (int i = 1; i <= qtdColunas; i++) {
                vetor[i - 1] = rs.getString(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vetor;
    }

    public List<String> geraListaClientes() {
        rs = con.consultaClientes();
        List<String> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                lista.add(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public List<String> geraListaCategorias() {
        rs = con.consultaCategorias();
        List<String> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                lista.add(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
