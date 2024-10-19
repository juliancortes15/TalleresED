package Clase2;

import java.util.Arrays;

public class ComparacionYAnalisis {

    public static void main(String[] args) {
        // Tamaño del array
        int n = 1_000_000;
        int[] array = new int[n];

        // Inicialización del array con valores aleatorios
        Arrays.setAll(array, i -> (int) (Math.random() * 100));

        // Medir tiempo para el método iterativo básico
        long durationBasic = medirTiempoEjecucion(() -> iterativeSumBasic(array));
        long sumBasic = iterativeSumBasic(array);

        // Medir tiempo para el método iterativo optimizado
        long durationOptimized = medirTiempoEjecucion(() -> iterativeSumOptimized(array));
        long sumOptimized = iterativeSumOptimized(array);

        // Imprimir resultados
        System.out.println("Suma usando método iterativo básico: " + sumBasic);
        System.out.println("Tiempo de ejecución (método iterativo básico): " + durationBasic + " nanosegundos");

        System.out.println("Suma usando método iterativo optimizado: " + sumOptimized);
        System.out.println("Tiempo de ejecución (método iterativo optimizado): " + durationOptimized + " nanosegundos");

        // Comparar los tiempos obtenidos
        System.out.println(durationBasic < durationOptimized ?
                "El método iterativo básico fue más rápido." :
                "El método iterativo optimizado fue más rápido.");

        // Análisis de la eficiencia
        System.out.println("\n**Análisis de la eficiencia:**");
        System.out.println("El método iterativo básico suma los elementos secuencialmente.");
        System.out.println("El método optimizado usa múltiples hilos para paralelizar la suma.");
        System.out.println("La eficiencia depende de la sobrecarga de la creación y sincronización de hilos.");
    }

    // Método para medir el tiempo de ejecución de un algoritmo
    private static long medirTiempoEjecucion(Runnable metodo) {
        long startTime = System.nanoTime();
        metodo.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Método iterativo básico para sumar elementos de un array
    public static long iterativeSumBasic(int[] array) {
        return Arrays.stream(array).sum(); // Usamos stream para mejorar la legibilidad
    }

    // Método iterativo optimizado para sumar elementos de un array (paralelización usando hilos)
    public static long iterativeSumOptimized(int[] array) {
        int mid = array.length / 2;

        // Crear y ejecutar dos hilos para realizar la suma en paralelo
        SumThread thread1 = new SumThread(array, 0, mid);
        SumThread thread2 = new SumThread(array, mid, array.length);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Retornar la suma total obtenida por los dos hilos
        return thread1.getSum() + thread2.getSum();
    }
}

// Clase auxiliar para realizar la suma en un hilo separado
class SumThread extends Thread {
    private final int[] array;
    private final int start, end;
    private long sum;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }

    public long getSum() {
        return sum;
    }
}
