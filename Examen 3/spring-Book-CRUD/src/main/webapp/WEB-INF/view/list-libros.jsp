<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de libros</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Biblioteca personal</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar libro"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Tipo</th>
					<th>Genero</th>
					<th>Estado</th>
					<th>Accion</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempLibro" items="${libros}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/libro/showFormForUpdate">
						<c:param name="libroId" value="${tempLibro.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/libro/delete">
						<c:param name="libroId" value="${tempLibro.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempLibro.nombre} </td>
						<td> ${tempLibro.tipo} </td>
						<td> ${tempLibro.genero} </td>
						<td> ${tempLibro.estado} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Estas seguro de borrar el libro?'))) return false">Borrar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









