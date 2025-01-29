import math

def insertion_sort(arr, start, end):
    for i in range(start + 1, end + 1):
        key = arr[i]
        j = i - 1
        while j >= start and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

def merge(arr, left, mid, right):
    left_part = arr[left:mid + 1]
    right_part = arr[mid + 1:right + 1]
    
    i = j = 0
    k = left
    
    while i < len(left_part) and j < len(right_part):
        if left_part[i] < right_part[j]:
            arr[k] = left_part[i]
            i += 1
        else:
            arr[k] = right_part[j]
            j += 1
        k += 1

    while i < len(left_part):
        arr[k] = left_part[i]
        i += 1
        k += 1

    while j < len(right_part):
        arr[k] = right_part[j]
        j += 1
        k += 1

def block_merge_sort(arr, left, right):
    if left < right:
        mid = left + (right - left) // 2
        block_merge_sort(arr, left, mid)
        block_merge_sort(arr, mid + 1, right)
        merge(arr, left, mid, right)

def block_sort(arr):
    n = len(arr)
    block_size = int(math.sqrt(n)) 

    for i in range(0, n, block_size):
        insertion_sort(arr, i, min(i + block_size - 1, n - 1))

    block_merge_sort(arr, 0, n - 1)

    return arr