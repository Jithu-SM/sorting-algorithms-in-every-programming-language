def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


arr = [3, 7, 4, 8, 6, 2, 1, 5, 0, -5, -2]
print(bubble_sort(arr))