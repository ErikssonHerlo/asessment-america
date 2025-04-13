package quickselect;

import java.util.Optional;

/**
 * Implements the Quickselect algorithm to find the k-th smallest element in an unsorted array.
 * Time complexity: average O(n), worst O(n²)
 */
public class Quickselect {

    /**
     * Finds the k-th smallest element in the array (0-based index).
     *
     * @param array The array of integers (not necessarily sorted).
     * @param k     The target index (0-based) of the smallest element to find.
     * @return An Optional containing the k-th smallest element if input is valid.
     */
    public Optional<Integer> findKthSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k < 0 || k >= array.length) {
            return Optional.empty();
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int pivotIndex = partition(array, left, right);

            if (pivotIndex == k) {
                return Optional.of(array[k]);
            } else if (k < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }

        return Optional.empty(); // should never reach this
    }

    /**
     * Partitions the array using array[right] as pivot. Elements less than pivot go to the left.
     *
     * @param array The array to partition.
     * @param left  The starting index of the segment.
     * @param right The ending index (pivot is at right).
     * @return The final index position of the pivot after partition.
     */
    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int swapIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                ArrayUtils.swap(array, i, swapIndex++);
            }
        }

        ArrayUtils.swap(array, swapIndex, right);
        return swapIndex;
    }
}
