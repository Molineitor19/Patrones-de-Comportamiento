package modelo;

import estrategia.Estrategia;

public class Jugador {
    private String nombre;
    private Estrategia estrategia;

    public Jugador(String nombre, Estrategia estrategia) {
        this.nombre = nombre;
        this.estrategia = estrategia;
    }

    public String getNombre() {
        return nombre;
    }

    public String jugar() {
        return estrategia.elegirJugada();
    }
}
