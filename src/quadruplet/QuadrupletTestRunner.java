package quadruplet;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

/**
 * Executes multiple test cases and validates correctness and performance of the QuadrupletFinder.
 */
public class QuadrupletTestRunner {

    private final QuadrupletFinder finder = new QuadrupletFinder();

    public void run() {
        runTestcase(new int[]{5, 4, 3, 2, 1, 0}, 11, "Small testcase");
        runTestcase(new int[]{54, 3, 42, 16, 4, 24}, 90, "With duplicates");
        runTestcase(new int[]{89, -62, -92, -37, 28, 29}, -7, "With negatives");
        runTestcase(new int[]{39, -57, -53, -79, 83, -6, 27, -97}, 0, "Zero target");

        for (int i = 1; i <= 5; i++) {
            int[] numbers = new Random().ints(1000, -100_000, 100_000).toArray();
            int target = numbers[numbers.length - 1] + numbers[numbers.length - 2] +
                    numbers[numbers.length - 3] + numbers[numbers.length - 4];
            shuffleArray(numbers);
            runTestcase(numbers, target, "Large test #" + i);
        }

        System.out.println("\nAll test cases passed!");
    }

    private void runTestcase(int[] numbers, int target, String name) {
        System.out.print(name + ": ");
        long start = System.nanoTime();
        Optional<Quadruplet> result = finder.findQuadruplet(numbers, target);
        long duration = System.nanoTime() - start;

        if (result.isEmpty()) {
            System.out.println("❌ FAILED - No quadruplet found.");
            return;
        }

        Quadruplet q = result.get();
        if (q.sum() != target) {
            System.out.println("❌ FAILED - Incorrect sum: " + q.sum());
            return;
        }

        boolean valid = validateExistence(q.toArray(), numbers);
        if (!valid) {
            System.out.println("❌ FAILED - Quadruplet uses unavailable numbers.");
            return;
        }

        System.out.println("✅ PASSED in " + duration / 1_000_000 + " ms → " + q);
    }

    private boolean validateExistence(int[] values, int[] source) {
        int[] sourceCopy = Arrays.copyOf(source, source.length);
        for (int val : values) {
            boolean found = false;
            for (int i = 0; i < sourceCopy.length; i++) {
                if (sourceCopy[i] == val) {
                    sourceCopy[i] = Integer.MIN_VALUE;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    private void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        new QuadrupletTestRunner().run();
    }
}
