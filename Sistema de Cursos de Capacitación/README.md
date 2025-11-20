# Sistema de Cursos de Capacitación (Spring Boot)

Proyecto académico desarrollado con Spring Boot para gestionar cursos de capacitación internos.  
Incluye:

- Panel **ADMIN** para administrar cursos.
- Panel **EMPLEADO** para ver cursos e inscribirse.
- API REST para listar cursos y registrar inscripciones.
- Seguridad con roles `ADMIN` y `EMPLEADO`.

---

1. Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- Java JDK 17
- Maven 3.5.7
- Un IDE como IntelliJ IDEA o Eclipse.

---

2. Clonar o descargar el proyecto

Clona el repositorio desde GitHub:

bash
git clone https://github.com/usuario/CursoCapacitacion.git
cd CursoCapacitacion

3. Ejecutar la aplicación

- Importa el proyecto como Maven Project.
- Ubica la clase principal (con @SpringBootApplication).
- Ejecuta la aplicación como Spring Boot App o Java Application.

4. Configuración por defecto

La aplicación usa:

- Puerto: 8088
- Base de datos: H2 en memoria
- URL base: http://localhost:8088

Puedes cambiar estas configuraciones en el archivo: src/main/resources/application.properties

5. Acceso a la aplicación web

5.1. Login

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

5.2. Panel ADMIN

- URL principal: http://localhost:8088/admin/cursos

Desde este panel se puede:

- Listar cursos.
- Crear nuevos cursos.
- Editar cursos existentes.
- Eliminar cursos.
- Asignar un instructor a cada curso.

5.3. Panel EMPLEADO

- URL principal: http://localhost:8088/empleado/cursos

Desde este panel se puede:

- Ver cursos disponibles.
- Inscribirse en un curso (respetando cupos).
- Ver el listado de cursos en los que está inscrito: http://localhost:8088/empleado/cursos/mis-inscripciones

6. Base de datos H2

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

7. Endpoints REST

Además de las vistas web, el proyecto expone endpoints REST protegidos con Basic Auth.

7.1. Listar cursos

Endpoint: GET /api/cursos

- Autenticación: Basic Auth (admin o empleado).
- Respuesta: lista de cursos en formato JSON, con información de cupos, inscritos e instructor.

7.2. Crear una inscripción

Endpoint: POST /api/inscripciones
Content-Type: application/json

Body JSON: {"cursoId": 1}

- El empleado autenticado se inscribe en el curso indicado.
- Se validan:
    - Que no esté inscrito previamente.
    - Que el curso tenga cupos disponible

8. Notas finales

- La base de datos H2 es en memoria, por lo que los datos se reinician cada vez que se detiene la aplicación.
- El diagrama de clases y el diagrama de flujo de navegación se encuentran en la carpeta docs/ (si se agregaron al repositorio).
- El tablero de Trello utilizado para gestionar el ciclo de vida del proyecto se adjunta en el informe en formato PDF como evidencia.