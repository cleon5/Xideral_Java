<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Libros Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Biblioteca personal</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Agregar Libro" 
				   onclick="window.location.href='add-libro-form2.jsp'; return false;"
				   class="add-student-button"
			/>
			<!-- Lista los usuarios -->
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Tipo</th>
					<th>Genero</th>
					<th>Estado</th>
					<th>Accion</th>
				</tr>
				
				<c:forEach var="tempLibro" items="${LIBRO_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="LibroControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="libroId" value="${tempLibro.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="LibroControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="libroId" value="${tempLibro.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempLibro.nombre} </td>
						<td> ${tempLibro.tipo} </td>
						<td> ${tempLibro.genero} </td>
						<td> ${tempLibro.estado} </td>
						<td> 
							<a href="${tempLink}">Actualizar</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Estas seguro de borrar el libro?'))) return false">
							Borrar</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








