def counting_sort(arr):
    max_val = max(arr)
    count = [0] * (max_val + 1)
    for num in arr:
        count[num] += 1
    output = []
    for i, cnt in enumerate(count):
        output.extend([i] * cnt)
    return output