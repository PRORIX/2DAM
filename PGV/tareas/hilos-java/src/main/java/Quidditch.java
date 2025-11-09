import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase del ejercicio 9
 * @author prorix
 * @version 1.0.0
 */
public class Quidditch {

    public AtomicBoolean snitchAtrapada = new AtomicBoolean(false);
    public int puntosEquipoA = 0;
    public int puntosEquipoB = 0;
    private final Lock lock = new ReentrantLock();

    private final Runnable cazadorA = () -> {
        while (!snitchAtrapada.get()) {
            int pausa = ThreadLocalRandom.current().nextInt(200, 501);
            try { Thread.sleep(pausa); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            int g = ThreadLocalRandom.current().nextInt(0, 2) * 10;
            if (g > 0) {
                lock.lock();
                try {
                    puntosEquipoA += g;
                } finally {
                    lock.unlock();
                }
                System.out.println("Equipo A anota 10. Total A=" + puntosEquipoA);
            }
        }
    };

    private final Runnable cazadorB = () -> {
        while (!snitchAtrapada.get()) {
            int pausa = ThreadLocalRandom.current().nextInt(200, 501);
            try { Thread.sleep(pausa); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            int g = ThreadLocalRandom.current().nextInt(0, 2) * 10;
            if (g > 0) {
                lock.lock();
                try {
                    puntosEquipoB += g;
                } finally {
                    lock.unlock();
                }
                System.out.println("Equipo B anota 10. Total B=" + puntosEquipoB);
            }
        }
    };

    private final Runnable buscador = () -> {
        while (!snitchAtrapada.get()) {
            int pausa = ThreadLocalRandom.current().nextInt(300, 701);
            try { Thread.sleep(pausa); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            if (ThreadLocalRandom.current().nextInt(1, 101) <= 15) {
                snitchAtrapada.set(true);
                System.out.println("¡Snitch dorada atrapada!");
            }
        }
    };


    public void main() {
        Thread t1 = new Thread(cazadorA);
        Thread t2 = new Thread(cazadorB);
        Thread t3 = new Thread(buscador);
        t1.start(); t2.start(); t3.start();
        try { t1.join(); t2.join(); t3.join(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        System.out.println("Marcador final: A=" + puntosEquipoA + " B=" + puntosEquipoB);
    }
}
