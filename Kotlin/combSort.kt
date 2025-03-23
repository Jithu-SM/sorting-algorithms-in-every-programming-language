fun combSort(arr: IntArray) {
    val n = arr.size
    var gap = n
    var swapped = true

    while (gap != 1 || swapped) {
        gap = getNextGap(gap)
        swapped = false

        for (i in 0 until n - gap) {
            if (arr[i] > arr[i + gap]) {
                val temp = arr[i]
                arr[i] = arr[i + gap]
                arr[i + gap] = temp
                swapped = true
            }
        }
    }
}

fun getNextGap(gap: Int): Int {
    val newGap = (gap * 10) / 13
    return if (newGap < 1) 1 else newGap
}

fun main() {
    val arr = intArrayOf(8, 4, 1, 56, 3, -44, 23, -6, 28, 0, -1)
    combSort(arr)
    println("Sorted array: ${arr.joinToString(", ")}")
}