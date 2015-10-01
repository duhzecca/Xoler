/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class AcaoLivro extends HttpServlet{
    
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
        String acao = request.getParameter("acao");
        if(acao.compareTo("listaTopLivro") == 0){
            try{
                acaoListaTopLivro(request, response);
            } catch (XolerDAOException ex){
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (acao.compareTo("adicionarLista") == 0) {
            try {
                acaoAdicionarLista(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("removerLista") == 0) {
            try {
                acaoRemoverLista(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try{
                acaoListaMeusLivros(request, response);
            } catch (XolerDAOException ex){
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.compareTo("adicionarLista") == 0) {
            try {
                acaoAdicionarLista(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else 
        if (acao.compareTo("adicionar") == 0) {
            try {
                acaoAdicionar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("alterar") == 0) {
            try {
                acaoAlterar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoLivro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("remover") == 0) {
            try {
                acaoRemover(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoEditora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (acao.compareTo("removerLista") == 0) {
            try {
                acaoRemoverLista(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (acao.compareTo("buscar") == 0) {
            try {
                acaoBuscar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoEditora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        private void acaoAdicionarLista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        String email = request.getParameter("email");
        String x = request.getParameter("cod");
        int cod = Integer.parseInt(x);

        boolean logado = true;

        PrintWriter out = response.getWriter();

        try {
            DAOLivro livro = new DAOLivro(logado);
            livro.adicionaLista(email, cod);
        } catch (XolerDAOException sqle) {
            out.print("erro");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

        rd.forward(request, response);
    }
        
    private void acaoRemoverLista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        String email = request.getParameter("email");
        String x = request.getParameter("cod");
        int cod = Integer.parseInt(x);
        boolean logado = true;

        PrintWriter out = response.getWriter();

        try {
            DAOLivro livro = new DAOLivro(logado);            
            livro.removeLista(email, cod);
        } catch (XolerDAOException sqle) {
            out.print("erro");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

        rd.forward(request, response);
    }       
    
    
    private void acaoAtualizaIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException{
        response.setContentType("text/html");
        String nome = request.getParameter("nome");
        StringBuffer retorno = new StringBuffer("");
        List<BeanLivro> listaDeLivros;
        
        try{
            DAOLivro livros = new DAOLivro(false);
            listaDeLivros = livros.listaTopLivros();
        } catch (Exception sqle){
            listaDeLivros = null;
        }
        
        PrintWriter out = response.getWriter();
        
        out.println("<ul>");
        
        for(BeanLivro nova : listaDeLivros){
            retorno.append("<li><a href=\"#\">" + nova.getCapa() + "</a><br>" + nova.getNome() + "<br>" + nova.getAutor() + "</li>");                        
        }
        
        out.println(retorno);
        
        out.println("</ul>");
        
        out.flush();
        out.close();
        
        
    }

    private void acaoAdicionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException{
        
        String nome = request.getParameter("nome");
        String autor = request.getParameter("autor");
        String tag = request.getParameter("tag");
        String capa = request.getParameter("capa");
        String conteudoLivro = request.getParameter("conteudoLivro");        
        String editora = request.getParameter("editora");
        String descricao = request.getParameter("descricao");
        
        boolean logado = true;
        
        PrintWriter out = response.getWriter();
        
        try{
            DAOLivro livro = new DAOLivro(logado);            
            livro.adiciona(nome, autor, tag, capa, conteudoLivro, editora,descricao);            
        }catch (XolerDAOException sqle){
            out.print("erro");
        }        
        
        RequestDispatcher rd = request.getRequestDispatcher("/admin.html");

        rd.forward(request, response);
    }
    
    private void acaoAlterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException{
        
        String nome = request.getParameter("nome");
        String novoNome = request.getParameter("novoNome");
        String autor = request.getParameter("autor");
        String editora = request.getParameter("editora");
        
        boolean logado = true;
        
        PrintWriter out = response.getWriter();
        
        try{
            DAOLivro livro = new DAOLivro(logado);
            livro.altera(nome, novoNome, autor, editora);
        }catch (XolerDAOException sqle){
            out.print("erro");
        }                             
        
    }
    
    private void acaoRemover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException{
        
        String nome = request.getParameter("nome");
        
        boolean logado = true;       
    
        PrintWriter out = response.getWriter();
        
        try{
            DAOLivro livro = new DAOLivro(logado);
            livro.remove(nome);
        }catch (XolerDAOException sqle){
            out.print("erro");
        }                             

    
    }
    
    private void acaoBuscar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, XolerDAOException{
        String searchField = request.getParameter("searchfield");
        String radio = request.getParameter("tipoBusca");
        boolean logado = true;

        List<BeanLivro> list = null;
        try{
            DAOLivro livros = new DAOLivro(logado);

            if(radio.compareTo("titulo") == 0){
                list = livros.consultaTitulo(searchField);
            }else if(radio.compareTo("autor") == 0){
                list = livros.consultaAutor(searchField);
            }else{
                list = livros.consultaAssunto(searchField);
            }
            request.setAttribute("listaLivros", list);
                            

        }catch(XolerDAOException sqle){
            request.setAttribute("listaLivros", null);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/resultBusca.jsp");

        rd.forward(request, response);

    }
    
    
      private void acaoListaTopLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {
        List<BeanLivro> listaDeLivros;
        String paginaOrigem = request.getParameter("paginaOrigem");
        
        try {
            DAOLivro livros = new DAOLivro(true);
            listaDeLivros = livros.listaTopLivros();
            request.setAttribute("listaTopLivro", listaDeLivros);
        } catch (Exception sqle) {
            listaDeLivros = new ArrayList<BeanLivro>();
            request.setAttribute("listaTopLivro", listaDeLivros);
        }
        RequestDispatcher rd = null;
        if(paginaOrigem.equals("index")){
          rd = request.getRequestDispatcher("/index.jsp");
        }else{
          rd = request.getRequestDispatcher("/visitante.jsp");
        }

        rd.forward(request, response);
    }
    
      private void acaoListaMeusLivros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {
        List<BeanLivro> listaDeLivros;
        String email = request.getParameter("user");
        try {
            DAOLivro livros = new DAOLivro(true);
            listaDeLivros = livros.listaMeusLivros(email);
            request.setAttribute("listaMeusLivros", listaDeLivros);
        } catch (Exception sqle) {
            listaDeLivros = new ArrayList<BeanLivro>();
            request.setAttribute("listaMeusLivros", listaDeLivros);
        }
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("/index.jsp");

        rd.forward(request, response);
    }
}
