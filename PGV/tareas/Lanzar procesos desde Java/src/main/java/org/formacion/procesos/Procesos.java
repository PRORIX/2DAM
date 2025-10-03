package org.formacion.procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Component;

/**
 * Clase procesos de la tarea
 * @author prorix
 * @version 1.0.0
 */

@Component
public class Procesos {
    private final static String pathProcesos = "../../../../resources/mis_procesos.txt";

    /**
     * Metodo que crea un fichero para guardar los procesos
     * @return resultado
     */
    public void procesosFichero() {
        String[] comando = { "sh", "-c", "ps aux | grep java > " + pathProcesos };
        try {

            Process proceso = Runtime.getRuntime().exec(comando);
            proceso.waitFor();

        } catch (InterruptedException | IOException e) {

            e.printStackTrace();

        }
    }

    /**
     * Metodo que cuenta las lineas
     * @return resultado
     */
    public void contarLineas() {
        try {

            String[] contadorLineas = { "sh", "-c", "wc -l " + pathProcesos };
            Process procesoContar = Runtime.getRuntime().exec(contadorLineas);
            BufferedReader reader = new BufferedReader(new InputStreamReader(procesoContar.getInputStream()));
            String linea;
            int contadorDeLineas = 0;
            if ((linea = reader.readLine()) != null) {
                System.out.println("Procesos Java: " + linea.trim());
                try {
                    contadorDeLineas = Integer.parseInt(linea.trim().split("\\s+")[0]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            procesoContar.waitFor();
            if (contadorDeLineas > 3) {
                System.out.println("¡Cuidado, muchos procesos de Java activos!");
            }

        } catch (IOException | InterruptedException e) {

            e.printStackTrace();

        }

    }

}