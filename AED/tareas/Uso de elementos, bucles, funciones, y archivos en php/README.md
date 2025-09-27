# ACCESO A DATOS

Uso de elementos, bucles, funciones, y archivos en php
Romén G. (PRORIX)

---

## Ejercicio 1

**Operaciones con numeros naturales en php**

**Código PHP:**

```php
<?php

/**
 * EJERCICIO 1: Operaciones con numeros naturales en php
 * @author prorix
 * @version 1.0.0
 */

realizarOperaciones();

/**
 * Metodo que realiza las operaciones de un archivo y genera otro archivo resultado
 * @return void
 */
function realizarOperaciones() {
    $rutaArchivoOperaciones = "ops.csv";
    $rutaDestino = "resultado.csv";

    $archivoOperaciones = fopen($rutaArchivoOperaciones,"r") or die("Ha ocurrido un error abriendo el archivo.");

    $archivoDestino = fopen($rutaDestino,"w") or die("Ha ocurrido un error al abrir el archivo de destino");
    fwrite($archivoDestino, "z1,z2,op,resultado\n");
    fgetcsv($archivoOperaciones);


    while(($datos = fgetcsv($archivoOperaciones,1000,",")) !== FALSE) {
        $numero1 = $datos[0];
        $numero2 = $datos[1];
        $operacion = $datos[2];

        $resultado = realizarOperacion($numero1,$numero2,$operacion);

        fwrite($archivoDestino, "$numero1,$numero2,$operacion,$resultado\n");
        
}
fclose($archivoOperaciones);
fclose($archivoDestino);
}

/**
 * Metodo que opera dos numeros con una operacion dada
 * @param mixed $numero1 primer numero de la operacion
 * @param mixed $numero2 segundo numero de la operacion
 * @param mixed $operacion operacion deseada por hacer
 */
function realizarOperacion ($numero1, $numero2, $operacion) {
    switch ($operacion) {
        case "suma":
            return $numero1 + $numero2;
        case "resta":
            return $numero1 - $numero2;
        case "producto":
            return $numero1 * $numero2;
        case "division":
            if ($numero2 == 0) {
                return "ERROR";
            } else {
                return $numero1 / $numero2;
            }
    }
}



?>
```


## Ejercicio 2

**Estadisticas de palabras en php**

**Código PHP:**

```php
<?php

/**
 * EJERCICIO 2: Estadisticas de palabras en php
 * @author prorix
 * @version 1.0.0
 */

contarPalabras();

/**
 * Metodo que cuenta las palabras por separado de un texto en un archivo txt
 * @return void
 */
function contarPalabras(){
    $rutaArchivoTexto = "texto.txt";
    $rutaArchivoSolucion = "estadisticas.csv";


    $texto = file_get_contents($rutaArchivoTexto);
    $texto = strtolower($texto);
    $palabras = str_word_count($texto, 1);

    $frecuencia = array_count_values($palabras);

    $archivoSolucion = fopen($rutaArchivoSolucion,"w");

    foreach ($frecuencia as $palabra => $cantidad) {
        fwrite($archivoSolucion,  "$palabra, $cantidad\n");
    }
    fclose($archivoSolucion);
}



?>
```
