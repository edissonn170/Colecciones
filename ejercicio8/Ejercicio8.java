package ejercicio8;
import java.util.Scanner; // Importar Scanner

// Clase que representa el registro del trabajador
class Trabajador {
    String codigo; // Variable para el código
    int horasAusencia; // Variable para horas de ausencia
    int pupitresDefectuosos; // Variable para pupitres defectuosos
    int pupitresProducidos; // Variable para pupitres producidos
    int gradoEficiencia; // Variable para almacenar el grado final
}

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Iniciamos Scanner
        System.out.print("Ingrese cantidad de operarios (N): "); // Pedimos N
        int n = sc.nextInt(); // Leemos N
        if (n <= 0) { // Comprobamos el numero de trabajadores.
            System.out.println("La cantidad de operarios debe ser mayor que cero."); // Informamos el error.
            sc.close(); // Cerramos Scanner.
            return; // Terminamos ante un tamano incorrecto.
        }
        
        Trabajador[] trabajadores = new Trabajador[n]; // Arreglo de objetos Trabajador
        
        for (int i = 0; i < n; i++) { // Recorremos para llenar datos
            trabajadores[i] = new Trabajador(); // Instanciamos un nuevo trabajador
            System.out.println("\n--- Datos del operario " + (i+1) + " ---"); // Encabezado
            System.out.print("Codigo: "); // Pedimos código
            trabajadores[i].codigo = sc.next(); // Guardamos código
            System.out.print("Horas de ausencia: "); // Pedimos ausencias
            trabajadores[i].horasAusencia = sc.nextInt(); // Guardamos ausencias
            System.out.print("Pupitres defectuosos: "); // Pedimos defectuosos
            trabajadores[i].pupitresDefectuosos = sc.nextInt(); // Guardamos defectuosos
            System.out.print("Pupitres producidos: "); // Pedimos producidos
            trabajadores[i].pupitresProducidos = sc.nextInt(); // Guardamos producidos
            if (trabajadores[i].horasAusencia < 0 || trabajadores[i].pupitresDefectuosos < 0 || trabajadores[i].pupitresProducidos < 0) { // Verificamos valores no negativos.
                System.out.println("Los valores no pueden ser negativos. Ingrese nuevamente este trabajador."); // Informamos el error.
                i--; // Repetimos el registro actual.
                continue; // Evitamos calcular grados con datos invalidos.
            }
            
            // Evaluamos las 3 condiciones devolviendo booleanos
            boolean c1 = trabajadores[i].horasAusencia <= 3; // Condición 1
            boolean c2 = trabajadores[i].pupitresDefectuosos < 300; // Condición 2
            boolean c3 = trabajadores[i].pupitresProducidos > 10000; // Condición 3
            
            // Asignación de grado basada en las condiciones
            if (c1 && c2 && c3) trabajadores[i].gradoEficiencia = 20; // Cumple las 3
            else if (c2 && c3) trabajadores[i].gradoEficiencia = 15; // Cumple 2 y 3
            else if (c1 && c3) trabajadores[i].gradoEficiencia = 13; // Cumple 1 y 3
            else if (c1 && c2) trabajadores[i].gradoEficiencia = 12; // Cumple 1 y 2
            else if (c3) trabajadores[i].gradoEficiencia = 9; // Cumple solo 3
            else if (c2) trabajadores[i].gradoEficiencia = 8; // Cumple solo 2
            else if (c1) trabajadores[i].gradoEficiencia = 7; // Cumple solo 1
            else trabajadores[i].gradoEficiencia = 5; // No cumple ninguna
        }
        
        System.out.println("\n--- REPORTE DE EFICIENCIA ---"); // Encabezado reporte
        for (int i = 0; i < n; i++) { // Bucle para imprimir cada trabajador
            System.out.println("Codigo: " + trabajadores[i].codigo + // Imprimimos código
                               " | Ausencias: " + trabajadores[i].horasAusencia + // Imprimimos ausencias
                               " | Defectuosos: " + trabajadores[i].pupitresDefectuosos + // Imprimimos defectuosos
                               " | Producidos: " + trabajadores[i].pupitresProducidos + // Imprimimos producidos
                               " | GRADO ASIGNADO: " + trabajadores[i].gradoEficiencia); // Imprimimos grado
        }
        sc.close(); // Cerramos Scanner
    }
}