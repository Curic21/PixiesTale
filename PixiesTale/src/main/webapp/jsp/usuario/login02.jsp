<%-- 
    Document   : form02
    Author     : Jordi
--%>
<%@page import="net.daw.bean.UsuarioBean"%>
<% UsuarioBean oUsuario = (UsuarioBean) request.getSession().getAttribute("usuarioBean"); %>
<% if (oUsuario==null){ %>
    <h1>Vd. no ha podido registrarse.</h1>
    <h4>Ha habido un problema con la validación. Revise los datos nuevamente.</h4>
<% } else { %>
    <h1>Vd. se ha registrado satisfactoriamente.</h1>
    <h4>Bienvenido, <%=oUsuario.getLogin() %>. Ahora ya se puede loguear.</h4>
<% } %>

<script>
    
    
    //Intervalo de timepo para redireccionar a home
    
    
    
    
</script>
