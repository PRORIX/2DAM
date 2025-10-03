package org.formacion.procesos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * clase ejecutadora
 * @author prorix
 * @version 1.0.0
 */

@SpringBootApplication
public class ProcesosServiciosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcesosServiciosApplication.class, args);
    }


    /**
     * Main (ejecuta los procesos)
     * @param procesos clase con procesos a ejecutar
     * @return resultado en consola
     */
    @Bean
    CommandLineRunner demo(Procesos procesos) {

        return args -> {
            procesos.procesosFichero();
            procesos.contarLineas();
            System.out.println("Proceso finalizado.");
            
        };
    }
}