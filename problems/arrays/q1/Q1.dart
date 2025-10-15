import 'dart:math';

List<int> sortedSquaredMethod1(List<int> array) {
    List<int> newArray = List.filled(array.length, 0);

    for (int i = 0; i < array.length; i++) {
        int base = array[i];
        newArray[i] = (pow(base, 2)).toInt();
    }

    // TODO
    // sort
    return newArray;
}

void main() {
    List<int> array = [5, 4, 3, 2, 1, 0];

    print(sortedSquaredMethod1(array));
}