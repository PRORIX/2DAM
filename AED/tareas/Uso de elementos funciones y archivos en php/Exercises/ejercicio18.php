<?php

/**
 * EJERCICIO 18: Encuesta de comidas favoritas
 * @author prorix
 * @version 1.0.0
 */

agregarComida();

/**
 * Metodo que agrega un elemento en una nueva linea en un archivo txt
 * @return void resultado
 */
function agregarComida() : void {
    $rutaArchivo = "../Resources/ejercicio18/comidas.txt";

    $archivo = fopen($rutaArchivo, "a") or die("Error al abrir el archivo.");

    $comida = trim(readline("Agrega una comida: "));
    fwrite($archivo, $comida . PHP_EOL) or die("Error al agregar la comida");
    echo("Comida agregada correctamente.\n");

    fclose($archivo);
}
?>