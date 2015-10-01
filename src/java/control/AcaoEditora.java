/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;


/**
 *
 * @author user
 */
public class AcaoEditora extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        } finally {
            out.close();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.compareTo("adicionar") == 0) {
            try {
                acaoAdicionar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("alterar") == 0) {
        } else if (acao.compareTo("remover") == 0) {
            try {
                acaoRemover(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoEditora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void acaoAdicionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException{
        
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        
        boolean logado = true;
        
        PrintWriter out = response.getWriter();                                
        
        try{
            DAOEditora editora = new DAOEditora(logado);
            editora.adiciona(nome, endereco, telefone);
        }catch (XolerDAOException sqle){
            out.print("erro");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("/admin.html");

        rd.forward(request, response);
    }
    
    private void acaoRemover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException{
        
        String nome = request.getParameter("nome");
        
        boolean logado = true;

        PrintWriter out = response.getWriter();
        
        try{
            DAOEditora editora = new DAOEditora(logado);
            editora.remove(nome);
        }catch (XolerDAOException sqle){
            out.print("erro");
        }        
    }
    
}
