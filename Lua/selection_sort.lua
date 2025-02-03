function selection_sort(arr)
    for i = 1, #arr - 1 do
        local min_idx = i
        for j = i + 1, #arr do
            if arr[j] < arr[min_idx] then
                min_idx = j
            end
        end
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
    end
end

local arr = {5, 1, 4, 2, 8}
selection_sort(arr)
print(table.concat(arr, " "))
