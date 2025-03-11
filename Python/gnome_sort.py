def gnome_sort(arr):
    n = len(arr)
    index = 0

    while index < n:
        if index == 0 or arr[index] >= arr[index - 1]:
            index += 1
        else:
            arr[index], arr[index - 1] = arr[index - 1], arr[index]
            index -= 1

    return arr

arr=[3, 7, 4, 8, 6, 2, 1, 5, 0, -5]
print(gnome_sort(arr))