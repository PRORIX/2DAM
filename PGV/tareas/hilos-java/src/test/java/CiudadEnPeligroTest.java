import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CiudadEnPeligroTest {

    @Test
    public void CiudadEnPeligroSoloNeutralizaElOtroSeDetiene() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        CiudadEnPeligro c = new CiudadEnPeligro();
        String salida;
        try {
            c.main();
            salida = out.toString().trim();
        } finally {
            System.setOut(original);
        }

        assertTrue(c.amenazaNeutralizada.get());
        assertTrue(
            c.ganador.get().equals("Superman") ||
            c.ganador.get().equals("Batman")
        );
        int neutralizaciones = salida.split("Amenaza neutralizada").length - 1;
        assertEquals(1, neutralizaciones);
    }
}
