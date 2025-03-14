fun bucketSort(array: IntArray): IntArray {
    if (array.isEmpty()) return array

    val maxValue = array.maxOrNull() ?: return array
    val bucketCount = array.size
    val buckets = Array(bucketCount) { mutableListOf<Int>() }

    for (value in array) {
        val bucketIndex = (value * bucketCount) / (maxValue + 1)
        buckets[bucketIndex].add(value)
    }

    for (bucket in buckets) {
        bucket.sort()
    }

    var index = 0
    for (bucket in buckets) {
        for (value in bucket) {
            array[index++] = value
        }
    }

    return array
}

fun main() {
    val array = intArrayOf(42, 32, 23, 52, 25, 47, 51, 0)
    val sortedArray = bucketSort(array)
    println("Sorted array: ${sortedArray.joinToString(", ")}")
}
