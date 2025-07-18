-- Consultas
SELECT p.id_pedido, p.fecha_pedido
FROM pedidos p
JOIN clientes c ON p.id_cliente = c.id_cliente
WHERE c.nombre = 'Juan Pérez';

SELECT c.nombre AS cliente, pr.nombre AS producto, dp.cantidad
FROM detalle_pedido dp
JOIN pedidos p ON dp.id_pedido = p.id_pedido
JOIN clientes c ON p.id_cliente = c.id_cliente
JOIN productos pr ON dp.id_producto = pr.id_producto
WHERE c.nombre = 'Juan Pérez';

SELECT c.nombre AS cliente, SUM(dp.cantidad * dp.precio_unitario) AS total_gastado
FROM clientes c
JOIN pedidos p ON c.id_cliente = p.id_cliente
JOIN detalle_pedido dp ON p.id_pedido = dp.id_pedido
GROUP BY c.nombre
ORDER BY total_gastado DESC;

SELECT fecha_pedido, COUNT(*) AS total_pedidos
FROM pedidos
GROUP BY fecha_pedido
ORDER BY fecha_pedido;

SELECT pr.nombre AS producto, SUM(dp.cantidad) AS total_vendido
FROM productos pr
JOIN detalle_pedido dp ON pr.id_producto = dp.id_producto
GROUP BY pr.nombre
ORDER BY total_vendido DESC;

SELECT dp.id_pedido, COUNT(*) AS cantidad_productos
FROM detalle_pedido dp
GROUP BY dp.id_pedido
HAVING COUNT(*) > 1;