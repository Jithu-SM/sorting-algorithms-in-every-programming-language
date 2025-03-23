fun gnomeSort(arr: IntArray) {
    var index = 0
    while (index < arr.size) {
        if (index == 0 || arr[index] >= arr[index - 1]) {
            index++
        } else {
            val temp = arr[index]
            arr[index] = arr[index - 1]
            arr[index - 1] = temp
            index--
        }
    }
}

fun main() {
    val arr = intArrayOf(34, 2, 10, -9, 7, 0)
    gnomeSort(arr)
    println("Sorted array: ${arr.joinToString(", ")}")
}