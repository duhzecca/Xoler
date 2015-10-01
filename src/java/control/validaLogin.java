package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

public class validaLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String acao = request.getParameter("acao");
        
        if(acao.compareTo("login") == 0){

        }else if(acao.compareTo("logout") == 0){
            logout(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
                
        String acao = request.getParameter("acao");
        if(acao.compareTo("login") == 0){
            login(request, response);
        }else if(acao.compareTo("logout") == 0){
            logout(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("usuarioLogin");
        String senha = request.getParameter("senhaLogin");

        //if deve verificar se usuario existe pelo banco de dados
        BeanUsuario user;
        
        try{
            DAOLogin loga = new DAOLogin();
            user = loga.buscaUser(login, senha);
        }catch(Exception sqle){
            user = null;
        }

        if(null != user){
            HttpSession session = request.getSession(); //sem parametro false, portanto se tiver outra sessao criada ele destroi
            session.setAttribute("Usuario", user);
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("loginfail.jsp");
        }

        
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}