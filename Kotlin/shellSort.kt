fun shellSort(arr: IntArray) {
    val n = arr.size
    var gap = n / 2

    while (gap > 0) {
        for (i in gap until n) {
            val temp = arr[i]
            var j = i

            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap]
                j -= gap
            }
            arr[j] = temp
        }
        gap /= 2
    }
}

fun main() {
    val array = intArrayOf(12, 34, 54, -5, 2, -1, 3, 0)
    shellSort(array)
    println("Sorted Array: ${array.joinToString(", ")}")
}