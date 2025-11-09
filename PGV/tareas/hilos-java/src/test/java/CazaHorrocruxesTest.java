import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CazaHorrocruxesTest {

    @Test
    public void CazaHorrocruxesUnGanadorYUnSoloHallazgo() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        CazaHorrocruxe c = new CazaHorrocruxe();
        String salida;
        try {
            c.main();
            salida = out.toString().trim();
        } finally {
            System.setOut(original);
        }

        assertTrue(c.encontrado.get());
        assertTrue(
            c.ganador.get().equals("Harry") ||
            c.ganador.get().equals("Hermione") ||
            c.ganador.get().equals("Ron")
        );

        assertEquals(1, salida.split("encontró un Horrocrux").length - 1);
    }
}
