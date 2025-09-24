<?php
// Given an array, 
// rotate the array to the right by k steps, 
// where k is non-negative.

function rotateArrayMethod1($array = [], $k) {
    if (count($array) == $k OR count($array) == 0) {
        return $array;
    }

    $counter = 1;
    for ($i = 0; $i < count($array); $i++) {
        if ($counter <= $k) {
            $lastItem = array_pop($array);
            array_unshift($array, $lastItem);
            $counter++;
        }
    }

    return $array;
}

$array = [1, 2, 3, 4, 5];
$k = 3;

print_r(rotateArrayMethod1($array, $k));