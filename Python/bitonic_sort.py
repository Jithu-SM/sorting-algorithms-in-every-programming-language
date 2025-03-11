def bitonic_merge(arr, low, cnt, direction):
    if cnt > 1:
        k = cnt // 2
        for i in range(low, low + k):
            if (direction == 1 and arr[i] > arr[i + k]) or (direction == 0 and arr[i] < arr[i + k]):
                arr[i], arr[i + k] = arr[i + k], arr[i]
        bitonic_merge(arr, low, k, direction)
        bitonic_merge(arr, low + k, k, direction)

def bitonic_sort(arr, low, cnt, direction):
    if cnt > 1:
        k = cnt // 2
        bitonic_sort(arr, low, k, 1)  
        bitonic_sort(arr, low + k, k, 0)  
        bitonic_merge(arr, low, cnt, direction)

def sort_bitonic(arr):
    n = len(arr)
    
    power_of_2 = 1
    while power_of_2 < n:
        power_of_2 *= 2
    arr.extend([float('inf')] * (power_of_2 - n))  

    bitonic_sort(arr, 0, power_of_2, 1)  

    return arr[:n]

arr=[3, 7, 4, 8, 6, 2, 1, 5, 0]
print(sort_bitonic(arr))  