CREATE DATABASE control_de_stock;
USE control_de_stock;
CREATE TABLE producto (
	id INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(250),
    cantidad INT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
    )Engine=InnoDB;
# Engine=InnoDB señala que queremos que esta tabla acepte operaciones dentro de una transacción.
    
SELECT * FROM producto;
INSERT INTO producto (nombre, descripcion, cantidad) VALUES ("Mesa", "Mesa de 4 lugares", 10);
SELECT * FROM producto;
INSERT INTO producto (nombre, descripcion, cantidad) VALUES ("Celular", "Celular Samsung", 50);
SELECT * FROM producto;