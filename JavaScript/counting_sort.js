function countingSort(arr) {
    if (arr.length === 0) return arr;

    const max = Math.max(...arr);
    const min = Math.min(...arr);

    const count = new Array(max - min + 1).fill(0);

    for (let i = 0; i < arr.length; i++) {
        count[arr[i] - min]++;
    }

    let sortedIndex = 0;
    for (let i = 0; i < count.length; i++) {
        while (count[i] > 0) {
            arr[sortedIndex++] = i + min;
            count[i]--;
        }
    }

    return arr;
}

const arr = [4, 2, 2, 8, 3, 3, 1];
console.log(countingSort(arr));