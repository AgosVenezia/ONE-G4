/* Vimos cómo hacer pruebas con if, pero ¿si necesitamos hacer varias pruebas? Un ejemplo, tenemos una variable de mes, necesitamos probar su número e imprimir su mes correspondiente. Entonces, ¿vamos a hacer 12 ifs?
Para estos casos, existe el switch, de cambio, donde podemos poner todas las opciones o instrucciones que nuestro programa puede tomar. Funciona de la siguiente manera:

switch (variableASerProbada) {
    case opción1:
        comando (s) si se ha elegido la opción 1
        break;
    case option2:
        comando (s) si se ha elegido la opción 2
        break;
    case option3:
        comando (s) si se ha elegido la opción 3
        break;
    default:
        comando (s) si ninguna de las opciones anteriores ha sido elegida
}

El código que se ejecutará, que en nuestro caso será la impresión del nombre del mes, será el código donde se cumple la condición:

public class TestMes {

    public static void main (String [] args) {

        int mes = 10;

        switch (mes) {
            case 1:
                System.out.println ("El mes es enero");
                break;
            case 2:
                System.out.println ("El mes es febrero");
                break;
            case 3:
                System.out.println ("El mes es marzo");
                break;
            case 4:
                System.out.println ("El mes es abril");
                break;
            case 5:
                System.out.println ("El mes es mayo");
                break;
            case 6:
                System.out.println ("El mes es junio");
                break;
            case 7:
                System.out.println ("El mes es julio");
                break;
            case 8:
                System.out.println ("El mes es agosto");
                break;
            case 9:
                System.out.println ("El mes es septiembre");
                break;
            case 10:
                System.out.println ("El mes es octubre");
                break;
            case 11:
                System.out.println ("El mes es noviembre");
                break;
            case 12:
                System.out.println ("El mes es diciembre");
                break;
            default:
                System.out.println ("Mes inválido");
                break;
        }
    }
}

El break interrumpirá la ejecución del caso que lo contiene, de modo que los demás no se ejecutarán y, si no se aceptan condiciones, se ejecutará el código default. Por ejemplo:

public class TestMes {

    public static void main (String[] args) {

        int mes = 13;

        switch (mes) {
            case 1:
                System.out.println ("El mes es enero");
                break;
            case 2:
                System.out.println ("El mes es febrero");
                break;
            case 3:
                System.out.println ("El mes es marzo");
                break;
            case 4:
                System.out.println ("El mes es abril");
                break;
            case 5:
                System.out.println ("El mes es mayo");
                break;
            case 6:
                System.out.println ("El mes es junio");
                break;
            case 7:
                System.out.println ("El mes es julio");
                break;
            case 8:
                System.out.println ("El mes es agosto");
                break;
            case 9:
                System.out.println ("El mes es septiembre");
                break;
            case 10:
                System.out.println ("El mes es octubre");
                break;
            case 11:
                System.out.println ("El mes es noviembre");
                break;
            case 12:
                System.out.println ("El mes es diciembre");
                break;
            default:
                System.out.println ("Mes inválido");
                break;
        }
    }
}

La impresión será Mes inválido. Entonces, el switch es una solución para los ifs encadenados.
*/

public class Switch {

    public static void main (String[] args) {

        int mes = 13;

        switch (mes) {
            case 1:
                System.out.println ("El mes es enero");
                break;
            case 2:
                System.out.println ("El mes es febrero");
                break;
            case 3:
                System.out.println ("El mes es marzo");
                break;
            case 4:
                System.out.println ("El mes es abril");
                break;
            case 5:
                System.out.println ("El mes es mayo");
                break;
            case 6:
                System.out.println ("El mes es junio");
                break;
            case 7:
                System.out.println ("El mes es julio");
                break;
            case 8:
                System.out.println ("El mes es agosto");
                break;
            case 9:
                System.out.println ("El mes es septiembre");
                break;
            case 10:
                System.out.println ("El mes es octubre");
                break;
            case 11:
                System.out.println ("El mes es noviembre");
                break;
            case 12:
                System.out.println ("El mes es diciembre");
                break;
            default:
                System.out.println ("Mes inválido");
                break;
        }
    }
}