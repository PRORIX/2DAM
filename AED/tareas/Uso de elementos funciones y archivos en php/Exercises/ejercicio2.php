<?php

/**
 * EJERCICIO 2: Guardar numeros en un fichero
 * @author prorix
 * @version 1.0.0
 */

numeros();

 /**
  * Metodo que crea (si no existe) un archivo numeros.txt y escribe 1..10
  * @return void resultado
  */
 function numeros () {

    if (!file_exists("../Resources/ejercicio2/numeros.txt")) {
        echo "No existe el archivo numeros.txt, creando...\n";
        echo "Archivo numeros.txt creado correctamente.\n";
    }
    $archivo = fopen("../Resources/ejercicio2/numeros.txt", "w");
    for ($i=0; $i <= 10 ; $i++) { 
        fwrite($archivo, "$i\n");
    }
    echo "Archivo escrito correctamente.";
    fclose($archivo);
    }

 

?>