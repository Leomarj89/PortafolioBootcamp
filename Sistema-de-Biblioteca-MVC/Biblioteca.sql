CREATE DATABASE biblioteca CHARACTER SET utf8mb4;
USE biblioteca;

CREATE TABLE libros (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(150) NOT NULL,
  autor  VARCHAR(150) NOT NULL,
  disponible TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE solicitudes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre_usuario VARCHAR(150) NOT NULL,
  correo VARCHAR(150) NOT NULL,
  libro_id INT NOT NULL,
  creada_en DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO libros (nombre, autor, disponible) VALUES
('Clean Code', 'Robert C. Martin', 1),
('Effective Java', 'Joshua Bloch', 1),
('Design Patterns', 'GoF', 0);

select * from libros;

SELECT user, host, plugin FROM mysql.user WHERE user='root';

CREATE USER IF NOT EXISTS 'usuario1'@'localhost'
  IDENTIFIED BY 'usuario1';
GRANT SELECT, INSERT, UPDATE, DELETE ON biblioteca.* TO 'usuario1'@'localhost';
FLUSH PRIVILEGES;