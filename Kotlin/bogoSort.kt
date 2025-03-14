import kotlin.random.Random

fun isSorted(arr: IntArray): Boolean {
    for (i in 0 until arr.size - 1) {
        if (arr[i] > arr[i + 1]) {
            return false
        }
    }
    return true
}

fun shuffle(arr: IntArray) {
    for (i in arr.indices) {
        val randomIndex = Random.nextInt(arr.size)
        val temp = arr[i]
        arr[i] = arr[randomIndex]
        arr[randomIndex] = temp
    }
}

fun bogoSort(arr: IntArray) {
    while (!isSorted(arr)) {
        shuffle(arr)
    }
}

fun main() {
    val arr = intArrayOf(3, 2, 5, 1, 4, 0)
    bogoSort(arr)
    println(arr.joinToString(", "))
}