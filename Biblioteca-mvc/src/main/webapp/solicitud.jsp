<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Solicitud</title></head>
<body>
<h1>Solicitud de préstamo</h1>
<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>
<form method="post" action="solicitar">
  <label>Nombre: <input type="text" name="nombre" required></label><br>
  <label>Correo: <input type="email" name="correo" required></label><br>
  <label>ID del libro: <input type="number" name="libroId" required></label><br>
  <button type="submit">Enviar</button>
</form>
</body>
</html>