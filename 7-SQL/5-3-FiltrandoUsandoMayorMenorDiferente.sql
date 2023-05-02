SELECT * FROM tbcliente;

SELECT * FROM tbcliente WHERE EDAD > 27;
SELECT * FROM tbcliente WHERE EDAD < 27;
SELECT * FROM tbcliente WHERE EDAD <= 27;
SELECT * FROM tbcliente WHERE EDAD <> 26; # Todos los registros que no son iguales a 26

SELECT * FROM tbcliente WHERE  NOMBRE > 'Erica Carvajo'; # Todos los registros que vienen después de Erica Carvajo alfabeticamente
SELECT * FROM tbcliente WHERE  NOMBRE < 'Erica Carvajo';
SELECT * FROM tbcliente WHERE  NOMBRE <= 'Erica Carvajo';

SELECT * FROM tbproducto;

SELECT * FROM tbproducto WHERE PRECIO_LISTA = 28.51; # No devuelve ninguno, a pesar de haber un registro 28.51
SELECT * FROM tbproducto WHERE PRECIO_LISTA > 28.51; # Ahora si lo devuelve, porque lo considera mayor a 28.51
SELECT * FROM tbproducto WHERE PRECIO_LISTA < 28.51;
SELECT * FROM tbproducto WHERE PRECIO_LISTA BETWEEN 28.49 AND 28.52;