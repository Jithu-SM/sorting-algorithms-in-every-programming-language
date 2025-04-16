<?php

function bucketSort(array $arr): array {
    if (empty($arr)) {
        return $arr;
    }

    $min = min($arr);
    $max = max($arr);

    $bucketCount = ceil(sqrt(count($arr)));
    $bucketSize = ceil(($max - $min + 1) / $bucketCount);

    $buckets = array_fill(0, $bucketCount, []);

    foreach ($arr as $value) {
        $bucketIndex = (int)(($value - $min) / $bucketSize);
        $buckets[$bucketIndex][] = $value;
    }

    $sortedArray = [];
    foreach ($buckets as $bucket) {
        sort($bucket);
        $sortedArray = array_merge($sortedArray, $bucket);
    }

    return $sortedArray;
}

$input = [42, 32, 33, 52, 37, -20, 47, 51, 0, -45];
$sorted = bucketSort($input);

echo "Sorted Array: " . implode(", ", $sorted) . PHP_EOL;
?>
