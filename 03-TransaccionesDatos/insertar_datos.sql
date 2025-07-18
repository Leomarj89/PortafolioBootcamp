-- Insert de datos
INSERT INTO clientes (nombre, correo, telefono) VALUES
('Juan Pérez', 'juan.perez@email.com', '123456789'),
('María López', 'maria.lopez@email.com', '987654321'),
('Carlos Díaz', 'carlos.diaz@email.com', '1122334455'),
('Ana Torres', 'ana.torres@email.com', '9988776655'),
('Pedro Sánchez', 'pedro.sanchez@email.com', '123123123'),
('Lucía Gómez', 'lucia.gomez@email.com', '321321321'),
('Jorge Morales', 'jorge.morales@email.com', '456456456'),
('Laura Ríos', 'laura.rios@email.com', '789789789'),
('Andrés Herrera', 'andres.herrera@email.com', '654654654'),
('Sofía Navarro', 'sofia.navarro@email.com', '987987987');

INSERT INTO productos (nombre, descripcion, precio) VALUES
('Laptop Lenovo', 'Laptop i5 con 8GB RAM', 550.00),
('Teclado Mecánico', 'Teclado retroiluminado con switches rojos', 80.00),
('Mouse Inalámbrico', 'Mouse óptico con batería recargable', 25.00),
('Monitor 24"', 'Pantalla LED Full HD', 150.00),
('Impresora HP', 'Impresora multifunción inalámbrica', 120.00),
('Webcam HD', 'Cámara web 1080p', 40.00),
('Silla ergonómica', 'Silla para oficina con soporte lumbar', 200.00),
('Auriculares Bluetooth', 'Con cancelación de ruido', 90.00),
('Tablet Samsung', '10" con 64GB de almacenamiento', 300.00),
('Disco SSD 1TB', 'Unidad de estado sólido', 130.00);

INSERT INTO pedidos (id_cliente, fecha_pedido) VALUES
(1, '2025-07-01'),
(2, '2025-07-02'),
(1, '2025-07-03'),
(3, '2025-07-04'),
(4, '2025-07-05'),
(5, '2025-07-06'),
(2, '2025-07-07'),
(6, '2025-07-08'),
(7, '2025-07-09'),
(8, '2025-07-10');

INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unitario) VALUES
(1, 1, 1, 550.00),
(1, 3, 2, 25.00),
(2, 2, 1, 80.00),
(3, 5, 1, 120.00),
(4, 4, 1, 150.00),
(5, 6, 1, 40.00),
(6, 7, 1, 200.00),
(7, 8, 1, 90.00),
(8, 9, 1, 300.00),
(9, 10, 2, 130.00);

-- Update
UPDATE clientes
SET correo = 'juan.perez2025@email.com'
WHERE nombre = 'Juan Pérez';

UPDATE productos
SET precio = 95.00
WHERE nombre = 'Auriculares Bluetooth';

UPDATE detalle_pedido
SET cantidad = 3
WHERE id_pedido = 1 AND id_producto = 3;

-- Delete
-- Primero eliminamos los detalles del pedido
DELETE FROM detalle_pedido
WHERE id_pedido = 10;

-- Luego eliminamos el pedido
DELETE FROM pedidos
WHERE id_pedido = 10;

INSERT INTO clientes (nombre, correo, telefono)
VALUES ('Cliente Sin Pedidos', 'sin.pedidos@email.com', '000000000');

-- Ahora lo eliminamos
DELETE FROM clientes
WHERE nombre = 'Cliente Sin Pedidos';