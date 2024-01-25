import org.jetbrains.annotations.NotNull;

public class Jugador {
    private String apodo;                   // NN, NV, NB
    private Flota flota;                    // NN <<R>>
    private TableroPropio tableroPropio;    // NN <<R>>
    private TableroEnemigo tableroEnemigo;  // NN<<R>>

    public Jugador(String a, Flota f, TableroPropio p, TableroEnemigo e ) {
        setApodo(a);
        setFlota(f);
        setTableroPropio(p);
        setTableroEnemigo(e);
    }

    private void setTableroPropio(@NotNull TableroPropio p) {
        this.tableroPropio=p;
    }

    private void setTableroEnemigo(@NotNull TableroEnemigo e) {
        this.tableroEnemigo=e;
    }

    private void setFlota(@NotNull Flota f) {
        this.flota=f;
    }

    private void setApodo(@NotNull String apodo) {
        // TODO: 25/01/2024 VALIDACIÓN
        this.apodo=apodo;
    }

    @Override
    public String toString() {
        return apodo;
    }
}
