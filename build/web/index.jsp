<%@page import="java.util.Iterator"%>
<%@page import="model.BeanLivro"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@page session="false" %>
<%@page import="model.BeanUsuario"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
  <head>
    <title>XôLer - Principal</title>
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
    <%
          if (null == request.getAttribute("listaTopLivro")) {%>
    <jsp:forward page="/AcaoLivro?acao=listaTopLivro&paginaOrigem=index"/>
    <%}
    %>


    <!-- Header -->
    <div id="header" class="shell">
      <div id="logo"><h1><a href="index.jsp" title="Página principal"></a></h1></div>
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
                    if (user.getEmail().compareTo("admin") == 0) {%>
        <jsp:forward page= "admin.html" />
        <%} else {

        %>
        <p><a href="perfil.jsp" onclick="" style="margin-right: 50px"><%=user.getFirstNome(user.getNome())%></a> <form method="get" action="validaLogin" style="text-align: right; margin-top: -20px;" ><input type="submit" value="Sair" onclick="validaLogin" style="font-size: 15px; margin-right: 20px; margin-top: 20px;"/><input type="hidden" name="acao" value="logout"/></form></p>
        <%}
                } else { //se nao esta logado
%>
        <jsp:forward page="login.jsp"/>
        <%}%>

        <%
                  if (null == request.getAttribute("listaMeusLivros")) {%>
        <jsp:forward page="/AcaoLivro">
          <jsp:param name="acao" value="listaMeusLivros"/>
          <jsp:param name="user" value="<%=user.getEmail()%>"/>
        </jsp:forward>
        <%  }
        %>
      </div>
      <!-- End Login-details -->
    </div>
    <!-- End Header -->
    <!-- Main -->
    <div id="main" class="shell">
      <div id="content">
        <!-- Products -->
        <div class="products">
          <h3>Meus Livros</h3>
          <ul>
            <%
              List<BeanLivro> listaMeusLivros = null;
              if (request.getAttribute("listaTopLivro") != null) {
                listaMeusLivros = (List<BeanLivro>) request.getAttribute("listaMeusLivros");
              }
              if (listaMeusLivros.isEmpty()) {

            %>
            Você ainda não adicionou livros à sua lista. Para fazer isso, pesquise por livros que você gostaria de ler e quando encontrá-los, clique em "Adicionar à Lista". Assim, todos os livros que você adicionar aparecerão aqui!
            <%} else {
                                  for (Iterator i = listaMeusLivros.iterator(); i.hasNext();) {
                                    BeanLivro l = (BeanLivro) i.next();%>
            <li>
              <div class="product">
                <a href="#">
                  <img src="<%= l.getCapa()%>" class ="fl-epubReader-container" onclick="setaNoQuery('<%=l.getConteudoLivro()%>');" alt="" />
                  <span class="book-name"><%=l.getNome()%></span>
                  <span class="author">by <%=l.getAutor()%></span>

                </a>
                <div class="button" style="text-align: center; float: none"><a href="javascript:void(0);" onclick="removerLivro('<%=user.getEmail()%>', <%=l.getCod()%>);">Remover</a></div>    

              </div>
            </li>

            <%}
                                  }%>
          </ul
          <!-- End Products -->
        </div>
        <div class="cl">&nbsp;</div>
        <!-- Best-sellers -->
        <div id="best-sellers" style="height: 350px">
          <h3>Mais Acessados</h3>
          <ul>                         

            <%
              List<BeanLivro> listaLivros = null;
              if (request.getAttribute("listaTopLivro") != null) {
                listaLivros = (List<BeanLivro>) request.getAttribute("listaTopLivro");
              }
              if (listaLivros.isEmpty()) {

            %>
            <li>Nao há Livros</li>
            <%} else {
                                  for (Iterator i = listaLivros.iterator(); i.hasNext();) {
                                    BeanLivro l = (BeanLivro) i.next();%>
            <li>
              <div class="product">
                <a href="#">
                  <img src="<%= l.getCapa()%>" alt="" />
                  <span class="book-name"><%=l.getNome()%></span>
                  <span class="author">by <%=l.getAutor()%></span>
                </a>
              </div>
                <div class="button" style="text-align: center; float: none;"><a style="width: 80px;" href="javascript:void(0);" onclick="adicionarLivro('<%=user.getEmail()%>', <%=l.getCod()%>);">Adicionar</a></div>
                
            </li>

            <%}
            }%>
          </ul>   

          <!-- End Best-sellers -->
        </div>
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
      function removerLivro(email, cod){
        var decisao = window.confirm("Deseja mesmo remover o livro de sua lista?");
        if(decisao){
          //chama acaoLivro
          document.location.href = "AcaoLivro?acao=removerLista&email="+email+"&cod="+cod;
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