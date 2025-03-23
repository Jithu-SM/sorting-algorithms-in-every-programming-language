fun cocktailShakerSort(arr: IntArray) {
    var swapped: Boolean
    var start = 0
    var end = arr.size - 1

    do {
        swapped = false

        for (i in start until end) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp
                swapped = true
            }
        }

        if (!swapped) break

        swapped = false
        end--

        for (i in end - 1 downTo start) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp
                swapped = true
            }
        }

        start++
    } while (swapped)
}

fun main() {
    val arr = intArrayOf(5, 1, 4, 2, 8, 0, 2, -5)
    cocktailShakerSort(arr)
    println("Sorted array: ${arr.joinToString(", ")}")
}