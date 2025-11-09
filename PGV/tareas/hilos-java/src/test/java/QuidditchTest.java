import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class QuidditchTest {

    @Test
    public void Quidditch_terminaCuandoSnitchAtrapada() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        Quidditch q = new Quidditch();
        String salida;
        try {
            q.main();
            salida = out.toString().trim();
        } finally {
            System.setOut(original);
        }

        assertTrue(salida.contains("¡Snitch dorada atrapada!"));
        boolean marcadorMostrado = salida.contains("Marcador final:");
        assertTrue(marcadorMostrado);
    }
}
