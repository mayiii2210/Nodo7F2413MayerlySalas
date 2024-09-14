package Java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class OfertaEmpleo {
    String industria;
    String ubicacion;
    String tipoContrato;

    public OfertaEmpleo(String industria, String ubicacion, String tipoContrato) {
        this.industria = industria;
        this.ubicacion = ubicacion;
        this.tipoContrato = tipoContrato;
    }

    @Override
    public String toString() {
        return "Industria: " + industria + ", Ubicación: " + ubicacion + ", Tipo de Contrato: " + tipoContrato;
    }
}


class Aplicacion {
    String candidato;
    String resumenCalificaciones;

    public Aplicacion(String candidato, String resumenCalificaciones) {
        this.candidato = candidato;
        this.resumenCalificaciones = resumenCalificaciones;
    }

    @Override
    public String toString() {
        return "Candidato: " + candidato + ", Resumen: " + resumenCalificaciones;
    }
}

public class SimuladorBolsaTrabajo {

    static List<OfertaEmpleo> ofertas = new ArrayList<>();
    static List<Aplicacion> aplicaciones = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Simulador de Bolsa de Trabajo");
            System.out.println("1. Registrar nueva oferta de empleo");
            System.out.println("2. Buscar ofertas de empleo");
            System.out.println("3. Aplicar a una oferta");
            System.out.println("4. Mostrar aplicaciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarOferta();
                    break;
                case 2:
                    buscarOfertas();
                    break;
                case 3:
                    aplicarOferta();
                    break;
                case 4:
                    mostrarAplicaciones();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

  
    public static void registrarOferta() {
        System.out.print("Ingrese la industria: ");
        String industria = scanner.nextLine();
        System.out.print("Ingrese la ubicación: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Ingrese el tipo de contrato: ");
        String tipoContrato = scanner.nextLine();

        ofertas.add(new OfertaEmpleo(industria, ubicacion, tipoContrato));
        System.out.println("Oferta de empleo registrada exitosamente.");
    }

 
    public static void buscarOfertas() {
        System.out.println("Ofertas disponibles:");
        for (OfertaEmpleo oferta : ofertas) {
            System.out.println(oferta);
        }
    }

   
    public static void aplicarOferta() {
        System.out.print("Ingrese su nombre: ");
        String candidato = scanner.nextLine();
        System.out.print("Ingrese un resumen de sus calificaciones: ");
        String resumenCalificaciones = scanner.nextLine();

        aplicaciones.add(new Aplicacion(candidato, resumenCalificaciones));
        System.out.println("Aplicación enviada exitosamente.");
    }

  
    public static void mostrarAplicaciones() {
        System.out.println("Aplicaciones recibidas:");
        for (Aplicacion aplicacion : aplicaciones) {
            System.out.println(aplicacion);
        }
    }
}

