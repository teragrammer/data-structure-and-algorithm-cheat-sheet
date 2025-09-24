<?php
/**
 * Sorted Squared Array - You are given an array of 
 * Integers in which each subsequent value is not 
 * less than the previous value. Write a function 
 * that takes this array as an input and returns a 
 * new array with the squares of each number sorted 
 * in ascending order.
 */

function sortedArrayMethod1($array = []) {
    $newArray = array_fill(0, count($array), 0);

    for ($i = 0; $i < count($array); $i++) {
        $newArray[$i] = $array[$i] ** 2;
    }

    sort($newArray);
    return $newArray;
}

function sortedArrayMethod2($array = []) {
    $newArray = array_fill(0, count($array), 0);

    $pointerLeft = 0;
    $pointerRight = count($array) - 1;

    for ($i = 0; $i < count($array); $i++) {
        $squaredLeft = $array[$pointerLeft] ** 2;
        $squaredRight = $array[$pointerRight] ** 2;

        if ($squaredLeft < $squaredRight) {
            $newArray[$i] = $squaredLeft;
            $pointerLeft++;
        } else {
            $newArray[$i] = $squaredRight;
            $pointerRight--;
        }
    }

    return $newArray;
}

print_r(sortedArrayMethod1([5, 4, 3, 2, 1, 0]));
print_r(sortedArrayMethod2([5, 4, 3, 2, 1, 0]));