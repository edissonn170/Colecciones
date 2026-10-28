package ejercicio4;
import java.util.Random; // Generación de matrices aleatorias.
import java.util.Scanner; // Lectura del menú.

public class Ejercicio4 {
    private static final Random AZAR = new Random(); // Generador compartido.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Inicializa entrada.
        int m = leerPositivo(sc, "Filas de la matriz A (M): "); // Define filas de A.
        int n = leerPositivo(sc, "Columnas de la matriz A (N): "); // Define columnas de A.
        int[][] a = generar(m, n); // Genera matriz A con enteros aleatorios.
        int opcion; // Guarda operación seleccionada.
        do { // Permite seleccionar varias operaciones.
            System.out.println("\n1. Sumar  2. Restar  3. Multiplicar  4. Trasponer  5. Salir"); // Presenta menú.
            opcion = leerPositivo(sc, "Opcion: "); // Lee opción.
            if (opcion >= 1 && opcion <= 4) mostrar("Matriz A", a); // Muestra primera matriz.
            switch (opcion) { // Ejecuta operación solicitada.
                case 1: case 2: { // Suma o resta de matrices de dimensiones iguales.
                    int[][] b = generar(m, n); // Genera matriz B de igual tamaño.
                    mostrar("Matriz B", b); // Muestra segundo operando.
                    int[][] resultado = new int[m][n]; // Reserva resultado.
                    for (int i = 0; i < m; i++) // Recorre filas.
                        for (int j = 0; j < n; j++) // Recorre columnas.
                            resultado[i][j] = opcion == 1 ? a[i][j] + b[i][j] : a[i][j] - b[i][j]; // Opera componentes.
                    mostrar(opcion == 1 ? "Suma" : "Resta", resultado); // Muestra resultado.
                    break; // Termina operación.
                }
                case 3: { // Multiplicación A(MxN) por B(NxP).
                    int p = leerPositivo(sc, "Columnas de la matriz B (P): "); // Solicita tercera dimensión.
                    int[][] b = generar(n, p); // Genera matriz B compatible.
                    mostrar("Matriz B", b); // Muestra segunda matriz.
                    int[][] resultado = new int[m][p]; // Reserva producto.
                    for (int i = 0; i < m; i++) // Recorre filas de A.
                        for (int j = 0; j < p; j++) // Recorre columnas de B.
                            for (int k = 0; k < n; k++) // Suma productos internos.
                                resultado[i][j] += a[i][k] * b[k][j]; // Calcula producto matricial.
                    mostrar("Producto A x B", resultado); // Imprime producto.
                    break; // Termina operación.
                }
                case 4: { // Calcula matriz transpuesta.
                    int[][] transpuesta = new int[n][m]; // Intercambia filas y columnas.
                    for (int i = 0; i < m; i++) // Recorre filas originales.
                        for (int j = 0; j < n; j++) transpuesta[j][i] = a[i][j]; // Invierte índices.
                    mostrar("Transpuesta de A", transpuesta); // Muestra transpuesta.
                    break; // Termina operación.
                }
                case 5: System.out.println("Fin del programa."); break; // Sale del menú.
                default: System.out.println("Seleccione una opcion entre 1 y 5."); // Indica opción inválida.
            }
        } while (opcion != 5); // Repite hasta salir.
        sc.close(); // Cierra entrada.
    }
    private static int leerPositivo(Scanner sc, String mensaje) { // Valida entero positivo.
        while (true) { // Repite ante errores.
            System.out.print(mensaje); // Muestra solicitud.
            if (sc.hasNextInt()) { int x = sc.nextInt(); if (x > 0) return x; } // Acepta valor positivo.
            else sc.next(); // Descarta texto inválido.
            System.out.println("Ingrese un entero positivo."); // Indica error.
        }
    }
    private static int[][] generar(int filas, int columnas) { // Construye una matriz aleatoria.
        int[][] matriz = new int[filas][columnas]; // Reserva elementos.
        for (int i = 0; i < filas; i++) // Recorre filas.
            for (int j = 0; j < columnas; j++) matriz[i][j] = AZAR.nextInt(10); // Asigna valores de 0 a 9.
        return matriz; // Devuelve matriz construida.
    }
    private static void mostrar(String titulo, int[][] matriz) { // Imprime una matriz.
        System.out.println("--- " + titulo + " ---"); // Identifica resultado.
        for (int[] fila : matriz) { // Recorre filas.
            for (int valor : fila) System.out.printf("%5d", valor); // Imprime celda alineada.
            System.out.println(); // Cambia a siguiente fila.
        }
    }
}
