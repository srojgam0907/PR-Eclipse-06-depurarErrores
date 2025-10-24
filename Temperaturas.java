package tema2_debug;
import java.util.Scanner;

/**
 * Programa con errores para practicar la depuración.
 * El programa pide una temperatura y muestra si hace frío, calor o temperatura templada.
 * Después, repite mientras el usuario quiera continuar.
 */

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

