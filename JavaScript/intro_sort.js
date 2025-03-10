function insertionSort(arr, left, right) {
    for (let i = left + 1; i <= right; i++) {
        let key = arr[i];
        let j = i - 1;
        while (j >= left && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

function partition(arr, low, high) {
    let pivot = arr[high];
    let i = low - 1;
    for (let j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            [arr[i], arr[j]] = [arr[j], arr[i]];
        }
    }
    [arr[i + 1], arr[high]] = [arr[high], arr[i + 1]];
    return i + 1;
}

function quickSort(arr, low, high, depthLimit) {
    if (low < high) {
        if (depthLimit === 0) {
            heapSort(arr, low, high);
            return;
        }
        let pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1, depthLimit - 1);
        quickSort(arr, pi + 1, high, depthLimit - 1);
    }
}

function heapify(arr, n, i) {
    let largest = i;
    let left = 2 * i + 1;
    let right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest]) {
        largest = left;
    }

    if (right < n && arr[right] > arr[largest]) {
        largest = right;
    }

    if (largest !== i) {
        [arr[i], arr[largest]] = [arr[largest], arr[i]];
        heapify(arr, n, largest);
    }
}

function heapSort(arr, low, high) {
    let n = high - low + 1;
    for (let i = Math.floor(n / 2) - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }
    for (let i = n - 1; i > 0; i--) {
        [arr[0], arr[i]] = [arr[i], arr[0]];
        heapify(arr, i, 0);
    }
}

function introSort(arr) {
    let n = arr.length;
    let depthLimit = 2 * Math.floor(Math.log(n) / Math.log(2));
    quickSort(arr, 0, n - 1, depthLimit);
    insertionSort(arr, 0, n - 1);
}

let arr = [10, 7, 8, 9, 1, 5, 0];
introSort(arr);
console.log("Sorted array:", arr);