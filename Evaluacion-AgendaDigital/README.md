# Evaluación de Portafolio: Agenda Digital en Java

## 1. Investigación: Java en aplicaciones empresariales

### ¿Qué hace adecuado a Java para este tipo de aplicaciones?
Java es uno de los lenguajes más utilizados en el desarrollo de aplicaciones empresariales gracias a sus características de portabilidad, robustez y seguridad. La existencia de la **JVM (Java Virtual Machine)** permite ejecutar aplicaciones en diferentes sistemas operativos sin necesidad de realizar cambios en el código. Además, cuenta con un ecosistema muy amplio de frameworks y librerías (como Spring, Hibernate y Java EE) que facilitan la construcción de sistemas escalables y confiables.

En entornos empresariales, donde la estabilidad y el rendimiento son cruciales, Java ofrece un conjunto sólido de herramientas para manejar aplicaciones de gran tamaño y con miles de usuarios simultáneos.

### Ventajas frente a otros lenguajes
- **Portabilidad: “Write once, run anywhere”. El mismo programa puede ejecutarse en Windows, Linux o macOS.
- **Escalabilidad: Permite construir desde aplicaciones pequeñas hasta sistemas corporativos complejos.
- **Seguridad: Incluye características de manejo de memoria, control de accesos y excepciones que lo hacen seguro en entornos críticos (bancos, salud, gobierno).
- **Ecosistema empresarial: Amplio soporte de librerías, frameworks y una comunidad global activa.
- **Orientación a objetos: Facilita la organización del código y su mantenimiento a largo plazo.

---

## 2. Algoritmo lógico de la aplicación

### Pseudocódigo

REPETIR
    MOSTRAR "Menú:"
    MOSTRAR "1. Agregar tarea"
    MOSTRAR "2. Listar tareas"
    MOSTRAR "3. Filtrar tareas por estado"
    MOSTRAR "4. Marcar tarea como completada"
    MOSTRAR "5. Salir"
    LEER opcion

    SEGUN opcion HACER
        CASO 1:
            PEDIR descripción
            PEDIR fecha
            CREAR tarea con estado "Pendiente"
            AGREGAR tarea a la lista
        CASO 2:
            MOSTRAR todas las tareas
        CASO 3:
            PEDIR estado (Pendiente/Completada)
            MOSTRAR tareas que coincidan con el estado
        CASO 4:
            PEDIR ID de tarea
            MARCAR tarea como "Completada"
        CASO 5:
            MOSTRAR "Saliendo del sistema..."
            SALIR del programa
    FINSEGUN
HASTA opcion = 5


---

Este documento cubre la parte teórica (investigación) y la parte lógica (algoritmo en pseudocódigo) solicitada en la evaluación.  
El siguiente paso será implementar la aplicación en Java y documentar el uso de **POO** y las pruebas unitarias con JUnit.