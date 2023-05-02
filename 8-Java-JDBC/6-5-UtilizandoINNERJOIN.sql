USE control_de_stock;
SELECT * FROM producto;
INSERT INTO producto (nombre, descripcion, cantidad, categoria_id) VALUES ('Mouse', 'Mouse inalámbrico', 10, 2);
SELECT * FROM producto;

SELECT * FROM categoria;

SELECT C.ID, C.NOMBRE, P.ID, P.NOMBRE, P.CANTIDAD FROM CATEGORIA C INNER JOIN PRODUCTO P ON C.ID = P.CATEGORIA_ID;