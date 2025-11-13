package estrategia;

public class EstrategiaConstante implements Estrategia {
    private String jugada;

    public EstrategiaConstante(String jugada) {
        this.jugada = jugada;
    }

    @Override
    public String elegirJugada() {
        return jugada;
    }
}
