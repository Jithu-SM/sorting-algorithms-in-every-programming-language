fun bitonicSort(arr: IntArray, low: Int, cnt: Int, dir: Boolean) {
    if (cnt > 1) {
        val k = cnt / 2
        bitonicSort(arr, low, k, true)
        bitonicSort(arr, low + k, k, false)
        bitonicMerge(arr, low, cnt, dir)
    }
}

fun bitonicMerge(arr: IntArray, low: Int, cnt: Int, dir: Boolean) {
    if (cnt > 1) {
        val k = cnt / 2
        for (i in low until low + k) {
            if (dir == (arr[i] > arr[i + k])) {
                val temp = arr[i]
                arr[i] = arr[i + k]
                arr[i + k] = temp
            }
        }
        bitonicMerge(arr, low, k, dir)
        bitonicMerge(arr, low + k, k, dir)
    }
}

fun sort(arr: IntArray, up: Boolean = true) {
    val n = arr.size
    val powerOfTwo = Integer.highestOneBit(n - 1) shl 1
    val paddedArr = arr.copyOf(powerOfTwo)
    for (i in n until powerOfTwo) {
        paddedArr[i] = Int.MAX_VALUE
    }
    bitonicSort(paddedArr, 0, powerOfTwo, up)
    for (i in 0 until n) {
        arr[i] = paddedArr[i]
    }
}

fun main() {
    val arr = intArrayOf(3, 7, 4, 8, 6, 2, 1, 5, 0)
    sort(arr)
    println("Sorted array: ${arr.joinToString(", ")}")
}