import kotlin.random.Random

fun randomizedQuickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = randomizedPartition(arr, low, high)
        randomizedQuickSort(arr, low, pivotIndex - 1)
        randomizedQuickSort(arr, pivotIndex + 1, high)
    }
}

fun randomizedPartition(arr: IntArray, low: Int, high: Int): Int {
    val randomIndex = Random.nextInt(low, high + 1)
    arr.swap(randomIndex, high)
    return partition(arr, low, high)
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            arr.swap(i, j)
        }
    }
    arr.swap(i + 1, high)
    return i + 1
}

fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun main() {
    val arr = intArrayOf(10, 7, 8, 9, 1, 5, 0, -1, -5)
    randomizedQuickSort(arr, 0, arr.size - 1)
    println("Sorted array: ${arr.joinToString(", ")}")
}