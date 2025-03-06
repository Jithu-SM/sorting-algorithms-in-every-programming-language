function bogoSort(arr) {
    function isSorted(arr) {
        for (let i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    function shuffle(arr) {
        for (let i = arr.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [arr[i], arr[j]] = [arr[j], arr[i]];
        }
    }

    while (!isSorted(arr)) {
        shuffle(arr);
    }

    return arr;
}

const array = [3, 2, 5, 1, 4, 0];
const sortedArray = bogoSort(array);
console.log("Sorted array:", sortedArray);