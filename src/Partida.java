import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Partida {
    private Jugador[] jugadores;                // <<R>>
    private Jugador ganador;                    // <<R>>
    private int turno;                          // {0,1}
    private TableroPropio[] tablerosPropios;    // <<R>>
    private TableroEnemigo[] tablerosEnemigos;  // <<R>>
    private Flota[] flotas;                     // <<R>>

    public Partida(@NotNull String[] apodos) {
        assert apodos.length==2:
                String.format("El juego debe tener 2 jugadores (nº juhadores=%d)", apodos.length);
        setTurno(0);

        // Crear tableros propios
        tablerosPropios=new TableroPropio[2];
        for (int i = 0; i < tablerosPropios.length; i++) {
            tablerosPropios[i]=new TableroPropio();
        }

        // Crear tableros propios
        tablerosEnemigos=new TableroEnemigo[2];
        for (int i = 0; i < tablerosEnemigos.length; i++) {
            tablerosEnemigos[i]=new TableroEnemigo();
        }

        crearFlotas();

        // Crear jugadores
        jugadores=new Jugador[apodos.length];
        for (int i = 0; i < apodos.length; i++) {
            jugadores[i]=new Jugador(apodos[i], flotas[i], tablerosPropios[i], tablerosEnemigos[i]);
        }
    }

    private void setTurno(int turno) {
        assert turno==0 || turno==1:
                String.format("El turno debe ser 0 o 1 (turno=%d)", turno);
        this.turno=turno;
    }

    private void crearFlotas() {
        flotas=new Flota[2];
        for (int i = 0; i < flotas.length; i++) {
            flotas[i]=new Flota(new int[]{4,3,3,2,2,2,1,1,1,1});
        }
    }

    @Override
    public String toString() {
        return "Partida{" +
                "jugadores=" + Arrays.toString(jugadores) +
                ", ganador=" + ganador +
                ", turno=" + turno +
                ", tablerosPropios=" + Arrays.toString(tablerosPropios) +
                ", tablerosEnemigos=" + Arrays.toString(tablerosEnemigos) +
                ", flotas=" + Arrays.toString(flotas) +
                '}';
    }
}
