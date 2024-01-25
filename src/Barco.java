import java.util.Arrays;

public class Barco {
    private Trozo[] trozos;    // <<R>>

    public Barco(int longitud) {
        assert longitud>=1:
                String.format("La longitud del barco debe ser >=1 (longitud=%d)", longitud);
        trozos=new Trozo[longitud];
        Arrays.fill(trozos, new Trozo());
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (Trozo trozo : trozos) {
            sb.append(trozo);
        }
        return sb.toString();
    }
}
