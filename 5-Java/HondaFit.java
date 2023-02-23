// "extends" establece la relacion de herencia con la clase Auto

/*
public class HondaFit extends Auto {

    public HondaFit(MecanismoAceleracion mecanismoAceleracion) {
        String modelo = "Honda Fit";
        // llama al constructor de la clase madre, es decira, de la clase "Auto"
        super(modelo, mecanismoAceleracion);
    }
}
*/

/*
Ejemplo en Python
# Las clases dentro del parénteses son las clases madre de la clase definiendose
class HondaFit(Auto):

    def __init__(self, mecanismoAceleracion):
        modelo = "Honda Fit"
        # llama al constructor de la clase madre, es decir, de la clase "Auto"
        super().__init__(self, modelo, mecanismoAceleracion)
*/

/*
Interfaz
Muchos de los métodos de los autos son comunes en muchos automóviles. Tanto un auto como una motocicleta son clases cuyos objetos pueden acelerar, frenar, encender los faros, etc., ya que son comunes a los automóviles. Podemos decir, entonces, que tanto la clase "auto" como la "motocicleta" son "automóviles".

Cuando dos (o más) clases tienen comportamientos comunes que pueden separarse en otra clase, decimos que la "clase común" es una interfaz, que puede ser "heredada" por las otras clases. Tenga en cuenta que colocamos la interfaz como una "clase común", que puede ser "heredada" (con comillas), porque una interfaz no es exactamente una clase, sino un conjunto de métodos que todas las clases que heredan de ella deben tener (implementar) - por lo tanto, una interfaz no es "heredada" por una clase, sino implementada. En el mundo del desarrollo de software, decimos que una interfaz es un "contrato": una clase que implementa una interfaz debe proporcionar una implementación para todos los métodos que define la interfaz y, a cambio, la clase de implementación puede decir que es del tipo de interfaz. En nuestro ejemplo, "auto" y "motocicleta" son clases que implementan los métodos de la interfaz "automóvil", por lo que podemos decir que cualquier objeto de estas dos primeras clases, como una Honda Fit o una motocicleta Yamaha, son automóviles.

Un pequeño detalle: una interfaz no puede ser heredada por una clase, sino implementada. Sin embargo, una interfaz puede heredar de otra interfaz, creando una jerarquía de interfaces. Usando un ejemplo completo con autos, decimos que la clase "Honda Fit Cross" hereda de la clase "Honda Fit", que a su vez hereda de la clase "Auto". La clase "Auto" implementa la interfaz "Automóvil" que, a su vez, puede heredar (por ejemplo) una interfaz llamada "MedioDeTransporte", ya que tanto un "automóvil" como un "carro" son medios de transporte, aunque un carro no sea un automóvil.

Ejemplo en Java
public interface Automovil {
    void acelerar();
    void frenar();
    void encenderFaro();
}

public class Auto implements Automovil {

    @Override
    public void acelerar() {
        this.mecanismoAceleracion.acelerar();
    }

    @Override
    public void frenar() {
        código del auto para frenar
    }

    @Override
    public void encenderFaro() {
        código del auto para encender el faro
    }

}

public class Moto implements Automovil {

    @Override
    public void acelerar() {
        código específico de la moto para acelerar 
    }

    @Override
    public void frenar() {
        código específico de la moto para frenar 
    }

    @Override
    public void encenderFaro() {
        código específico de la moto para encender el faro 
    }

}
Ejemplo en Python
class Automovil():
    def acelerar(self):
        raise NotImplementedError()

    def frenar(self):
        raise NotImplementedError()

    def encenderFarol(self):
        raise NotImplementedError()

class Auto(Automovil):

    # ...

    def acelerar(self):
        # Codigo para acelerar el auto

    def frenar(self):
        # Codigo para frenar el auto

    def encenderFaro(self):
        # Codigo para encender el faro del auto

    # ...

class Moto(Automovil):

    # ...

    def acelerar(self):
        # Codigo para acelerar la moto

    def frear(self):
        # Codigo para frenar la moto

    def encenderFaro(self):
        # Codigo para encender la moto

    # ...
Nota: crea un error de tipo NotImplementedError, aquello, evidencia que, si una clase hija intenta ejecutar un método de la clase padre sin haberlo implementado, se produce el error. En Python, las interfaces se crean como clases normales que heredan las clases hijas. Hay formas de forzar la implementación por parte de las clases hijas, pero para nuestro ejemplo, este abordaje es suficiente.

Polimorfismo
Digamos que una de las razones por las que compraste un auto fue la calidad de su sistema de sonido. Pero, en su caso, digamos que la reproducción solo se puede hacer por radio o bluetooth, mientras que en su auto antiguo, solo se puede hacer a través de la tarjeta SD y pendrive. El método de "reproducir música" está presente en ambos autos, pero como su sistema de sonido es diferente, la forma en que el automóvil reproduce música es diferente. Decimos que el método "reproducir música" es una forma de polimorfismo, porque dos objetos, de dos clases diferentes, tienen el mismo método que se implementa de diferentes maneras, es decir, un método tiene varias formas, varias implementaciones diferentes en diferentes clases, pero que tienen el mismo efecto ("polimorfismo" proviene del griego poli = muchas, morfos= forma).

Ejemplo en Java
public class Main {
    public static void main(String[] args) {
        Automovil moto = new Moto("Yamaha XPTO-100", new MecanismoDeAceleracionDeMotos())
        Automovil auto = new Auto("Honda Fit", new MecanismoDeAceleracionDeAutos())
        List<Automovil> listaAutomoviles = Arrays.asList(moto, auto);
        for (Automovil automovil : listaAutomoviles) {
            automovil.acelerar();
            automovil.encenderFaro();
        }
    }
}
Ejemplo en Python
def main():
    moto = Moto("Yahama XPTO-100", MecanismoDeAceleracionDeMotos())
    auto = Auto("Honda Fit", MecanismoDeAceleracionDeAutos())
    listaAutomoviles = [moto, auto]
    for automovil in listaAutomoviles:
        automovil.acelerar()
        automovil.encenderFaro()
Ten en cuenta que, aunque son objetos diferentes, moto y auto tienen los mismos métodos acelerar y encenderFaro, que se llaman igual, a pesar de estar implementados de manera diferente.
*/