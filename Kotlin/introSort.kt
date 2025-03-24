fun introSort(arr: IntArray) {
    val depthLimit = 2 * log2(arr.size.toDouble()).toInt()
    introSort(arr, 0, arr.size - 1, depthLimit)
}

private fun introSort(arr: IntArray, start: Int, end: Int, depthLimit: Int) {
    if (end - start <= 16) {
        insertionSort(arr, start, end)
    } else if (depthLimit == 0) {
        heapSort(arr, start, end)
    } else {
        val pivot = partition(arr, start, end)
        introSort(arr, start, pivot - 1, depthLimit - 1)
        introSort(arr, pivot + 1, end, depthLimit - 1)
    }
}

private fun insertionSort(arr: IntArray, start: Int, end: Int) {
    for (i in start + 1..end) {
        val key = arr[i]
        var j = i - 1
        while (j >= start && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}

private fun heapSort(arr: IntArray, start: Int, end: Int) {
    val n = end - start + 1
    for (i in n / 2 - 1 downTo start) {
        heapify(arr, n, i, start)
    }
    for (i in end downTo start + 1) {
        arr[start] = arr[i].also { arr[i] = arr[start] }
        heapify(arr, i - start, start, start)
    }
}

private fun heapify(arr: IntArray, n: Int, i: Int, start: Int) {
    var largest = i
    val left = 2 * (i - start) + 1 + start
    val right = 2 * (i - start) + 2 + start

    if (left < start + n && arr[left] > arr[largest]) {
        largest = left
    }
    if (right < start + n && arr[right] > arr[largest]) {
        largest = right
    }
    if (largest != i) {
        arr[i] = arr[largest].also { arr[largest] = arr[i] }
        heapify(arr, n, largest, start)
    }
}

private fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1
}

private fun log2(x: Double): Double {
    return Math.log(x) / Math.log(2.0)
}

fun main() {
    val arr = intArrayOf(10, 7, 8, 9, 1, 5, 0, -1, 3)
    introSort(arr)
    println("Sorted array: ${arr.joinToString(", ")}")
}
