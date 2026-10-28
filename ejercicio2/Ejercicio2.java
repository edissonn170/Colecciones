package ejercicio2;
import java.util.Arrays; // Permite imprimir vectores.
import java.util.Random; // Permite generar números aleatorios.
import java.util.Scanner; // Permite leer por teclado.

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Prepara entrada.
        Random azar = new Random(); // Crea generador de números aleatorios.
        int[] original = new int[20]; // Reserva 20 enteros.
        for (int i = 0; i < original.length; i++) original[i] = azar.nextInt(51); // Genera enteros de 0 a 50.
        System.out.println("Vector original: " + Arrays.toString(original)); // Muestra números generados.
        System.out.print("Numero entero a buscar: "); // Solicita valor buscado.
        while (!sc.hasNextInt()) { // Valida entrada.
            sc.next(); // Descarta texto inválido.
            System.out.print("Ingrese un entero: "); // Solicita nuevamente.
        }
        int buscado = sc.nextInt(); // Lee valor válido.
        boolean encontrado = false; // Marca si se halló alguna coincidencia.
        for (int i = 0; i < original.length; i++) { // Examina todas las posiciones.
            if (original[i] == buscado) { // Comprueba coincidencia.
                System.out.println("Encontrado en indice " + i + " (posicion " + (i + 1) + ")"); // Indica posición.
                encontrado = true; // Registra resultado.
            }
        }
        if (!encontrado) System.out.println("Numero no encontrado."); // Reporta ausencia.
        int[] impares = new int[10]; // Contiene elementos de índices 1,3,...,19.
        for (int i = 1, j = 0; i < original.length; i += 2, j++) impares[j] = original[i]; // Copia índices impares.
        System.out.println("Vector indices impares: " + Arrays.toString(impares)); // Muestra segundo vector.
        int mayores = 0; // Cuenta valores superiores a 20.
        for (int valor : impares) if (valor > 20) mayores++; // Cuenta solo valores > 20.
        System.out.println("Elementos mayores a 20 en segundo vector: " + mayores); // Reporta conteo.
        sc.close(); // Cierra entrada.
    }
}
