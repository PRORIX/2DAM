import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase del ejercicio 1
 * @author prorix
 * @version 1.0.0
 */
public class BatallaMagos {

    public int energiaGandalf = 120;
    public int energiaSaruman = 120;
    public AtomicBoolean combateTerminado = new AtomicBoolean(false);
    private final Lock lock = new ReentrantLock();

    /**
     * Metodo que calcula el efecto del hechizo y comprueba la victoria.
     * @param atacante nombre del mago que ataca
     * @param esGandalf indica si el atacante es Gandalf
     */
    private void lanzarHechizo(String atacante, boolean esGandalf) {
        if (combateTerminado.get()) {
            return;
        }
        int daño = ThreadLocalRandom.current().nextInt(8, 26);

        if (esGandalf) {
            energiaSaruman -= daño;
            System.out.println(atacante + " lanza hechizo por " + daño + ". Energía rival: " + energiaSaruman);
            if (energiaSaruman <= 0 && combateTerminado.compareAndSet(false, true)) {
                System.out.println(atacante + " gana la batalla mágica.");
            }
        } else {
            energiaGandalf -= daño;
            System.out.println(atacante + " lanza hechizo por " + daño + ". Energía rival: " + energiaGandalf);
            if (energiaGandalf <= 0 && combateTerminado.compareAndSet(false, true)) {
                System.out.println(atacante + " gana la batalla mágica.");
            }
        }
    }

    private final Runnable gandalf = () -> {
        while (!combateTerminado.get()) {
            lock.lock();
            try {
                boolean puedeAtacar = !combateTerminado.get();
                if (puedeAtacar) {
                    lanzarHechizo("Gandalf", true);
                }
            } finally { lock.unlock(); }
            try { Thread.sleep(ThreadLocalRandom.current().nextInt(200, 601)); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    };

    private final Runnable saruman = () -> {
        while (!combateTerminado.get()) {
            lock.lock();
            try {
                boolean puedeAtacar = !combateTerminado.get();
                if (puedeAtacar) {
                    lanzarHechizo("Saruman", false);
                }
            } finally { lock.unlock(); }
            try { Thread.sleep(ThreadLocalRandom.current().nextInt(200, 601)); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    };

    public void main() {
        Thread t1 = new Thread(gandalf);
        Thread t2 = new Thread(saruman);
        t1.start(); t2.start();
        try { t1.join(); t2.join(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
