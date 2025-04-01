fun minRunLength(n: Int): Int {
    var r = 0
    var length = n
    while (length >= 64) {
        r = r or (length and 1)
        length = length shr 1
    }
    return length + r
}

fun insertionSort(arr: IntArray, left: Int, right: Int) {
    for (i in left + 1..right) {
        val temp = arr[i]
        var j = i - 1
        while (j >= left && arr[j] > temp) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = temp
    }
}

fun merge(arr: IntArray, left: Int, mid: Int, right: Int) {
    val len1 = mid - left + 1
    val len2 = right - mid
    val leftArr = IntArray(len1)
    val rightArr = IntArray(len2)

    for (i in 0 until len1) leftArr[i] = arr[left + i]
    for (i in 0 until len2) rightArr[i] = arr[mid + 1 + i]

    var i = 0
    var j = 0
    var k = left

    while (i < len1 && j < len2) {
        if (leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i]
            i++
        } else {
            arr[k] = rightArr[j]
            j++
        }
        k++
    }

    while (i < len1) {
        arr[k] = leftArr[i]
        i++
        k++
    }

    while (j < len2) {
        arr[k] = rightArr[j]
        j++
        k++
    }
}

fun timSort(arr: IntArray) {
    val n = arr.size
    val minRun = minRunLength(n)

    for (i in 0 until n step minRun) {
        insertionSort(arr, i, kotlin.math.min(i + minRun - 1, n - 1))
    }

    var size = minRun
    while (size < n) {
        for (left in 0 until n step 2 * size) {
            val mid = left + size - 1
            val right = kotlin.math.min(left + 2 * size - 1, n - 1)

            if (mid < right) {
                merge(arr, left, mid, right)
            }
        }
        size *= 2
    }
}

fun main() {
    val arr = intArrayOf(5, 21, 7, 23, -7, 19, 0, 10, 3, 12, 8, -5, 15)
    timSort(arr)
    println("Sorted Array: ${arr.joinToString(", ")}")
}