package quadruplet;

import java.util.*;

/**
 * Efficient quadruplet finder using a HashMap of pair sums.
 * Time complexity: O(n^2), space complexity: O(n^2).
 *
 * This class is designed to find any combination of four distinct integers
 * in an array that add up to a given target value.
 */
public class QuadrupletFinder {

    /**
     * Finds a quadruplet {a, b, c, d} from the given array such that:
     * a + b + c + d == target
     *
     * @param nums   The array of integers to search.
     * @param target The target sum.
     * @return An Optional containing a valid Quadruplet if found, or empty otherwise.
     */
    public Optional<Quadruplet> findQuadruplet(int[] nums, int target) {
        Map<Integer, List<Pair>> pairSumMap = new HashMap<>();
        int n = nums.length;

        // Step 1: Store all unique pairs and their sums in the map
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                pairSumMap
                        .computeIfAbsent(sum, k -> new ArrayList<>())
                        .add(new Pair(i, j));
            }
        }

        // Step 2: Iterate again and look for a complementary pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int complement = target - (nums[i] + nums[j]);
                List<Pair> complements = pairSumMap.getOrDefault(complement, Collections.emptyList());

                for (Pair p : complements) {
                    // Ensure all indices are unique
                    if (p.i != i && p.i != j && p.j != i && p.j != j) {
                        return Optional.of(new Quadruplet(nums[p.i], nums[p.j], nums[i], nums[j]));
                    }
                }
            }
        }

        return Optional.empty();
    }

    /**
     * Represents a pair of indices in the original array.
     */
    private static class Pair {
        final int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
