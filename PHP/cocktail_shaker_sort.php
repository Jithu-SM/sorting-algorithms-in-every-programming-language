<?php
function cocktailShakerSort(&$arr) {
    $n = count($arr);
    $swapped = true;
    $start = 0;
    $end = $n - 1;

    while ($swapped) {
        $swapped = false;

        for ($i = $start; $i < $end; $i++) {
            if ($arr[$i] > $arr[$i + 1]) {
                $temp = $arr[$i];
                $arr[$i] = $arr[$i + 1];
                $arr[$i + 1] = $temp;
                $swapped = true;
            }
        }

        if (!$swapped) {
            break;
        }

        $swapped = false;
        $end--;

        for ($i = $end - 1; $i >= $start; $i--) {
            if ($arr[$i] > $arr[$i + 1]) {
                $temp = $arr[$i];
                $arr[$i] = $arr[$i + 1];
                $arr[$i + 1] = $temp;
                $swapped = true;
            }
        }

        $start++;
    }
}

$array = [5, 3, 8, 4, 2, 7, 1, 10, -8, 1, -11];

cocktailShakerSort($array);

echo "Sorted Array:\n";
echo "[" . implode(", ", $array) . "]\n";
