package model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import auxiliar.BDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DAOUsuario {
    
    private Connection conn;
    
    public DAOUsuario(boolean logado) throws XolerDAOException{
        try {
            this.conn = BDConnection.getConnection(logado);
            

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }         
    }
    
    public boolean adiciona(String email, String nome, String senha) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean usuarioExiste = false;
        
        if(email == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        
        try{
            String SQL = "SELECT * FROM usuario WHERE email LIKE '"+email+"'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            if(!rs.next()){
              SQL = "INSERT INTO usuario(email, nome, senha, tipoUsuario, livrosLidos)"
                      + "VALUES ('"+ email +"','"+ nome +"','"+senha+"', 2, '');";      
              ps = conn.prepareStatement(SQL);
              ps.executeUpdate();                        
            }else{
              usuarioExiste = true;
            }
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }
        return usuarioExiste;
        
        
    }
    
    public boolean alteraSenha(String email, String senhaAtual, String senhaNova) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean senhaNaoConfirma = false;
        
        if(email == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        
        try{
            String SQL = "SELECT * FROM usuario WHERE email LIKE '"+email+"' and senha LIKE '"+senhaAtual+"'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            if(rs.next()){
              SQL = "UPDATE usuario SET senha = '"+senhaNova+"' where email LIKE '"+email+"'"; 
              ps = conn.prepareStatement(SQL);
              ps.executeUpdate();                        
            }else{
              senhaNaoConfirma = true;
            }
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }
        return senhaNaoConfirma;
        
    }
    
    public void altera(String email, String novaSenha) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;

        if(email == null || novaSenha == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }        
        
        try{
            String SQL = "UPDATE usuarios SET senha = '" + novaSenha
                    + "' WHERE email = '" + email + "';";            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle){
            throw new XolerDAOException("Erro ao alterar dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }
    }
    
    public boolean remove(String email, String senha) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean senhaNaoConfirma = false;
        
        if(email == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        
        try{
            String SQL = "SELECT * FROM usuario WHERE email LIKE '"+email+"' and senha LIKE '"+senha+"'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            if(rs.next()){
              SQL = "DELETE FROM usuario WHERE email LIKE '" + email + "';";
              conn = this.conn;
              ps = conn.prepareStatement(SQL);
              ps.executeUpdate();
              
              SQL = "DELETE FROM lidos WHERE email LIKE '" + email + "';";
              conn = this.conn;
              ps = conn.prepareStatement(SQL);
              ps.executeUpdate();
            }
            else{
              senhaNaoConfirma = true;
            }
        } catch (SQLException sqle){
            throw new XolerDAOException("Erro ao remover dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }

        return senhaNaoConfirma;
    }
}
