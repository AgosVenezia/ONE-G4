SELECT * FROM tbcliente; # Selecciona todos los registros de la tabla tbcliente
SELECT DNI, NOMBRE, DIRECCION1, DIRECCION2, BARRIO, CIUDAD, ESTADO,CP, FECHA_NACIMIENTO, EDAD, 
SEXO, LIMITE_CREDITO, VOLUMEN_COMPRA, PRIMERA_COMPRA FROM tbcliente; # Selecciona todos los registros de la tabla tbcliente

SELECT DNI, NOMBRE FROM tbcliente;
SELECT NOMBRE, SEXO, EDAD, DIRECCION1 FROM tbcliente;
SELECT NOMBRE AS Nombre_Completo, SEXO AS Género, EDAD AS Años, DIRECCION1 AS Domicilio FROM tbcliente; # Alias
SELECT NOMBRE, SEXO, EDAD, DIRECCION1 FROM tbcliente LIMIT 6;


SELECT * FROM tbproducto;
SELECT * FROM tbproducto WHERE SABOR = 'Maracuyá';
SELECT * FROM tbproducto WHERE ENVASE = 'Botella de Vidrio';

UPDATE tbproducto SET SABOR = 'Cítrico' WHERE SABOR = 'Limón';
SELECT * FROM tbproducto WHERE SABOR = 'Limón'; # Ya no me muestra nada porque reemplacé limón por cítrico
SELECT * FROM tbproducto WHERE SABOR = 'Cítrico';