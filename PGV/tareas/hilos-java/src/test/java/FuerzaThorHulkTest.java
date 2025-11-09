import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class FuerzaThorHulkTest {

    @Test
    public void FuerzaThorHulk_terminaPorTiempo_yDeclaraResultado() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        FuerzaThorHulk f = new FuerzaThorHulk();
        String salida;
        try {
            f.main();
            salida = out.toString().trim();
        } finally {
            System.setOut(original);
        }

        assertTrue(salida.contains("¡Tiempo!"));
        boolean declaracionValida = salida.contains("gana") || salida.contains("Empate");
        assertTrue(declaracionValida);
    }
}
