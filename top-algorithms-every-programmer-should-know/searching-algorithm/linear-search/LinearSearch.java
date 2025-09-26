// Given a sorted array of n integers and a target value, 
// determine if the target exists in the array. 
// If target exists in the array, print the index of it.

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int target = 3;

        System.out.println(search(array, target));
    }

    static int search(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return 0;
    }
}
