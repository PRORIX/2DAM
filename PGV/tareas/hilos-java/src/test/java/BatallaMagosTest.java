import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BatallaMagosTest {

    @Test
    public void BatallaMagos_debeHaberGanadorYTerminar() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        BatallaMagos b = new BatallaMagos();
        String salida;
        try {
            b.main();
            salida = out.toString().trim();
        } finally {
            System.setOut(original);
        }

        assertTrue(salida.contains("gana la batalla mágica."));
        assertTrue(b.combateTerminado.get());
        assertTrue(b.energiaGandalf <= 0 || b.energiaSaruman <= 0);
    }
}
