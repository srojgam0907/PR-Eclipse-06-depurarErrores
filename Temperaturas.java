package tema2_debug;
import java.util.Scanner;

/**
 * Programa con errores para practicar la depuración.
 * El programa pide una temperatura y muestra si hace frío, calor o temperatura templada.
 * Después, repite mientras el usuario quiera continuar.
 */

//RESPUESTA AL APARTADO 2 Que ocurre y como solucionarlo
/*En la función pedirTemperatura el codigo nunca va a entrar en el if y nunca se va a repetir el bucle 
 *por que el operador logico que usa es un && (AND) y un valor no puede ser a la vez menor que -10 y mayor que 50.
 *Lo he arreglado cambiando el operador lógico por un || (OR) 
 *
 *En el main, en el bucle while, el if comprueba si la respuesta del usuario es n o N para tener en cuenta la mayuscula y 
 *aun así aunque escribas una n por teclado no entra en el if y no termina el programa por que esta comparando dos strings 
 *con el operador == y este solo comparar la referencia a la que apunta en memoria. Hay que hacerlo con .equals para que 
 *compare el contenido en sí de la variable. En este caso he usado .equalsIgnoreCase para no poner dos veces lo mismo y que 
 *no importe si es mayúscula o minúscula.
 **/

//RESPUESTA AL APARTADO 3 ¿Piensas que la documentación de un programa es necesaria?
/*Aunque sea una parte aburrida de programar, la documentación es necesaria para entender
 *lo que hace el código y cómo funciona, sobretodo cuando no lo has escrito tú. También es
 *muy importante para mejorar la legibilidad y que si un programador quiere mirar un código
 *sepa qué hace de forma rápida leyendo los comentarios.*/

public class Temperaturas {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        mostrarMensajeBienvenida(); //SRG20252410: he añadido el punto y coma

        boolean continuar = true;

        while (continuar) { //SRG20252410: lo he cambiado de false a continuar para que pueda entrar en el bucle 
            double temperatura = pedirTemperatura(sc); //SRG20252410: he añadido el punto y coma
            mostrarResultado(temperatura); //SRG20252410: he añadido el punto y coma

            System.out.print("¿Desea introducir otra temperatura? (s/n): ");
            String respuesta = sc.next();

            //SRG20252410: he arreglado un error de ejecucion con .equalsIgnoreCase
             if (respuesta.equalsIgnoreCase("n")) { //SRG20252410: he añadido las llaves
            	continuar = false; 
            }     
        }

        sc.close(); //SRG20252410: he añadido el punto y coma
        System.out.println("Programa finalizado."); //SRG20252410: he cambiado un cierre de bloque de comentario por el punto y coma
    }

    public static void mostrarMensajeBienvenida() { 
        System.out.println("Bienvenido al analizador de temperaturas."); //SRG20252410: he añadido el punto y coma
        System.out.println("Este programa indica si hace frío, calor o está templado."); //SRG20252410: he añadido el punto y coma
    }

    public static double pedirTemperatura(Scanner sc) {
        double t;
        
        //SRG20252410: he cambiado los operados && por || para que entre en el if y para que pueda quedarse en el bucle
        do {
            System.out.print("Introduce la temperatura en grados: ");
            t = sc.nextDouble();
            
            if (t < -10 || t > 50) {
                System.out.println("Temperatura fuera del rango permitido (-10 a 50)."); //SRG20252410: he añadido el punto y coma
            }
            
        } while (t < -10 || t > 50);
        
        return t;
    }

    public static void mostrarResultado(double temperatura) {
    	//He añadido las laves y los punto y coma al final de las lineas 
    	
        if (temperatura < 15) {
        	System.out.println("Hace frío.");
        	
        }else if (temperatura >= 15 && temperatura < 30) {
        	System.out.println("Temperatura templada.");
        	
        }else if (temperatura >= 30) {
        	System.out.println("¡Hace mucho calor!");
        	
        }else {
        	System.out.println("Valor no reconocido.");
        }
    }
}
