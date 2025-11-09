import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BatallaPokemonTest {

    @Test
    public void BatallaPokemon_debeHaberGanador() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        BatallaPokemon juego = new BatallaPokemon();
        String salida;
        try {
            juego.main();
            salida = out.toString().trim();
        } finally {
            System.setOut(original);
        }

        assertTrue(salida.contains("ha ganado la batalla!"));
        assertTrue(juego.juegoTerminado.get());
        assertTrue(juego.hpPikachu <= 0 || juego.hpCharmander <= 0);
    }
}
