import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class FabricaDroidsTest {

    @Test
    public void FabricaDroidsNoSeActivaAntesYCuentaCorrecta() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        FabricaDroids f = new FabricaDroids();
        String salida;
        try {
            f.main();
            salida = out.toString().trim();
        } finally {
            System.setOut(original);
        }

        for (int k = 1; k <= f.N; k++) {
            String ensamblado = "Ensamblado Droid-" + k;
            String activado = "Activado Droid-" + k;
            int idxE = salida.indexOf(ensamblado);
            int idxA = salida.indexOf(activado);

            assertTrue(idxE != -1 && idxA != -1);
            assertTrue(idxE < idxA);
        }

        assertEquals(f.N, f.activados.get());
    }
}
