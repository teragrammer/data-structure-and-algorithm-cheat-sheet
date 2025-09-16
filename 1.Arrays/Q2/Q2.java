import java.util.Arrays;
import java.util.ArrayList;

/**
 * Given an array, 
 * rotate the array to the right by k steps, 
 * where k is non-negative.
 */

public class Q2 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int k = 3;

        System.out.println(rotateArrayMethod1(array, k));
    }

    static ArrayList<Integer> rotateArrayMethod1(ArrayList<Integer> array, int k) {
        if (array.size() == k || array.size() == 0) {
            return array;
        }

        int counter = 1;
        for (int i = 0; i < array.size(); i++) {
            if (counter <= k) {
                int lastIndex = array.size() - 1;
                int lastItem = array.get(lastIndex);
                array.remove(lastIndex);
                array.add(0, lastItem);
                counter++;
            }
        }

        return array;
    }
}