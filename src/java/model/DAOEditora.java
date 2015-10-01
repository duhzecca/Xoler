/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import auxiliar.BDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class DAOEditora {
    
    private Connection conn;
    
    public DAOEditora(boolean logado) throws XolerDAOException{
        try {
            this.conn = BDConnection.getConnection(logado);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }         
    }
    
    public void adiciona(String nome, String endereco, String telefone) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(nome == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        
        try{            
            String SQL = "INSERT INTO editora(nome, endereco, telefone)"
                    + "VALUES ('"+ nome +"','"+ endereco +"','"+ telefone +"');";            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }
        
        
    }
    
    /*public void altera(String nome, String novoNome, String novoAutor, String novaEditora) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;

        if(nome == null || novoNome == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }        
        
        try{
            String SQL = "UPDATE Usuarios SET nome = " + novoNome + ", autor = " + novoAutor + ", editora = " + novaEditora
                    + "WHERE nome = " + nome + ";";            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle){
            throw new XolerDAOException("Erro ao alterar dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }
    }*/
    
    public void remove(String nome) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;

        if(nome == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        try{
            String SQL = "DELETE FROM editora WHERE nome = '" + nome + "';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle){
            throw new XolerDAOException("Erro ao remover dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }        
    }
}
