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
    
    public void inserirUsuario(String nome, String login, String senha) {
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES ('" + nome + "', '" + login + "', '" + senha + "')";
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuario " + login + " inserido com sucesso");
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir usuário: " + sql);
            ex.printStackTrace();
        }
    }
    
    public void removerUsuario(String login) {
        String sql = "DELETE FROM usuario WHERE login = '" + login + "'";
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuario " + login + " removido com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao remover usuario " + login);
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
    
}
