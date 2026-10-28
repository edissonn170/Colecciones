package ejercicio9;
import java.util.ArrayList; // Importamos ArrayList para manejar listas dinámicas
import java.util.Scanner; // Importamos Scanner

// Clase registro para Medicamento
class Medicamento {
    String nombre; // Atributo nombre
    int stockActual; // Atributo stock actual
    int stockMinimo; // Atributo stock mínimo
    double precioUnitario; // Atributo precio unitario
}

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Instanciamos Scanner
        ArrayList<Medicamento> inventario = new ArrayList<>(); // Lista dinámica para inventario
        int opcion = 0; // Variable para el menú
        
        while (opcion != 6) { // Bucle del menú principal, sale si elige 6
            System.out.println("\n--- FARMACIA ---"); // Título
            System.out.println("1. Registrar medicamento"); // Opción 1
            System.out.println("2. Medicamentos bajo stock minimo"); // Opción 2
            System.out.println("3. Valor total del inventario"); // Opción 3
            System.out.println("4. Vender medicamento (actualizar stock)"); // Opción 4
            System.out.println("5. Reporte general"); // Opción 5
            System.out.println("6. Salir"); // Opción 6
            System.out.print("Elija una opcion: "); // Pedir opción
            opcion = sc.nextInt(); // Leer opción
            
            if (opcion == 1) { // Lógica para registrar
                Medicamento med = new Medicamento(); // Creamos objeto medicamento
                System.out.print("Nombre: "); // Pedimos nombre
                med.nombre = sc.next(); // Leemos nombre
                System.out.print("Stock actual: "); // Pedimos stock
                med.stockActual = sc.nextInt(); // Leemos stock
                System.out.print("Stock minimo: "); // Pedimos stock mínimo
                med.stockMinimo = sc.nextInt(); // Leemos stock mínimo
                System.out.print("Precio unitario: "); // Pedimos precio
                med.precioUnitario = sc.nextDouble(); // Leemos precio
                if (med.stockActual < 0 || med.stockMinimo < 0 || med.precioUnitario < 0 || !Double.isFinite(med.precioUnitario)) { // Evitamos datos de inventario invalidos.
                    System.out.println("Datos invalidos. Medicamento no registrado."); // Informamos el error.
                    continue; // Regresamos al menu.
                }
                inventario.add(med); // Añadimos medicamento a la lista
                System.out.println("Medicamento registrado."); // Confirmación
            } 
            else if (opcion == 2) { // Lógica para stock bajo
                System.out.println("\n--- STOCK BAJO ---"); // Título
                for (Medicamento med : inventario) { // Recorremos inventario
                    if (med.stockActual < med.stockMinimo) { // Condición de stock bajo
                        System.out.println(med.nombre + " - Stock actual: " + med.stockActual); // Imprimimos alerta
                    }
                }
            } 
            else if (opcion == 3) { // Lógica para valor total
                double valorTotal = 0; // Acumulador
                for (Medicamento med : inventario) { // Recorremos inventario
                    valorTotal += (med.stockActual * med.precioUnitario); // Sumamos precio por cantidad
                }
                System.out.println("Valor economico total: $" + valorTotal); // Mostramos total
            } 
            else if (opcion == 4) { // Lógica para vender
                System.out.print("Ingrese nombre del medicamento a vender: "); // Pedimos nombre
                String nombreVenta = sc.next(); // Leemos nombre
                System.out.print("Cantidad a vender: "); // Pedimos cantidad
                int cantidad = sc.nextInt(); // Leemos cantidad
                boolean encontrado = false; // Bandera de búsqueda
                
                for (Medicamento med : inventario) { // Recorremos inventario
                    if (med.nombre.equalsIgnoreCase(nombreVenta)) { // Si coincide el nombre
                        encontrado = true; // Cambiamos bandera
                        if (cantidad > 0 && med.stockActual >= cantidad) { // Si hay suficiente stock
                            med.stockActual -= cantidad; // Restamos la cantidad del stock
                            System.out.println("Venta realizada. Nuevo stock: " + med.stockActual); // Confirmamos
                        } else {
                            System.out.println("Cantidad invalida o stock insuficiente."); // Evita ventas negativas y exceso de stock
                        }
                    }
                }
                if (!encontrado) System.out.println("Medicamento no encontrado."); // Error no existe
            } 
            else if (opcion == 5) { // Lógica para reporte
                System.out.println("\n--- REPORTE GENERAL ---"); // Título
                for (Medicamento med : inventario) { // Recorremos inventario
                    System.out.println("Nombre: " + med.nombre + " | Stock: " + med.stockActual + 
                                       " | Stock minimo: " + med.stockMinimo + " | Precio: $" + med.precioUnitario); // Imprimimos datos del medicamento
                }
            }
        }
        sc.close(); // Cerramos Scanner al salir
    }
}