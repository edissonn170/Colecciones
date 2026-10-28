package ejercicio6;

import java.util.Scanner; // Importamos Scanner para leer datos del teclado

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Instanciamos Scanner para la entrada de datos

        System.out.print("Ingrese el numero de vendedores (N): "); // Solicitamos cantidad de vendedores
        int n = sc.nextInt(); // Leemos el numero de vendedores
        System.out.print("Ingrese el numero de anios (M): "); // Solicitamos cantidad de años
        int m = sc.nextInt(); // Leemos el numero de años
        if (n <= 0 || m <= 0) { // Evitamos dimensiones no validas.
            System.out.println("El numero de vendedores y anios debe ser mayor que cero."); // Informamos el error.
            sc.close(); // Cerramos Scanner.
            return; // Finalizamos sin ejecutar calculos invalidos.
        }

        double[][] ventas = new double[n][m]; // Declaramos la matriz de N vendedores por M años

        // Bucle anidado para llenar la matriz de ventas
        for (int i = 0; i < n; i++) { // Recorremos cada vendedor (filas)
            System.out.println("Ventas del vendedor " + (i + 1) + ":"); // Mensaje indicativo del vendedor
            for (int j = 0; j < m; j++) { // Recorremos cada año (columnas)
                System.out.print("Anio " + (j + 1) + ": "); // Solicitamos la venta de ese año
                ventas[i][j] = sc.nextDouble(); // Guardamos el valor ingresado en la matriz
            }
        }

        double totalEmpresa = 0; // Variable acumuladora para el total de ventas de toda la empresa

        System.out.println("\n--- TOTAL VENTAS POR VENDEDOR ---"); // Encabezado de resultados
        for (int i = 0; i < n; i++) { // Recorremos las filas (vendedores)
            double totalVendedor = 0; // Inicializamos el acumulador del vendedor en 0
            for (int j = 0; j < m; j++) { // Recorremos las columnas (años)
                totalVendedor += ventas[i][j]; // Sumamos la venta al total del vendedor
            }
            System.out.println("Vendedor " + (i + 1) + ": $" + totalVendedor); // Imprimimos el total del vendedor
        }

        System.out.println("\n--- TOTAL VENTAS POR ANIO ---"); // Encabezado de resultados
        for (int j = 0; j < m; j++) { // Recorremos las columnas (años) primero
            double totalAnio = 0; // Inicializamos el acumulador del año en 0
            for (int i = 0; i < n; i++) { // Recorremos las filas (vendedores)
                totalAnio += ventas[i][j]; // Sumamos la venta al total del año
                totalEmpresa += ventas[i][j]; // Aprovechamos para sumar al total global de la empresa
            }
            System.out.println("Anio " + (j + 1) + ": $" + totalAnio); // Imprimimos el total del año
        }

        // Cada celda de la matriz ya se sumó una sola vez al total empresarial.
        System.out.println("\nTotal ventas de la empresa: $" + totalEmpresa); // Muestra suma global correcta.
        sc.close(); // Cerramos el objeto Scanner para liberar memoria
    }
}