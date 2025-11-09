import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Clase del ejercicio 3
 * @author prorix
 * @version 1.0.0
 */
public class CazaHorrocruxe {

    public AtomicBoolean encontrado = new AtomicBoolean(false);
    public AtomicReference<String> ganador = new AtomicReference<>(null);

    /**
     * Metodo que construye hilos buscadores de Horrocruxes.
     * @param nombre nombre del personaje buscador
     * @param ubicacion lugar donde realiza la busqueda
     * @return Runnable configurado para la busqueda
     */
    private Runnable buscador(String nombre, String ubicacion) {
        return () -> {
            if (encontrado.get()) {
                return;
            }
            int pausa = ThreadLocalRandom.current().nextInt(500, 2001);
            try { Thread.sleep(pausa); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }

            boolean exito = !encontrado.get() && encontrado.compareAndSet(false, true);
            if (exito) {
                ganador.set(nombre);
                System.out.println(nombre + " encontró un Horrocrux en " + ubicacion + ". ¡Búsqueda terminada!");
            }
        };
    }

    public void main() {
        Thread t1 = new Thread(buscador("Harry", "Bosque Prohibido"));
        Thread t2 = new Thread(buscador("Hermione", "Biblioteca Antigua"));
        Thread t3 = new Thread(buscador("Ron", "Mazmorras del castillo"));
        t1.start(); t2.start(); t3.start();
        try { t1.join(); t2.join(); t3.join(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
