<?php
function introSort(array &$arr): void {
    $n = count($arr);
    $maxDepth = (int)(2 * log($n, 2));
    introSortHelper($arr, 0, $n - 1, $maxDepth);
}

function introSortHelper(array &$arr, int $low, int $high, int $depthLimit): void {
    if ($high - $low <= 16) {
        insertionSort($arr, $low, $high);
    } elseif ($depthLimit == 0) {
        heapSort($arr, $low, $high);
    } else {
        $pivot = partition($arr, $low, $high);
        introSortHelper($arr, $low, $pivot - 1, $depthLimit - 1);
        introSortHelper($arr, $pivot + 1, $high, $depthLimit - 1);
    }
}

function partition(array &$arr, int $low, int $high): int {
    $pivot = $arr[$high];
    $i = $low - 1;
    for ($j = $low; $j < $high; $j++) {
        if ($arr[$j] <= $pivot) {
            $i++;
            swap($arr, $i, $j);
        }
    }
    swap($arr, $i + 1, $high);
    return $i + 1;
}

function insertionSort(array &$arr, int $low, int $high): void {
    for ($i = $low + 1; $i <= $high; $i++) {
        $key = $arr[$i];
        $j = $i - 1;
        while ($j >= $low && $arr[$j] > $key) {
            $arr[$j + 1] = $arr[$j];
            $j--;
        }
        $arr[$j + 1] = $key;
    }
}

function heapSort(array &$arr, int $low, int $high): void {
    $size = $high - $low + 1;
    for ($i = $low + (int)($size / 2) - 1; $i >= $low; $i--) {
        heapify($arr, $size, $i, $low);
    }
    for ($i = $high; $i > $low; $i--) {
        swap($arr, $low, $i);
        heapify($arr, $i - $low, $low, $low);
    }
}

function heapify(array &$arr, int $size, int $root, int $offset): void {
    $largest = $root;
    $left = 2 * ($root - $offset) + 1 + $offset;
    $right = 2 * ($root - $offset) + 2 + $offset;

    if ($left < $offset + $size && $arr[$left] > $arr[$largest]) {
        $largest = $left;
    }
    if ($right < $offset + $size && $arr[$right] > $arr[$largest]) {
        $largest = $right;
    }
    if ($largest != $root) {
        swap($arr, $root, $largest);
        heapify($arr, $size, $largest, $offset);
    }
}

function swap(array &$arr, int $i, int $j): void {
    $temp = $arr[$i];
    $arr[$i] = $arr[$j];
    $arr[$j] = $temp;
}

$arr = [10, 3, 76, 34, 23, 32, -56, -2, 0];
introSort($arr);
echo '[' . implode(', ', $arr) . ']';

?>
