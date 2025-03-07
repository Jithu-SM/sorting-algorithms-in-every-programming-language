function cocktailShakerSort(arr) {
    let isSorted = true;
    do {
        isSorted = true;
        for (let i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                [arr[i], arr[i + 1]] = [arr[i + 1], arr[i]];
                isSorted = false;
            }
        }
        if (isSorted) break;
        isSorted = true;
        for (let i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                [arr[i], arr[i - 1]] = [arr[i - 1], arr[i]];
                isSorted = false;
            }
        }
    } while (!isSorted);
    return arr;
}

const array = [5, 3, 8, 4, 2, 0];
console.log(cocktailShakerSort(array));