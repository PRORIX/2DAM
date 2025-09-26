<?php

/**
 * EJERCICIO 13: Cancion aleatoria
 * @author prorix
 * @version 1.0.0
 */

 leerCancionAleatoria();

/**
 * Metodo que muestra una linea aleatoria de un archivo .txt
 * @param mixed $entrada entrada
 * @return void resultado
 */
function leerCancionAleatoria() : void {
    $rutaArchivo = "../Resources/ejercicio13/canciones.txt";

    $archivo = fopen($rutaArchivo, "r") or die("Error al abrir el archivo.");

    $lineas = file($rutaArchivo);
    $indiceAleatorio = array_rand($lineas);
    echo "Cancion aleatoria: $lineas[$indiceAleatorio]";

    fclose($archivo);
}


?>