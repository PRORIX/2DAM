import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ExploradoresJediTest {

    @Test
    public void ExploradoresJediUnSoloGanador() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        ExploradoresJedi e = new ExploradoresJedi();
        String salida;
        try {
            e.main();
            salida = out.toString().trim();
        } finally {
            System.setOut(original);
        }

        assertTrue(e.pistaEncontrada.get());
        assertEquals(1, salida.split("halló una pista").length - 1);
    }
}
