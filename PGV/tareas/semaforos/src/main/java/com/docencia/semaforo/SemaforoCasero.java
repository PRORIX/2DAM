package com.docencia.semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Clase del semaforo casero
 * @author prorix
 * @version 1.0.0
 */
public class SemaforoCasero implements Runnable {

    private final String color;
    private static final AtomicBoolean estaCorriendo = new AtomicBoolean(true);
    private static final Semaphore semaforo = new Semaphore(1, true);

    /**
     * Constructor vacio
     */
    public SemaforoCasero() {
        this.color = "";
    }

    /**
     * Constructor con el color
     * 
     * @param color color
     */
    public SemaforoCasero(String color) {
        this.color = color;
    }

    /**
     * Metodo que gestiona el tiempo de actualizacion de cada turno
     * 
     * @return tiempo (ms)
     */
    private int gestionarTiempoColor() {
        int tiempo = 0;

        switch (color) {
            case "Rojo":
                tiempo = 3000;
                break;

            case "Verde":
                tiempo = 3000;
                break;

            case "Ambar":
                tiempo = 1000;
                break;
        }

        return tiempo;
    }

    @Override
    public void run() {
        while (estaCorriendo.get()) {
            try {
                semaforo.acquire();

                System.out.println("Color actual: " + color);

                int tiempo = gestionarTiempoColor();
                Thread.sleep(tiempo);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaforo.release();
            }
        }
    }

    public static void main(String[] args) {
        Thread rojo = new Thread(new SemaforoCasero("Rojo"));
        Thread ambar = new Thread(new SemaforoCasero("Ambar"));
        Thread verde = new Thread(new SemaforoCasero("Verde"));

        rojo.start();
        verde.start();
        ambar.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        estaCorriendo.set(false);

    }

}
