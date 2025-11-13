package modelo;

public class GameManager {
    private static GameManager instancia;

    private GameManager() {}  // Constructor privado

    public static GameManager getInstancia() {
        if (instancia == null) {
            instancia = new GameManager();
        }
        return instancia;
    }

    public void jugarRonda(Jugador j1, Jugador j2) {
        String jugada1 = j1.jugar();
        String jugada2 = j2.jugar();

        System.out.println(j1.getNombre() + " juega: " + jugada1);
        System.out.println(j2.getNombre() + " juega: " + jugada2);

        String resultado = determinarGanador(jugada1, jugada2);
        System.out.println(resultado);
    }

    private String determinarGanador(String j1, String j2) {
        if (j1.equalsIgnoreCase(j2)) return "Empate!";
        if (
            (j1.equalsIgnoreCase("Piedra") && j2.equalsIgnoreCase("Tijera")) ||
            (j1.equalsIgnoreCase("Papel") && j2.equalsIgnoreCase("Piedra")) ||
            (j1.equalsIgnoreCase("Tijera") && j2.equalsIgnoreCase("Papel"))
        ) {
            return "Gana el Jugador 1!";
        } else {
            return "Gana el Jugador 2!";
        }
    }
}
