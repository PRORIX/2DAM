<?php

/**
 * EJERCICIO 1: Hola fichero
 * @author prorix
 * @version 1.0.0
 */

crearYLeer("datos.txt", "Hola Mundo desde PHP");

 /**
  * Metodo que crea un archivo con un nombre y un texto dado
  * @param mixed $nombreFichero nombre deseado para el fichero
  * @param mixed $textoFichero texto deseado para el fichero
  * @return void respuesta
  */
 function crearYLeer ($nombreFichero, $textoFichero) {

    if (file_exists("../Resources/ejercicio1/$nombreFichero")) {
        echo "Ya existe un archivo con ese nombre.";
    } else {

    $archivo = fopen("../Resources/ejercicio1/$nombreFichero", "w");
    fwrite($archivo, $textoFichero);
    fclose($archivo);
    echo "Archivo creado y escrito correctamente.";
    }

 }

?>