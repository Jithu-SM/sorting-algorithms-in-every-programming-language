<?php

function gnomeSort(array $arr): array {
    $index = 0;
    $n = count($arr);

    while ($index < $n) {
        if ($index == 0 || $arr[$index] >= $arr[$index - 1]) {
            $index++;
        } else {
            [$arr[$index], $arr[$index - 1]] = [$arr[$index - 1], $arr[$index]];
            $index--;
        }
    }

    return $arr;
}

$unsortedArray = [34, 2, 10, -9, 7, 0, 78, -66];
$sortedArray = gnomeSort($unsortedArray);

echo "Sorted Array: " . implode(", ", $sortedArray) . PHP_EOL;
?>
