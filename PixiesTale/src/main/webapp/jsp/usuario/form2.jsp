<%-- 
    Document   : login02
    Author     : Jordi
--%>
<%@page import="net.daw.bean.UsuarioBean"%>
<% UsuarioBean oUsuario = (UsuarioBean) request.getSession().getAttribute("usuarioBean"); %>
<% if (oUsuario==null){ %>
    <h1>Vd. no ha entrado en el sistema</h1>
    <h4>Ha habido un problema con su autenticaci�n. Revise su login o su password.</h4>
<% } else { %>
    <h1>Vd. ha entrado en el sistema</h1>
    <h4>Bienvenido, <%=oUsuario.getLogin() %>. Ahora puede operar con los men�s de la aplicaci�n.</h4>
<% } %>

<script>
    
    
    //Intervalo de timepo para redireccionar a home
    
    
    
    
</script>
