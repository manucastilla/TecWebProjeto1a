<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, br.edu.insper.Model.*, br.edu.insper.Controller.*"%>

	

<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
<a href ="PaginaInicial.html">sair</a><br>
	<%!String user;%>

	<%
		user = (String) request.getAttribute("user");
	%>

	
		<h1>BEM VIND@ <%=user%> !</h1><br>
		
		<form action="postar" method="post">
			<input type="hidden" name="nome" value="<%=user%>" readonly>
			<label>Assunto:</label> <br />
			<input type="text"
				name="titulo_nota" size="40" maxlength="100"><br /> 
				<label
				for="nome">Notas:</label><br />
			<textarea rows="10" cols="40" name="notas"> </textarea>
			<div class="button">
				<button type="submit">Postar</button>
			</div>
		</form>
	
	<div class="card" style="width: 18rem;">

	<%
		DAO dao = new DAO();

		List<Notas> lista = dao.getLista(user);

		for (Notas nota : lista) {
	%>
	
	<div class="card border-primary bg-primary mb-3" style="max-width: 18rem;">
	<form action="edit" method="get">
	    <h5 class="card-title"><%=nota.getTitulo()%></h5>
	    <p class="card-text"><%=nota.getNotas()%></p>
	    <input name="nome" type="hidden" value= "${user}">
	    <input name="titulo" value="<%=nota.getTitulo()%>" type="hidden">
	    <input name="nota" value="<%=nota.getNotas()%>" type="hidden">
	    <input name="id" value="<%=nota.getId()%>" type="hidden">
	   	<input type="submit" value="editar">
	</form>
	<form action="delete" method="post">
	     <input name="id" value="<%=nota.getId()%>" type="hidden">
	     <input name="nome" type="hidden" value= "${user}">
	 
	 <input type="submit" value="apagar">
	 </form>
  	</div>
  <%
		}
	%>
	
</div>



</body>
</html>