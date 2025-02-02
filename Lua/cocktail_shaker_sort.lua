function cocktail_shaker_sort(arr)
    local swapped = true
    local start = 1
    local finish = #arr

    while swapped do
        swapped = false
        for i = start, finish - 1 do
            if arr[i] > arr[i + 1] then
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                swapped = true
            end
        end
        if not swapped then break end

        swapped = false
        finish = finish - 1

        for i = finish, start + 1, -1 do
            if arr[i] < arr[i - 1] then
                arr[i], arr[i - 1] = arr[i - 1], arr[i]
                swapped = true
            end
        end
        start = start + 1
    end
end

local arr = {5, 1, 4, 2, 8}
cocktail_shaker_sort(arr)
print(table.concat(arr, " "))
