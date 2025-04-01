fun getMax(arr: IntArray): Int {
    var max = arr[0]
    for (i in arr) {
        if (i > max) max = i
    }
    return max
}

fun countingSort(arr: IntArray, exp: Int) {
    val output = IntArray(arr.size)
    val count = IntArray(10)

    for (i in arr) {
        count[(i / exp) % 10]++
    }

    for (i in 1 until 10) {
        count[i] += count[i - 1]
    }

    for (i in arr.size - 1 downTo 0) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i]
        count[(arr[i] / exp) % 10]--
    }

    for (i in arr.indices) {
        arr[i] = output[i]
    }
}

fun radixSort(arr: IntArray) {
    val max = getMax(arr)
    var exp = 1
    while (max / exp > 0) {
        countingSort(arr, exp)
        exp *= 10
    }
}

fun radixSortWithNegatives(arr: IntArray) {
    val negatives = arr.filter { it < 0 }.map { -it }.toIntArray()
    val nonNegatives = arr.filter { it >= 0 }.toIntArray()

    if (negatives.isNotEmpty()) radixSort(negatives)
    if (nonNegatives.isNotEmpty()) radixSort(nonNegatives)

    for (i in negatives.indices) {
        arr[i] = -negatives[negatives.size - 1 - i]
    }
    for (i in nonNegatives.indices) {
        arr[negatives.size + i] = nonNegatives[i]
    }
}

fun main() {
    val arr = intArrayOf(170, 45, 75, 90, 802, 24, 2, 66, -1, 0, -78)
    radixSortWithNegatives(arr)
    println("Sorted array: ${arr.joinToString(", ")}")
}
