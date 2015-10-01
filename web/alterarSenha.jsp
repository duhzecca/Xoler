<!DOCTYPE html>
<html>
  <head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="css/images/favicon.ico" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <script type="text/javascript" src="js/funcoes.js"></script>
    <script type="text/javascript">
      function exibeAlertaSenha(x){
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

    <%@include file="recuperaSession.jsp" %>

    <div id="cadastro">
      <h1 style="text-align: center"><a href="#">XôLer</a></h1>
      <% if (logado) {%>
      <div id="login-admin2">
        <p><a href="perfil.jsp" id="user"><%=user.getFirstNome(user.getNome())%></a></p><p>&nbsp|&nbsp</p><p> Sair</p>
      </div>
      <%} else {%>
      <jsp:forward page="login.jsp"/>
      <%}%>
      <br><br><br>
      <label style="margin-left: 396px; font-size: 24px; color: #73c1e0;">Alteração de Senha</label><br>
      <form id="alteracaoDeSenha" method="post" action="AcaoUsuario">
        <table>
          <tr><td></td><td style="text-align: left; color:#8A8A8A">(<font color="red">*</font>) - Campos obrigatórios.<input type="hidden" name="acao" id="acao" value="alterarSenha"/></td><td><input type="hidden" name="email" value="<%=user.getEmail()%>"/></td></tr>
          <tr><td class="labelTd">Senha Atual: (<font color="red">*</font>)</td><td><input type="password" name="senhaAtual" size="40" id="senhaAtual"/></td><td></td></tr>
          <tr><td class="labelTd">Nova Senha: (<font color="red">*</font>)</td><td><input type="password" name="senha" size="40" maxlength="20" id="senha" onkeyup="VerificacaoSenha(document.getElementById('senha').value), LiberarBotao();"/></td><td><div id="alertSenha" style="position:absolute; right: 422px; top: 200px; " ></div></td></tr>
          <tr><td class="labelTd">Confirme a nova senha: (<font color="red">*</font>)</td><td> <input type="password" name="senha2" size="40" maxlength="20" id="senha2" onkeyup="VerificacaoSenhasIguais(document.getElementById('senha').value, document.getElementById('senha2').value), LiberarBotao();"/></td><td><div id="alertSenha2" style="position:absolute; right: 422px; top: 235px;"></div></td></tr>
          <tr><td></td><td colspan="2" style="float: right; width: 280px; padding-top: 5px;"><a href="perfil.jsp">&lt;&lt; Voltar ao Perfil</a> <input type="submit" id="alterarSenha" value="Alterar Senha" class="links" disabled="disabled" title="Para concluir a alteração, preecha os dados corretamente!"/></td></tr>
        </table>
      </form>
      <br><br>
    </div>
  </body>
</html>
