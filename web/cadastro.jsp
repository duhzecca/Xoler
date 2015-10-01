<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>XôLer - Cadastro</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="shortcut icon" href="css/images/favicon.ico" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <script type="text/javascript" src="js/funcoes.js" charset="utf-8"></script>
    <script type="text/javascript">
      function exibeAlertaCadastro(x){
        alert(x);
      }
    </script>
  </head>
  <body>
    <% 
        String x = (String)request.getAttribute("msgCadastro");
        if(x != null){
          //
    %>
    <script>
      exibeAlertaCadastro('<%=x%>');
    </script>
    <%
       }
    %>
    <div id="cadastro">
      <h1 style="text-align: center"><a href="login.jsp" title="Login">XôLer</a></h1>
      <br><br><br>
      <label style="margin-left: 364px; font-size: 24px; color: #73c1e0;">Cadastro de Usuário</label><br>
      <form id="newUser" method="post" action="AcaoUsuario">
        <table>
          <tr><td></td><td style="text-align: left; color:#8A8A8A">(<font color="red">*</font>) - Campos obrigatórios.<input type="hidden" name="acao" id="acao" value="adicionar"/></td><td></td></tr>
          <tr><td class="labelTd">Nome Completo: (<font color="red">*</font>)</td><td><input type="text" name="nome" size="40" id="pNome" value="Informe seu nome completo" onfocus="EmptyField(this.id);" onblur="VerificaPNome(document.getElementById('pNome').value),EmptyField2(this.id)" onkeyup="VerificaPNome(document.getElementById('pNome').value), LiberaBotao();"/></td><td><div id="alertPNome"></div></td></tr>
          <tr><td class="labelTd">Email: (<font color="red">*</font>)  </td><td><input type="text" name="email" size="40" id="email" value="Exemplo: aaaa@aaaa.com" onfocus="EmptyField(this.id);" onblur="VerificaEmail(document.getElementById('email').value),EmptyField2(this.id)" onkeyup="VerificaEmail(document.getElementById('email').value), LiberaBotao();"/></td><td><div id="alertEmail"></div></td></tr>
          <tr><td class="labelTd">Senha: (<font color="red">*</font>)</td><td><input type="password" name="senha" size="40" maxlength="20" id="senha" onkeyup="VerificaSenha(document.getElementById('senha').value), LiberaBotao();"/></td><td><div id="alertSenha"></div></td></tr>
          <tr><td class="labelTd">Repita a Senha: (<font color="red">*</font>)</td><td> <input type="password" name="senha2" size="40" maxlength="20" id="senha2" onkeyup="VerificaSenhasIguais(document.getElementById('senha').value, document.getElementById('senha2').value), LiberaBotao();"/></td><td><div id="alertSenha2"></div></td></tr>
          <tr><td></td><td colspan="2" style="float: right; width: 280px; padding-top: 5px;"><a href="login.jsp">&lt;&lt; Voltar à pagina de acesso</a> <input type="submit" disabled="true" id="cadastrar" value="Cadastrar" class="links" title="Para concluir o cadastro, preecha os dados corretamente!"></td></tr>
        </table>
      </form>
      <br><br>
    </div>
  </body>
</html>
