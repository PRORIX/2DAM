<?php

/**
 * EJERCICIO 10: Leer JSON desde fichero
 * @author prorix
 * @version 1.0.0
 */

leerDatosJson();

/**
 * Metodo que lee un archivo Json y muestra la informacion
 * @return void resultado
 */
function leerDatosJson() {
    $rutaArchivo = "../Resources/ejercicio10/datos.json";

    $archivo = fopen($rutaArchivo, "r");

    $datosJson = file_get_contents($rutaArchivo);

    $datosJsonFormateados = json_decode($datosJson);

    print_r(value: $datosJsonFormateados);

    fclose($archivo);

}

?>