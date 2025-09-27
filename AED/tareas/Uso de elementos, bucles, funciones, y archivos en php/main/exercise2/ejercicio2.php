<?php

/**
 * EJERCICIO 2: Estadisticas de palabras en php
 * @author prorix
 * @version 1.0.0
 */

contarPalabras();

/**
 * Metodo que cuenta las palabras por separado de un texto en un archivo txt
 * @return void
 */
function contarPalabras(){
    $rutaArchivoTexto = "texto.txt";
    $rutaArchivoSolucion = "estadisticas.csv";


    $texto = file_get_contents($rutaArchivoTexto);
    $texto = strtolower($texto);
    $palabras = str_word_count($texto, 1);

    $frecuencia = array_count_values($palabras);

    $archivoSolucion = fopen($rutaArchivoSolucion,"w");

    foreach ($frecuencia as $palabra => $cantidad) {
        fwrite($archivoSolucion,  "$palabra, $cantidad\n");
    }
    fclose($archivoSolucion);
}



?>