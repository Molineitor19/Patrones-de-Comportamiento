package estrategia;

import java.util.Random;

public class EstrategiaAleatoria implements Estrategia {
    private final String[] jugadas = {"Piedra", "Papel", "Tijera"};
    private Random random = new Random();

    @Override
    public String elegirJugada() {
        return jugadas[random.nextInt(jugadas.length)];
    }
}
