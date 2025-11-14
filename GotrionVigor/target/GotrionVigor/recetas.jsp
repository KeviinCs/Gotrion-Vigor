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
    <ul>
        <% if (recetas != null) {
            for (Receta r : recetas) { %>
                <li><strong><%= r.getNombre() %></strong> - <%= r.getIngredientes() %></li>
        <%  }
           } else { %>
           <li>No hay recetas registradas.</li>
        <% } %>
    </ul>

    <p><a href="index.jsp">Volver al inicio</a></p>
</body>
</html>
