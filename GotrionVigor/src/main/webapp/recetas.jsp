<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.gotrionvigor.modelo.Receta" %>
<%@ page import="java.util.List" %>

<%
    List<Receta> recetas = (List<Receta>) request.getAttribute("recetas");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Recetas</title>
</head>
<body>

<h2>Agregar Nueva Receta</h2>

<form action="recetas" method="post">
    <label>Nombre:</label><br>
    <input type="text" name="nombre" required><br><br>

    <label>Ingredientes:</label><br>
    <textarea name="ingredientes" required></textarea><br><br>

    <label>Instrucciones:</label><br>
    <textarea name="instrucciones" required></textarea><br><br>

    <button type="submit">Guardar</button>
</form>

<h2>Lista de Recetas</h2>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Ingredientes</th>
        <th>Acciones</th>
    </tr>

    <% if (recetas != null && !recetas.isEmpty()) {
        for (Receta r : recetas) { %>

        <tr>
            <td><%= r.getId() %></td>
            <td><%= r.getNombre() %></td>
            <td><%= r.getIngredientes() %></td>
            <td>
                <!-- Botón Editar -->
                <a href="recetas?accion=editar&id=<%= r.getId() %>">Editar</a>

                &nbsp;&nbsp;

                <!-- Botón Eliminar -->
                <a href="recetas?accion=eliminar&id=<%= r.getId() %>"
                   onclick="return confirm('¿Seguro que deseas eliminar esta receta?');">
                    Eliminar
                </a>
            </td>
        </tr>

    <%  }
       } else { %>

       <tr>
           <td colspan="4">No hay recetas registradas.</td>
       </tr>

    <% } %>

</table>

<br>
<a href="index.jsp">Volver al inicio</a>

</body>
</html>