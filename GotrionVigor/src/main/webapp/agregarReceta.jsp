<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Receta</title>
</head>
<body>
<h2>Agregar nueva receta</h2>
<form action="RecetaServlet" method="post">
    <input type="hidden" name="action" value="insertar">
    Nombre:<br>
    <input type="text" name="nombre" required><br><br>

    Ingredientes:<br>
    <textarea name="ingredientes" rows="4" cols="50" required></textarea><br><br>

    Instrucciones:<br>
    <textarea name="instrucciones" rows="4" cols="50" required></textarea><br><br>

    <input type="submit" value="Guardar">
    <a href="RecetaServlet">Cancelar</a>
</form>
</body>
</html>
