function bucketSort(arr, bucketSize = 5) {
    if (arr.length === 0) {
        return arr;
    }

    let minValue = arr[0];
    let maxValue = arr[0];
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] < minValue) {
            minValue = arr[i];
        } else if (arr[i] > maxValue) {
            maxValue = arr[i];
        }
    }

    let bucketCount = Math.floor((maxValue - minValue) / bucketSize) + 1;
    let buckets = new Array(bucketCount);
    for (let i = 0; i < buckets.length; i++) {
        buckets[i] = [];
    }

    for (let i = 0; i < arr.length; i++) {
        buckets[Math.floor((arr[i] - minValue) / bucketSize)].push(arr[i]);
    }

    arr.length = 0;
    for (let i = 0; i < buckets.length; i++) {
        buckets[i].sort((a, b) => a - b);
        arr.push(...buckets[i]);
    }

    return arr;
}

const array = [29, 25, 3, 49, 9, 37, 21, 43, 0];
console.log('Sorted array:', bucketSort(array));