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
    max_val = max(arr)
    size = max_val // len(arr)
    buckets = [[] for _ in range(len(arr))]
    for num in arr:
        index = num // size
        if index != len(arr):
            buckets[index].append(num)
        else:
            buckets[len(arr) - 1].append(num)
    for bucket in buckets:
        bucket=insertion_sort(bucket)
    result = []
    for bucket in buckets:
        result.extend(bucket)
    return result
