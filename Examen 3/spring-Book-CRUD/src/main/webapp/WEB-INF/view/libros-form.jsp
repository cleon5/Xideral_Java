<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Libro</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Biblioteca Personal</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Libro</h3>
	
		<form:form action="saveLibro" modelAttribute="libro" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>tipo:</label></td>
						<td>
							<table>
							<tr>
								<tr><td><label> Comic</label>  	<form:radiobutton path="tipo" value="Comic"/>  </td></tr>
								<tr><td><label> Libro</label> 	<form:radiobutton path="tipo" value="Libro"/>   </td></tr>
								<tr><td><label> Manga</label>  <form:radiobutton path="tipo" value="Manga"/>   </td></tr>
							</tr>
							</table>

        				</td>
					</tr>

					<tr>
						<td><label>Genero:</label></td>
						<td>
							   <form:select path="genero">  
							        <form:option value="Accion" label="Accion"/>  
							        <form:option value="Aventura" label="Aventura"/>  
							        <form:option value="Historia" label="Historia"/>  
							        <form:option value="Suspenso" label="Suspenso"/>  
							        <form:option value="Terror" label="Terror"/>  
							        <form:option value="Poderes" label="Poderes"/>
						        </form:select>  
						</td>
					</tr>
					
					<tr>
						<td><label>Estado:</label></td>

						<td>
							   <form:select path="estado">  
							        <form:option value="Por Leer" label="Por Leer"/>  
							        <form:option value="En proceso" label="En proceso"/>  
							        <form:option value="Terminado" label="Terminado"/>  
						        </form:select>  
						</td>
						
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/libro/list">Regresar</a>
		</p>
	
	</div>

</body>

</html>










