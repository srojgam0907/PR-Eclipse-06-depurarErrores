# PR-Eclipse-06-depurarErrores

## APARTADO 2: 
## Depura y soluciona los errores de ejecución... Muéstrame un pantallazo de al menos un error que puedas encontrar depurando y explícame mediante el contenido de las vistas que estaba ocurriendo y cómo lo has solucionado.

En la función pedirTemperatura el codigo nunca va a entrar en el if y nunca se va a repetir el bucle si el número introducido es incorrecto por que el operador logico que usa es un && (AND) y un valor no puede ser a la vez menor que -10 y mayor que 50. Lo he arreglado cambiando el operador lógico por un || (OR).

Vista de las variables mientras hacia el debug



 *En el main, en el bucle while, el if comprueba si la respuesta del usuario es n o N para tener en cuenta la mayuscula y 
 *aun así aunque escribas una n por teclado no entra en el if y no termina el programa por que esta comparando dos strings 
 *con el operador == y este solo comparar la referencia a la que apunta en memoria. Hay que hacerlo con .equals para que 
 *compare el contenido en sí de la variable. En este caso he usado .equalsIgnoreCase para no poner dos veces lo mismo y que 
 *no importe si es mayúscula o minúscula.
