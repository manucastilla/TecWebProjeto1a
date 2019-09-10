<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
	<%!String user;
		String nota;
		String titulo;
		int id;%>

	<%
		user = (String) request.getAttribute("user");
		nota = (String) request.getAttribute("nota");
		titulo = (String) request.getAttribute("titulo");
		id = (int) request.getAttribute("id");
	%>
	
	<%=user%><br>
		<form action="edit" method="post">
			<input type="hidden" name="nome" value="<%=user%>" readonly>
			<input type="hidden" name="id" value="<%=id%>" readonly>
			<label for="nome">Assunto:</label> <br />
			<input type="text"
				name="titulo_nota" size="40" maxlength="100" value="<%=titulo%>"><br /> 
				<label>Notas:</label><br />
			<textarea  rows="10" cols="40" name="notas"><%=nota%></textarea>
			<div class="button">
				<button type="submit">Atualizar</button>
			</div>
		</form>
	
</body>
</html>