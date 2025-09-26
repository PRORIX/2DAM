<?php

/**
 * EJERCICIO 6: Invertir el contenido de un fichero
 * @author prorix
 * @version 1.0.0
 */

invertirTexto();

/**
 * Metodo que invierte un texto de un archivo y lo envia a otro
 * @return void resultado
 */
function invertirTexto() {
    $rutaArchivoOrigen = "../Resources/ejercicio6/frase.txt";
    $rutaArchivoDestino = "../Resources/ejercicio6/frase_invertida.txt";

    $archivoOrigen = fopen($rutaArchivoOrigen, "w");
    fwrite($archivoOrigen, "Hola PHP");
    $archivoDestino = fopen($rutaArchivoDestino, "w");
    $fraseNormal = file_get_contents($rutaArchivoOrigen);
    $fraseInvertida =  strrev($fraseNormal);
    if (file_put_contents($rutaArchivoDestino, $fraseInvertida)) {
        echo "Texto invertido agregado correctamente.";
    } else {
        echo "Error al copiar el texto.";
    }


    fclose($archivoOrigen);
    fclose($archivoDestino);

}

?>