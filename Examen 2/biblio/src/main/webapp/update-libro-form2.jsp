<!DOCTYPE html>
<html>

<head>
	<title>Actualizar Libro</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Biblioteca personal</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar libros</h3>
		
		<form action="LibroControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="libroId" value="${LIBRO.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" 
								   value="${LIBRO.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Tipo:</label></td>
						<td><input type="text" name="tipo" 
								   value="${LIBRO.tipo}" /></td>
								    <td><label>Libro, Manga o Comic</label></td>
					</tr>

					<tr>
						<td><label>Genero:</label></td>
						<td><input type="text" name="genero" 
								   value="${LIBRO.genero}" /></td>
					</tr>
					
					<tr>
						<td><label>Estado:</label></td>
						<td><input type="text" name="estado" 
								   value="${LIBRO.estado}" /></td>
								   <td><label>Terminado, En proceso o Por leer</label></td>
					</tr>
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="LibroControllerServlet">Regrersar</a>
		</p>
	</div>
</body>
</html>











