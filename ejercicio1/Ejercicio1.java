package ejercicio1;
import java.util.Scanner; // Permite leer datos ingresados por teclado.
import java.util.LinkedHashSet; // Conserva el orden y evita cédulas repetidas.
import java.util.Set; // Define conjuntos de cédulas.

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Abre la entrada del teclado.
        int n = leerPositivo(sc, "Cantidad de estudiantes reprobados por cada materia (N): "); // Lee el tamaño solicitado.
        String[] matematica = new String[n]; // Guarda cédulas de reprobados en Matemática.
        String[] ingles = new String[n]; // Guarda cédulas de reprobados en Inglés.
        System.out.println("--- REPROBADOS EN MATEMATICA ---"); // Identifica el primer arreglo.
        for (int i = 0; i < n; i++) { // Recorre posiciones de Matemática.
            matematica[i] = leerCedula(sc, "Cedula " + (i + 1) + ": "); // Guarda cada cédula como texto.
        }
        System.out.println("--- REPROBADOS EN INGLES ---"); // Identifica el segundo arreglo.
        for (int i = 0; i < n; i++) { // Recorre posiciones de Inglés.
            ingles[i] = leerCedula(sc, "Cedula " + (i + 1) + ": "); // Guarda cada cédula.
        }
        Set<String> conjuntoIngles = new LinkedHashSet<>(); // Crea conjunto para búsquedas rápidas.
        for (String cedula : ingles) conjuntoIngles.add(cedula); // Registra las cédulas de Inglés.
        Set<String> ambas = new LinkedHashSet<>(); // Prepara intersección sin duplicados.
        for (String cedula : matematica) { // Recorre los reprobados en Matemática.
            if (conjuntoIngles.contains(cedula)) ambas.add(cedula); // Conserva quienes reprobaron ambas.
        }
        String[] tercera = ambas.toArray(new String[0]); // Forma el tercer arreglo requerido.
        System.out.println("Matematica: " + java.util.Arrays.toString(matematica)); // Imprime primer vector.
        System.out.println("Ingles: " + java.util.Arrays.toString(ingles)); // Imprime segundo vector.
        System.out.println("Ambas materias: " + java.util.Arrays.toString(tercera)); // Imprime tercer vector.
        sc.close(); // Cierra entrada.
    }
    private static int leerPositivo(Scanner sc, String mensaje) { // Valida entero positivo.
        while (true) { // Repite hasta recibir un valor correcto.
            System.out.print(mensaje); // Muestra solicitud.
            if (sc.hasNextInt()) { // Comprueba formato entero.
                int valor = sc.nextInt(); // Lee entero.
                if (valor > 0) return valor; // Acepta tamaños mayores que cero.
            } else sc.next(); // Descarta una entrada no numérica.
            System.out.println("Ingrese un numero entero mayor que cero."); // Indica error.
        }
    }
    private static String leerCedula(Scanner sc, String mensaje) { // Lee cédula preservando ceros iniciales.
        System.out.print(mensaje); // Solicita la cédula.
        return sc.next().trim(); // Devuelve el identificador sin alterar su contenido.
    }
}
