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
    private DefaultTableModel modelo;

    private ResultSet rs;

    public Consulta() {
        this.con = new Conexao();
    }

    public String consultaLogin(String login, String senha) throws SQLException {
        rs = con.consultaLogin(login);
        rs.next();
        if (rs.getString(2).equals(login) && rs.getString(3).equals(senha)) {
            return rs.getString(1);
        }
        return null;
    }

    public DefaultTableModel geraTabelaChamados(String filtro) {
        switch (filtro) {
            case "Concluidos":
                rs = con.consultaChamados("status = false");
                break;
            case "Abertos":
                rs = con.consultaChamados("status = true");
                break;
            default:
                rs = con.consultaChamados("status = true or status = false");
        }
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        try {
            String vetor[] = new String[6];
            modelo.addColumn("ID");
            modelo.addColumn("Cliente");
            modelo.addColumn("Categoria");
            modelo.addColumn("Data");
            modelo.addColumn("Hora");
            modelo.addColumn("Status");

            while (rs.next()) {

                for (int i = 1; i <= 6; i++) {
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
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int qtdColunas = rsmt.getColumnCount();
            String vetor[] = new String[qtdColunas];

            modelo.addColumn("ID");
            modelo.addColumn("Descrição");
            modelo.addColumn("Programador");
            modelo.addColumn("Tempo Trabalhado");

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
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
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

    public DefaultTableModel geraTabelaCategorias() {
        rs = con.consultaCategorias();
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int qtdColunas = rsmt.getColumnCount();
            String vetor[] = new String[qtdColunas];

            modelo.addColumn("ID");
            modelo.addColumn("Nome");

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

    public DefaultTableModel geraTabelaUsuarios() {
        rs = con.consultaUsuarios();
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Login");
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int qtdColunas = rsmt.getColumnCount();
            String vetor[] = new String[qtdColunas];

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

    public DefaultTableModel geraTabelaProgramadores() {
        rs = con.consultaProgramadores();
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        try {
            ResultSetMetaData rsmt = rs.getMetaData();
            int qtdColunas = rsmt.getColumnCount();
            String vetor[] = new String[qtdColunas];

            modelo.addColumn("ID");
            modelo.addColumn("Nome");
            modelo.addColumn("Valor Hora");

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

    public String[] geraVisaoCategoria(int idCategoria) {
        rs = con.consultaCategoria(idCategoria);
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

    public String[] geraVisaoUsuario(int idUsuario) {
        rs = con.consultaUsuario(idUsuario);
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

    public String[] geraVisaoProgramador(int idProgramador) {
        rs = con.consultaProgramador(idProgramador);
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

    public List<String> geraListaProgramadores() {
        rs = con.consultaProgramadores();
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
