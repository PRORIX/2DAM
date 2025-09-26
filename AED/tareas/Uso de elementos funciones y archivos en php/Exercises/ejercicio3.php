<?php

/**
 * EJERCICIO 3: Contar palabras en un fichero
 * @author prorix
 * @version 1.0.0
 */

contarPalabras();

/**
 * Metodo que escribe un archivo y cuenta las palabras que hay en el
 * @return void resultado
 */
function contarPalabras() {
    $rutaArchivo = "../Resources/ejercicio3/texto.txt";

    $archivo = fopen($rutaArchivo, "w");
    fwrite($archivo, "Hola mundo que tal");
    fclose($archivo);

    $textoArchivo = file_get_contents($rutaArchivo);
    echo "Texto del archivo: $textoArchivo\n";

    // Contar palabras
    $cantidadPalabras = str_word_count($textoArchivo);
    echo "Contador de palabras: $cantidadPalabras";
}
?>