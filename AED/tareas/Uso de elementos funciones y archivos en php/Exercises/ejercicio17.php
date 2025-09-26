<?php

/**
 * EJERCICIO 17: Generador de nombres para superheroes
 * @author prorix
 * @version 1.0.0
 */

crearNombreSuperheroeAleatorio();

function crearNombreSuperheroeAleatorio() : void {
    $rutaArchivoAnimales = "../Resources/ejercicio17/animales.txt";
    $rutaArchivoAdjetivos = "../Resources/ejercicio17/adjetivos.txt";

    $lineasAnimales = file($rutaArchivoAnimales);
    $lineasAdjetivos = file($rutaArchivoAdjetivos);


    $posicionAnimalAleatorio = array_rand($lineasAnimales);
    $posicionAdjetivoAleatorio = array_rand($lineasAdjetivos);

    $animalAleatorio = trim($lineasAnimales[$posicionAnimalAleatorio]);
    $adjetivoAleatorio = trim($lineasAdjetivos[$posicionAdjetivoAleatorio]);

    $nombreSuperheroe = "$animalAleatorio $adjetivoAleatorio";

    echo $nombreSuperheroe;

}
?>