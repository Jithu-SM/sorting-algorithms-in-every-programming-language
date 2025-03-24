fun flip(arr: IntArray, k: Int) {
    var start = 0
    var end = k
    while (start < end) {
        val temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp
        start++
        end--
    }
}

fun findMax(arr: IntArray, n: Int): Int {
    var maxIndex = 0
    for (i in 1 until n) {
        if (arr[i] > arr[maxIndex]) {
            maxIndex = i
        }
    }
    return maxIndex
}

fun pancakeSort(arr: IntArray) {
    for (currSize in arr.size downTo 2) {
        val maxIndex = findMax(arr, currSize)
        if (maxIndex != currSize - 1) {
            flip(arr, maxIndex)
            flip(arr, currSize - 1)
        }
    }
}

fun main() {
    val arr = intArrayOf(3, 6, 1, 10, 7, 2, 0, -2, 4)
    pancakeSort(arr)
    println(arr.joinToString(", "))
}