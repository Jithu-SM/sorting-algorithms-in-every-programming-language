import random

def is_sorted(arr):
    return all(arr[i] <= arr[i + 1] for i in range(len(arr) - 1))

def bogo_sort(arr):
    while not is_sorted(arr):
        random.shuffle(arr)
    return arr

arr = [3, 7, 4, 8, 6, 2, 0]
print(bogo_sort(arr))