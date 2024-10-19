package Clase1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AplicacionPractica {

    // Crear la lista de tareas
    private static ArrayList<String> listaTareas = new ArrayList<>();

    // Constantes para las opciones del menú
    private static final int AGREGAR_TAREA = 1;
    private static final int ELIMINAR_TAREA = 2;
    private static final int MOSTRAR_TAREAS = 3;
    private static final int SALIR = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú
            mostrarMenu();
            opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case AGREGAR_TAREA:
                    agregarTarea(scanner);
                    break;
                case ELIMINAR_TAREA:
                    eliminarTarea(scanner);
                    break;
                case MOSTRAR_TAREAS:
                    mostrarTareasPendientes();
                    break;
                case SALIR:
                    confirmarSalida(scanner);
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != SALIR);
    }

    // Método para mostrar el menú
    private static void mostrarMenu() {
        System.out.println("\n--- Gestión de Tareas ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Eliminar tarea completada");
        System.out.println("3. Mostrar todas las tareas pendientes");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    // Método para obtener y validar la opción ingresada por el usuario
    private static int obtenerOpcion(Scanner scanner) {
        int opcion = -1;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next();  // Limpiar la entrada inválida
        }
        scanner.nextLine(); // Limpiar el buffer
        return opcion;
    }

    // Función para agregar una tarea
    private static void agregarTarea(Scanner scanner) {
        System.out.print("Ingresa la tarea a agregar: ");
        String tarea = scanner.nextLine();
        listaTareas.add(tarea);
        System.out.println("Tarea agregada exitosamente.");
    }

    // Función para eliminar una tarea
    private static void eliminarTarea(Scanner scanner) {
        mostrarTareasPendientes();
        if (listaTareas.isEmpty()) return; // No hay nada que eliminar

        System.out.print("Ingresa el número de la tarea a eliminar: ");
        try {
            int indice = scanner.nextInt() - 1;
            if (indice >= 0 && indice < listaTareas.size()) {
                listaTareas.remove(indice);
                System.out.println("Tarea eliminada exitosamente.");
            } else {
                System.out.println("Índice inválido.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next(); // Limpiar la entrada inválida
        }
    }

    // Función para mostrar todas las tareas pendientes
    private static void mostrarTareasPendientes() {
        System.out.println("\n--- Tareas Pendientes ---");
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            for (int i = 0; i < listaTareas.size(); i++) {
                System.out.println((i + 1) + ". " + listaTareas.get(i));
            }
        }
    }

    // Función para confirmar la salida
    private static void confirmarSalida(Scanner scanner) {
        System.out.print("¿Estás seguro que deseas salir? (S/N): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        if (!respuesta.equals("s")) {
            System.out.println("Continuando con el gestor de tareas...");
        } else {
            System.out.println("Saliendo del gestor de tareas...");
        }
    }
}
