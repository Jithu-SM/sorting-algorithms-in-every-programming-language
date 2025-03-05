function bitonicSort(arr, ascending = true) {
    function compareAndSwap(arr, i, j, direction) {
        if ((arr[i] > arr[j]) === direction) {
            [arr[i], arr[j]] = [arr[j], arr[i]];
        }
    }

    function bitonicMerge(arr, start, length, direction) {
        if (length > 1) {
            let mid = Math.floor(length / 2);
            for (let i = start; i < start + mid; i++) {
                compareAndSwap(arr, i, i + mid, direction);
            }
            bitonicMerge(arr, start, mid, direction);
            bitonicMerge(arr, start + mid, mid, direction);
        }
    }

    function bitonicSortRecursive(arr, start, length, direction) {
        if (length > 1) {
            let mid = Math.floor(length / 2);
            bitonicSortRecursive(arr, start, mid, true);
            bitonicSortRecursive(arr, start + mid, mid, false);
            bitonicMerge(arr, start, length, direction);
        }
    }

    let n = arr.length;
    let nextPowerOf2 = 1;
    while (nextPowerOf2 < n) nextPowerOf2 *= 2;

    let paddedArray = [...arr, ...Array(nextPowerOf2 - n).fill(Infinity)];

    bitonicSortRecursive(paddedArray, 0, paddedArray.length, ascending);

    return paddedArray.filter(num => num !== Infinity);
}

console.log(bitonicSort([3, 7, 2, 8, 6, 1, 5, 4, 0]));  