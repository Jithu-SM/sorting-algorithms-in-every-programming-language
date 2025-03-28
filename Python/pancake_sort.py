def flip(arr, k):
    arr[:k] = reversed(arr[:k])

def pancake_sort(arr):
    n = len(arr)
    for curr_size in range(n, 1, -1):
        max_idx = arr.index(max(arr[:curr_size]))
        if max_idx != curr_size - 1:
            flip(arr, max_idx + 1)
            flip(arr, curr_size)
    return arr

arr = [3, 7, 4, 8, 6, 2, 1, 5, 0, -2]
print(pancake_sort(arr))