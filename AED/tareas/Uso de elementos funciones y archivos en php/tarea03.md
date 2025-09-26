# 📘 Tarea de PHP - Manejo de Ficheros

**Autor:** PRORIX  
**Curso:** 2º DAM  
**Fecha:** 26.09.2025

---

---

## Ejercicio 1: Hola fichero

**Archivo:** `ejercicio1.php`


```php
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
```


---

## Ejercicio 2: Guardar numeros en un fichero

**Archivo:** `ejercicio2.php`


```php
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
```


---

## Ejercicio 3: Contar palabras en un fichero

**Archivo:** `ejercicio3.php`


```php
<?php

/**
 * EJERCICIO 3: Contar palabras en un fichero
 * @author prorix
 * @version 1.0.0
 */

contarPalabras();

/**
 * Metodo que escribe un archivo y cuenta las palabras que hay en el
 * @return void resultado
 */
function contarPalabras() {
    $rutaArchivo = "../Resources/ejercicio3/texto.txt";

    $archivo = fopen($rutaArchivo, "w");
    fwrite($archivo, "Hola mundo que tal");
    fclose($archivo);

    $textoArchivo = file_get_contents($rutaArchivo);
    echo "Texto del archivo: $textoArchivo\n";

    // Contar palabras
    $cantidadPalabras = str_word_count($textoArchivo);
    echo "Contador de palabras: $cantidadPalabras";
}
?>
```


---

## Ejercicio 4: Escribir y leer array en fichero

**Archivo:** `ejercicio4.php`


```php
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
```


---

## Ejercicio 5: Copiar contenido de un fichero a otro

**Archivo:** `ejercicio5.php`


```php
<?php

/**
 * EJERCICIO 5: Copiar contenido de un fichero a otro
 * @author prorix
 * @version 1.0.0
 */

copiarArchivo();

/**
 * Función que copia el contenido de origen.txt a copia.txt
 */
function copiarArchivo() {
    $rutaArchivoOrigen = "../Resources/ejercicio5/origen.txt";
    $rutaArchivoDestino = "../Resources/ejercicio5/copia.txt";

    $archivoOrigen = fopen($rutaArchivoOrigen, "w");
    fwrite($archivoOrigen, "yo soy el original");
    $archivoDestino = fopen($rutaArchivoDestino, "w");


    copy($rutaArchivoOrigen, $rutaArchivoDestino);
    echo "Archivo copiado con exito.\n";

    fclose($archivoOrigen);
    fclose($archivoDestino);

}

?>
```


---

## Ejercicio 6: Invertir el contenido de un fichero

**Archivo:** `ejercicio6.php`


```php
<?php

/**
 * EJERCICIO 6: Invertir el contenido de un fichero
 * @author prorix
 * @version 1.0.0
 */

invertirTexto();

/**
 * Metodo que invierte un texto de un archivo y lo envia a otro
 * @return void resultado
 */
function invertirTexto() {
    $rutaArchivoOrigen = "../Resources/ejercicio6/frase.txt";
    $rutaArchivoDestino = "../Resources/ejercicio6/frase_invertida.txt";

    $archivoOrigen = fopen($rutaArchivoOrigen, "w");
    fwrite($archivoOrigen, "Hola PHP");
    $archivoDestino = fopen($rutaArchivoDestino, "w");
    $fraseNormal = file_get_contents($rutaArchivoOrigen);
    $fraseInvertida =  strrev($fraseNormal);
    if (file_put_contents($rutaArchivoDestino, $fraseInvertida)) {
        echo "Texto invertido agregado correctamente.";
    } else {
        echo "Error al copiar el texto.";
    }


    fclose($archivoOrigen);
    fclose($archivoDestino);

}

?>
```


---

## Ejercicio 7: Calcular la suma desde fichero

**Archivo:** `ejercicio7.php`


```php
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
```


---

## Ejercicio 8: Crear fichero de multiplicaciones

**Archivo:** `ejercicio8.php`


```php
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
```


---

## Ejercicio 9: Registrar entradas de usuario

**Archivo:** `ejercicio9.php`


```php
<?php

/**
 * EJERCICIO 9: Registrar entradas de usuario
 * @author prorix
 * @version 1.0.0
 */

escribirTablaCinco();

/**
 * Metodo que registra las entradas de un usuario de un formulario
 * @return void resultado
 */
function escribirTablaCinco() {

    // TODO
    
}

?>
```


---

## Ejercicio 10: Leer JSON desde fichero

**Archivo:** `ejercicio10.php`


```php
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
```


---

## Ejercicio 11: Diario personal secreto

**Archivo:** `ejercicio11.php`


```php
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
```


---

## Ejercicio 12: Ranking de videojuegos

**Archivo:** `ejercicio12.php`


```php
<?php

/**
 * EJERCICIO 12: Ranking de videojuegos
 * @author prorix
 * @version 1.0.0
 */

 mostrarTopTres();


/**
 * Metodo que muestra las tres pimeras lineas de un archivo txt
 * @param mixed $entrada entrada
 * @return void resultado
 */
function mostrarTopTres() : void {
    $rutaArchivo = "../Resources/ejercicio12/ranking.txt" or die("Error al abrir el archivo");


    $archivo = fopen($rutaArchivo, "r");

    for ($i = 0 ; $i <= 3 ; $i++) {
        echo fgets($archivo);
    }


    fclose($archivo);
}


?>
```


---

## Ejercicio 13: Cancion aleatoria

**Archivo:** `ejercicio13.php`


```php
<?php

/**
 * EJERCICIO 13: Cancion aleatoria
 * @author prorix
 * @version 1.0.0
 */

 leerCancionAleatoria();

/**
 * Metodo que muestra una linea aleatoria de un archivo .txt
 * @param mixed $entrada entrada
 * @return void resultado
 */
function leerCancionAleatoria() : void {
    $rutaArchivo = "../Resources/ejercicio13/canciones.txt";

    $archivo = fopen($rutaArchivo, "r") or die("Error al abrir el archivo.");

    $lineas = file($rutaArchivo);
    $indiceAleatorio = array_rand($lineas);
    echo "Cancion aleatoria: $lineas[$indiceAleatorio]";

    fclose($archivo);
}


?>
```


---

## Ejercicio 14: Generador de excusas divertidas

**Archivo:** `ejercicio14.php`


```php
<?php

/**
 * EJERCICIO 14: Generador de excusas divertidas
 * @author prorix
 * @version 1.0.0
 */

 leerExcusaAleatoria();

/**
 * Metodo que lee una linea aleatoria de un txt
 * @param mixed $entrada entrada
 * @return void resultado
 */
function leerExcusaAleatoria() : void {
    $rutaArchivo = "../Resources/ejercicio14/excusas.txt";

    $archivo = fopen($rutaArchivo, "r") or die("Error al abrir el archivo.");

    $lineas = file($rutaArchivo);
    $indiceAleatorio = array_rand($lineas);
    echo "Excusa aleatoria: $lineas[$indiceAleatorio]";

    fclose($archivo);
}


?>
```


---

## Ejercicio 15: Lista de chistes (rotativos)

**Archivo:** `ejercicio15.php`


```php
<?php

/**
 * EJERCICIO 15: Lista de chistes (rotativos)
 * @author prorix
 * @version 1.0.0
 */

 leerChisteAleatorio();

/**
 * Metodo que lee una linea aleatoria de un txt
 * @param mixed $entrada entrada
 * @return void resultado
 */
function leerChisteAleatorio() : void {
    $rutaArchivo = "../Resources/ejercicio15/chistes.txt";

    $archivo = fopen($rutaArchivo, "r") or die("Error al abrir el archivo.");

    $lineas = file($rutaArchivo);
    $indiceAleatorio = array_rand($lineas);
    echo "Chiste aleatorio: $lineas[$indiceAleatorio]";

    fclose($archivo);
}


?>
```


---

## Ejercicio 16: Adivina la palabra

**Archivo:** `ejercicio16.php`


```php
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
```


---

## Ejercicio 17: Generador de nombres para superheroes

**Archivo:** `ejercicio17.php`


```php
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
```


---

## Ejercicio 18: Encuesta de comidas favoritas

**Archivo:** `ejercicio18.php`


```php
<?php

/**
 * EJERCICIO 18: Encuesta de comidas favoritas
 * @author prorix
 * @version 1.0.0
 */

agregarComida();

/**
 * Metodo que agrega un elemento en una nueva linea en un archivo txt
 * @return void resultado
 */
function agregarComida() : void {
    $rutaArchivo = "../Resources/ejercicio18/comidas.txt";

    $archivo = fopen($rutaArchivo, "a") or die("Error al abrir el archivo.");

    $comida = trim(readline("Agrega una comida: "));
    fwrite($archivo, $comida . PHP_EOL) or die("Error al agregar la comida");
    echo("Comida agregada correctamente.\n");

    fclose($archivo);
}
?>
```


---

## Ejercicio 19: Twitter

**Archivo:** `ejercicio19.php`


```php
<?php

/**
 * EJERCICIO 11: Diario personal secreto
 * @author prorix
 * @version 1.0.0
 */

$entrada = "Dioooooooooooooos";

escribirEntrada($entrada);
leerEntradas();


/**
 * Metodo que guarda entradas de diario a un fichero
 * @param mixed $entrada entrada
 * @return void resultado
 */
function escribirEntrada($entrada) : void {
    $rutaArchivo = "../Resources/ejercicio19/tweets.txt";

    $archivo = fopen($rutaArchivo, "a");


    $fechaHoraActual = date('[Y-m-d H:i]');
    $entradaConFecha = "$fechaHoraActual $entrada";

    fwrite($archivo, "$entradaConFecha\n");
    fclose($archivo);
}

/**
 * Metodo que muestra las entradas de un archivo
 * @return void resultado
 */
function leerEntradas() {
    $rutaArchivo = "../Resources/ejercicio19/tweets.txt";
    $archivo = fopen($rutaArchivo, "r");

    $lineas = file($rutaArchivo
);

    $ultimasCincoEntradas = array_slice($lineas, -5);

    foreach($ultimasCincoEntradas as $linea) {
        echo "$linea \n";
    }


}

?>
```


---

## Ejercicio 20: Historias locas (Mad Libs)

**Archivo:** `ejercicio20.php`


```php
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
```
