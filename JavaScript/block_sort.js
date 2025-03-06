function blockSort(arr, blockSize) {
    if (blockSize <= 0) {
        throw new Error("Block size must be greater than 0");
    }

    const n = arr.length;
    const sortedArr = [];

    for (let i = 0; i < n; i += blockSize) {
        const block = arr.slice(i, i + blockSize);
        block.sort((a, b) => a - b);
        sortedArr.push(...block);
    }

    return mergeSortedBlocks(sortedArr, blockSize);
}

function mergeSortedBlocks(arr, blockSize) {
    const n = arr.length;
    const result = [];
    const numBlocks = Math.ceil(n / blockSize);
    const pointers = Array(numBlocks).fill(0);

    while (result.length < n) {
        let minIndex = -1;
        let minValue = Infinity;

        for (let i = 0; i < numBlocks; i++) {
            const blockStart = i * blockSize;
            const blockEnd = Math.min(blockStart + blockSize, n);
            const pointer = pointers[i];

            if (pointer < blockEnd - blockStart) {
                const value = arr[blockStart + pointer];
                if (value < minValue) {
                    minValue = value;
                    minIndex = i;
                }
            }
        }

        if (minIndex !== -1) {
            result.push(minValue);
            pointers[minIndex]++;
        }
    }

    return result;
}

const arr = [5, 2, 9, 1, 5, 6, 0];
const blockSize = 2;
console.log(blockSort(arr, blockSize));