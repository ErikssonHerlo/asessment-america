package quickselect;

import java.util.Optional;
import java.util.Arrays;

/**
 * Executes test cases for the Quickselect algorithm.
 */
public class QuickselectTestRunner {

    private static final Quickselect quickselect = new Quickselect();

    public static void main(String[] args) {
        runTest(new int[]{3, 1, 4, 0, 2}, 2, 2, "Basic unordered input");
        runTest(new int[]{5, 5, 5, 5, 5}, 3, 5, "All duplicates");
        runTest(new int[]{10}, 0, 10, "Single element");
        runTest(new int[]{7, 3, 1, 9, 8}, 0, 1, "First smallest element");
        runTest(new int[]{7, 3, 1, 9, 8}, 4, 9, "Last smallest element");
        runTest(new int[]{1, 2, 2, 2, 3}, 3, 2, "With repeated values in the middle");

        // Edge cases
        runInvalidTest(new int[]{}, 0, "Empty array");
        runInvalidTest(new int[]{1, 2, 3}, -1, "Negative k");
        runInvalidTest(new int[]{1, 2, 3}, 3, "k out of bounds");
    }

    private static void runTest(int[] array, int k, int expected, String description) {
        Optional<Integer> result = quickselect.findKthSmallest(Arrays.copyOf(array, array.length), k);
        String status = (result.isPresent() && result.get() == expected) ? "✅ PASSED" : "❌ FAILED";

        System.out.println(status + " | " + description +
                " | k = " + k + " | expected = " + expected + " | result = " + result.orElse(null));
    }

    private static void runInvalidTest(int[] array, int k, String description) {
        Optional<Integer> result = quickselect.findKthSmallest(array, k);
        String status = result.isEmpty() ? "✅ PASSED" : "❌ FAILED";

        System.out.println(status + " | " + description +
                " | k = " + k + " | result = " + result.orElse(null));
    }
}
