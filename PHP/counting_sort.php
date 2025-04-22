<?php

function countingSort($array) {
    $max = max($array);
    $min = min($array);
    $range = $max - $min + 1;

    $count = array_fill(0, $range, 0);

    foreach ($array as $num) {
        $count[$num - $min]++;
    }

    $sortedArray = [];
    for ($i = 0; $i < $range; $i++) {
        while ($count[$i] > 0) {
            $sortedArray[] = $i + $min;
            $count[$i]--;
        }
    }

    return $sortedArray;
}

$array = [4, 2, 2, 8, 3, 3, 1, -8, 1, 0];
$sortedArray = countingSort($array);

echo "Sorted Array: " . implode(", ", $sortedArray) . PHP_EOL;
?>