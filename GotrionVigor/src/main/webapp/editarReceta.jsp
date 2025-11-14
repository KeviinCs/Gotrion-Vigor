<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.gotrionvigor.modelo.Receta" %>

<%
    Receta receta = (Receta) request.getAttribute("receta");
    if (receta == null) {
%>
    <h2>No se encontró la receta</h2>
    <a href="recetas">Volver</a>
<%
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Receta</title>
</head>
<body>

<h2>Editar Receta</h2>

<form action="recetas" method="post">

    <!-- Campo oculto con el ID -->
    <input type="hidden" name="id" value="<%= receta.getId() %>">

    <label>Nombre:</label><br>
    <input type="text" name="nombre" value="<%= receta.getNombre() %>" required><br><br>

    <label>Ingredientes:</label><br>
    <textarea name="ingredientes" required><%= receta.getIngredientes() %></textarea><br><br>

    <label>Instrucciones:</label><br>
    <textarea name="instrucciones" required><%= receta.getInstrucciones() %></textarea><br><br>

    <button type="submit">Actualizar</button>
</form>

<br>
<a href="recetas">Volver a la lista</a>

</body>
</html>