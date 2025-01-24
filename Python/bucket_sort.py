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
        bucket.sort()
    result = []
    for bucket in buckets:
        result.extend(bucket)
    return result