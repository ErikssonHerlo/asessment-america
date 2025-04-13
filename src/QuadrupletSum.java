import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import java.util.HashSet;
import java.util.Set;

public class QuadrupletSum {

    public static int[] findQuadrupletSum(int[] numbers, int target) {
        for (int a : numbers) {
            for (int b : numbers) {
                for (int c : numbers) {
                    for (int d : numbers) {
                        if (a + b + c + d == target) {
                            return new int[]{a, b, c, d};
                        }
                    }
                }
            }
        }
        return null;  // This line should never be reached
    }

    public static int[] findQuadrupletSumFast(int[] numbers, int target) {
        int n = numbers.length;

        Set<Integer> numSet = new HashSet<>();
        for (int num : numbers) {
            numSet.add(num);
        }

        for (int a : numbers) {
            for (int b : numbers) {
                for (int c : numbers) {
                    int d = target - (a + b + c);
                    if (numSet.contains(d)) {
                        return new int[]{a, b, c, d};
                    }
                }
            }
        }

        return null;
    }

    public static void runTestcase(int[] numbers, int target, String testcaseName) {
        System.out.print(testcaseName + " - ");
        long t0 = System.nanoTime();
        int[] result = findQuadrupletSumFast(numbers, target);
        long elapsed = System.nanoTime() - t0;

        if (result == null || result.length != 4) {
            System.out.println("FAILED: the result has " + (result == null ? "null" : result.length) + " elements, not 4");
            System.exit(1);
        }

        int sum = Arrays.stream(result).sum();
        if (sum != target) {
            System.out.println("FAILED: the sum of " + Arrays.toString(result) + " is " + sum + ", not " + target);
            System.exit(1);
        }

        List<Integer> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(number);
        }

        for (int r : result) {
            if (!numberList.contains(r)) {
                System.out.println("FAILED: one of the numbers is not in the list");
                System.exit(1);
            }
        }

        System.out.println("PASSED");
    }

    public static void main(String[] args) {
        runTestcase(new int[]{5, 4, 3, 2, 1, 0}, 11, "Small testcase");
        runTestcase(new int[]{54, 3, 42, 16, 4, 24}, 90, "Solution with duplicates");
        runTestcase(new int[]{89, -62, -92, -37, 28, 29}, -7, "With negative numbers");
        runTestcase(new int[]{39, -57, -53, -79, 83, -6, 27, -97}, 0, "Target is zero");

        Random random = new Random();
        for (int i = 1; i <= 5; i++) {
            int[] numbers = random.ints(1000, -100_000_000, 100_000_000).toArray();
            int target = numbers[numbers.length - 1] + numbers[numbers.length - 2] + numbers[numbers.length - 3] + numbers[numbers.length - 4];
            randomizeArray(numbers);
            runTestcase(numbers, target, "Large test #" + i);
        }

        System.out.println("Congratulations. You passed all testcases!");
    }

    private static void randomizeArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
