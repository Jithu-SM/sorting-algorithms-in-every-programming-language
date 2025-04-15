<?php
function padArrayToPowerOfTwo(&$arr) {
    $n = count($arr);
    $nextPowerOfTwo = pow(2, ceil(log($n, 2)));
    while (count($arr) < $nextPowerOfTwo) {
        $arr[] = PHP_INT_MAX;
    }
}

function bitonicSort(&$arr, $low, $count, $ascending) {
    if ($count > 1) {
        $k = intval($count / 2);
        bitonicSort($arr, $low, $k, true);
        bitonicSort($arr, $low + $k, $k, false);
        bitonicMerge($arr, $low, $count, $ascending);
    }
}

function bitonicMerge(&$arr, $low, $count, $ascending) {
    if ($count > 1) {
        $k = intval($count / 2);
        for ($i = $low; $i < $low + $k; $i++) {
            if (($ascending && $arr[$i] > $arr[$i + $k]) || (!$ascending && $arr[$i] < $arr[$i + $k])) {
                $temp = $arr[$i];
                $arr[$i] = $arr[$i + $k];
                $arr[$i + $k] = $temp;
            }
        }
        bitonicMerge($arr, $low, $k, $ascending);
        bitonicMerge($arr, $low + $k, $k, $ascending);
    }
}

$arr = [3, 7, 2, 8, 1, 5, 4, 6, -4, 0, 1];
padArrayToPowerOfTwo($arr);

$n = count($arr);
bitonicSort($arr, 0, $n, true);

$arr = array_filter($arr, fn($x) => $x !== PHP_INT_MAX);

echo "Sorted array: " . implode(", ", $arr) . PHP_EOL;
?>
