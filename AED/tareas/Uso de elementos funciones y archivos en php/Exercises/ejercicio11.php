<?php

/**
 * EJERCICIO 11: Diario personal secreto
 * @author prorix
 * @version 1.0.0
 */

$entrada1 = "He comido arroz.";
$entrada2 = "He comido pizza.";

escribirEntrada($entrada1);
sleep(5);
escribirEntrada($entrada2);
leerEntradas();

/**
 * Metodo que guarda entradas de diario a un fichero
 * @param mixed $entrada entrada
 * @return void resultado
 */
function escribirEntrada($entrada) : void {
    $rutaArchivo = "../Resources/ejercicio11/diario.txt";

    $archivo = fopen($rutaArchivo, "a");


    $fechaHoraActual = date('[Y-m-d H:i:s]');
    $entradaConFecha = "$fechaHoraActual $entrada";

    fwrite($archivo, "$entradaConFecha\n");
    fclose($archivo);
}

/**
 * Metodo que muestra las entradas de un archivo
 * @return void resultado
 */
function leerEntradas() {
    $rutaArchivo = "../Resources/ejercicio11/diario.txt";

    if (!file_exists($rutaArchivo)) {
        echo "El archivo no existe.";
        return;
    }

    $resultado = file_get_contents($rutaArchivo);
    echo $resultado;
}

?>