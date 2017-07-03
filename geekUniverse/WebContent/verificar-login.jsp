<%@page import="modelo.Usuario"%>
<%
	HttpSession sessao = request.getSession();
	Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		if((usuario == null)){
			response.sendRedirect("operacao-invalida.jsp");
		}
	
%>