package quadruplet;

import java.util.Arrays;

/**
 * Domain model representing a group of four integers that sum to a target.
 */
public class Quadruplet {
    private final int a, b, c, d;

    public Quadruplet(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int[] toArray() {
        return new int[]{a, b, c, d};
    }

    public int sum() {
        return a + b + c + d;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
