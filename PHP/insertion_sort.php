<?php
function insertionSort(array $arr): array {
    $n = count($arr);
    for ($i = 1; $i < $n; $i++) {
        $key = $arr[$i];
        $j = $i - 1;

        while ($j >= 0 && $arr[$j] > $key) {
            $arr[$j + 1] = $arr[$j];
            $j--;
        }
        $arr[$j + 1] = $key;
    }
    return $arr;
}

$unsortedArray = [64, 34, 25, 12, 22, 11, 90, -89, 0, -45];
$sortedArray = insertionSort($unsortedArray);

echo "Sorted Array: " . implode(", ", $sortedArray);
?>
