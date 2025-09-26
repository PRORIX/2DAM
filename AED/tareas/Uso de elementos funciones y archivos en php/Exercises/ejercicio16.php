<?php
/**
 * EJERCICIO 16: Adivina la palabra
 * @author prorix
 * @version 1.0.0
 */

adivinaLaPalabra();

/**
 * Metodo que genera una palabra aleatoria (2 primeras letras) y pide al usuario que adivine
 * @return void juego
 */
function adivinaLaPalabra() : void {
    $rutaArchivo = "../Resources/ejercicio16/palabras.txt";

    $lineas = file($rutaArchivo);

    $indiceAleatorio = array_rand($lineas);
    $palabraElegida = trim($lineas[$indiceAleatorio]);

    $arrayPalabraElegida = str_split($palabraElegida);
    
    for ($i = 2; $i < count($arrayPalabraElegida); $i++) {
    $arrayPalabraElegida[$i] = "_";
}

    $palabraMisteriosa = implode(" ", $arrayPalabraElegida);
    echo "Intenta adivinar la palabra:\n";
    echo "Pista: $palabraMisteriosa\n";

    $palabraUsuario = "";

    while (true) {
        $palabraUsuario = trim(readline("Tu intento: "));

        if (strcasecmp($palabraUsuario, $palabraElegida) == 0) {
            echo "¡Muy bien! Has acertado.\n";
            break;
        } else {
            echo "Incorrecto, vuelve a intentarlo.\n";
        }
    }
}
?>