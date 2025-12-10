# Sistema de Cursos de Capacitación (Spring Boot)

Proyecto académico desarrollado con Spring Boot para gestionar cursos de capacitación internos.  
Incluye:

- Panel **ADMIN** para administrar cursos.
- Panel **EMPLEADO** para ver cursos e inscribirse.
- API REST para listar cursos y registrar inscripciones.
- Seguridad con roles `ADMIN` y `EMPLEADO`.

---

## 1. Problemática real

En muchas empresas la gestión de cursos internos se realiza con planillas Excel, correos dispersos o formularios manuales.  
Esto provoca problemas como:

- Dificultad para saber qué cursos están disponibles y cuántos cupos quedan.
- Duplicidad de información entre distintas áreas.
- Poca trazabilidad sobre qué empleados han tomado qué cursos.
- Errores al inscribir personas o al cerrar los cupos de un curso.

El **Sistema de Cursos de Capacitación** busca resolver esta situación centralizando la información en una sola aplicación web.

---

## 2. Objetivos del sistema

- Centralizar la gestión de cursos, instructores y empleados inscritos.
- Permitir que el área de capacitación administre cursos desde un panel tipo **ADMIN**.
- Facilitar que los empleados puedan ver cursos disponibles e inscribirse ellos mismos.
- Evitar inscripciones duplicadas y respetar los cupos máximos de cada curso.
- Exponer una **API REST** que permita integrar el sistema con otras aplicaciones en el futuro.

---

## 3. Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.x**
  - Spring Web / Spring MVC
  - Spring Security
  - Spring Data JPA
- **Base de datos H2 en memoria**
- **Thymeleaf** (o JSP, según implementación)
- **Maven 3.x**
- Herramientas de apoyo: consola H2, IDE (IntelliJ IDEA / Eclipse / STS)

---

## 4. Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- Java JDK 17
- Maven 3.5.7
- Un IDE como IntelliJ IDEA o Eclipse.

---

## 5. Clonar o descargar el proyecto

Clona el repositorio desde GitHub:

bash
git clone https://github.com/usuario/CursoCapacitacion.git
cd CursoCapacitacion

---

## 6. Ejecutar la aplicación

- Importa el proyecto como Maven Project.
- Ubica la clase principal (con @SpringBootApplication).
- Ejecuta la aplicación como Spring Boot App o Java Application.

---

## 7. Configuración por defecto

La aplicación usa:

- Puerto: 8088
- Base de datos: H2 en memoria
- URL base: http://localhost:8088

Puedes cambiar estas configuraciones en el archivo: src/main/resources/application.properties

---

## 8. Acceso a la aplicación web

8.1. Login

URL de inicio de sesión:: http://localhost:8088/login

Usuarios de prueba:

- ADMIN

- Usuario: admin
- Contraseña: admin123
- Acceso: /admin/cursos

- EMPLEADO

- Usuario: empleado
- Contraseña: empleado123
- Acceso: /empleado/cursos y /empleado/cursos/mis-inscripciones

8.2. Panel ADMIN

- URL principal: http://localhost:8088/admin/cursos

Desde este panel se puede:

- Listar cursos.
- Crear nuevos cursos.
- Editar cursos existentes.
- Eliminar cursos.
- Asignar un instructor a cada curso.

8.3. Panel EMPLEADO

- URL principal: http://localhost:8088/empleado/cursos

Desde este panel se puede:

- Ver cursos disponibles.
- Inscribirse en un curso (respetando cupos).
- Ver el listado de cursos en los que está inscrito: http://localhost:8088/empleado/cursos/mis-inscripciones

---

## 9. Base de datos H2

La aplicación utiliza una base de datos H2 en memoria.
Se carga información inicial (instructores y empleado de prueba) mediante data.sql.

Acceso a la consola H2

URL: http://localhost:8088/h2-console

Valores típicos (según configuración de application.properties):

- JDBC URL: jdbc:h2:mem:cursosdb
- User: sa
- Password: (vacío o el configurado)

Desde la consola H2 se pueden consultar tablas como:

- INSTRUCTORES
- CURSOS
- EMPLEADOS
- INSCRIPCIONES

---

## 10. Endpoints REST

Además de las vistas web, el proyecto expone endpoints REST protegidos con Basic Auth.

10.1. Listar cursos

Endpoint: GET /api/cursos

- Autenticación: Basic Auth (admin o empleado).
- Respuesta: lista de cursos en formato JSON, con información de cupos, inscritos e instructor.

10.2. Crear una inscripción

Endpoint: POST /api/inscripciones
Content-Type: application/json

Body JSON: {"cursoId": 1}

- El empleado autenticado se inscribe en el curso indicado.
- Se validan:
    - Que no esté inscrito previamente.
    - Que el curso tenga cupos disponible

---

## 11. Proceso de desarrollo

11.1  Análisis de la problemática

- Identificación de la necesidad de gestionar cursos internos de forma centralizada.
- Definición de roles: ADMIN (capacitaciones) y EMPLEADO.

11.2  Diseño del modelo de datos

- Entidades principales: Curso, Instructor, Empleado, Inscripcion.
- Relaciones entre cursos e inscripciones, y entre cursos e instructores.

11.3  Configuración del proyecto

- Creación del proyecto Spring Boot con dependencias Web, Security, Data JPA y H2.
- Configuración de seguridad básica con roles y rutas protegidas.

4  Implementación de capas

- Controladores para ADMIN y EMPLEADO.
- Servicios para la lógica de negocio (gestión de cursos e inscripciones).
- Repositorios JPA para acceso a datos.

5  Pruebas y ajustes

- Pruebas manuales de creación, edición e inscripción a cursos.
- Verificación de validaciones (cupos, duplicidad de inscripción).
- Revisión visual de formularios y listados.

6  Documentación y portafolio

- Creación de este README con instrucciones y contexto.
- Documentación visual complementaria en Behance (flujo de usuario y pantallas).
- Video explicativo del sistema para el portafolio técnico.


## 12. Notas finales

- La base de datos H2 es en memoria, por lo que los datos se reinician cada vez que se detiene la aplicación.
- El diagrama de clases y el diagrama de flujo de navegación se encuentran en la carpeta docs/ (si se agregaron al repositorio).
- El tablero de Trello utilizado para gestionar el ciclo de vida del proyecto se adjunta en el informe en formato PDF como evidencia.