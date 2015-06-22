
package br.univali.gerenciador.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {

    private String url = "jdbc:postgresql://localhost:5432/db_chamados";
    private String usuario = "us_admin";
    private String senha = "1234";
    private Connection conexao;
    
    public Conexao() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida");
        } catch (SQLException ex) {
            //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao se conectar");
        }
    }
    
    
    
    
}
