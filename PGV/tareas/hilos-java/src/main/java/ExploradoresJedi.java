import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Clase del ejercicio 5
 * @author prorix
 * @version 1.0.0
 */
public class ExploradoresJedi {

    public AtomicBoolean pistaEncontrada = new AtomicBoolean(false);
    public AtomicReference<String> ganador = new AtomicReference<>(null);

    /**
     * Metodo que genera exploradores jedis con su planeta asignado.
     * @param nombre nombre del jedi
     * @param planeta planeta que inspecciona
     * @return Runnable que representa la tarea del jedi
     */
    private Runnable jedi(String nombre, String planeta) {
        return () -> {
            if (pistaEncontrada.get()) {
                return;
            }
            int pausa = ThreadLocalRandom.current().nextInt(400, 1501);
            try { Thread.sleep(pausa); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }

            boolean exito = !pistaEncontrada.get() && pistaEncontrada.compareAndSet(false, true);
            if (exito) {
                ganador.set(nombre);
                System.out.println(nombre + " halló una pista en " + planeta + ". Fin de búsqueda.");
            }
        };
    }


    public void main() {
        Thread t1 = new Thread(jedi("Kenobi", "Tatooine"));
        Thread t2 = new Thread(jedi("Skywalker", "Dagobah"));
        t1.start(); t2.start();
        try { t1.join(); t2.join(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
