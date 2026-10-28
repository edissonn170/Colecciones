package ejercicio5;
import java.util.Scanner; // Permite leer datos del usuario.

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Inicializa lector.
        int n = leerPositivo(sc, "Numero de articulos (N): "); // Número de artículos.
        int m = leerPositivo(sc, "Numero de sucursales (M): "); // Número de sucursales.
        double[][] precios = new double[n][m]; // Precio del artículo i en sucursal j.
        int[][] cantidades = new int[n][m]; // Unidades vendidas del artículo i en sucursal j.
        for (int i = 0; i < n; i++) { // Recorre artículos.
            for (int j = 0; j < m; j++) { // Recorre sucursales.
                System.out.println("Articulo " + (i + 1) + ", sucursal " + (j + 1)); // Identifica celda.
                precios[i][j] = leerNoNegativo(sc, "Precio unitario ($): "); // Registra precio.
                cantidades[i][j] = leerEnteroNoNegativo(sc, "Cantidad vendida: "); // Registra ventas.
            }
        }
        double[] ventasArticulos = new double[n]; // Total monetario por artículo.
        double[] ventasSucursales = new double[m]; // Total monetario por sucursal.
        for (int i = 0; i < n; i++) { // Recorre artículos.
            for (int j = 0; j < m; j++) { // Recorre sucursales.
                double venta = precios[i][j] * cantidades[i][j]; // Calcula importe de la celda.
                ventasArticulos[i] += venta; // Acumula venta monetaria del artículo.
                ventasSucursales[j] += venta; // Acumula venta monetaria de la sucursal.
            }
        }
        System.out.println("--- VENTAS TOTALES POR ARTICULO ($) ---"); // Título de salida.
        for (int i = 0; i < n; i++) System.out.printf("Articulo %d: $%.2f%n", i + 1, ventasArticulos[i]); // Imprime por artículo.
        System.out.println("--- VENTAS TOTALES POR SUCURSAL ($) ---"); // Título de salida.
        for (int j = 0; j < m; j++) System.out.printf("Sucursal %d: $%.2f%n", j + 1, ventasSucursales[j]); // Imprime por sucursal.
        sc.close(); // Cierra entrada.
    }
    private static int leerPositivo(Scanner sc, String mensaje) { // Obtiene cantidad mayor que cero.
        int numero; // Guarda valor.
        do { // Repite ante cero o negativos.
            numero = leerEnteroNoNegativo(sc, mensaje); // Obtiene entero no negativo.
        } while (numero == 0); // Exige cantidad positiva.
        return numero; // Retorna dimensión.
    }
    private static int leerEnteroNoNegativo(Scanner sc, String mensaje) { // Valida cantidad.
        while (true) { // Repite hasta recibir un entero válido.
            System.out.print(mensaje); // Muestra solicitud.
            if (sc.hasNextInt()) { int x = sc.nextInt(); if (x >= 0) return x; } // Acepta enteros >= 0.
            else sc.next(); // Descarta texto no numérico.
            System.out.println("Ingrese un entero mayor o igual a cero."); // Indica entrada inválida.
        }
    }
    private static double leerNoNegativo(Scanner sc, String mensaje) { // Valida un precio no negativo.
        while (true) { // Repite hasta obtener valor válido.
            System.out.print(mensaje); // Muestra solicitud.
            if (sc.hasNextDouble()) { double x = sc.nextDouble(); if (Double.isFinite(x) && x >= 0) return x; } // Acepta precio válido.
            else sc.next(); // Descarta entrada no numérica.
            System.out.println("Ingrese un precio valido mayor o igual a cero."); // Indica error.
        }
    }
}
