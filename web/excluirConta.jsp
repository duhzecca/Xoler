<%-- 
    Document   : excluirConta
    Created on : 26/01/2013, 18:06:53
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>XôLer - Excluir Conta</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="css/images/favicon.ico" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <script type="text/javascript">
      function exibeAlertaCadastro(x){
        alert(x);
      }
      function VerificaSenhaExc(dado){
        if(dado.length > 0){
          return true;
        }else{
          alert("Você deve informar sua senha para esta ação.")
          return false;
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
      <% if (logado) {%>
      <div id="login-excluir">          
          <p><a href="perfil.jsp" id="user"><%=user.getFirstNome(user.getNome())%></a></p><p>&nbsp|&nbsp</p><a href="validaLogin?acao=logout" onclick="">Sair</a>
      </div>
      <%} else {%>
      <jsp:forward page="login.jsp"/>
      <%}%>
      <label style="margin-left: 150px; font-size: 24px; color: #73c1e0;">Exclusão de conta</label><br><br>
      <form id="loginForm" method="post" onsubmit="return VerificaSenhaExc(document.getElementById('senhaExcluir').value)" action="AcaoUsuario">
        <label>Para excluir sua conta, informe sua senha no campo abaixo e clique em "Excluir minha conta".</label><br><br>
        <input type="password" name="senhaExcluir" id="senhaExcluir" class="field" size="40"/><br>
        <input type="submit" id="entrar" value="Excluir minha conta" style="font-size: 16px; margin-left: 217px;">
        <input type="hidden" name="acao" id="acao" value="remover" />
        <input type="hidden" name="emailExcluir" id="emailExcluir" value="<%=user.getEmail()%>" />
      </form>
      <a href="perfil.jsp">&lt;&lt; Voltar ao Perfil</a>
      <br><br>
    </div>
  </body>
</html>
