<%@page import="java.util.Iterator"%>
<%@page import="model.BeanLivro"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page session="false" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
  <head>
    <title>XÙLer - Resultado da Busca</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="css/images/favicon.ico" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
    <!--[if IE 6]>
            <script type="text/javascript" src="js/png-fix.js"></script>
    <![endif]-->
    <script type="text/javascript" src="js/functions.js"></script>
    <script type="text/javascript" src="js/funcoes.js"></script>
  </head>
  <body>
    <%@include file="recuperaSession.jsp"%>

    <!-- Header -->
    <div id="header" class="shell">
      <%if (logado) {%>
      <div id="logo"><h1><a href="index.jsp" title="P·gina principal"></a></h1></div>
      <%} else {%>
      <div id="logo"><h1><a href="visitante.jsp" title="P·gina principal do visitante"></a></h1></div>
      <%}%>
      <!-- Navigation -->
      <div id="navigation">
        <div id="search">
          <%@include file="formBusca.html"%>
        </div>
      </div>
      <!-- End Navigation -->
      <div class="cl">&nbsp;</div>
      <!-- Login-details -->
      <div id="login-details">
        <%
          if (logado) {
        %>
        <p><a href="perfil.jsp" onclick="" style="margin-right: 50px"><%=user.getFirstNome(user.getNome())%></a> <form method="get" action="validaLogin" style="text-align: right; margin-top: -20px;" ><input type="submit" value="Sair" onclick="validaLogin" style="font-size: 15px; margin-right: 20px; margin-top: 20px;"/><input type="hidden" name="acao" value="logout"/></form></p>
        <%} else { //se nao esta logado
%>
        <p><a href="login.jsp">Login</a></p><p>&nbsp|&nbsp</p><p><a href="cadastro.jsp" id="user">Cadastrar-se</a></p>
        <%}%>
      </div>
      <!-- End Login-details -->
    </div>

    <!-- Main -->
    <div id="main" class="shell">
      <div id="content">
        <h3>Resultados da busca</h3>
        <div class="list">
          <ul>
            <%
              List<BeanLivro> listaLivros = null;
              if (request.getAttribute("listaLivros") != null) {
                listaLivros = (List<BeanLivro>) request.getAttribute("listaLivros");
              }
              if (listaLivros.isEmpty()) {

            %>
            Sua busca n„o retornou resultados.
            <%} else {
                          for (Iterator i = listaLivros.iterator(); i.hasNext();) {
                            BeanLivro l = (BeanLivro) i.next();%>                        
            <li>
              <%if (logado) {%>
              <div class="list-title">
                <a href="javascript:void(0);" alt="Ler" class="fl-epubReader-container" onclick="setaNoQuery('<%=l.getConteudoLivro()%>');"><b><%=l.getNome()%></b></a> - by <%=l.getAutor()%>
              </div>
              <div class="list-art">
                <a href="javascript:void(0);"><img src="<%= l.getCapa()%>" class="fl-epubReader-container" onclick="setaNoQuery('<%=l.getConteudoLivro()%>');" alt="Img" /></a>
              </div>
              <div class="list-text"><p><%=l.getDescricao()%></p></div>
              <div class="button"><a href="javascript:void(0);" onclick="adicionarLivro('<%=user.getEmail()%>', <%=l.getCod()%>);">Adicionar ‡ lista</a> <a href="#">Ler</a></div>
              <%}else{%>
              <div class="list-title">
                <a href="javascript:void(0);" onclick="javascript:alert('Para visualizar o conte˙do do livro, vocÍ deve estar logado!');" title="Para visualizar o conte˙do do livro, vocÍ deve estar logado!" disabled="true"><b><%=l.getNome()%></b></a> - by <%=l.getAutor()%>
              </div>
              <div class="list-art">
                <a href="javascript:void(0);"><img src="<%= l.getCapa()%>" alt="Capa" onclick="javascript:alert('Para visualizar o conte˙do do livro, vocÍ deve estar logado!');" /></a>
              </div>
              <div class="list-text"><p><%=l.getDescricao()%></p></div>
              <%}%>
              <div class="clear-float"></div>

            </li>
            <%}
            }%>
          </ul>
          <%if (logado) {%>
          <div class="button" style="float: none; text-align: center;"><a href="index.jsp" title="P·gina principal">&lt;&lt; Voltar ‡ p·gina principal</a></div>
          <%} else {%>
          <div class="button" style="float: none; text-align: center;"><a href="visitante.jsp" title="P·gina principal do visitante">&lt;&lt; Voltar ‡ p·gina principal</a></div>
          <%}%>
          <div class="clear-float"></div>
        </div>


        <div class="cl">&nbsp;</div>

        <!-- End Content -->
      </div>
      <div class="cl">&nbsp;</div>
    </div>                     
    <!-- End Main -->
    <!-- Footer -->
    <%@include file="rodape.html"%>
    <!-- End Footer -->
    <script type="text/javascript">
      function adicionarLivro(email, cod){
        var decisao = window.confirm("Deseja mesmo adicionar o livro em sua lista?");
        if(decisao){
          //chama acaoLivro
          document.location.href = "AcaoLivro?acao=adicionarLista&email="+email+"&cod="+cod;
        }
      }
      function EmptyField(id)
      {
        var Fid = document.getElementById(id);
        var TheDefaultValue = Fid.defaultValue;
        var TheValue = Fid.value;

        if(TheDefaultValue == TheValue) //se quando ganhar foco, o conteudo for o default zera o campo
        {
          Fid.value = '';
        }
      }

      function EmptyField2(id)
      {
        var Fid = document.getElementById(id);
        var TheDefaultValue = Fid.defaultValue;
        var TheValue = Fid.value;

        if(TheValue == '')//se o conteudo for vazio quando perder o foco, volta ao default
        {
          Fid.value = TheDefaultValue;
        }
      }
    </script>
  </body>
</html>