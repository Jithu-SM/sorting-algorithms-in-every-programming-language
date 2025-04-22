<?php
function heapify(&$array, $n, $i) {
    $largest = $i;
    $left = 2 * $i + 1;
    $right = 2 * $i + 2;

    if ($left < $n && $array[$left] > $array[$largest]) {
        $largest = $left;
    }

    if ($right < $n && $array[$right] > $array[$largest]) {
        $largest = $right;
    }

    if ($largest != $i) {
        $temp = $array[$i];
        $array[$i] = $array[$largest];
        $array[$largest] = $temp;

        heapify($array, $n, $largest);
    }
}

function heapSort(&$array) {
    $n = count($array);

    for ($i = $n / 2 - 1; $i >= 0; $i--) {
        heapify($array, $n, $i);
    }

    for ($i = $n - 1; $i > 0; $i--) {
        $temp = $array[0];
        $array[0] = $array[$i];
        $array[$i] = $temp;

        heapify($array, $i, 0);
    }
}

$array = [12, 11, 13, 5, 6, 7, 0, -4,-1];
heapSort($array);

echo "Sorted array: ";
echo "[" . implode(", ", $array) . "]";
?>
