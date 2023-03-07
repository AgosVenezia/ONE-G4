public abstract class Cuenta2 {

    //atributos omitidos

    public Cuenta2(int agencia, int numero){

        if(agencia < 1) {
            throw new IllegalArgumentException("Agencia inválida");
        }

        if(numero < 1) {
            throw new IllegalArgumentException("Número de cuenta inválido");
        }

        //resto del constructor fue omitido
    }
}