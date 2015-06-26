/*
 Exemplo de uso dos metodos desta classe:
 Conexao con = new Conexao();
 con.inserirUsuario("Joao", "jfg12", "123");
 con.encerrarConexao();
 */
package br.univali.gerenciador.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {

    private String url = "jdbc:postgresql://localhost:5432/db_chamado";
    private String usuario = "postgres";
    private String senha = "123";
    private Connection conexao;
    private Statement statement;

    public Conexao() {

        try {
            this.conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida");

            this.statement = conexao.createStatement();
            System.out.println("Statement criado");
        } catch (SQLException ex) {
            System.err.println("Erro ao se conectar");
        }
    }

    public void encerrarConexao() {
        try {
            conexao.close();
            System.out.println("Conexão encerrada");
        } catch (SQLException ex) {
            System.err.println("Erro ao encerrar conexão");
        }
    }

    //Inserções
    public void inserirUsuario(String nome, String login, String senha) {
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES ('" + nome + "', '" + login + "', '" + senha + "')";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Usuario " + login + " inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário já existe!\nErro ao inserir usuário: " + sql);
            ex.printStackTrace();
        }
    }

    public void inserirCliente(String nome, String email) {
        String sql = "INSERT INTO cliente (nome, email) VALUES ('" + nome + "', '" + email + "')";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cliente " + nome + " inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente já existe! \nErro ao inserir cliente " + sql);
            ex.printStackTrace();
        }
    }

    public void inserirProgramador(String nome, float valorHora) {
        String sql = "INSERT INTO programador (nome, valorHora) VALUES('" + nome + "', '" + valorHora + "')";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Programador " + nome + " inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir programador " + nome + "\n" + sql);
            ex.printStackTrace();
        }
    }

    public void inserirCategoria(String nome) {
        String sql = "INSERT INTO categoria (nome) VALUES ('" + nome + "')";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Categoria " + nome + " inserida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir categoria " + nome + "\n" + sql);
            ex.printStackTrace();
        }
    }

    public void inserirChamado(String descricao, int id_categoria, int id_cliente, int id_usuario, String dataHora) {
        String sql = "INSERT INTO chamado(descricao, id_categoria, id_cliente, id_usuario, dataHora) VALUES ('" + descricao + "', " + id_categoria + ", " + id_cliente + ", " + id_usuario + ", '" + dataHora + "')";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Chamado inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar chamado");
            ex.printStackTrace();
        }
    }

    //Remoções
    public void removerUsuario(int id, String login) {
        String sql = "DELETE FROM usuario WHERE id = '" + id + "'";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Usuario " + login + " removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuario " + login + "\n" + sql);
            ex.printStackTrace();
        }
    }

    public void removerCliente(int id, String nome) {
        String sql = "DELETE FROM cliente WHERE id = '" + id + "'";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cliente " + nome + " removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover cliente " + nome + "\n" + sql);
            ex.printStackTrace();
        }
    }

    public void removerProgramador(int id, String nome) {
        String sql = "DELETE FROM programador WHERE id = '" + id + "'";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Programador " + nome + " removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover programador " + nome + "\n" + sql);
            ex.printStackTrace();
        }
    }

    public void removerCategoria(int id, String nome) {
        String sql = "DELETE FROM categoria WHERE id = '" + id + "'";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Categoria " + nome + " removida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover categoria " + nome + "\n" + sql);
            ex.printStackTrace();
        }
    }

    public void removerChamado(int id) {
        String sql = "DELETE FROM chamado WHERE id = '" + id + "'";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Chamado " + id + " foi removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover o chamado " + id + "\n" + sql);
            ex.printStackTrace();
        }
    }

    // Consultas
    public ResultSet consultaChamados(String parametro) {
        //String sql = "SELECT * FROM chamado WHERE " + parametro;

        String sql = "SELECT ch.id, c.nome, ct.nome, ch.data, ch.hora, status FROM chamado ch join cliente c on (c.id = ch.id_cliente) join categoria ct on (ct.id = ch.id_categoria) WHERE " + parametro;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar chamado\n" + sql);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaChamado(int id) {
        String sql = "SELECT cl.nome, ct.nome, ch.data, ch.hora, ch.status, ch.descricao  FROM chamado ch JOIN categoria ct ON (ch.id_categoria = ct.id) JOIN cliente cl ON (ch.id_cliente = cl.id) WHERE ch.id = " + id;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar chamado\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaTopicos(int idChamado) {
        String sql = "SELECT t.id, t.descricao, p.nome, t.tempo_trabalhado, t.solucionado FROM topico t JOIN programador p ON (t.id_programador = p.id) WHERE t.id_chamado = " + idChamado + " ORDER BY t.id";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar topicos\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consulaTopico(int idTopico) {
        String sql = "SELECT t.descricao, p.nome, t.tempo_trabalhado, t.solucionado FROM topico t JOIN programador p ON (t.id_programador = p.id) WHERE t.id = " + idTopico;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar topico\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaClientes() {
        String sql = "SELECT * FROM cliente";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar clientes\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaCliente(int idCliente) {
        String sql = "SELECT nome, email FROM cliente WHERE id = " + idCliente;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar cliente\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaProgramadores() {
        String sql = "SELECT * FROM programador";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar programadores\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaProgramador(int id) {
        String sql = "SELECT * FROM programador WHERE id = " + id;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar clientes\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaUsuarios() {
        String sql = "SELECT * FROM usuario";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuario\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaUsuario(int idUsuario) {
        String sql = "SELECT * FROM usuario WHERE id = " + idUsuario;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuario\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaCategorias() {
        String sql = "SELECT * FROM categoria";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Categorias\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaCategoria(int idCategoria) {
        String sql = "SELECT * FROM categoria WHERE id = " + idCategoria;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Categoria\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }
}
