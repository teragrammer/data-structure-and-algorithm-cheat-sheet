// Given an array, 
// rotate the array to the right by k steps, 
// where k is non-negative.

List<int> rotateArrayMethod1(List<int> array, int k) {
    if (array.length == k || array.length == 0) {
        return array;
    }

    int counter = 1;
    for (int i = 0; i < array.length; i++) {
        if (counter <= k) {
            int lastItem = array[array.length - 1];
            array.removeLast();
            array.insert(0, lastItem);
            counter++;
        }
    }

    return array;
}

void main() {
    List<int> array = [1, 2, 3, 4, 5];
    int k = 3;

    print(rotateArrayMethod1(array, k));
}