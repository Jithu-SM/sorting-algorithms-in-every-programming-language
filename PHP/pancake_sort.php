<?php

function flip(&$arr, $i) {
    $start = 0;
    while ($start < $i) {
        $temp = $arr[$start];
        $arr[$start] = $arr[$i];
        $arr[$i] = $temp;
        $start++;
        $i--;
    }
}

function findMaxIndex($arr, $n) {
    $maxIndex = 0;
    for ($i = 1; $i < $n; $i++) {
        if ($arr[$i] > $arr[$maxIndex]) {
            $maxIndex = $i;
        }
    }
    return $maxIndex;
}

function pancakeSort(&$arr) {
    $n = count($arr);
    for ($currSize = $n; $currSize > 1; $currSize--) {
        $maxIndex = findMaxIndex($arr, $currSize);

        if ($maxIndex != $currSize - 1) {
            flip($arr, $maxIndex);
            flip($arr, $currSize - 1);
        }
    }
}

$arr = [3, 6, 1, 8, 4, 5, -9, 0, -3];

pancakeSort($arr);

echo "Sorted Array: " . implode(", ", $arr) . "\n";
?>

