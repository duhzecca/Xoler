<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
  <head>
    <title>XÙLer - Meu Perfil</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="css/images/favicon.ico" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
    <!--[if IE 6]>
            <script type="text/javascript" src="js/png-fix.js"></script>
    <![endif]-->
    <script type="text/javascript" src="js/functions.js"></script>
    <script type="text/javascript">
      function exibeAlertaSenha(x){
        alert(x);
      }
    </script>
  </head>
  <body>
    <%
      String x = (String) request.getAttribute("msgSenha");
      if (x != null) {
        //
    %>
    <script>
      exibeAlertaSenha('<%=x%>');
    </script>
    <%
      }
    %>
    <%@include file="recuperaSession.jsp"%>
    <!-- Header -->
    <div id="header" class="shell">
      <div id="logo"><h1><a href="index.jsp" title="P·gina principal"></a></h1></div>
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
        <%} else {%>
        <p><a href="perfil.jsp" onclick="" style="margin-right: 50px"><%=user.getFirstNome(user.getNome())%></a> <form method="get" action="validaLogin" style="text-align: right; margin-top: -20px;" ><input type="submit" value="Sair" onclick="validaLogin" style="font-size: 15px; margin-right: 20px; margin-top: 20px;"/><input type="hidden" name="acao" value="logout"/></form></p>
        <%}
        } else { //se nao esta logado
%>
        <jsp:forward page="login.jsp"/>
        <%}%>
      </div>
      <!-- End Login-details -->
    </div>
    <!-- End Header -->

    <!-- Main -->
    <div id="main" class="shell">
      <div id="content">
        <label style="font-size: 24px; color: #73c1e0;">Meu Perfil</label><br><br>
            <div id="dados">
              <b>Nome:</b> <%=user.getNome()%><br>
              <b>Email:</b> <%=user.getEmail()%><br><br>
              <div class="button" style="float:none; display: inline"><a title="Alterar Minha Senha" href="alterarSenha.jsp">Alterar Senha</a></div>
              <div class="button" style="float:none"><a title="Excluir Minha Conta" href="excluirConta.jsp">Excluir Minha Conta</a></div>
            </div>
            <div class="cl">&nbsp;</div>
            <br><br><br>
            <div class="button" style="float: none; text-align: left;"><a href="index.jsp" title="P·gina principal">&lt;&lt; Voltar ‡ p·gina principal</a></div>
      </div>
      <!-- End Content -->
      <div class="cl">&nbsp;</div>
      </div>
      <!-- End Main -->
      <!-- Footer -->
      <%@include file="rodape.html"%>
      <!-- End Footer -->
      </body>
      </html>