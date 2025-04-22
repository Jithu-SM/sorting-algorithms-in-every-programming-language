<?php

function mergeSort(array $array): array {
    if (count($array) <= 1) {
        return $array;
    }

    $middle = intdiv(count($array), 2);

    $left = array_slice($array, 0, $middle);
    $right = array_slice($array, $middle);

    $left = mergeSort($left);
    $right = mergeSort($right);

    return merge($left, $right);
}

function merge(array $left, array $right): array {
    $result = [];
    $i = $j = 0;

    while ($i < count($left) && $j < count($right)) {
        if ($left[$i] <= $right[$j]) {
            $result[] = $left[$i];
            $i++;
        } else {
            $result[] = $right[$j];
            $j++;
        }
    }

    while ($i < count($left)) {
        $result[] = $left[$i];
        $i++;
    }

    while ($j < count($right)) {
        $result[] = $right[$j];
        $j++;
    }

    return $result;
}

$array = [38, 27, 43, 3, 9, 82, 10, 0, -98, -67];

$sortedArray = mergeSort($array);
echo "Sorted Array: " . implode(", ", $sortedArray) . PHP_EOL;
?>
