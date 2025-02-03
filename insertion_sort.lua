function insertion_sort(arr)
    for i = 2, #arr do
        local key = arr[i]
        local j = i - 1
        while j >= 1 and arr[j] > key do
            arr[j + 1] = arr[j]
            j = j - 1
        end
        arr[j + 1] = key
    end
end

local arr = {5, 1, 4, 2, 8}
insertion_sort(arr)
print(table.concat(arr, " "))
