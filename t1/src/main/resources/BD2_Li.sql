-- Script de base de datos para CiberMarket
-- Crea BD2_Li con tablas productos y proveedores + datos de prueba

CREATE DATABASE IF NOT EXISTS BD2_Li;
USE BD2_Li;

CREATE TABLE IF NOT EXISTS proveedores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_proveedor VARCHAR(100) NOT NULL,
    direccion VARCHAR(150),
    apoderado_legal VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(120) NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    proveedor_id BIGINT NOT NULL,
    CONSTRAINT fk_productos_proveedor FOREIGN KEY (proveedor_id) REFERENCES proveedores(id)
);

INSERT INTO proveedores (nombre_proveedor, direccion, apoderado_legal) VALUES
('Proveedor Andino', 'Av. Los Olivos 123, Lima', 'María Rojas'),
('Distribuidora Pacífico', 'Jr. Grau 456, Callao', 'Jorge Campos'),
('Comercial Amazonia', 'Calle Amazonas 789, Iquitos', 'Luisa Paredes');

INSERT INTO productos (nombre_producto, cantidad, precio_unitario, proveedor_id) VALUES
('Laptop Ultrabook', 15, 4200.00, 1),
('Monitor 27"', 30, 1100.50, 2),
('Mouse inalámbrico', 50, 75.90, 3),
('Teclado mecánico', 40, 320.00, 1),
('Disco SSD 1TB', 25, 580.75, 2),
('Silla ergonómica', 12, 890.00, 3),
('Impresora láser', 8, 1250.00, 1),
('Cámara web HD', 45, 220.00, 2),
('Router WiFi 6', 35, 460.00, 3);
