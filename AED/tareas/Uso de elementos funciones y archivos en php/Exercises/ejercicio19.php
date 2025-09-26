<?php

/**
 * EJERCICIO 11: Diario personal secreto
 * @author prorix
 * @version 1.0.0
 */

$entrada = "Dioooooooooooooos";

escribirEntrada($entrada);
leerEntradas();


/**
 * Metodo que guarda entradas de diario a un fichero
 * @param mixed $entrada entrada
 * @return void resultado
 */
function escribirEntrada($entrada) : void {
    $rutaArchivo = "../Resources/ejercicio19/tweets.txt";

    $archivo = fopen($rutaArchivo, "a");


    $fechaHoraActual = date('[Y-m-d H:i]');
    $entradaConFecha = "$fechaHoraActual $entrada";

    fwrite($archivo, "$entradaConFecha\n");
    fclose($archivo);
}

/**
 * Metodo que muestra las entradas de un archivo
 * @return void resultado
 */
function leerEntradas() {
    $rutaArchivo = "../Resources/ejercicio19/tweets.txt";
    $archivo = fopen($rutaArchivo, "r");

    $lineas = file($rutaArchivo
);

    $ultimasCincoEntradas = array_slice($lineas, -5);

    foreach($ultimasCincoEntradas as $linea) {
        echo "$linea \n";
    }


}

?>