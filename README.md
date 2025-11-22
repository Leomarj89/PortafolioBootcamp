# Portafolio de Productos – Bootcamp Java

Este repositorio reúne los proyectos más importantes que desarrollé durante el Bootcamp de Java, organizados como un **portafolio de productos**.  
Aquí muestro mi progreso en desarrollo backend, aplicaciones web, bases de datos y diseño de interfaces.

---

## 🚀 Visión general del portafolio

- **Repositorio principal:** `PortafolioBootcamp`
- **Sitio publicado (GitHub Pages):**  
  👉 https://leomarj89.github.io/PortafolioBootcamp/
- **Portafolio visual en Behance (UX/UI):**  
  👉 https://www.behance.net/gallery/238926309/Sistema-de-Gestion-de-Cursos-de-Capacitacion
- **Video tutorial técnico en YouTube:**  
  👉 https://youtu.be/-eeaKdgoVvw

> 💡 Este portafolio está pensado como resumen global de mis proyectos, con foco en:  
> 1) código (GitHub), 2) experiencia de usuario (Behance) y 3) explicación en video (YouTube).

---

## 🎯 Problemáticas que se abordan

Los proyectos principales de este portafolio están pensados para resolver **situaciones reales**:

- **Gestión de biblioteca:**  
  Dificultad para controlar préstamos, catálogos y usuarios →  
  👉 *Sistema de Biblioteca (MVC).*

- **Gestión de cursos internos de capacitación:**  
  Cursos administrados por Excel y correos, poca trazabilidad de asistentes →  
  👉 *Sistema de Cursos de Capacitación (Spring Boot).*

- **Registro de eventos internos:**  
  Falta de un lugar centralizado para agendar reuniones, capacitaciones y actividades →  
  👉 *Agenda Digital de Eventos.*

---

## 📂 Proyectos incluidos

### 1. Sistema de Biblioteca (Biblioteca-mvc)

**Descripción:**  
Aplicación web para gestión de una biblioteca (libros, usuarios, préstamos), usando el patrón **Modelo–Vista–Controlador (MVC)**.

- **Carpeta:** `Biblioteca-mvc/`
- **Tecnologías:**
  - Java
  - JSP / Servlets
  - Patrón MVC
  - JDBC + base de datos relacional
  - Servidor Apache Tomcat
- **Aspectos destacados:**
  - Separación clara entre modelo, controlador y vista.
  - Manejo de formularios para alta/edición de libros.
  - Listas de elementos en JSP (tablas de libros, préstamos, etc.).

---

### 2. Sistema de Cursos de Capacitación

**Descripción:**  
Sistema para gestionar cursos internos de capacitación: creación de cursos, asignación de instructores y registro de empleados.  
Es uno de los **productos principales** del portafolio.

- **Carpeta:** `CursosCapacitacion/`
- **Tecnologías:**
  - Java / Spring Boot (Web, Security, Data JPA)
  - Thymeleaf (o JSP)
  - Base de datos H2 en memoria
- **Aspectos destacados:**
  - Vistas separadas por rol: **ADMIN** y **EMPLEADO**.
  - Gestión de cursos, instructores y cupos.
  - Inscripción de empleados a cursos con validaciones.
  - Exposición de una **API REST** para cursos e inscripciones.
- **Relación con UX/UI:**
  - Utilizado como base para documentar el flujo de usuario y las pantallas en un proyecto de UX/UI en Behance.
  - Demostración técnica en video (YouTube).

---

### 3. Agenda Digital de Eventos (Evaluacion-AgendaDigital)

**Descripción:**  
Mini agenda para registrar y listar eventos internos (reuniones, capacitaciones, actividades).

- **Carpeta:** `Evaluacion-AgendaDigital/`
- **Tecnologías:**
  - Java
  - Spring Boot
  - MVC + vistas HTML/Thymeleaf
- **Funcionalidades clave:**
  - Registro de eventos (título, fecha, descripción, responsable).
  - Listado de eventos registrados.
  - Manejo básico de validaciones.

---

### 4. Módulos de Bases de Datos

Además de las aplicaciones web, el portafolio incluye varios módulos enfocados en **diseño y manejo de bases de datos**:

- `01-DefinicionBDRelacional/`
- `02-ConsultasSQL/`
- `03-TransaccionesDatos/`
- `04-DefinicionObjetosDDL/`
- `05-ModeloDatos/`

En estos módulos trabajé:

- Diseño de modelos relacionales.
- Consultas SQL (SELECT con filtros, joins, agregaciones).
- Transacciones y control de cambios.
- Creación de tablas, claves primarias/foráneas y otros objetos DDL.

---

## 🛠️ Proceso de creación del portafolio

El proceso para armar este portafolio fue el siguiente:

1. **Selección de proyectos**
   - Revisé los trabajos realizados durante el Bootcamp y elegí aquellos que mejor representaban:
     - Aplicaciones web completas (Biblioteca, Cursos, Agenda).
     - Trabajo con bases de datos (módulos 01–05).
   - Priorizé proyectos con código entendible y potencial de mejora visual/documental.

2. **Organización en GitHub**
   - Agrupé todo en este repositorio `PortafolioBootcamp`.
   - Separé cada proyecto en su propia carpeta.
   - Añadí/ajusté archivos `README` específicos para que cada proyecto se entienda por sí solo.

3. **Creación de la página principal**
   - Diseñé un `index.html` para funcionar como **landing page** del portafolio.
   - Enlazé desde ahí a las carpetas de proyectos y a recursos externos (Behance, YouTube, etc.).
   - Activé **GitHub Pages** para que el portafolio esté disponible en línea.

4. **Integración con Behance y YouTube**
   - Para el proyecto de **Cursos de Capacitación** preparé una presentación tipo UX/UI en Behance.
   - Grabé un **video tutorial técnico** explicando uno de los proyectos y lo publiqué en YouTube.
   - Añadí ambos enlaces en este README y en la landing page.

---

## 🧩 Retos encontrados y cómo los solucioné

### 🔹 1. Organización de proyectos en un solo portafolio

- **Reto:**  
  Tenía varios proyectos sueltos del Bootcamp (carpetas, repos separados, ejercicios de BD) y al principio era difícil mostrar todo de forma ordenada.
- **Solución:**  
  Unifiqué todo en un solo repositorio `PortafolioBootcamp` y diseñé una estructura clara:
  - Carpeta por proyecto.
  - Módulos de BD numerados.
  - README general que explica el conjunto (este archivo).

---

### 🔹 2. Configuración de GitHub Pages

- **Reto:**  
  Algunos enlaces desde la página publicada devolvían **errores 404** porque apuntaban a rutas que no existían como páginas HTML.
- **Solución:**  
  - Ajusté los enlaces para que apunten:
    - A archivos `index.html` existentes, o
    - Directamente a las carpetas/proyectos en GitHub.
  - Verifiqué manualmente los enlaces desde la URL pública hasta que todos funcionaron correctamente.

---

### 🔹 3. Documentación clara para cada proyecto

- **Reto:**  
  Varios proyectos solo tenían código, pero poca o ninguna explicación.
- **Solución:**  
  - Creé/ajusté archivos `README` con:
    - Descripción del proyecto.
    - Tecnologías utilizadas.
    - Forma básica de ejecución.
  - En el caso de Biblioteca y Cursos de Capacitación, también describí la relación con las vistas y la experiencia de usuario.

---

### 🔹 4. Conectar código, UX/UI y video

- **Reto:**  
  No basta con tener el código; había que mostrar el proyecto visualmente (Behance) y explicarlo en un video técnico.
- **Solución:**  
  - Tomé capturas de las vistas principales y las usé para construir un **caso de estudio UX/UI** en Behance.
  - Grabé un video mostrando:
    - Introducción al proyecto.
    - Tecnologías usadas.
    - Funcionalidades clave.
    - Algunos desafíos técnicos.

---

## ✅ Cómo este portafolio responde a la evaluación de portafolio

- **Portafolio profesional y efectivo:**  
  - Sitio web responsivo publicado en GitHub Pages.  
  - Navegación clara por proyectos, bases de datos y enlaces externos.

- **Productos tecnológicos para problemáticas reales:**  
  - Al menos dos sistemas completos (Biblioteca y Cursos de Capacitación) que resuelven problemas reales de gestión interna.
  - Agenda Digital de Eventos como proyecto adicional.

- **Documentación y evidencias:**  
  - Código fuente disponible en GitHub.
  - READMEs con descripción, tecnologías, objetivos y forma de ejecución.
  - Caso UX/UI en Behance y video técnico en YouTube como evidencia adicional.

---

## 📦 Cómo navegar este portafolio

1. Visita la página publicada:  
   👉 https://leomarj89.github.io/PortafolioBootcamp/
2. Desde ahí, navega a los proyectos destacados:
   - Sistema de Biblioteca (MVC).
   - Sistema de Cursos de Capacitación.
   - Agenda Digital de Eventos.
   - Módulos de bases de datos.
3. Revisa el proyecto UX/UI documentado en Behance.  
4. Mira el video técnico en YouTube para ver una demostración guiada de uno de los productos.
5. Vuelve a este `README` si quieres un resumen global o contexto general.

---

## 📎 Licencia

Este repositorio está bajo la licencia **MIT**.  
Consulta el archivo `LICENSE` para más detalles.