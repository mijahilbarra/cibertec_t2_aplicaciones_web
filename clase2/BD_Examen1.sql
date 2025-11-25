-- Crear base de datos
CREATE DATABASE IF NOT EXISTS BD_Examen1;
USE BD_Examen1;

-- Tabla carrera
CREATE TABLE carrera (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_carrera VARCHAR(100) NOT NULL,
    facultad VARCHAR(100) NOT NULL
);

-- Tabla alumno (conectada con carrera)
CREATE TABLE alumno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    carrera_id INT,
    FOREIGN KEY (carrera_id) REFERENCES carrera(id)
);

-- Tabla curso (conectada con carrera)
CREATE TABLE curso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_curso VARCHAR(100) NOT NULL,
    ciclo INT NOT NULL,
    docente VARCHAR(100) NOT NULL,
    carrera_id INT,
    FOREIGN KEY (carrera_id) REFERENCES carrera(id)
);

-- Insertar 5 carreras
INSERT INTO carrera (nombre_carrera, facultad) VALUES
('Ciencias de la Computación', 'Facultad de Ingeniería'),
('Inteligencia Artificial', 'Facultad de Ingeniería'),
('Diseño Gráfico', 'Facultad de Arte y Diseño'),
('Redes y Comunicaciones', 'Facultad de Ingeniería'),
('Desarrollo de Videojuegos', 'Facultad de Ingeniería');

-- Insertar 5 alumnos
INSERT INTO alumno (nombre, apellido, fecha_nacimiento, carrera_id) VALUES
('Juan', 'Pérez', '2002-05-15', 1),
('María', 'González', '2001-08-22', 2),
('Carlos', 'Rodríguez', '2003-03-10', 3),
('Ana', 'Martínez', '2002-11-30', 4),
('Luis', 'Fernández', '2001-07-18', 5);

-- Insertar 3 cursos por carrera

-- Cursos de Ciencias de la Computación
INSERT INTO curso (nombre_curso, ciclo, docente, carrera_id) VALUES
('Algoritmos y Estructuras de Datos', 3, 'Dr. Roberto Silva', 1),
('Bases de Datos', 4, 'Mg. Patricia Ramos', 1),
('Programación Orientada a Objetos', 2, 'Ing. Miguel Torres', 1);

-- Cursos de Inteligencia Artificial
INSERT INTO curso (nombre_curso, ciclo, docente, carrera_id) VALUES
('Machine Learning', 5, 'Dr. Andrea López', 2),
('Procesamiento de Lenguaje Natural', 6, 'Dr. Fernando Castillo', 2),
('Visión por Computadora', 5, 'Mg. Laura Mendoza', 2);

-- Cursos de Diseño Gráfico
INSERT INTO curso (nombre_curso, ciclo, docente, carrera_id) VALUES
('Diseño Digital', 2, 'Lic. Sofía Vargas', 3),
('Ilustración Vectorial', 3, 'Mg. Diego Morales', 3),
('Tipografía Avanzada', 4, 'Lic. Carmen Ruiz', 3);

-- Cursos de Redes y Comunicaciones
INSERT INTO curso (nombre_curso, ciclo, docente, carrera_id) VALUES
('Redes de Computadoras', 3, 'Ing. Jorge Sánchez', 4),
('Seguridad Informática', 5, 'Dr. Ricardo Flores', 4),
('Administración de Servidores', 4, 'Ing. Elena Castro', 4);

-- Cursos de Desarrollo de Videojuegos
INSERT INTO curso (nombre_curso, ciclo, docente, carrera_id) VALUES
('Programación de Videojuegos', 3, 'Ing. Pablo Herrera', 5),
('Diseño de Niveles', 4, 'Mg. Daniela Ortiz', 5),
('Motores Gráficos', 5, 'Dr. Andrés Vega', 5);
