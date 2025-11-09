import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Clase del ejercicio 10
 * @author prorix
 * @version 1.0.0
 */
public class Tardis {

    public AtomicBoolean destinoAlcanzado = new AtomicBoolean(false);
    public AtomicReference<String> eraGanadora = new AtomicReference<>(null);

    /**
     * Metodo que crea la tarea de viaje a una era determinada.
     * @param era destino temporal asignado
     * @return Runnable que simula el viaje
     */
    private Runnable viaje(String era) {
        return () -> {
            if (destinoAlcanzado.get()) {
                return;
            }
            int pausa = ThreadLocalRandom.current().nextInt(500, 2001);
            try { Thread.sleep(pausa); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }

            boolean exito = !destinoAlcanzado.get() && destinoAlcanzado.compareAndSet(false, true);
            if (exito) {
                eraGanadora.set(era);
                System.out.println("La TARDIS llegó primero a " + era);
            }
        };
    }


    public void main() {
        String[] eras = {"Roma Antigua", "Futuro Lejano", "Era Victoriana", "Año 3000"};
        Thread[] hilos = new Thread[eras.length];

        for (int i = 0; i < eras.length; i++) {
            hilos[i] = new Thread(viaje(eras[i]));
            hilos[i].start();
        }

        for (Thread t : hilos) {
            try { t.join(); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}
