<%-- 
    Document   : visitante
    Created on : 23/01/2013, 20:44:25
    Author     : Felipe
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.BeanLivro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>XôLer - Visitante</title>
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
    <%
          if (null == request.getAttribute("listaTopLivro")) {%>
    <jsp:forward page="/AcaoLivro?acao=listaTopLivro&paginaOrigem=visitante"/>
    <%}
    %>
    <!-- Header -->
    <div id="header" class="shell">
      <div id="logo"><h1><a href="visitante.jsp" title="Página principal do visitante"></a></h1></div>
      <!-- Navigation -->
      <div id="navigation">
        <div id="search">
          <%@include file="formBusca.html" %>
        </div>
      </div>
      <!-- End Navigation -->
      <div class="cl">&nbsp;</div>
      <!-- Login-details -->
      <div id="login-details">
        <p><a href="login.jsp">Login</a></p><p>&nbsp|&nbsp</p><p><a href="cadastro.jsp" id="user">Cadastrar-se</a></p>
      </div>
      <!-- End Login-details -->
    </div>
    <!-- End Header -->
    <!-- Slider -->
    <div id="slider">
      <div class="shell">
        <ul>
          <li>
            <div class="image">
              <img src="css/images/books.png" alt="" />
            </div>
            <div class="details">
              <h2>
                <h2>XôLer</h2>
                <br><br>
                <p class="title">Bem vindo!</p>
                <p class="description">Aqui você encontra diversos livros voltados à área técnica para leitura online.</p>
                <a href="#" class="read-more-btn">Saiba mais</a>
                 
              </h2>
            </div>
          </li>
          <li>
            <div class="image">
              <!--<img src="css/images/books.png" alt="" />-->
            </div>
            <div class="details">
              <!--
                    <h2>Bestsellers</h2>
                    <h3>Special Offers</h3>
                    <p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
                    <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>
                    <a href="#" class="read-more-btn">Read More</a>
              -->
            </div>
          </li>
          <li>
            <div class="image">
              <!--<img src="css/images/books.png" alt="" />-->
            </div>
            <div class="details">
              <!--
                    <h2>Bestsellers</h2>
                    <h3>Special Offers</h3>
                    <p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
                    <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>
                    <a href="#" class="read-more-btn">Read More</a>
              -->
            </div>
          </li>
          <li>
            <div class="image">
              <!--<img src="css/images/books.png" alt="" />-->
            </div>
            <div class="details">
              <!--
                    <h2>Bestsellers</h2>
                    <h3>Special Offers</h3>
                    <p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
                    <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>
                    <a href="#" class="read-more-btn">Read More</a>
              -->
            </div>
          </li>
        </ul>
        <div class="nav">
          <a href="#">1</a>
          <a href="#">2</a>
          <a href="#">3</a>
          <a href="#">4</a>
        </div>
      </div>
    </div>
    <!-- End Slider -->
    <!-- Main -->
    <!-- Main -->
    <div id="main" class="shell">
      <div id="content">
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
            <li>Nao ha Livros</li>
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
  </body>
</html>
