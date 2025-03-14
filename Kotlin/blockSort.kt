fun blockSort(arr: IntArray, blockSize: Int): IntArray {
    if (arr.isEmpty()) return arr

    val n = arr.size
    val sortedArr = arr.copyOf()
    val blocks = (n + blockSize - 1) / blockSize

    for (i in 0 until blocks) {
        val start = i * blockSize
        val end = minOf(start + blockSize, n)
        sortedArr.sort(start, end)
    }

    val result = IntArray(n)
    var index = 0
    for (i in 0 until blocks) {
        val start = i * blockSize
        val end = minOf(start + blockSize, n)
        for (j in start until end) {
            result[index++] = sortedArr[j]
        }
    }
    result.sort()

    return result
}

fun main() {
    val arr = intArrayOf(5, 2, 9, 1, 5, 6, 0)
    val blockSize = 2
    val sortedArr = blockSort(arr, blockSize)
    println(sortedArr.joinToString(", "))
}