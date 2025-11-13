package modelo;

import estrategia.*;

public class JugadorFactory {

    public static Jugador crearJugador(String tipo, String nombre) {
        switch (tipo.toLowerCase()) {
            case "humano":
                return new Jugador(nombre, new EstrategiaHumano());
            case "aleatorio":
                return new Jugador(nombre, new EstrategiaAleatoria());
            case "constante":
                return new Jugador(nombre, new EstrategiaConstante("Piedra"));
            default:
                throw new IllegalArgumentException("Tipo de jugador no reconocido");
        }
    }
}
