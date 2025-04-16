<?php

function bubbleSort(array $arr): array {
    $n = count($arr);
    for ($i = 0; $i < $n - 1; $i++) {
        for ($j = 0; $j < $n - $i - 1; $j++) {
            if ($arr[$j] > $arr[$j + 1]) {
                $temp = $arr[$j];
                $arr[$j] = $arr[$j + 1];
                $arr[$j + 1] = $temp;
            }
        }
    }
    return $arr;
}

$numbers = [64, 34, 25, 12, 22, 11, 90, -50, 0, -89];

$sortedNumbers = bubbleSort($numbers);
echo "Sorted Array: " . implode(", ", $sortedNumbers) . PHP_EOL;
?>
