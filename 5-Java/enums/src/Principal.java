public class Principal {
    
    // final = constante = no modificable
    //public static final String DIA_LUNES = "lunes";

    public static void main(String[] args) {
        
        for(Dia dia : Dia.values()) {
            System.out.println("El día de la semana es: " + dia);
        }

        Dia domingo = Dia.DOMINGO;
        System.out.println(domingo.name()); // Devuelve el nombre del día
        System.out.println(domingo.ordinal()); // Devuelve la posición en el enum del día
        System.out.println(domingo.toString()); // Devuelve el nombre del día en string

        //Dia domingo = Dia.TRIMINGO; // El compilador comprueba que estemos pasando un valor de ese enum

    }
}