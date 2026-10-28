package ejercicio7;
import java.util.Scanner; // Importamos Scanner para lectura de datos

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos objeto Scanner
        
        System.out.print("Ingrese el numero de estudiantes (N): "); // Pedimos cantidad de estudiantes
        int n = sc.nextInt(); // Leemos N
        int numMaterias = 8; // Constante de 8 materias según el problema
        
        String[] codigos = new String[n]; // Arreglo para guardar los códigos de los estudiantes
        double[][] notas = new double[n][numMaterias]; // Matriz para guardar las notas (estudiantes x materias)
        
        // Ingreso de datos
        for (int i = 0; i < n; i++) { // Bucle para cada estudiante
            System.out.print("Codigo del estudiante " + (i+1) + ": "); // Pedimos el código
            codigos[i] = sc.next(); // Guardamos el código
            for (int j = 0; j < numMaterias; j++) { // Bucle para las 8 materias
                System.out.print("Nota materia " + (j+1) + " (0-10): "); // Pedimos la nota
                double nota; // Valor de la calificacion ingresada.
                do { // Repetimos si la nota esta fuera de 0 a 10.
                    nota = sc.nextDouble(); // Leemos la calificacion.
                    if (nota < 0 || nota > 10 || !Double.isFinite(nota)) { // Verificamos el rango solicitado.
                        System.out.print("Nota invalida. Ingrese una nota entre 0 y 10: "); // Solicitamos corregirla.
                    }
                } while (nota < 0 || nota > 10 || !Double.isFinite(nota)); // Solo se permiten notas validas.
                notas[i][j] = nota; // Guardamos la nota valida en la matriz
            }
        }
        
        double mayorPromedio = -1; // Variable para buscar el estudiante con mejor promedio
        String mejorEstudiante = ""; // Variable para guardar el código del mejor estudiante
        
        System.out.println("\n--- PROMEDIO POR ESTUDIANTE ---"); // Encabezado
        for (int i = 0; i < n; i++) { // Bucle de estudiantes
            double sumaNotas = 0; // Acumulador de notas del estudiante
            for (int j = 0; j < numMaterias; j++) { // Bucle de materias
                sumaNotas += notas[i][j]; // Sumamos la nota
            }
            double promedio = sumaNotas / numMaterias; // Calculamos el promedio
            System.out.println("Estudiante " + codigos[i] + ": " + promedio); // Mostramos el promedio
            
            if (promedio > mayorPromedio) { // Verificamos si es el mayor promedio hasta ahora
                mayorPromedio = promedio; // Actualizamos el mayor promedio
                mejorEstudiante = codigos[i]; // Actualizamos el código del mejor
            }
        }
        
        System.out.println("\nEstudiante con mayor promedio: " + mejorEstudiante + " (" + mayorPromedio + ")");
        
        System.out.println("\n--- ESTADISTICAS POR MATERIA ---"); // Encabezado de materias
        for (int j = 0; j < numMaterias; j++) { // Recorremos por materia (columnas)
            double sumaMateria = 0; // Acumulador para promedio de la materia
            int aprobados = 0; // Contador de aprobados
            int reprobados = 0; // Contador de reprobados
            
            for (int i = 0; i < n; i++) { // Recorremos por estudiante (filas)
                double nota = notas[i][j]; // Extraemos la nota actual
                sumaMateria += nota; // Sumamos para el promedio de la materia
                if (nota >= 7) aprobados++; // Si es >= 7, aumentamos contador aprobados
                else reprobados++; // Si es < 7, aumentamos contador reprobados
            }
            
            System.out.println("Materia " + (j+1) + " -> Promedio: " + (sumaMateria/n) + 
                               " | Aprobados: " + aprobados + " | Reprobados: " + reprobados); // Imprimimos datos
        }
        sc.close(); // Cerramos Scanner
    }
}