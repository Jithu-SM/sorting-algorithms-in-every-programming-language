fun countingSort(arr: IntArray): IntArray {
    if (arr.isEmpty()) return arr

    val max = arr.maxOrNull() ?: return arr
    val min = arr.minOrNull() ?: return arr
    val range = max - min + 1
    val count = IntArray(range)
    val output = IntArray(arr.size)

    for (num in arr) {
        count[num - min]++
    }

    for (i in 1 until count.size) {
        count[i] += count[i - 1]
    }

    for (i in arr.indices.reversed()) {
        output[count[arr[i] - min] - 1] = arr[i]
        count[arr[i] - min]--
    }

    return output
}

fun main() {
    val arr = intArrayOf(4, 2, 2, 8, 3, 3, 1, 0, -8)
    val sortedArr = countingSort(arr)
    println(sortedArr.joinToString(", "))
}