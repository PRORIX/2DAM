<?php

/**
 * EJERCICIO 5: Copiar contenido de un fichero a otro
 * @author prorix
 * @version 1.0.0
 */

copiarArchivo();

/**
 * Función que copia el contenido de origen.txt a copia.txt
 */
function copiarArchivo() {
    $rutaArchivoOrigen = "../Resources/ejercicio5/origen.txt";
    $rutaArchivoDestino = "../Resources/ejercicio5/copia.txt";

    $archivoOrigen = fopen($rutaArchivoOrigen, "w");
    fwrite($archivoOrigen, "yo soy el original");
    $archivoDestino = fopen($rutaArchivoDestino, "w");


    copy($rutaArchivoOrigen, $rutaArchivoDestino);
    echo "Archivo copiado con exito.\n";

    fclose($archivoOrigen);
    fclose($archivoDestino);

}

?>