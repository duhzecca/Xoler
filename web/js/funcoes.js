var a, b, c, f, g, h, i = false;

////////////////////////////////FUNCOES DE VERIFICACAO DE DADOS
function VerificaPNome(dado){
    if(dado != ''){
        document.getElementById('alertPNome').innerHTML = '<img title="Nome OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        a = true
        return true
    } else{
        document.getElementById('alertPNome').innerHTML = '<img title="Nome Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        a = false
        return false
    }
}

function VerificaSNome(dado){
    if(dado != ''){
        document.getElementById('alertSNome').innerHTML = '<img title="Sobrenome OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        b = true
        return true
    } else{
        document.getElementById('alertSNome').innerHTML = '<img title="Sobrenome Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        b = false
        return false
    }
}

function setaNoQuery(caminho){
    window.location="reader.html"+'?'+caminho;
}


function VerificaLogin(dado){
    if(dado != ''){
        document.getElementById('alertLogin').innerHTML = '<img title="Login OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        i = true
        return true
    } else{
        document.getElementById('alertLogin').innerHTML = '<img title="Login Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        i = false
        return false
    }
}

function VerificaCPF (campo) {
    if (vercpf(campo)){
        document.getElementById('alertCPF').innerHTML = '<img title="CPF OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        c = true
        return true
    }else {
        document.getElementById('alertCPF').innerHTML = '<img title="CPF Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        c = false
        return false
    }
}

function vercpf (cpf) {
    if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" || cpf == "88888888888" || cpf == "99999999999")
        return false;
    add = 0;
    for (i=0; i < 9; i++)
        add += parseInt(cpf.charAt(i)) * (10 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(9)))
        return false;
    add = 0;
    for (i = 0; i < 10; i ++)
        add += parseInt(cpf.charAt(i)) * (11 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(10)))
        return false;
    return true;
}

function VerificaData(dado)
{
    var expr = /^([0-9]|[0,1,2][0-9]|3[0,1])\/([\d]|1[0,1,2])\/\d{4}$/;
    
    if(dado.match(expr)){
        document.getElementById('alertData').innerHTML = '<img title="Data OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        d = true
        return true
    }
    else {
        document.getElementById('alertData').innerHTML = '<img title="Data Inválida!" src="css/images/icoErro.gif" alt="Erro"/>'
        d = false
        return false
    }
}


function VerificaSexo(dado){
    if(dado != ''){
        document.getElementById('alertSexo').innerHTML = '<img title="Sexo OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        e = true
        return true
    } else{
        document.getElementById('alertSexo').innerHTML = '<img title="Selecione seu sexo!" src="css/images/icoErro.gif" alt="Erro"/>'
        e = false
        return false
    }
}

function VerificaEmail(dado)
{
    var expr = /^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$/;
    
    if(expr.test(dado)){
        document.getElementById('alertEmail').innerHTML = '<img title="Email OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        f = true
        return true
    }
    else {
        document.getElementById('alertEmail').innerHTML = '<img title="Email Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        f = false
        return false
    }
}

function VerificaSenha(dado){
    if(dado.length >= 6 && dado.length <= 40){
        document.getElementById('alertSenha').innerHTML = '<img title="Senha OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        g = true
        return true;
    }else{
        document.getElementById('alertSenha').innerHTML = '<img title="Senha deve ter entre 6 e 40 caracteres" src="css/images/icoErro.gif" alt="Erro"/>'
        g = false
        return false;
    }
}

function VerificaSenhasIguais(senha1, senha2){
    if(senha1 == senha2 && senha1.length >= 6){
        document.getElementById('alertSenha2').innerHTML = '<img title="Confirmação de Senha OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        h = true
        return true;
    }else{
        document.getElementById('alertSenha2').innerHTML = '<img title="Confirmação de Senha Inválida!" src="css/images/icoErro.gif" alt="Erro"/>'
        h = false
        return false;
    }
}

function VerificaAutor(dado){
    if(dado != ''){
        document.getElementById('alertAutor').innerHTML = '<img title="Autor OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        a = true
        return true
    } else{
        document.getElementById('alertAutor').innerHTML = '<img title="Autor Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        a = false
        return false
    }
}

function VerificaCapa(dado){
    if(dado != ''){
        document.getElementById('alertCapa').innerHTML = '<img title="Capa OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        a = true
        return true
    } else{
        document.getElementById('alertCapa').innerHTML = '<img title="Capa Inválida!" src="css/images/icoErro.gif" alt="Erro"/>'
        a = false
        return false
    }
}

function VerificaConteudo(dado){
    if(dado != ''){
        document.getElementById('alertConteudo').innerHTML = '<img title="Conteudo OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        a = true
        return true
    } else{
        document.getElementById('alertConteudo').innerHTML = '<img title="Conteudo Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        a = false
        return false
    }
}


function VerificaEditora(dado){
    if(dado != ''){
        document.getElementById('alertEditora').innerHTML = '<img title="Editora OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        e = true
        return true
    } else{
        document.getElementById('alertEditora').innerHTML = '<img title="Selecione a editora!" src="css/images/icoErro.gif" alt="Erro"/>'
        e = false
        return false
    }
}

function VerificaEndereco(dado){
    if(dado != ''){
        document.getElementById('alertEndereco').innerHTML = '<img title="Endereco OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        e = true
        return true
    } else{
        document.getElementById('alertEndereco').innerHTML = '<img title="Endereco Invalido!" src="css/images/icoErro.gif" alt="Erro"/>'
        e = false
        return false
    }
}


function VerificaTelefone(dado){
    var expr = /^\(?\d{2}\)?[\s-]?\d{4}-?\d{4}$/;

    if(expr.test(dado)){
        document.getElementById('alertTelefone').innerHTML = '<img title="Telefone OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        e = true
        return true
    } else{
        document.getElementById('alertTelefone').innerHTML = '<img title="Telefone Invalido!" src="css/images/icoErro.gif" alt="Erro"/>'
        e = false
        return false
    }
}


///////////////////////////FUNCOES PARA LIMPAR CAIXAS DE TEXTO
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

///////////////////////////FUNCAO PARA LIBERAR O BOTAO DE CONTINUAR
function LiberaBotao()
{
    if(a && f && g && h){
        document.getElementById('cadastrar').disabled = false;
    }
    else{
        document.getElementById('cadastrar').disabled = true;
    }
}



////////////////////////////////////FUNCOES DA PAGINA GERENCIAR
var auxGerenciaFecha;  //variavel para guardar a input aberta.
function gerenciar(q, acao)
{
    if(q == 'c'){
        auxGerenciaFecha = 'c';
        if(acao == "adicionar"){
            document.getElementById('gerenciaCategoria').innerHTML = "<form method=\"post\" id=\"formCategory\" action=\"javascript:acoesCategoria();\">"+
        "<input type=\"text\" id=\"nome\" name=\"nome\" value=\"Nova Categoria\" onfocus=\"EmptyField(this.id);\"/>"+
        "<input type=\"submit\" value=\"Adicionar categoria\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"adicionar\"/>"+
        "<input type=\"hidden\" id=\"catSelectBox\" name=\"catSelectBox\" value=\"oi\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }else if(acao == "alterar"){
            document.getElementById('gerenciaCategoria').innerHTML = "<form method=\"post\" id=\"formCategory\" action=\"javascript:acoesCategoria();\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<input type=\"text\" id=\"nome\" name=\"nome\" value=\"Novo nome de Categoria\" onfocus=\"EmptyField(this.id);\"/>"+
        "<input type=\"submit\" value=\"Alterar categoria\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"alterar\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }else{
            document.getElementById('gerenciaCategoria').innerHTML = "<form method=\"post\" id=\"formCategory\" action=\"javascript:acoesCategoria();\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<input type=\"submit\" value=\"Remover categoria\"/>"+
        "<input type=\"hidden\" id=\"nome\" name=\"nome\" value=\"remover\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"remover\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }
    }else if(q == 't'){
        auxGerenciaFecha = 't';
        if(acao == "adicionar"){
            document.getElementById('gerenciaTipo').innerHTML = "<form method=\"post\" action=\"javascript:acoesTipo();\" id=\"formType\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<input type=\"text\"id=\"nome\"  name=\"nome\" value=\"Novo Tipo\" onfocus=\"EmptyField(this.id);\"/><input type=\"submit\" value=\"Adicionar tipo\"/>"+
        "<input type=\"hidden\" id=\"tipoSelectBox\" name=\"tipoSelectBox\" value=\"oi\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"adicionar\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }else if(acao == "alterar"){
            document.getElementById('gerenciaTipo').innerHTML = "<form method=\"post\" action=\"javascript:acoesTipo();\" id=\"formType\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<label id=\"tipoSelect\">"+
        "<select name=\"tipoSelectBox\" id=\"tipoSelectBox\"><option>(Tipos)</option></select>"+
        "</label>" +
        "<input type=\"text\" id=\"nome\" name=\"nome\" value=\"Novo nome de Tipo\" onfocus=\"EmptyField(this.id);\"><input type=\"submit\" value=\"Alterar tipo\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"alterar\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }else{
            document.getElementById('gerenciaTipo').innerHTML = "<form method=\"post\" action=\"javascript:acoesTipo();\" id=\"formType\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<label id=\"tipoSelect\">"+
        "<select name=\"tipoSelectBox\" id=\"tipoSelectBox\"><option>(Tipos)</option></select>"+
        "</label>" +
        "<input type=\"hidden\" id=\"nome\" name=\"nome\"><input type=\"submit\" value=\"Remover Tipo\"/>" +
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"remover\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";

        }
    }else{
        auxGerenciaFecha = 'e';

        /*        if(acao == "adicionar")
            document.getElementById('gerenciaEntidade').innerHTML = "<form><input type=\"text\" value=\"add\"/><input type=\"submit\" value=\"Ok\"/></form>";*/
        if(acao == "adicionar")
            document.getElementById('gerenciaEntidade').innerHTML = "<form method=\"post\" action=\"javascript:acoesEntidade();\" id=\"formEntidade\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<label id=\"tipoSelect\" name=\"tipoSelect\">"+
        "<select><option>(Tipos)</option></select>"+
        "</label>" +
        "<input type=\"text\" name=\"mid\" id=\"mid\" value=\"Mid\" onfocus=\"EmptyField(this.id)\">"+
        "<input type=\"text\" name=\"nome\" id=\"nome\" value=\"Entidade\" onfocus=\"EmptyField(this.id)\">"+
        "<input type=\"text\" style=\"width: 260px\" name=\"descricao\" id=\"descricao\" value=\"Descricao\" onfocus=\"EmptyField(this.id)\">" +
        "<br><input type=\"submit\" value=\" + Categorias/Tipos\"/><br>"+
        "<input type=\"submit\" value=\"Adicionar\"/>"+
        "<input type=\"hidden\" name=\"acao\" value=\"adicionar\"/>"+
        "<input type=\"hidden\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        else if(acao == "alterar")
            document.getElementById('gerenciaEntidade').innerHTML = "<form method=\"post\" action=\"javascript:acoesEntidade();\" id=\"formEntidade\">" +
        "<input type=\"text\" name=\"nome\" id=\"nome\" value=\"Entidade\" onfocus=\"EmptyField(this.id)\"/>"+
        "<input type=\"text\" name=\"catSelectBox\" id=\"catSelectBox\" value=\"Digite o novo nome\" onfocus=\"EmptyField(this.id);\"/>"+
        "<br><input type=\"hidden\" style=\"width: 220px\" name=\"descricao\" id=\"descricao\" value=\"Descricao\" onfocus=\"EmptyField(this.id);\"/>" +
        "<input type=\"text\" name=\"tipoSelectBox\"  style=\"width: 220px\" id=\"tipoSelectBox\" value=\"Digite a nova descricao\" onfocus=\"EmptyField(this.id);\"/>"+
        "<input type=\"hidden\" name=\"mid\" id=\"mid\" value=\"Mid\"/>"+
        "<br><input type=\"submit\" value=\"Alterar\"/>"+
        "<input type=\"hidden\" name=\"acao\" value=\"alterar\"/>"+
        "<input type=\"hidden\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        /*        else if(acao == "alterar")
            document.getElementById('gerenciaEntidade').innerHTML = "<form><input type=\"text\" value=\"alt\"/><input type=\"submit\" value=\"Ok\"/></form>";*/
        else
            document.getElementById('gerenciaEntidade').innerHTML = "<form><input type=\"text\" value=\"remover\"/><input type=\"submit\" value=\"Ok\"/></form>";
    }
}

function gerenciaFecha()
{
    if(auxGerenciaFecha == 'c')
        document.getElementById('gerenciaCategoria').innerHTML = "";
    else if(auxGerenciaFecha == 't')
        document.getElementById('gerenciaTipo').innerHTML = "";
    else
        document.getElementById('gerenciaEntidade').innerHTML = "";
}











//////////////////////FUNCOES DE ORDENACAO

// Ordena pelo nome do usuário
function byname(user_a, user_b) {
    return user_a.nome > user_b.nome;
}

// Ordena pela idade do usuário
function byread(user_a, user_b) {
    return user_a.idade > user_b.idade;
}


var s1, s2;
function VerificacaoSenha(dado){
    if(dado.length == 0 ){
        s1 = false
        return false;
    }else  
          
    if(dado.length >= 6 && dado.length <= 40){
        document.getElementById('alertSenha').innerHTML = '<img title="Senha OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        s1 = true
        return true;
    }else{
        document.getElementById('alertSenha').innerHTML = '<img title="Senha deve ter entre 6 e 40 caracteres" src="css/images/icoErro.gif" alt="Erro"/>'
        s1 = false
        return false;
    }
}

function VerificacaoSenhasIguais(senha1, senha2){
    if(senha2.length == 0 || senha1.length == 0){
        s2 = false
        return false;
    }else
        
    if(senha1 == senha2 && senha1.length >= 6){
        document.getElementById('alertSenha2').innerHTML = '<img title="Confirmação de Senha OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        s2 = true
        return true;
    }else{
        document.getElementById('alertSenha2').innerHTML = '<img title="Confirmação de Senha Inválida!" src="css/images/icoErro.gif" alt="Erro"/>'
        s2 = false
        return false;
    }
}
        
function LiberarBotao()
{
    
    if(s1 && s2){
        document.getElementById('alterarSenha').disabled = false;
    }
    else{
        document.getElementById('alterarSenha').disabled = true;
    }
}