package br.univali.gerenciador.modelo;

import br.univali.gerenciador.visao.Login;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ailton Cardoso Jr
 */
public class Consulta {

    Conexao con;
    private DefaultTableModel modelo = new DefaultTableModel();
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

    public DefaultTableModel geraTabelaTopicos() {
        rs = con.consultaChamados("status = true or status = false");
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

}
