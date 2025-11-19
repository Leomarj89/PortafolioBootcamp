# Sistema de Biblioteca (MVC – Java)

Proyecto de aplicación web para la gestión de una **biblioteca**, desarrollado como parte del Bootcamp de Java.  
El foco está en aplicar el patrón **Modelo–Vista–Controlador (MVC)** usando JSP, Servlets y una capa DAO para el acceso a datos.

---

## 🎯 Objetivo del proyecto

Construir una aplicación web que permita:

- Registrar y gestionar libros.
- Consultar el catálogo.
- Registrar préstamos y devoluciones.
- Practicar la separación en capas (modelo, controlador, vista) y el acceso a base de datos.

---

## 🧩 Funcionalidades principales

- Listado de libros disponibles.
- Formulario para agregar/editar libros.
- Registro de préstamos (asociando libro + usuario).
- Visualización de préstamos activos.

> El alcance exacto puede variar según las actividades del módulo, pero el proyecto está orientado a simular el flujo básico de una biblioteca.

---

## 🏗️ Arquitectura y tecnologías

- **Lenguaje:** Java
- **Vista:** JSP
- **Controlador:** Servlets (patrón MVC)
- **Acceso a datos:** DAO + JDBC
- **Base de datos:** (MySQL / SQL Server, según configuración del Bootcamp)
- **Servidor de aplicaciones:** Apache Tomcat

---

## 📂 Estructura general del proyecto

A modo general, la estructura sigue una separación en capas similar a:

- `src/`  
  - `modelo/` → Clases de entidad (por ejemplo, `Libro`, `Usuario`, `Prestamo`, etc.).  
  - `dao/` → Clases DAO para acceso a base de datos.  
  - `controlador/` → Servlets que reciben las peticiones y coordinan la lógica.  
- `webapp/` o `WebContent/`  
  - `jsp/` → Vistas JSP para mostrar formularios, listados y resultados.  
  - Recursos estáticos (CSS, imágenes, etc.).

> La estructura exacta depende del IDE y configuración usada en el módulo (Eclipse/STS/IntelliJ).

---

## ▶️ Cómo ejecutar el proyecto

1. Importar el proyecto en tu IDE (por ejemplo, Eclipse o STS) como **Dynamic Web Project** o **proyecto Maven**, según corresponda.
2. Configurar el servidor **Apache Tomcat** en el IDE.
3. Verificar la configuración de la base de datos (URL, usuario y contraseña) en la clase de conexión/DAO.
4. Levantar el servidor Tomcat.
5. Acceder en el navegador a la URL configurada, por ejemplo:

   ```text
   http://localhost:8080/Biblioteca-mvc