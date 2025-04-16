<?php

function blockSort(array $arr): array {
    $n = count($arr);
    if ($n <= 1) {
        return $arr;
    }

    $min = min($arr);
    $max = max($arr);

    $range = $max - $min + 1;
    $blockSize = ceil($range / $n);
    $blocks = array_fill(0, $n, []);

    foreach ($arr as $value) {
        $index = (int)(($value - $min) / $blockSize);
        $blocks[$index][] = $value;
    }

    $sortedArray = [];
    foreach ($blocks as $block) {
        sort($block);
        $sortedArray = array_merge($sortedArray, $block);
    }

    return $sortedArray;
}

$array = [29, 25, 3, 49, 9, 37, 21, 43, 0, -7, 3];
$sortedArray = blockSort($array);

echo "Sorted Array: " . implode(", ", $sortedArray) . PHP_EOL;
?>
