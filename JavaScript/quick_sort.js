function quickSort(arr) {
    if (arr.length <= 1) {
        return arr;
    }

    const pivot = arr[arr.length - 1];
    const left = [];
    const right = [];

    for (const el of arr.slice(0, arr.length - 1)) {
        if (el < pivot) {
            left.push(el);
        } else {
            right.push(el);
        }
    }

    return [...quickSort(left), pivot, ...quickSort(right)];
}

const array = [3, 6, 8, 10, 1, 2, 1, 0];
console.log(quickSort(array));
