# Punto 1 - Creación de Tablas y Relaciones

Este script crea 4 tablas que simulan la gestión de pedidos en una tienda:

- `clientes`: almacena información básica de los clientes.
- `productos`: contiene los productos disponibles.
- `pedidos`: almacena pedidos realizados por clientes.
- `detalle_pedido`: tabla intermedia que relaciona pedidos con productos, especificando la cantidad y el precio unitario.

## Relaciones

- Un cliente puede tener muchos pedidos (`1:N`).
- Un pedido puede incluir muchos productos y un producto puede estar en muchos pedidos (`N:M`), usando la tabla `detalle_pedido`.

## Ejecución

Para ejecutar este script:

1. Abrir MySQL Workbench o el cliente que estés usando.
2. Ejecutar el contenido de `crear_tablas.sql`.
3. Se creará una base de datos llamada `tienda` y las tablas con sus respectivas relaciones.

Este punto cumple con:

- La identificación de componentes como claves primarias y foráneas.
- El uso correcto del lenguaje de definición de datos (DDL).
- La representación de cómo se gestionan los datos en una base relacional.