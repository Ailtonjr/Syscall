package br.univali.gerenciador.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;
import static sun.security.jgss.GSSUtil.login;

public class Conexao {

    private String url = "jdbc:postgresql://localhost:5432/db_chamado";
    private String usuario = "postgres";
    private String senha = "123";
    private Connection conexao;
    private PreparedStatement preparedStatement;
    private Statement statement;

    public Conexao() {

        try {
            this.conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida");

            this.statement = conexao.createStatement();
            System.out.println("Statement criado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar ao banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
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

    public ResultSet consultaLogin(String login) throws SQLException {
        String sql = "SELECT login,senha FROM usuario WHERE login = ?";
        ResultSet rs = null;

        preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, login);
        rs = preparedStatement.executeQuery();

        return rs;
    }

    //Inserções
    public void inserirUsuario(String nome, String login, String senha) {
        String sql = "BEGIN;"
                + "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?);"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, senha);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario " + login + " inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário já existe!\nErro ao inserir usuário: " + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void inserirCliente(String nome, String email) {
        String sql = "BEGIN;"
                + "INSERT INTO cliente (nome, email) VALUES (?, ?);"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente " + nome + " inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente já existe! \nErro ao inserir cliente " + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void inserirProgramador(String nome, float valorHora) {
        String sql = "BEGIN;"
                + "INSERT INTO programador (nome, valorHora) VALUES(?, ?);"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setFloat(2, valorHora);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Programador " + nome + " inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir programador " + nome + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void inserirCategoria(String nome) {
        String sql = "BEGIN;"
                + "INSERT INTO categoria (nome) VALUES (?);"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria " + nome + " inserida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir categoria " + nome + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void inserirChamado(String descricao, int id_categoria, int id_cliente, int id_usuario, String data, String hora) {
        String sql = "BEGIN;"
                + "INSERT INTO chamado(status, descricao, id_categoria, id_cliente, id_usuario, data, hora) VALUES (?, ?, ?, ?, ?, ?, ?);"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, descricao);
            preparedStatement.setInt(3, id_categoria);
            preparedStatement.setInt(4, id_cliente);
            preparedStatement.setInt(5, id_usuario);
            preparedStatement.setDate(6, java.sql.Date.valueOf(data));
            preparedStatement.setTime(7, java.sql.Time.valueOf(hora));

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chamado inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar chamado", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void inserirTopico(int id_chamado, String descricao, int id_programador, String tempo_trabalhado) {
        String sql = "BEGIN;"
                + "INSERT INTO topico (id_chamado, descricao, id_programador, tempo_trabalhado) VALUES (?, ?, ?, ?);"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id_chamado);
            preparedStatement.setString(2, descricao);
            preparedStatement.setInt(3, id_programador);
            preparedStatement.setTime(4, java.sql.Time.valueOf(tempo_trabalhado));

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Topico inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir topico", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    //Remoções
    public void removerUsuario(int id, String login) {
        String sql = "BEGIN;"
                + "DELETE FROM usuario WHERE id = '" + id + "';"
                + "COMMIT";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Usuario " + login + " removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuario " + login + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void removerCliente(int id, String nome) {
        String sql = "BEGIN;"
                + "DELETE FROM cliente WHERE id = '" + id + "';"
                + "COMMIT";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cliente " + nome + " removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover cliente " + nome + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void removerProgramador(int id, String nome) {
        String sql = "BEGIN;"
                + "DELETE FROM programador WHERE id = '" + id + "';"
                + "COMMIT";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Programador " + nome + " removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover programador " + nome + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void removerCategoria(int id, String nome) {
        String sql = "BEGIN;"
                + "DELETE FROM categoria WHERE id = '" + id + "';"
                + "COMMIT";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Categoria " + nome + " removida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover categoria " + nome + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void removerChamado(int id) {
        String sql = "BEGIN;"
                + "DELETE FROM chamado WHERE id = '" + id + "';"
                + "COMMIT";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Chamado " + id + " foi removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover o chamado " + id + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void removerTopico(int id) {
        String sql = "BEGIN;"
                + "DELETE FROM topico WHERE id = '" + id + "';"
                + "COMMIT";
        try {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Topico " + id + " foi removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover o topico " + id + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Erro ao buscar chamados\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
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
        String sql = "SELECT t.id, t.descricao, p.nome, t.tempo_trabalhado FROM topico t JOIN programador p ON (t.id_programador = p.id) WHERE t.id_chamado = " + idChamado + " ORDER BY t.id";
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
    
    public int consultaIdProgramador(String nome) {
        String sql = "SELECT * FROM programador WHERE nome = '" + nome+"'";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar clientes\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        try {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
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
        String sql = "SELECT * FROM usuario WHERE id =" + idUsuario;
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

    // Atualizações
    public void atualizarUsuario(int id, String nome, String login, String senha) {
    
        String sql = "BEGIN;"
                + "UPDATE usuario SET nome = ?, login = ?, senha = ? WHERE id = ? ;"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, senha);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario " + nome + " atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuario " + nome + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        System.out.println("teste");
    }

    public void atualizarCliente(int id, String nome, String email) {
        String sql = "BEGIN;"
                + "UPDATE cliente SET nome = ?, email = ? WHERE id = ?;"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente " + nome + " atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente " + nome + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void atualizarProgramador(int id, String nome, float valorHora) {
        String sql = "BEGIN;"
                + "UPDATE programador SET nome = ?, valorHora = ? WHERE id = ?;"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setFloat(2, valorHora);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Programador " + nome + " atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar programador " + nome + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void atualizarCategoria(int id, String nome) {
        String sql = "BEGIN;"
                + "UPDATE categoria SET nome = ? WHERE id = ?;"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria " + nome + " atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar categoria " + nome + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void atualizarChamado(int id, String descricao, int id_categoria, int id_cliente, int id_usuario, String data, String hora) {
        String sql = "BEGIN;"
                + "UPDATE chamado SET descricao = ?, id_categoria = ?, id_cliente = ?, id_usuario = ?, data = ?, hora = ? WHERE id = ?;"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, descricao);
            preparedStatement.setInt(2, id_categoria);
            preparedStatement.setInt(3, id_cliente);
            preparedStatement.setInt(4, id_usuario);
            preparedStatement.setDate(5, java.sql.Date.valueOf(data));
            preparedStatement.setTime(6, java.sql.Time.valueOf(hora));

            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chamado " + id + " atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar chamado " + id + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void atualizarTopico(int id, int id_chamado, String descricao, int id_programador, String tempo_trabalhado) {
        String sql = "BEGIN;"
                + "UPDATE topico SET id_chamado = ?, descricao = ?, id_programador = ?, tempo_trabalhado = ? WHERE id = ?;"
                + "COMMIT";
        try {
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id_chamado);
            preparedStatement.setString(2, descricao);
            preparedStatement.setInt(3, id_programador);
            preparedStatement.setTime(4, java.sql.Time.valueOf(tempo_trabalhado));
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Topico " + id + " atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar topico " + id + "\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }


}
