<?php

/**
 * EJERCICIO 20: Historias locas (Mad Libs)
 * @author prorix
 * @version 1.0.0
 */

crearNombreSuperheroeAleatorio();

/**
 * Metodo que genera un texto aleatorio con diferentes elementos
 * @return void
 */
function crearNombreSuperheroeAleatorio() : void {
    $rutaArchivoPlantilla = "../Resources/ejercicio20/plantilla.txt";
    $rutaArchivoAnimales = "../Resources/ejercicio20/animales.txt";
    $rutaArchivoComidas = "../Resources/ejercicio20/comidas.txt";
    $rutaArchivoLugares = "../Resources/ejercicio20/lugares.txt";

    $lineasAnimales = file($rutaArchivoAnimales);
    $lineasComidas = file($rutaArchivoComidas);
    $lineasLugares = file($rutaArchivoLugares);

    $posicionAnimalAleatorio = array_rand($lineasAnimales);
    $posicionComidaAleatoria = array_rand($lineasComidas);
    $posicionLugarAleatorio = array_rand($lineasLugares);

    $animalAleatorio = trim($lineasAnimales[$posicionAnimalAleatorio]);
    $comidaAleatoria = trim($lineasComidas[$posicionComidaAleatoria]);
    $lugarAleatorio = trim($lineasLugares[$posicionLugarAleatorio]);

    $archivoPlantilla = fopen($rutaArchivoPlantilla, "r");
    $plantilla = fread($archivoPlantilla, 100);
    $plantilla = str_replace("[animal]", $animalAleatorio, $plantilla);
    $plantilla = str_replace("[lugar]", $lugarAleatorio, $plantilla);
    $plantilla = str_replace("[comida]", $comidaAleatoria, $plantilla);

    echo $plantilla;

    fclose($archivoPlantilla);


    

}
?>