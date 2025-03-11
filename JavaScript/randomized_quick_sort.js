function randomizedQuickSort(arr, low = 0, high = arr.length - 1) {
    if (low < high) {
        const pivotIndex = randomizedPartition(arr, low, high);
        randomizedQuickSort(arr, low, pivotIndex - 1);
        randomizedQuickSort(arr, pivotIndex + 1, high);
    }
    return arr;
}

function randomizedPartition(arr, low, high) {
    const randomIndex = Math.floor(Math.random() * (high - low + 1)) + low;
    [arr[randomIndex], arr[high]] = [arr[high], arr[randomIndex]];
    return partition(arr, low, high);
}

function partition(arr, low, high) {
    const pivot = arr[high];
    let i = low - 1;
    for (let j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            [arr[i], arr[j]] = [arr[j], arr[i]];
        }
    }
    [arr[i + 1], arr[high]] = [arr[high], arr[i + 1]];
    return i + 1;
}

const array = [10, 7, 8, 9, 1, 5, 0];
console.log("Sorted array:", randomizedQuickSort(array));