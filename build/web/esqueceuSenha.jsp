<%-- 
    Document   : excluirConta
    Created on : 26/01/2013, 18:06:53
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>XôLer - Recuperar Senha</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="css/images/favicon.ico" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <script type="text/javascript">
      function exibeAlertaCadastro(x){
        alert(x);
      }

  
      function VerificaEmail(dado)
        {
            var expr = /^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$/;
            
            if(expr.test(dado)){
                alert('Um email estará sendo enviado com os seus dados')
                return true
            }
            else {
                alert("Você deve informar seu email para esta ação.")
                return false
            }
        }
    </script>
  </head>
  <body>
    <%@include file="recuperaSession.jsp" %>
    <%
      String x = (String) request.getAttribute("msgCadastro");
      if (x != null) {
        //
%>
    <script>
      exibeAlertaCadastro('<%=x%>');
    </script>
    <%
      }
    %>
    <div id="login">
      <h1 style="text-align: center"><a href="index.jsp" title="Página Inicial">XôLer</a></h1><br><br><br>
      <label style="margin-left: 150px; font-size: 24px; color: #73c1e0;">Recuperar senha</label><br><br>
      <form id="loginForm" method="post" onsubmit="return VerificaEmail(document.getElementById('email').value)" action="login.jsp">
        <label>Para recuperar sua senha, informe seu email abaixo e clique em "Recuperar senha".</label><br><br>
        <input type="text" name="email" id="email" class="field" size="40"/><br>
        <input type="submit" id="entrar" value="Recuperar senha" style="font-size: 16px; margin-left: 217px;">
        <input type="hidden" name="acao" id="acao" value="recuperar" />        
      </form>
      <a href="perfil.jsp">&lt;&lt; Voltar ao Perfil</a>
      <br><br>
    </div>
  </body>
</html>
