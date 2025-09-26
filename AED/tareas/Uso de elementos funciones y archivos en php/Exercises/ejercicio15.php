<?php

/**
 * EJERCICIO 15: Lista de chistes (rotativos)
 * @author prorix
 * @version 1.0.0
 */

 leerChisteAleatorio();

/**
 * Metodo que lee una linea aleatoria de un txt
 * @param mixed $entrada entrada
 * @return void resultado
 */
function leerChisteAleatorio() : void {
    $rutaArchivo = "../Resources/ejercicio15/chistes.txt";

    $archivo = fopen($rutaArchivo, "r") or die("Error al abrir el archivo.");

    $lineas = file($rutaArchivo);
    $indiceAleatorio = array_rand($lineas);
    echo "Chiste aleatorio: $lineas[$indiceAleatorio]";

    fclose($archivo);
}


?>