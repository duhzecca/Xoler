/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Eduardo Zecca
 */
public class DAORemedio {

    private Connection conn;

    public DAORemedio(boolean logado) throws XolerDAOException {
        try {
            this.conn = BDConnection.getConnection(logado);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }
    }

    public void adiciona(int id_remedio, String nome, String descricao, String validade, float preco, String foto, int um_id)
            throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;

        if (nome == null) {
            throw new XolerDAOException("O valor passado nao pode ser nulo");
        }

        try {
            String SQL = "INSERT INTO remedio(nome,descricao,validade,preco,foto,um_id)"
                    + "VALUES('" + nome + "','" + descricao + "','" + validade + "','" + preco + "','" + foto + "','" + um_id + "');";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
    }

    public void altera(int id, String novaDesc, String novoPreco, String novaFoto) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            String SQL = "UPDATE remedio SET descricao = '" + novaDesc + "', preco = '" + novoPreco + "', foto = '" + novaFoto
                    + "' WHERE id_remedio = '" + id + "';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao alterar dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
    }

    public void remove(int id) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;

        if (id == 0) {
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "DELETE FROM remedio WHERE id_remedio = '" + id + "';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao remover dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
    }

    public List<BeanRemedio> consultaNome(String buscanome) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanRemedio novo = null;

        try {
            //Define consulta
            String SQL = "SELECT * from remedio WHERE nome LIKE '%" + buscanome + "%';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanRemedio> list = new ArrayList<BeanRemedio>();

            while (rs.next()) {
                String nome = rs.getObject("nome").toString();
                String descricao = rs.getObject("descricao").toString();
                String validade = rs.getObject("validade").toString();
                String preco = rs.getObject("preco").toString();
                String foto = rs.getObject("foto").toString();
                int um_id = rs.getInt("um_id");

                novo = new BeanRemedio(nome, descricao, validade, um_id, foto, um_id);
                list.add(novo);
            }

            return list;
        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
}
