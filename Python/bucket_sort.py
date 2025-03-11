import math

def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
    return arr

def bucket_sort(arr):
    if len(arr) == 0:
        return arr

    max_val = max(arr)
    min_val = min(arr)
    bucket_count = len(arr)
    size = math.ceil((max_val - min_val + 1) / bucket_count)

    buckets = [[] for _ in range(bucket_count)]
    for num in arr:
        index = (num - min_val) // size
        buckets[index].append(num)

    for i in range(len(buckets)):
        buckets[i] = insertion_sort(buckets[i])

    result = []
    for bucket in buckets:
        result.extend(bucket)
    return result

arr = [3, 7, 4, 8, 6, 2, 1, 5, 0, -5, -2]
print(bucket_sort(arr))