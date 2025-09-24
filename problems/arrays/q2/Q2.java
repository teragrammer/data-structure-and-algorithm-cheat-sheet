import java.util.Arrays;
import java.util.ArrayList;

/**
 * Given an array, 
 * rotate the array to the right by k steps, 
 * where k is non-negative.
 */

public class Q2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int[] array = {1, 2, 3, 4, 5};
        int k = 3;

        System.out.println(rotateArrayMethod1(arrayList, k));
        System.out.println(Arrays.toString(rotateArrayMethod2(array, k)));
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

    static int[] rotateArrayMethod2(int[] array, int k) {
        if (array.length == k || array.length == 0) {
            return array;
        }
        
        k = k % array.length;
        int tempArray[] = new int[k];

        // store last k elements in temp
        for (int i = 0; i < k; i++) {
            tempArray[i] = array[array.length - k + i];
        }

        // shift rest of array right by k
        for (int i = array.length - k - 1; i >= 0; i--) {
            array[i + k] = array[i];
        }

        // copy temp element to front
        for (int i = 0; i < k; i++) {
            array[i] = tempArray[i];
        }

        return array;
    }
}