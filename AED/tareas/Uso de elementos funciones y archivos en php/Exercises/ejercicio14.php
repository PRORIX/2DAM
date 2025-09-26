<?php

/**
 * EJERCICIO 14: Generador de excusas divertidas
 * @author prorix
 * @version 1.0.0
 */

 leerExcusaAleatoria();

/**
 * Metodo que lee una linea aleatoria de un txt
 * @param mixed $entrada entrada
 * @return void resultado
 */
function leerExcusaAleatoria() : void {
    $rutaArchivo = "../Resources/ejercicio14/excusas.txt";

    $archivo = fopen($rutaArchivo, "r") or die("Error al abrir el archivo.");

    $lineas = file($rutaArchivo);
    $indiceAleatorio = array_rand($lineas);
    echo "Excusa aleatoria: $lineas[$indiceAleatorio]";

    fclose($archivo);
}


?>