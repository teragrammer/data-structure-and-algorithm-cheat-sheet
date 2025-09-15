import java.util.Arrays;

/**
 * Given an array, 
 * rotate the array to the right by k steps, 
 * where k is non-negative.
 */

public class Q2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int k = 1;

        System.out.println(Arrays.toString(rotateArrayMethod1(array, k)));
    }

    static int[] rotateArrayMethod1(int[] array, int k) {
        if (array.length == k || array.length == 0) {
            return array;
        }

        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (counter <= k) {
                // TODO
                int lastItem = array[array.length - 1];
                array[0] = lastItem;
                counter++;
            }
        }

        return array;
    }
}