fun mergeSort(arr: IntArray): IntArray {
    if (arr.size <= 1) {
        return arr
    }

    val middle = arr.size / 2
    val left = arr.sliceArray(0 until middle)
    val right = arr.sliceArray(middle until arr.size)

    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: IntArray, right: IntArray): IntArray {
    var leftIndex = 0
    var rightIndex = 0
    val result = IntArray(left.size + right.size)

    for (i in result.indices) {
        when {
            leftIndex >= left.size -> {
                result[i] = right[rightIndex++]
            }
            rightIndex >= right.size -> {
                result[i] = left[leftIndex++]
            }
            left[leftIndex] <= right[rightIndex] -> {
                result[i] = left[leftIndex++]
            }
            else -> {
                result[i] = right[rightIndex++]
            }
        }
    }
    return result
}

fun main() {
    val arr = intArrayOf(38, 27, 43, 3, 9, 82, 10, -1, 0, 23, 7)
    val sortedArr = mergeSort(arr)
    println(sortedArr.joinToString(", "))
}
