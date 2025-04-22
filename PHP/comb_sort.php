<?php

function combSort(array $arr): array {
    $gap = count($arr);
    $shrink = 1.3;
    $sorted = false;

    while (!$sorted) {
        $gap = (int)($gap / $shrink);
        if ($gap <= 1) {
            $gap = 1;
            $sorted = true;
        }

        for ($i = 0; $i + $gap < count($arr); $i++) {
            if ($arr[$i] > $arr[$i + $gap]) {
                [$arr[$i], $arr[$i + $gap]] = [$arr[$i + $gap], $arr[$i]];
                $sorted = false;
            }
        }
    }

    return $arr;
}

$array = [64, 34, 25, 12, 22, 11, 90, -56, 0, -44];
$sortedArray = combSort($array);

echo "Sorted Array: " . implode(", ", $sortedArray) . PHP_EOL;
?>
