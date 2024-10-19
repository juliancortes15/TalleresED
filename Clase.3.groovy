package Clase3;

import java.util.Arrays;
import java.util.HashSet;

public class Clase3 {

    // Primera parte (Identificación de Complejidades)

    // Primer algoritmo
    public void printFirstElement(int[] arr) {
        if (arr.length > 0) { // Complejidad temporal O(1) y espacial O(1)
            System.out.println(arr[0]); // Complejidad temporal O(1) y espacial O(1)
        }
    }
    // Resultado final: Complejidad temporal O(1) y espacial O(1)

    // Segundo algoritmo
    public void printAllElements(int[] arr) {
        for (int element : arr) { // Complejidad temporal O(n) y espacial O(1)
            System.out.println(element); // Complejidad temporal O(1) y espacial O(1)
        }
    }
    // Resultado final: Complejidad temporal O(n) y espacial O(1)

    // Tercer algoritmo
    public void printAllPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // Complejidad temporal O(n^2)
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j]); // Complejidad temporal O(1)
            }
        }
    }
    // Resultado final: Complejidad temporal O(n^2) y espacial O(1)

    // Cuarto algoritmo
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // Complejidad temporal O(1)
            if (arr[mid] == target) {
                return mid; // Complejidad temporal O(1)
            } else if (arr[mid] < target) {
                low = mid + 1; // Complejidad temporal O(1)
            } else {
                high = mid - 1; // Complejidad temporal O(1)
            }
        }
        return -1; // Si no se encuentra el elemento
    }
    // Resultado final: Complejidad temporal O(log n) y espacial O(1)

    // Quinto algoritmo (Fibonacci recursivo)
    public int fibonacci(int n) {
        if (n <= 1) { // Complejidad temporal O(1) y espacial O(1)
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Complejidad temporal O(2^n) debido a las múltiples llamadas recursivas
        }
    }
    // Resultado final: Complejidad temporal O(2^n) y espacial O(n) (debido a la profundidad de la recursión)

    // Sexto algoritmo (Ordenar y mostrar elementos)
    public void sortAndPrint(int[] arr) {
        Arrays.sort(arr); // Complejidad O(n log n) para la ordenación
        for (int element : arr) { // Complejidad temporal O(n)
            System.out.println(element); // Complejidad temporal O(1)
        }
    }
    // Resultado final: Complejidad temporal O(n log n) y espacial O(1)

    // Segunda parte (Optimización de Algoritmos)

    // Algoritmo original con complejidad O(n^2)
    public boolean hasDuplicate1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true; // Se encontró un duplicado
                }
            }
        }
        return false;
    }
    // Complejidad temporal O(n^2) y espacial O(1)

    // Algoritmo optimizado usando un HashSet (complejidad O(n))
    public boolean hasDuplicate(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int element : arr) {
            if (seen.contains(element)) {
                return true; // Se encontró un duplicado
            }
            seen.add(element);
        }
        return false;
    }
    // Complejidad temporal O(n) y espacial O(n)
}
