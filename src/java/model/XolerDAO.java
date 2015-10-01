package model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import auxiliar.BDConnection;
import java.util.ArrayList;
import java.util.List;

public class XolerDAO {
    private Connection conn;

    public XolerDAO() throws XolerDAOException {
        try {
            this.conn = BDConnection.getConnection(true);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: " + ":\n" + e.getMessage());
        }
    }
}
