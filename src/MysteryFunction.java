class Solution {

    private static int mysteryFunction(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;

        for(;;) {
            int pivotIndex = partition(array, left, right);

            if(k == pivotIndex) {
                return array[k];
            } else if(k < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    // partition the array using array[right] as a pivot
    // returns the pivot's final index
    private static int partition(int[] array, int left, int right) {
        int pivotValue = array[right];
        int swapIdx = left;
        for (int i = 0; i < right; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, swapIdx++);
            }
        }
        swap(array, swapIdx, right);
        return swapIdx;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3};
        System.out.println(mysteryFunction(array, 1));

        System.out.println("\n--- Explicación de la función ---");
        System.out.println("La función mysteryFunction encuentra el k-ésimo elemento más pequeño en un arreglo desordenado.");
        System.out.println("Inicializa left y right para recorrer el arreglo");
        System.out.println("- Si el índice del pivote coincide con k, devuelve array[k]");
        System.out.println("- Si k < pivotIndex, busca en la izquierda de lo contrario busca en la derecha");
        System.out.println("- El partition reorganiza el arreglo: todos los elementos < pivot van a la izquierda");
        System.out.println("- Cada partición divide el array en mitades");
    }
}

/* Respuesta:
 * out: 1
 * Inicializa left y right para recorrer el arreglo.
 * Si el índice del pivote coincide con k, devuelve array[k]
 * Si k < pivotIndex, busca en la izquierda de lo contrario busca en la derecha
 * El partition reorganiza el arreglo: todos los elementos < pivot van a la izquierda
 * Cada partición divide el array en mitades */


