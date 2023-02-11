public class EjemploCaracteres {
    public static void main(String[] args) {
        
        char caracter = 'a'; // Sólo soporta un caracter y con comillas simples
        System.out.println(caracter);

        caracter = 65; // Devuelve código ASCII
        System.out.println(caracter);

        caracter = 65 + 1; // Se puede porque devuelve un caracter
        System.out.println(caracter);

        char segundoCaracter = (char) (caracter + 1); // Hay que forzar la conversión de int a char
        System.out.println(segundoCaracter);

        String palabra = "Alura cursos online"; // String no es palabra reservada
        System.out.println(palabra);

        palabra = palabra + " 2020";
        System.out.println(palabra);

    }
}