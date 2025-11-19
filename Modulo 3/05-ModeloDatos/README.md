# Punto 5 - Modelo Entidad-Relación (ER)

Este modelo representa una tienda en línea con las siguientes entidades:

- `clientes`: personas que realizan pedidos.
- `productos`: artículos disponibles para la venta.
- `metodos_pago`: métodos utilizados para pagar pedidos.
- `pedidos`: pedidos realizados por los clientes.
- `detalle_pedido`: productos incluidos en cada pedido.

## Relaciones

- Un cliente puede hacer muchos pedidos (1:N).
- Un pedido puede tener muchos productos, y un producto puede estar en muchos pedidos (N:M).
- Un pedido utiliza un método de pago (1:1).
- La relación N:M entre pedidos y productos se gestiona con `detalle_pedido`.

## Diagrama ER

Puedes generar el diagrama automáticamente desde MySQL Workbench usando la opción: