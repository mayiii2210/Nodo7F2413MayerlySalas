package Java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Empleado {
    String nombre;
    double evaluacion;
    public Empleado(String nombre, double evaluacion) {
        this.nombre = nombre;
        this.evaluacion = evaluacion;
    }

    public double calcularBonificacion() {
        return evaluacion * 100; 
    }
}


public class GestionEmpleados {

    private static List<Empleado> empleados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bienveni@ al sistema de Gestión de Empleados, ¿Qué deseas hacer?");
            System.out.println("1. Agregar nuevo empleado");
            System.out.println("2. Registrar evaluación de desempeño");
            System.out.println("3. Calcular bonificación");
            System.out.println("4. Mostrar empleados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    registrarEvaluacion();
                    break;
                case 3:
                    calcularBonificaciones();
                    break;
                case 4:
                    mostrarEmpleados();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void agregarEmpleado() {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        empleados.add(new Empleado(nombre, 0));
        System.out.println("Empleado agregado exitosamente.");
    }

    private static void registrarEvaluacion() {
        System.out.print("Ingrese el nombre del empleado para registrar la evaluación: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la puntuación de la evaluación (0-10): ");
        double puntuacion = scanner.nextDouble();
        scanner.nextLine(); 
        for (Empleado empleado : empleados) {
            if (empleado.nombre.equals(nombre)) {
                empleado.evaluacion = puntuacion;
                System.out.println("Evaluación registrada exitosamente.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    private static void calcularBonificaciones() {
        System.out.println("Bonificaciones de empleados:");
        for (Empleado empleado : empleados) {
            double bonificacion = empleado.calcularBonificacion();
            System.out.printf("Nombre: %s, Bonificación: %.2f\n", empleado.nombre, bonificacion);
        }
    }

    private static void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println("Nombre: " + empleado.nombre + ", Evaluación: " + empleado.evaluacion);
            }
        }
    }
}
