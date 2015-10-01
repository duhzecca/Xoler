package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import model.BeanLivro;
import java.util.List;
import model.BeanUsuario;

public final class resultBusca_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/recuperaSession.jsp");
    _jspx_dependants.add("/formBusca.html");
    _jspx_dependants.add("/rodape.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html lang=\"en-US\" xmlns=\"http://www.w3.org/1999/xhtml\" dir=\"ltr\">\n");
      out.write("  <head>\n");
      out.write("    <title>XôLer - Resultado da Busca</title>\n");
      out.write("    <meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("    <link rel=\"shortcut icon\" href=\"css/images/favicon.ico\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-1.6.2.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.jcarousel.min.js\"></script>\n");
      out.write("    <!--[if IE 6]>\n");
      out.write("            <script type=\"text/javascript\" src=\"js/png-fix.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("    <script type=\"text/javascript\" src=\"js/functions.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"js/funcoes.js\"></script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");

  //recupera session
  HttpSession s = request.getSession(false);
  BeanUsuario user = null;
  boolean logado = false;
  if (null != s && (BeanUsuario) s.getAttribute("Usuario") != null) {
    logado = true;
    user = (BeanUsuario) s.getAttribute("Usuario");
  }

      out.write("\n");
      out.write("\n");
      out.write("    <!-- Header -->\n");
      out.write("    <div id=\"header\" class=\"shell\">\n");
      out.write("      ");
if (logado) {
      out.write("\n");
      out.write("      <div id=\"logo\"><h1><a href=\"index.jsp\" title=\"Página principal\"></a></h1></div>\n");
      out.write("      ");
} else {
      out.write("\n");
      out.write("      <div id=\"logo\"><h1><a href=\"visitante.jsp\" title=\"Página principal do visitante\"></a></h1></div>\n");
      out.write("      ");
}
      out.write("\n");
      out.write("      <!-- Navigation -->\n");
      out.write("      <div id=\"navigation\">\n");
      out.write("        <div id=\"search\">\n");
      out.write("          ");
      out.write("<form action=\"AcaoLivro\" method=\"post\">\r\n");
      out.write("  <input type=\"hidden\" value=\"buscar\" id=\"acao\" name=\"acao\"/> \r\n");
      out.write("  <input type=\"text\" value=\"Buscar...\" name=\"searchfield\" id=\"searchfield\" size=\"100\" title=\"Informe o que deseja buscar\" onfocus=\"EmptyField(this.id);\" onblur=\"EmptyField2(this.id);\" />\r\n");
      out.write("  <input type=\"submit\" name=\"Search\" value=\"Buscar\" alt=\"Search\" id=\"searchbutton\" title=\"Buscar\" />\r\n");
      out.write("  <input style=\"margin: 10px 0 0 10px;\" type=\"radio\" value=\"titulo\" name=\"tipoBusca\" CHECKED/><label> T&iacute;tulo</label>\r\n");
      out.write("  <input style=\"margin: 10px 0 0 40px;\" type=\"radio\" value=\"autor\" name=\"tipoBusca\"/><label> Autor</label>\r\n");
      out.write("  <input style=\"margin: 10px 0 0 40px;\" type=\"radio\" value=\"assunto\" name=\"tipoBusca\"/><label> Assunto</label>\r\n");
      out.write("</form>");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- End Navigation -->\n");
      out.write("      <div class=\"cl\">&nbsp;</div>\n");
      out.write("      <!-- Login-details -->\n");
      out.write("      <div id=\"login-details\">\n");
      out.write("        ");

          if (logado) {
        
      out.write("\n");
      out.write("        <p><a href=\"perfil.jsp\" onclick=\"\" style=\"margin-right: 50px\">");
      out.print(user.getFirstNome(user.getNome()));
      out.write("</a> <form method=\"get\" action=\"validaLogin\" style=\"text-align: right; margin-top: -20px;\" ><input type=\"submit\" value=\"Sair\" onclick=\"validaLogin\" style=\"font-size: 15px; margin-right: 20px; margin-top: 20px;\"/><input type=\"hidden\" name=\"acao\" value=\"logout\"/></form></p>\n");
      out.write("        ");
} else { //se nao esta logado

      out.write("\n");
      out.write("        <p><a href=\"login.jsp\">Login</a></p><p>&nbsp|&nbsp</p><p><a href=\"cadastro.jsp\" id=\"user\">Cadastrar-se</a></p>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <!-- End Login-details -->\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Main -->\n");
      out.write("    <div id=\"main\" class=\"shell\">\n");
      out.write("      <div id=\"content\">\n");
      out.write("        <h3>Resultados da busca</h3>\n");
      out.write("        <div class=\"list\">\n");
      out.write("          <ul>\n");
      out.write("            ");

              List<BeanLivro> listaLivros = null;
              if (request.getAttribute("listaLivros") != null) {
                listaLivros = (List<BeanLivro>) request.getAttribute("listaLivros");
              }
              if (listaLivros.isEmpty()) {

            
      out.write("\n");
      out.write("            Sua busca não retornou resultados.\n");
      out.write("            ");
} else {
                          for (Iterator i = listaLivros.iterator(); i.hasNext();) {
                            BeanLivro l = (BeanLivro) i.next();
      out.write("                        \n");
      out.write("            <li>\n");
      out.write("              ");
if (logado) {
      out.write("\n");
      out.write("              <div class=\"list-title\">\n");
      out.write("                <a href=\"javascript:void(0);\" alt=\"Ler\" class=\"fl-epubReader-container\" onclick=\"setaNoQuery('");
      out.print(l.getConteudoLivro());
      out.write("');\"><b>");
      out.print(l.getNome());
      out.write("</b></a> - by ");
      out.print(l.getAutor());
      out.write("\n");
      out.write("              </div>\n");
      out.write("              <div class=\"list-art\">\n");
      out.write("                <a href=\"javascript:void(0);\"><img src=\"");
      out.print( l.getCapa());
      out.write("\" class=\"fl-epubReader-container\" onclick=\"setaNoQuery('");
      out.print(l.getConteudoLivro());
      out.write("');\" alt=\"Img\" /></a>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"list-text\"><p>");
      out.print(l.getDescricao());
      out.write("</p></div>\n");
      out.write("              <div class=\"button\"><a href=\"javascript:void(0);\" onclick=\"adicionarLivro('");
      out.print(user.getEmail());
      out.write("', ");
      out.print(l.getCod());
      out.write(");\">Adicionar à lista</a> <a href=\"#\">Ler</a></div>\n");
      out.write("              ");
}else{
      out.write("\n");
      out.write("              <div class=\"list-title\">\n");
      out.write("                <a href=\"javascript:void(0);\" onclick=\"javascript:alert('Para visualizar o conteúdo do livro, você deve estar logado!');\" title=\"Para visualizar o conteúdo do livro, você deve estar logado!\" disabled=\"true\"><b>");
      out.print(l.getNome());
      out.write("</b></a> - by ");
      out.print(l.getAutor());
      out.write("\n");
      out.write("              </div>\n");
      out.write("              <div class=\"list-art\">\n");
      out.write("                <a href=\"javascript:void(0);\"><img src=\"");
      out.print( l.getCapa());
      out.write("\" alt=\"Capa\" onclick=\"javascript:alert('Para visualizar o conteúdo do livro, você deve estar logado!');\" /></a>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"list-text\"><p>");
      out.print(l.getDescricao());
      out.write("</p></div>\n");
      out.write("              ");
}
      out.write("\n");
      out.write("              <div class=\"clear-float\"></div>\n");
      out.write("\n");
      out.write("            </li>\n");
      out.write("            ");
}
            }
      out.write("\n");
      out.write("          </ul>\n");
      out.write("          ");
if (logado) {
      out.write("\n");
      out.write("          <div class=\"button\" style=\"float: none; text-align: center;\"><a href=\"index.jsp\" title=\"Página principal\">&lt;&lt; Voltar à página principal</a></div>\n");
      out.write("          ");
} else {
      out.write("\n");
      out.write("          <div class=\"button\" style=\"float: none; text-align: center;\"><a href=\"visitante.jsp\" title=\"Página principal do visitante\">&lt;&lt; Voltar à página principal</a></div>\n");
      out.write("          ");
}
      out.write("\n");
      out.write("          <div class=\"clear-float\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"cl\">&nbsp;</div>\n");
      out.write("\n");
      out.write("        <!-- End Content -->\n");
      out.write("      </div>\n");
      out.write("      <div class=\"cl\">&nbsp;</div>\n");
      out.write("    </div>                     \n");
      out.write("    <!-- End Main -->\n");
      out.write("    <!-- Footer -->\n");
      out.write("    ");
      out.write("<div id=\"footer\" class=\"shell\">\r\n");
      out.write("  <div class=\"cl\">&nbsp;</div>\r\n");
      out.write("  <div class=\"copy\">\r\n");
      out.write("    <p style=\"text-align: center;\">Template by <a href=\"http://css-free-templates.com/\">CSS-FREE-TEMPLATES.COM</a></p>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>");
      out.write("\n");
      out.write("    <!-- End Footer -->\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("      function adicionarLivro(email, cod){\n");
      out.write("        var decisao = window.confirm(\"Deseja mesmo adicionar o livro em sua lista?\");\n");
      out.write("        if(decisao){\n");
      out.write("          //chama acaoLivro\n");
      out.write("          document.location.href = \"AcaoLivro?acao=adicionarLista&email=\"+email+\"&cod=\"+cod;\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("      function EmptyField(id)\n");
      out.write("      {\n");
      out.write("        var Fid = document.getElementById(id);\n");
      out.write("        var TheDefaultValue = Fid.defaultValue;\n");
      out.write("        var TheValue = Fid.value;\n");
      out.write("\n");
      out.write("        if(TheDefaultValue == TheValue) //se quando ganhar foco, o conteudo for o default zera o campo\n");
      out.write("        {\n");
      out.write("          Fid.value = '';\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      function EmptyField2(id)\n");
      out.write("      {\n");
      out.write("        var Fid = document.getElementById(id);\n");
      out.write("        var TheDefaultValue = Fid.defaultValue;\n");
      out.write("        var TheValue = Fid.value;\n");
      out.write("\n");
      out.write("        if(TheValue == '')//se o conteudo for vazio quando perder o foco, volta ao default\n");
      out.write("        {\n");
      out.write("          Fid.value = TheDefaultValue;\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
