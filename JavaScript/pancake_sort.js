function flip(arr, end) {
    let start = 0;
    while (start < end) {
        [arr[start], arr[end]] = [arr[end], arr[start]];
        start++;
        end--;
    }
}

function findMaxIndex(arr, n) {
    let maxIndex = 0;
    for (let i = 1; i <= n; i++) {
        if (arr[i] > arr[maxIndex]) {
            maxIndex = i;
        }
    }
    return maxIndex;
}

function pancakeSort(arr) {
    for (let currSize = arr.length; currSize > 1; currSize--) {
        let maxIndex = findMaxIndex(arr, currSize - 1);

        if (maxIndex !== currSize - 1) {
            flip(arr, maxIndex);
            flip(arr, currSize - 1);
        }
    }
    return arr;
}

const arr = [3, 6, 2, 7, 4, 1, 5, 0];
const sortedArr = pancakeSort(arr);
console.log("Sorted array:", sortedArr);
