SELECT NOMBRE, MATRICULA FROM TABLA_DE_VENDEDORES; # Seleccionando a todos los vendedores
SELECT * FROM TABLA_DE_VENDEDORES WHERE NOMBRE = 'Claudia Morais'; # Seleccionando a un vendedor
SELECT * FROM TABLA_DE_VENDEDORES WHERE PORCENTAJE_COMISION > 0.10; # Seleccionando vendedores por el valor de la comisión
SELECT * FROM TABLA_DE_VENDEDORES WHERE YEAR(FECHA_ADMISION) >= 2016; # Seleccionando a un vendedor por fecha
SELECT * FROM TABLA_DE_VENDEDORES WHERE YEAR(FECHA_ADMISION) < 2016 AND DE_VACACIONES = 1; # Selección compuesta
SELECT NOMBRE, MATRICULA FROM TABLA_DE_VENDEDORES; # Seleccionar a todos los vendedores