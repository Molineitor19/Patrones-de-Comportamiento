package estrategia;

import java.util.Scanner;

public class EstrategiaHumano implements Estrategia {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String elegirJugada() {
        System.out.print("Elige (Piedra, Papel o Tijera): ");
        return scanner.nextLine();
    }
}
