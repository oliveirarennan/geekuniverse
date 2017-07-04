<%@page import="modelo.Usuario"%>
<%
	HttpSession sessao = request.getSession();
	Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if((usuario == null) || (!usuario.getTipoUsuario().equals("administrador"))){
			sessao.removeAttribute("usuario");
			sessao.invalidate();
			response.sendRedirect("../index.jsp");
		}
	
%>