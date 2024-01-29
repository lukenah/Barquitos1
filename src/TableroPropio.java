import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TableroPropio {
    private Casilla[][] casillas;
    public TableroPropio() {
        rellenarConAgua();
    }

    private void rellenarConAgua() {
        casillas=new Casilla[filas()][columnas()];
        for (int i = 0; i < filas(); i++) {
            for (int j = 0; j < columnas(); j++) {
                casillas[i][j]=new Casilla(true);
            }
        }
    }

    private int filas() {
        return Coordenada.getMaxFila()-Coordenada.getMinFila()+1;
    }

    private int columnas() {
        return Coordenada.getMaxColumna()-Coordenada.getMinColumna()+1;
    }

    public boolean colocar(@NotNull Barco barco, @NotNull Coordenada c, @NotNull TipoOrientacion o) {
        // Comprobar si todas las casillas que va a ocupar el barco son agua
        Casilla[] casillas=new Casilla[barco.longitud()];
        Coordenada aux=new Coordenada(c.getFila(), c.getColumna());
        for (int i = 0; i < barco.longitud(); i++) {
            if (esCoordenada(aux))
                casillas[i]=getCasilla(aux);
            else 
                return false;
            if (o.equals(TipoOrientacion.HORIZONTAL))
                aux.setFila((char)(aux.getFila()+1));
            else if (o.equals(TipoOrientacion.VERTICAL))
                aux.setColumna(aux.getColumna()+1);
            else {                                                                          // PROGRAMACIÓN DEFENSIVA
                System.err.printf("Tipo de orientacion desconocida (orientacion=%s)\n", o);
                System.exit(1);
            }
        }
        
        if (!sonAgua(casillas)) {
            return false;
        }
        // TODO: 29/01/2024 3) No puede existir un barco contiguo al barco a colocar
        // TODO: 29/01/2024 4) Todos los trozos del barco deben estar colocados dentro del tablero
        return true;
    }
    
    private boolean esCoordenada(@NotNull Coordenada c) {
        return Coordenada.esFila(c.getFila()) && Coordenada.esColumna(c.getColumna());
    }
    
    private Casilla getCasilla(@NotNull Coordenada c) {
        return casillas[c.getFila()-Coordenada.getMinFila()][c.getColumna()-Coordenada.getMinColumna()];
    }

    private boolean sonAgua(@NotNull Casilla[] casillas) {
        for (Casilla casilla : casillas)
            if (!casilla.esAgua()) return false;
        return true;
    }
}
