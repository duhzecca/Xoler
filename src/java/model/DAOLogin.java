package model;

import auxiliar.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DAOLogin {

    private Connection conn;

    public DAOLogin() throws XolerDAOException {
        try {
            this.conn = BDConnection.getConnection(true);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }
    }

    public BeanUsuario buscaUser(String email, String senha) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try {
            String SQL = "Select * from usuario where email = '" + email + "' AND senha = '" + senha + "';";

            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            while(rs.next()){
                BeanUsuario user = new BeanUsuario(
                        rs.getObject("email").toString(),
                        rs.getObject("nome").toString(),
                        rs.getObject("senha").toString());
                return user;
            }
            return null;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
}
