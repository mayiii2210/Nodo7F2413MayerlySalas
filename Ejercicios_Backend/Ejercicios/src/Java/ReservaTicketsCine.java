package Java;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Pelicula {
    String titulo;
    int NasientosDisponibles;

    public Pelicula(String titulo, int NasientosDisponibles) {
        this.titulo = titulo;
        this.NasientosDisponibles = NasientosDisponibles;
    }
}

public class ReservaTicketsCine {
    private static Map<String, Pelicula> peliculas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        peliculas.put("1", new Pelicula("Avatar 2", 25));
        peliculas.put("2", new Pelicula("Mi villano favorito 4", 15));
        peliculas.put("3", new Pelicula("Romper el círculo", 8));
        peliculas.put("4", new Pelicula("Vacaciones", 30));
        peliculas.put("5", new Pelicula("Son como niños", 9));
        

        while (true) {
            System.out.println("Bienvenido al Sistema de Reserva de Tickets de Cine");
            mostrarPeliculas();
            System.out.print("Seleccione el número de la película que desea ver o '0' para salir: ");
            String opcion = scanner.nextLine();

            if (opcion.equals("0")) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            Pelicula pelicula = peliculas.get(opcion);
            if (pelicula != null) {
                gestionarReserva(pelicula);
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void mostrarPeliculas() {
        System.out.println("Películas disponibles:");
        for (Map.Entry<String, Pelicula> entry : peliculas.entrySet()) {
            Pelicula pelicula = entry.getValue();
            System.out.println(entry.getKey() + ". " + pelicula.titulo + " - Asientos disponibles: " + pelicula.NasientosDisponibles);
        }
    }

    private static void gestionarReserva(Pelicula pelicula) {
        System.out.print("Ingrese el número de asientos que desea reservar: ");
        int asientos;
        try {
            asientos = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Debe ingresar un número.");
            return;
        }

        if (asientos > 0 && asientos <= pelicula.NasientosDisponibles) {
            pelicula.NasientosDisponibles -= asientos;
            System.out.println("Reserva confirmada para " + asientos + " asiento(s) en '" + pelicula.titulo + "'.");
            procesarPago(asientos);
        } else {
            System.out.println("Número de asientos no disponible o inválido.");
        }
    }

    private static void procesarPago(int asientos) {
        double precioPorAsiento = 50.000;
        double total = asientos * precioPorAsiento;
        System.out.printf("El total a pagar es: $%.2f\n", total);
        System.out.println("Pago procesado exitosamente. ¡Gracias por su compra!");
    }
}
