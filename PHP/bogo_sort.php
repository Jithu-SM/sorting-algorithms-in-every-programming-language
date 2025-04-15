<?php

function isSorted($array) {
    for ($i = 0; $i < count($array) - 1; $i++) {
        if ($array[$i] > $array[$i + 1]) {
            return false;
        }
    }
    return true;
}

function shuffleArray(&$array) {
    for ($i = count($array) - 1; $i > 0; $i--) {
        $j = rand(0, $i);
        $temp = $array[$i];
        $array[$i] = $array[$j];
        $array[$j] = $temp;
    }
}

function bogoSort(&$array) {
    while (!isSorted($array)) {
        shuffleArray($array);
    }
}

$array = [3, 0, 5, 1, 4, -1];

bogoSort($array);

echo "Sorted Array: " . implode(", ", $array) . PHP_EOL;
?>
