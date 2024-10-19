package Clase2;

public class Fibonacci {

    // Método iterativo para calcular el enésimo número de Fibonacci
    public static long fibonacciIterativo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = b;
            b += a;
            a = temp;
        }
        return b;
    }

    // Método iterativo optimizado usando menos operaciones para calcular Fibonacci
    public static long fibonacciOptimizado(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        if (n <= 1) {
            return n;
        }
        long prev = 0, current = 1;
        for (int i = 2; i <= n; i++) {
            prev = current + (current = prev);
        }
        return current;
    }

    // Método para medir el tiempo de ejecución de un algoritmo con una interfaz funcional
    public static long medirTiempoEjecucion(Runnable algoritmo) {
        long inicio = System.nanoTime();
        algoritmo.run();
        long fin = System.nanoTime();
        return fin - inicio;
    }

    // Método para realizar múltiples pruebas y obtener el tiempo promedio
    public static long medirTiempoPromedio(Runnable algoritmo, int repeticiones) {
        long tiempoTotal = 0;
        for (int i = 0; i < repeticiones; i++) {
            tiempoTotal += medirTiempoEjecucion(algoritmo);
        }
        return tiempoTotal / repeticiones;
    }

    // Método principal para probar ambos algoritmos y comparar tiempos
    public static void main(String[] args) {
        int n = 30;
        int repeticiones = 100;  // Aumentamos el número de repeticiones para mayor precisión

        // Medir tiempo de ejecución para el método iterativo básico
        long tiempoPromedioBasico = medirTiempoPromedio(() -> fibonacciIterativo(n), repeticiones);
        System.out.println("Tiempo promedio del método iterativo: " + tiempoPromedioBasico + " nanosegundos");

        // Medir tiempo de ejecución para el método iterativo optimizado
        long tiempoPromedioOptimizado = medirTiempoPromedio(() -> fibonacciOptimizado(n), repeticiones);
        System.out.println("Tiempo promedio del método optimizado: " + tiempoPromedioOptimizado + " nanosegundos");
    }
}
