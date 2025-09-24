import java.util.Arrays;

/**
 * Sorted Squared Array - You are given an array of 
 * Integers in which each subsequent value is not 
 * less than the previous value. Write a function 
 * that takes this array as an input and returns a 
 * new array with the squares of each number sorted 
 * in ascending order.
 */

public class Q1 {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 0};

        System.out.println(Arrays.toString(sortedArrayMethod1(array)));
        System.out.println(Arrays.toString(sortedArrayMethod2(array)));
    }

    static int[] sortedArrayMethod1(int[] array) {
        int newArray[] = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = (int) Math.pow(array[i], 2);
        }

        // sort
        Arrays.sort(newArray);

        return newArray;
    }

    static int[] sortedArrayMethod2(int[] array) {
        int newArray[] = new int[array.length];

        int leftPointer = 0;
        int rightPointer = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            int squaredLeft = (int) Math.pow(array[leftPointer], 2);
            int squaredRight = (int) Math.pow(array[rightPointer], 2);
            
            if (squaredLeft < squaredRight) {
                newArray[i] = squaredLeft;
                leftPointer++;
            } else {
                newArray[i] = squaredRight;
                rightPointer--;
            }
        }

        return newArray;
    }
}