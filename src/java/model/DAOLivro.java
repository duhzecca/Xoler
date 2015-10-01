/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import auxiliar.BDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class DAOLivro {
    
    private Connection conn;
    
    public DAOLivro(boolean logado) throws XolerDAOException{
        try {
            this.conn = BDConnection.getConnection(logado);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }         
    }    

    
    public void adiciona(String nome, String autor, String tag, String capa, String conteudoLivro, String editora, String descricao) 
            throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;        
        if(nome == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        
        try{
            String SQL = "INSERT INTO livros(nome, autor, tag, capa, conteudoLivro, visitas, editora, descricao)"
                    + "VALUES ('"+ nome +"','"+ autor +"','"+ tag +"','"+ capa +"','"+ conteudoLivro +"', 0, '"+ editora + " '"+ descricao + "');";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }
        
        
    }
    
    public void adicionaLista(String email, int cod) 
            throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;       
        ResultSet rs = null;
        
        if(email == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        
        try{
            String SQL = "SELECT * FROM lidos WHERE email LIKE '"+email+"' and cod = "+cod;
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            if(!rs.next()){
              SQL = "INSERT INTO lidos(email, cod) VALUES ('"+email+"', "+cod+")";
              conn = this.conn;
              ps = conn.prepareStatement(SQL);
              ps.executeUpdate();
            }
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }
        
        
    }
    
    public void altera(String nome, String novoNome, String novoAutor, String novaEditora) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;

        if(nome == null || novoNome == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }        
        
        try{
            String SQL = "UPDATE usuarios SET nome = '" + novoNome + "', autor = '" + novoAutor + "', editora = '" + novaEditora
                    + "' WHERE nome = '" + nome + "';";            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle){
            throw new XolerDAOException("Erro ao alterar dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }
    }
    
    public void remove(String nome) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;

        if(nome == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        try{
            String SQL = "DELETE FROM livros WHERE nome = '" + nome + "';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle){
            throw new XolerDAOException("Erro ao remover dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }        
    }
    
    public void removeLista(String email, int cod) 
            throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;        
        if(email == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        
        try{
            String SQL = "DELETE FROM lidos WHERE email = '" + email + "' AND cod = "+cod+";";            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao remover dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn,ps);
        }
    }
    
     public List<BeanLivro> consultaTitulo(String cod) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanLivro novo = null;

        try {
            //Define consulta
            String SQL = "Select * from livros where nome LIKE '%" + cod +"%';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanLivro> list = new ArrayList<BeanLivro>();
            while (rs.next()) {
                String nome = rs.getObject("nome").toString();
                
                String autor = rs.getObject("autor").toString();
                String tag = rs.getObject("tag").toString();
                String capa = rs.getObject("capa").toString();
                String conteudo = rs.getObject("conteudoLivro").toString();
                int visitas = (Integer)rs.getObject("visitas");
                int chave = (Integer)rs.getObject("cod");
                String editora = rs.getObject("editora").toString();
                String descricao = rs.getObject("descricao").toString();
                
                novo = new BeanLivro(nome, autor, tag, capa, conteudo, visitas, editora,descricao,chave);
                list.add(novo);
            }
            
            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
     
     public List<BeanLivro> consultaAutor(String cod) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanLivro novo = null;

        try {
            //Define consulta
            String SQL = "Select * from livros where autor LIKE '%" + cod +"%';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanLivro> list = new ArrayList<BeanLivro>();
            while (rs.next()) {
                String nome = rs.getObject("nome").toString();
                String autor = rs.getObject("autor").toString();
                String tag = rs.getObject("tag").toString();
                String capa = rs.getObject("capa").toString();
                String conteudo = rs.getObject("conteudoLivro").toString();
                int visitas = (Integer)rs.getObject("visitas");
                String editora = rs.getObject("editora").toString();
                String descricao = rs.getObject("descricao").toString();
                int chave = (Integer)rs.getObject("cod");

                novo = new BeanLivro(nome, autor, tag, capa, conteudo, visitas, editora,descricao,chave);
                list.add(novo);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
     
     public List<BeanLivro> consultaAssunto(String cod) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanLivro novo = null;

        try {
            //Define consulta
            String SQL = "Select * from livros where tag LIKE '%" + cod +"%';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanLivro> list = new ArrayList<BeanLivro>();
            while (rs.next()) {
                String nome = rs.getObject("nome").toString();
                String autor = rs.getObject("autor").toString();
                String tag = rs.getObject("tag").toString();
                String capa = rs.getObject("capa").toString();
                String conteudo = rs.getObject("conteudoLivro").toString();
                int visitas = (Integer)rs.getObject("visitas");
                String editora = rs.getObject("editora").toString();
                String descricao = rs.getObject("descricao").toString();
                int chave = (Integer)rs.getObject("cod");

                novo = new BeanLivro(nome, autor, tag, capa, conteudo, visitas, editora,descricao,chave);
                list.add(novo);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
    
    public List<BeanLivro> listaTopLivros() throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "SELECT nome, autor, visitas, cod, tag, capa, conteudoLivro, editora, descricao FROM livros GROUP BY nome, autor ORDER BY max(visitas) LIMIT 10;";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanLivro> list = new ArrayList<BeanLivro>();

            while (rs.next()) {
                int chave = (Integer)rs.getObject("cod");
                String nome = rs.getObject("nome").toString();
                String autor = rs.getObject("autor").toString();
                String tag = rs.getObject("tag").toString();
                String capa = rs.getObject("capa").toString();
                String conteudo = rs.getObject("conteudoLivro").toString();
                String editora = rs.getObject("editora").toString();
                int visitas = (Integer)rs.getObject("visitas");
                String descricao = rs.getObject("descricao").toString();
                
                BeanLivro a = new BeanLivro();
                
                a.setNome(nome);
                a.setAutor(autor); 
                a.setCod(chave);
                a.setTag(tag);
                a.setCapa(capa);
                a.setConteudoLivro(conteudo);
                a.setEditora(editora);
                a.setVisitas(visitas);
                a.setDescricao(descricao);

                list.add(a);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }            
    
   public List<BeanLivro> listaMeusLivros(String email) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "SELECT livros.nome, livros.autor, livros.cod, livros.visitas, livros.tag, livros.capa, livros.conteudoLivro, livros.editora  FROM lidos, usuario, livros WHERE livros.cod = lidos.cod AND lidos.email LIKE  '"+email+"' AND usuario.email LIKE  '"+email+"'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanLivro> list = new ArrayList<BeanLivro>();

            while (rs.next()) {
                int chave = (Integer)rs.getObject("cod");
                String nome = rs.getObject("nome").toString();
                String autor = rs.getObject("autor").toString();
                String tag = rs.getObject("tag").toString();
                String capa = rs.getObject("capa").toString();
                String conteudo = rs.getObject("conteudoLivro").toString();
                String editora = rs.getObject("editora").toString();
                int visitas = (Integer)rs.getObject("visitas");
                
                BeanLivro a = new BeanLivro();
                
                a.setNome(nome);
                a.setAutor(autor); 
                a.setCod(chave);
                a.setTag(tag);
                a.setCapa(capa);
                a.setConteudoLivro(conteudo);
                a.setEditora(editora);
                a.setVisitas(visitas);
                
                list.add(a);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }        
    
}
