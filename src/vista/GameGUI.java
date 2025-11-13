package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import modelo.*;
import estrategia.*;

public class GameGUI extends JFrame {

    private JLabel lblJugador, lblComputadora, lblResultado;
    private JButton btnPiedra, btnPapel, btnTijera;
    private GameManager juego;
    private Jugador jugadorHumano;
    private Jugador jugadorComputadora;

    public GameGUI() {
        setTitle("Piedra, Papel o Tijera");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior
        JLabel titulo = new JLabel("¡Piedra, Papel o Tijera!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        // Panel central (jugadas)
        JPanel panelCentro = new JPanel(new GridLayout(3, 1, 10, 10));
        lblJugador = new JLabel("Tu jugada: ", SwingConstants.CENTER);
        lblComputadora = new JLabel("Computadora: ", SwingConstants.CENTER);
        lblResultado = new JLabel("Resultado: ", SwingConstants.CENTER);
        panelCentro.add(lblJugador);
        panelCentro.add(lblComputadora);
        panelCentro.add(lblResultado);
        add(panelCentro, BorderLayout.CENTER);

        // Panel inferior (botones)
        JPanel panelBotones = new JPanel();
        btnPiedra = new JButton("Piedra");
        btnPapel = new JButton("Papel");
        btnTijera = new JButton("Tijera");
        panelBotones.add(btnPiedra);
        panelBotones.add(btnPapel);
        panelBotones.add(btnTijera);
        add(panelBotones, BorderLayout.SOUTH);

        // Inicialización de lógica del juego
        juego = GameManager.getInstancia();
        jugadorHumano = new Jugador("Tú", new EstrategiaConstante("Piedra")); // se cambiará al presionar botón
        jugadorComputadora = JugadorFactory.crearJugador("aleatorio", "Computadora");

        // Listeners
        btnPiedra.addActionListener(e -> jugar("Piedra"));
        btnPapel.addActionListener(e -> jugar("Papel"));
        btnTijera.addActionListener(e -> jugar("Tijera"));
    }

    private void jugar(String eleccionHumano) {
        // Cambiar la estrategia del humano según el botón
        jugadorHumano = new Jugador("Tú", new EstrategiaConstante(eleccionHumano));

        // Jugar la ronda
        String jugada1 = jugadorHumano.jugar();
        String jugada2 = jugadorComputadora.jugar();

        lblJugador.setText("Tu jugada: " + jugada1);
        lblComputadora.setText("Computadora: " + jugada2);
        lblResultado.setText(determinarGanador(jugada1, jugada2));
    }

    private String determinarGanador(String j1, String j2) {
        if (j1.equalsIgnoreCase(j2)) return "Empate 😐";
        if (
            (j1.equalsIgnoreCase("Piedra") && j2.equalsIgnoreCase("Tijera")) ||
            (j1.equalsIgnoreCase("Papel") && j2.equalsIgnoreCase("Piedra")) ||
            (j1.equalsIgnoreCase("Tijera") && j2.equalsIgnoreCase("Papel"))
        ) {
            return "¡Ganaste! 😄";
        } else {
            return "Perdiste 😢";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameGUI ventana = new GameGUI();
            ventana.setVisible(true);
        });
    }
}
