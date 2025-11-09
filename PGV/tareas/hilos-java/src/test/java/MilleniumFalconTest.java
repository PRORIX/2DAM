import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MilleniumFalconTest {

    @Test
    public void MilleniumFalcon_finalizaConEscapeODestruccion() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        MilleniumFalcon m = new MilleniumFalcon();
        String salida;
        try {
            m.main();
            salida = out.toString().trim();
        } finally {
            System.setOut(original);
        }

        boolean destr = salida.contains("se destruye");
        boolean esc = salida.contains("escapan");

        assertTrue(destr ^ esc);
    }
}
