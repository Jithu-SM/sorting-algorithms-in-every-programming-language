def comb_sort(arr):
    n = len(arr)
    gap = n
    shrink = 1.3
    sorted_flag = False

    while not sorted_flag:
        gap = max(1, int(gap / shrink)) 
        sorted_flag = gap == 1 

        for i in range(n - gap):
            if arr[i] > arr[i + gap]:
                arr[i], arr[i + gap] = arr[i + gap], arr[i]
                sorted_flag = False  

    return arr


arr = [64, 34, 25, 12, 22, 11, 90, 0]
sorted_arr = comb_sort(arr)
print("Sorted array:", sorted_arr)