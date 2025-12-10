<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Admin - Solicitudes</title></head>
<body>
<h1>Solicitudes registradas</h1>
<%
  // Cargar datos rápidamente sin crear otro servlet (para prototipo):
  cl.universidad.biblioteca.dao.SolicitudDAO dao =
      new cl.universidad.biblioteca.dao.impl.SolicitudDAOImpl();
  request.setAttribute("solicitudes", dao.listar());
%>
<table border="1" cellpadding="6">
  <tr><th>ID</th><th>Nombre</th><th>Correo</th><th>Libro ID</th><th>Fecha</th></tr>
  <c:forEach var="s" items="${solicitudes}">
    <tr>
      <td>${s.id}</td>
      <td>${s.nombreUsuario}</td>
      <td>${s.correo}</td>
      <td>${s.libroId}</td>
      <td>${s.creadaEn}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>