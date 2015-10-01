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
public class AcaoUsuario extends HttpServlet{
    
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
        if(acao.compareTo("adicionar") == 0){
            try {
                acaoAdicionar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(acao.compareTo("alterar") == 0){
            try {
                acaoAlterar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(acao.compareTo("remover") == 0){
            try {
                acaoRemover(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(acao.compareTo("alterarSenha") == 0){
            try {
                acaoAlterarSenha(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void acaoAdicionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        String email = request.getParameter("email");
        String nome = request.getParameter("nome");                        
        String senha = request.getParameter("senha");        
        
        boolean logado = true;
        boolean erro = false;
        boolean usuarioExiste = false;

        try {            
            DAOUsuario user = new DAOUsuario(logado);            
            usuarioExiste = user.adiciona(email, nome, senha);            
            
        } catch (XolerDAOException sqle) {
            erro = true;
        }
        RequestDispatcher rd = null;
        if(erro){
          request.setAttribute("msgCadastro", "Ocorreu um erro durante o cadastro. Tente novamente mais tarde.");
          rd = request.getRequestDispatcher("/cadastro.jsp");
        }
        if(usuarioExiste){
          request.setAttribute("msgCadastro", "Email já cadastrado!");
          rd = request.getRequestDispatcher("/cadastro.jsp");
        }
        if(!erro && !usuarioExiste){
          request.setAttribute("msgCadastro", "Cadastro efetuado com sucesso!");
          rd = request.getRequestDispatcher("/login.jsp");
        }
        rd.forward(request, response);
    }
    
    private void acaoAlterarSenha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        String email = request.getParameter("email");                    
        String senhaAtual = request.getParameter("senhaAtual");
        String senhaNova = request.getParameter("senha");
        
        boolean logado = true;
        boolean erro = false;
        boolean senhaNaoConfere = false;

        try {            
            DAOUsuario user = new DAOUsuario(logado);            
            senhaNaoConfere = user.alteraSenha(email, senhaAtual, senhaNova);            
            
        } catch (XolerDAOException sqle) {
            erro = true;
        }
        RequestDispatcher rd = null;
        if(erro){
          request.setAttribute("msgSenha", "Ocorreu um erro durante a alteração. Tente novamente mais tarde.");
          rd = request.getRequestDispatcher("/alterarSenha.jsp");
        }
        if(senhaNaoConfere){
          request.setAttribute("msgSenha", "Senha atual inválida!");
          rd = request.getRequestDispatcher("/alterarSenha.jsp");
        }
        if(!erro && !senhaNaoConfere){
          request.setAttribute("msgSenha", "Senha alterada com sucesso!");
          rd = request.getRequestDispatcher("/perfil.jsp");
        }
        rd.forward(request, response);
    }
    
    public void acaoAlterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        boolean logado = true;
        
        try{
            DAOUsuario user = new DAOUsuario(logado);
            user.altera(email, senha);
        }catch (XolerDAOException sqle){
            
        }
        
        response.sendRedirect("index.jsp");
    }

    public void acaoRemover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {    
        String email = request.getParameter("emailExcluir");
        String senha = request.getParameter("senhaExcluir");
        
        boolean logado = true;
        boolean erro = false;
        boolean senhaNaoConfere = false;
        
        try{
            DAOUsuario user = new DAOUsuario(logado);
            senhaNaoConfere = user.remove(email, senha);
        }catch (XolerDAOException sqle){
            erro = true;
        }
        RequestDispatcher rd = null;
        if(erro){
          request.setAttribute("msgCadastro", "Ocorreu um erro durante a exclusão. Tente novamente mais tarde.");
          rd = request.getRequestDispatcher("/excluirConta.jsp");
        }
        if(senhaNaoConfere){
          request.setAttribute("msgCadastro", "Senha inválida!");
          rd = request.getRequestDispatcher("/excluirConta.jsp");
        }
        if(!erro && !senhaNaoConfere){
          request.setAttribute("msgCadastro", "Conta removida com sucesso!");
          rd = request.getRequestDispatcher("/login.jsp");
        }
        rd.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
