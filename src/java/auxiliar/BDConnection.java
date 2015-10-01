package auxiliar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import model.XolerDAOException;

public class BDConnection {

    public static Connection getConnection(boolean logado) throws XolerDAOException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //String conexao = "jdbc:mysql://mysql-xoler.jelastic.websolute.net.br/xoler";
            //String usuario, senha;
            String conexao = "jdbc:mysql://localhost/xoler";
            String usuario, senha;
            if(logado){
                usuario = "root";
                senha = "";
            }else{
                usuario = "x";
                senha = "x";
            }
            Connection conn = DriverManager.getConnection(conexao, usuario, senha);
            return conn;
        } catch (Exception e) {
            throw new XolerDAOException(e.getMessage());
        }
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws XolerDAOException {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt)
            throws XolerDAOException {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn)
            throws XolerDAOException {
        close(conn, null, null);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs)
            throws XolerDAOException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new XolerDAOException(e.getMessage());
        }
    }
}
