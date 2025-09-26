<?php

/**
 * EJERCICIO 7: Calcular la suma desde fichero
 * @author prorix
 * @version 1.0.0
 */

sumarNumerosArchivo();

/**
 * Metodo que suma los numeros de un archivo
 * @return void resultado
 */
function sumarNumerosArchivo() {
    $rutaArchivo = "../Resources/ejercicio7/datos_numericos.txt";

    $archivo = fopen($rutaArchivo, "w");
    fwrite($archivo, "10,20,30,40");

    $numeros = file_get_contents($rutaArchivo);
    $arrayNumeros = explode(",",$numeros);
    $resultadoSuma = array_sum($arrayNumeros);

    echo "la suma de los numeros del archivo: $numeros es igual a $resultadoSuma";

    fclose($archivo);

}

?>