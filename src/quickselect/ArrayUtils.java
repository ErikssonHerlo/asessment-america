package quickselect;

/**
 * Utility methods for array manipulation.
 * This class provides methods to perform common operations on arrays,
 * such as swapping elements.
 */
public class ArrayUtils {

    /**
     * Swaps two elements in an array.
     *
     * @param array The array.
     * @param i     Index of the first element.
     * @param j     Index of the second element.
     */
    public static void swap(int[] array, int i, int j) {
        if (i == j) return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
