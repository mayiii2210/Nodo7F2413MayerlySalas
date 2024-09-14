package Java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Version {
    String contenido;
    int numero;

    public Version(String contenido, int numero) {
        this.contenido = contenido;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Versión " + numero + ":\n" + contenido;
    }
}


class Documento {
    String titulo;
    List<Version> versiones;
    int numeroVersionActual;

    public Documento(String titulo, String contenidoInicial) {
        this.titulo = titulo;
        this.versiones = new ArrayList<>();
        this.numeroVersionActual = 0;
        agregarVersion(contenidoInicial);
    }

    
    public void agregarVersion(String contenido) {
        numeroVersionActual++;
        versiones.add(new Version(contenido, numeroVersionActual));
        System.out.println("Nueva versión " + numeroVersionActual + " guardada.");
    }

 
    public void mostrarVersion(int numero) {
        if (numero > 0 && numero <= versiones.size()) {
            System.out.println(versiones.get(numero - 1));
        } else {
            System.out.println("Versión no encontrada.");
        }
    }

 
    public void restaurarVersion(int numero) {
        if (numero > 0 && numero <= versiones.size()) {
            Version versionRestaurada = versiones.get(numero - 1);
            agregarVersion(versionRestaurada.contenido);
            System.out.println("Versión " + numero + " restaurada.");
        } else {
            System.out.println("Versión no encontrada.");
        }
    }

   
    public void mostrarHistorial() {
        System.out.println("Historial de versiones de '" + titulo + "':");
        for (Version v : versiones) {
            System.out.println(v);
        }
    }
}


public class ControlDeVersiones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el título del documento:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el contenido inicial del documento:");
        String contenidoInicial = scanner.nextLine();

        Documento documento = new Documento(titulo, contenidoInicial);

        while (true) {
            System.out.println("\n1. Modificar documento");
            System.out.println("2. Ver una versión");
            System.out.println("3. Restaurar una versión");
            System.out.println("4. Ver historial de versiones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 1) {
                System.out.println("Ingrese el nuevo contenido del documento:");
                String nuevoContenido = scanner.nextLine();
                documento.agregarVersion(nuevoContenido);

            } else if (opcion == 2) {
                System.out.println("Ingrese el número de versión a consultar:");
                int numeroVersion = scanner.nextInt();
                documento.mostrarVersion(numeroVersion);

            } else if (opcion == 3) {
                System.out.println("Ingrese el número de versión a restaurar:");
                int numeroVersion = scanner.nextInt();
                documento.restaurarVersion(numeroVersion);

            } else if (opcion == 4) {
                documento.mostrarHistorial();

            } else if (opcion == 5) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
