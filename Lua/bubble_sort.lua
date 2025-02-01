function bubble_sort(arr)
    local n = #arr
    for i = 1, n - 1 do
        for j = 1, n - i do
            if arr[j] > arr[j + 1] then
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
            end
        end
    end
end

local arr = {5, 1, 4, 2, 8}
bubble_sort(arr)
print(table.concat(arr, " "))
