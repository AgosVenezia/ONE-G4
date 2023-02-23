/* 
public class Auto {
    private Double velocidad;
    private String modelo;
    private MecanismoAceleracion mecanismoAceleracion;
    private String color;

    Vea que se inserta el mecanismo de aceleración en el auto al construirse, y
        no lo vemos ni podemos modificarlo, es decir, no tiene getter ni setter.
        Ya el "modelo" se puede ver, pero no se puede alterar.
    public Auto(String modelo, MecanismoAceleracion mecanismoAceleracion) {
        this.modelo = modelo;
        this.mecanismoAceleracion = mecanismoAceleracion;
        this.velocidad = 0;
    }

    public void acelerar() {
        this.mecanismoAceleracion.acelerar();
    }

    public void frenar() {
        código del auto para frenar
    }

    public void encenderFaro() {
        código del auto para encender el faro
    }

    public Double getVelocidad() {
        return this.velocidad
    }

    private void setVelocidad() {
        código para alterar la velocidad del auto 
        Como solo el propio auto debe calcular la velocidad, 
            este método no se puede llamado de afuera, por eso es "private"
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getCor() {
        return this.cor;
    }

    podemos cambiar el color del auto cuando deseemos
    public void setCor(String color) {
        this.cor = color;
    }
}
*/

/*
Ejemplo en Python
# Ejemplo de la clase Auto en Python
class Auto:
    def __init__(self, modelo, mecanismoAceleracion):
        self.__modelo = modelo;
        self.__velocidad = 0
        self.__mecanismoAceleracion = mecanismoAceleracion

    def acelerar(self):
        mecanismoAceleracion.acelerar()

    def frear(self):
        # Codigo para frenar el auto

    def encenderFaro(self):
        # Codigo para encender el faro del auto

    def getVelocidad(self):
        return self.velocidad

    def __setVelocidad(self):
        # Codigo para alterar la velocidad por dentro del objeto

    def getModelo(self):
        return self.modelo

    def getColor(self):
        return self.color

    def setColor(self, color):
        self.color = color
*/