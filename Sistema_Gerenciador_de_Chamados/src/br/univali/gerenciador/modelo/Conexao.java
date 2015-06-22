
package br.univali.gerenciador.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String url = "jdbc:postgersql://localhost:5432/db_chamados";
    private String usuario = "us_admin";
    private String senha = "1234";
    private Connection conexao;
    
    public Conexao() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida");
        } catch (SQLException ex) {
            System.out.println("Erro ao se conectar");
        }
    }
    
    
    
    
}
