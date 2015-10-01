<%@page import="model.BeanUsuario"%>

<%
  //recupera session
  HttpSession s = request.getSession(false);
  BeanUsuario user = null;
  boolean logado = false;
  if (null != s && (BeanUsuario) s.getAttribute("Usuario") != null) {
    logado = true;
    user = (BeanUsuario) s.getAttribute("Usuario");
  }
%>