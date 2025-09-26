<?php

/**
 * EJERCICIO 8: Crear fichero de multiplicaciones
 * @author prorix
 * @version 1.0.0
 */

escribirTablaCinco();

/**
 * Metodo que escribe la tabla del 5 en un archivo y lo muestra
 * @return void resultado
 */
function escribirTablaCinco() {
    $rutaArchivo = "../Resources/ejercicio8/tabla5.txt";

    $archivo = fopen($rutaArchivo, "w");

    for ( $i = 1 ; $i <= 10 ; $i++ ){
        $resultado = 5*$i;
        $lineaCompleta = "5 * $i = $resultado\n";
        fwrite($archivo, $lineaCompleta);
    }

    echo file_get_contents($rutaArchivo);

    fclose($archivo);

}

?>