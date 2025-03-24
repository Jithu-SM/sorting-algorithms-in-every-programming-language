fun insertionSort(arr: Array<Int>) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j -= 1
        }
        arr[j + 1] = key
    }
}

fun main() {
    val arr = arrayOf(12, 11, 13, 5, 6, 0, -1, 2)
    insertionSort(arr)
    println("Sorted array: ${arr.joinToString(", ")}")
}