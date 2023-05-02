USE control_de_stock;
SELECT * FROM producto;
INSERT INTO producto (nombre, descripcion, cantidad) VALUES ('Teclado', 'Teclado inalámbrico', 10);
SELECT * FROM producto;

CREATE TABLE categoria(
	id INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
    )Engine=InnoDB;
SELECT * FROM categoria;
SELECT * FROM producto;
INSERT INTO categoria(nombre) VALUES('Muebles'),('Tecnologia'),('Cocina'),('Zapatillas');
SELECT * FROM categoria;

ALTER TABLE producto ADD COLUMN categoria_id INT;
SELECT * FROM producto;
ALTER TABLE producto ADD FOREIGN KEY (categoria_id) REFERENCES categoria(id);
/*Clave foránea: esta clave es la que va a vincular las dos tablas de forma que sea creada una relación entre ellas*/
SELECT * FROM producto;
SELECT * FROM categoria;

UPDATE producto SET categoria_id = 1 WHERE id = 1;
SELECT * FROM producto;
/*UPDATE producto SET categoria_id = 5 WHERE id = 2; Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`control_de_stock`.`producto`, CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`))*/
SELECT * FROM categoria;

UPDATE producto SET categoria_id = 2 WHERE id = 2;
UPDATE producto SET categoria_id = 3 WHERE id = 3;
UPDATE producto SET categoria_id = 3 WHERE id = 5;
UPDATE producto SET categoria_id = 2 WHERE id = 8;
UPDATE producto SET categoria_id = 2 WHERE id = 9;
UPDATE producto SET categoria_id = 2 WHERE id = 10;
UPDATE producto SET categoria_id = 4 WHERE id = 11;
UPDATE producto SET categoria_id = 3 WHERE id = 12;
UPDATE producto SET categoria_id = 3 WHERE id = 13;
UPDATE producto SET categoria_id = 3 WHERE id = 23;
UPDATE producto SET categoria_id = 2 WHERE id = 30;
SELECT * FROM producto;