def counting_sort_for_radix(arr, exp):
    n = len(arr)
    output = [0] * n
    count = [0] * 10
    for num in arr:
        index = abs(num // exp) % 10
        count[index] += 1
    for i in range(1, 10):
        count[i] += count[i - 1]
    i = n - 1
    while i >= 0:
        index = abs(arr[i] // exp) % 10
        output[count[index] - 1] = arr[i]
        count[index] -= 1
        i -= 1
    for i in range(n):
        arr[i] = output[i]

def radix_sort(arr):
    if len(arr) == 0:
        return arr

    neg_arr = [num for num in arr if num < 0]
    pos_arr = [num for num in arr if num >= 0]

    if pos_arr:
        max_val = max(pos_arr)
        exp = 1
        while max_val // exp > 0:
            counting_sort_for_radix(pos_arr, exp)
            exp *= 10

    if neg_arr:
        min_val = min(neg_arr)
        exp = 1
        while abs(min_val) // exp > 0:
            counting_sort_for_radix(neg_arr, exp)
            exp *= 10
        neg_arr.reverse()

    return neg_arr + pos_arr

arr = [3, 7, 4, 8, 6, 2, 1, 5, 0, -5, -2]
print(radix_sort(arr))