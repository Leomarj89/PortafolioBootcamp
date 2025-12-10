<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Catálogo</title></head>
<body>
<h1>Catálogo de libros</h1>

<table border="1" cellpadding="6">
  <tr><th>ID</th><th>Nombre</th><th>Autor</th><th>Disponibilidad</th></tr>
  <c:forEach var="l" items="${libros}">
    <tr>
      <td>${l.id}</td>
      <td>${l.nombre}</td>
      <td>${l.autor}</td>
      <td>
        <c:choose>
          <c:when test="${l.disponible}">Disponible</c:when>
          <c:otherwise>No disponible</c:otherwise>
        </c:choose>
      </td>
    </tr>
  </c:forEach>
</table>

<p><a href="solicitud.jsp">Solicitar préstamo</a></p>
<p><a href="admin.jsp">Ver solicitudes (admin)</a></p>
</body>
</html>