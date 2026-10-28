
package ejercicio10;

import java.util.ArrayList; // Importamos ArrayList
import java.util.Scanner; // Importamos Scanner

// Clase registro para los pedidos
class Pedido {
    String nombreCliente; // Nombre del cliente
    String plato; // Nombre del plato
    int cantidad; // Cantidad solicitada
    double precioUnitario; // Precio unitario del plato
    double totalPagar; // Total calculado del pedido
}

public class Ejercicio10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Iniciamos Scanner
        ArrayList<Pedido> listaPedidos = new ArrayList<>(); // Lista de pedidos
        int opcion = 0; // Opcion del menu

        while (opcion != 4) { // Repite el menu hasta salir
            System.out.println("\n--- RESTAURANTE ---"); // Encabezado
            System.out.println("1. Registrar pedido"); // Opcion 1
            System.out.println("2. Mostrar todos los pedidos (Calculo y Descuento)"); // Opcion 2
            System.out.println("3. Mostrar ingresos totales y pedido mayor"); // Opcion 3
            System.out.println("4. Salir"); // Opcion 4
            System.out.print("Opcion: "); // Solicita opcion
            opcion = sc.nextInt(); // Lee opcion numerica
            sc.nextLine(); // Limpia el salto de linea pendiente

            if (opcion == 1) { // Registrar pedido
                Pedido p = new Pedido(); // Crea un pedido

                System.out.print("Nombre del cliente: "); // Solicita cliente
                p.nombreCliente = sc.nextLine().trim(); // Lee nombre completo

                System.out.print("Plato solicitado: "); // Solicita plato
                p.plato = sc.nextLine().trim(); // Lee plato con espacios

                System.out.print("Cantidad: "); // Solicita cantidad
                p.cantidad = sc.nextInt(); // Lee cantidad

                System.out.print("Precio unitario: "); // Solicita precio
                p.precioUnitario = sc.nextDouble(); // Lee precio
                sc.nextLine(); // Limpia el salto de linea pendiente

                // Verifica valores validos
                if (p.cantidad <= 0 || p.precioUnitario < 0 ||
                        !Double.isFinite(p.precioUnitario)) {
                    System.out.println("Cantidad o precio invalido. Pedido no registrado.");
                    continue; // Regresa al menu sin guardar
                }

                // Calcula el subtotal del pedido
                double subtotal = p.cantidad * p.precioUnitario;

                if (subtotal > 50) { // Aplica descuento si supera $50
                    p.totalPagar = subtotal - (subtotal * 0.10); // Descuento del 10%
                    System.out.println("Aplica descuento del 10%!");
                } else {
                    p.totalPagar = subtotal; // Conserva total sin descuento
                }

                listaPedidos.add(p); // Guarda el pedido
                System.out.println("Pedido registrado exitosamente.");

            } else if (opcion == 2) { // Mostrar pedidos
                System.out.println("\n--- LISTA DE PEDIDOS ---");

                for (Pedido p : listaPedidos) { // Recorre pedidos
                    System.out.println("Cliente: " + p.nombreCliente +
                            " | Plato: " + p.plato +
                            " | Cantidad: " + p.cantidad +
                            " | Total a pagar: $" + p.totalPagar);
                }

            } else if (opcion == 3) { // Estadisticas
                double ingresoTotal = 0; // Acumula ingresos
                double mayorValor = 0; // Mayor total registrado
                String clienteMayor = ""; // Cliente del pedido mayor

                for (Pedido p : listaPedidos) { // Recorre pedidos
                    ingresoTotal += p.totalPagar; // Suma ingresos

                    if (p.totalPagar > mayorValor) { // Compara pedidos
                        mayorValor = p.totalPagar; // Actualiza mayor
                        clienteMayor = p.nombreCliente; // Guarda cliente
                    }
                }

                System.out.println("Ingreso total del restaurante: $" +
                        ingresoTotal); // Muestra ingresos

                System.out.println("El pedido de mayor valor fue de: " +
                        clienteMayor + " con $" + mayorValor); // Muestra mayor
            }
        }

        sc.close(); // Cierra Scanner
    }
}
