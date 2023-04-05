USE jugos;

INSERT INTO tbproductos(
producto, nombre, envase, volumen, sabor,
precio) VALUES ('773912', 'clean', 'botella pet',
'1 litro', 'naranja', 8.01);

SELECT * FROM tbproductos;

ALTER TABLE tbproductos ADD PRIMARY KEY(PRODUCTO); # Declara el campo producto como clave primaria de la tabla tbproductos
# La clave primaria es muy útil para evitar la duplicidad en los registros y para garantizar la integridad de los datos.