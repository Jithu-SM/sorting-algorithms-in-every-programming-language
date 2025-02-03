function quick_sort(arr, left, right)
    if left < right then
        local pivot = arr[right]
        local i = left - 1
        for j = left, right - 1 do
            if arr[j] <= pivot then
                i = i + 1
                arr[i], arr[j] = arr[j], arr[i]
            end
        end
        arr[i + 1], arr[right] = arr[right], arr[i + 1]
        local pivot_index = i + 1
        quick_sort(arr, left, pivot_index - 1)
        quick_sort(arr, pivot_index + 1, right)
    end
end

local arr = {5, 1, 4, 2, 8}
quick_sort(arr, 1, #arr)
print(table.concat(arr, " "))
