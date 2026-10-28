package ejercicio3;
import java.util.Scanner; // Habilita lectura por teclado.

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Prepara entrada.
        int n; // Almacena cantidad de empleados.
        do { // Repite lectura para evitar cantidades inválidas.
            System.out.print("Cantidad de empleados (N > 0): "); // Solicita tamaño.
            while (!sc.hasNextInt()) { sc.next(); System.out.print("Ingrese un numero entero: "); } // Descarta texto.
            n = sc.nextInt(); // Obtiene cantidad.
        } while (n <= 0); // Exige al menos un empleado.
        sc.nextLine(); // Consume salto de línea pendiente.
        String[] codigos = new String[n]; // Registra identificadores de empleados.
        String[] nombres = new String[n]; // Registra nombres correspondientes.
        for (int i = 0; i < n; i++) { // Captura todos los empleados.
            System.out.print("Codigo del empleado " + (i + 1) + ": "); // Solicita código.
            codigos[i] = sc.nextLine().trim(); // Guarda código como texto.
            System.out.print("Nombre completo: "); // Solicita nombre.
            nombres[i] = sc.nextLine().trim(); // Permite nombres con espacios.
        }
        System.out.print("Codigo a consultar: "); // Solicita búsqueda.
        String consulta = sc.nextLine().trim(); // Lee código de búsqueda.
        boolean encontrado = false; // Registra si existe coincidencia.
        for (int i = 0; i < n; i++) { // Recorre códigos registrados.
            if (codigos[i].equals(consulta)) { // Compara códigos exactamente.
                System.out.println("Nombre del empleado: " + nombres[i]); // Muestra nombre encontrado.
                encontrado = true; // Marca coincidencia.
                break; // Termina la búsqueda.
            }
        }
        if (!encontrado) System.out.println("No existe empleado con ese codigo."); // Informa sin coincidencias.
        sc.close(); // Cierra entrada.
    }
}
