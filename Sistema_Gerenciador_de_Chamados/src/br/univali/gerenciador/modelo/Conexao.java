/*
Exemplo de uso dos metodos desta classe:
        Conexao con = new Conexao();
        con.inserirUsuario("Joao", "jfg12", "123");
        con.encerrarConexao();
*/

package br.univali.gerenciador.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {

    private String url = "jdbc:postgresql://localhost:5432/db_chamados";
    private String usuario = "postgres";
    private String senha = "7133";
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
    
    //Remoções
    public void removerUsuario(String login) {
        String sql = "DELETE FROM usuario WHERE login = '" + login + "'";
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
    
    
}
