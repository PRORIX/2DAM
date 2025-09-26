<?php

/**
 * EJERCICIO 12: Ranking de videojuegos
 * @author prorix
 * @version 1.0.0
 */

 mostrarTopTres();


/**
 * Metodo que muestra las tres pimeras lineas de un archivo txt
 * @param mixed $entrada entrada
 * @return void resultado
 */
function mostrarTopTres() : void {
    $rutaArchivo = "../Resources/ejercicio12/ranking.txt" or die("Error al abrir el archivo");


    $archivo = fopen($rutaArchivo, "r");

    for ($i = 0 ; $i <= 3 ; $i++) {
        echo fgets($archivo);
    }


    fclose($archivo);
}


?>