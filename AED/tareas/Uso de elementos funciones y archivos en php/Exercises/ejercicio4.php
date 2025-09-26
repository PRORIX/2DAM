<?php

/**
 * EJERCICIO 4: Escribir y leer array en fichero
 * @author prorix
 * @version 1.0.0
 */

crearYLeerArray();

/**
 * Metodo que crea y lee un array dentro de un fichero
 * @return void resultado
 */
function crearYLeerArray() {
    $rutaArchivo = "../Resources/ejercicio4/nombres.txt";

    $archivo = fopen($rutaArchivo, "w");
    $arrayNombres = ["Romen", "Carla", "Marcos"];

    for($i = 0 ; $i <= sizeof($arrayNombres) ; $i++){
    fwrite($archivo, "$arrayNombres[$i] \n");
    }

    fclose($archivo);

    $textoArchivo = file_get_contents($rutaArchivo);
    echo "Nombres dentro del archivo:\n$textoArchivo\n";

}
?>