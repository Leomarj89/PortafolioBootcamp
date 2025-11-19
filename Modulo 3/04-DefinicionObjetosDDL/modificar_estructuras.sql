-- Agregar columna "direccion" a la tabla clientes
ALTER TABLE clientes
ADD direccion VARCHAR(255);

-- Modificar tipo de dato de la columna telefono
ALTER TABLE clientes
MODIFY telefono VARCHAR(15);

-- Crear un índice en la tabla productos por el nombre
CREATE INDEX idx_nombre_producto ON productos(nombre);

-- Eliminar ese índice
DROP INDEX idx_nombre_producto ON productos;

-- Eliminar una tabla (por ejemplo, detalle_pedido si se desea rediseñar)
DROP TABLE IF EXISTS detalle_pedido;