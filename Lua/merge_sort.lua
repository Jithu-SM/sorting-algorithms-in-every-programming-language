function merge(arr, left, middle, right)
    local n1 = middle - left + 1
    local n2 = right - middle
    local left_arr = {}
    local right_arr = {}

    for i = 1, n1 do
        left_arr[i] = arr[left + i - 1]
    end
    for i = 1, n2 do
        right_arr[i] = arr[middle + i]
    end

    local i, j, k = 1, 1, left
    while i <= n1 and j <= n2 do
        if left_arr[i] <= right_arr[j] then
            arr[k] = left_arr[i]
            i = i + 1
        else
            arr[k] = right_arr[j]
            j = j + 1
        end
        k = k + 1
    end

    while i <= n1 do
        arr[k] = left_arr[i]
        i = i + 1
        k = k + 1
    end

    while j <= n2 do
        arr[k] = right_arr[j]
        j = j + 1
        k = k + 1
    end
end

function merge_sort(arr, left, right)
    if left < right then
        local middle = math.floor((left + right) / 2)
        merge_sort(arr, left, middle)
        merge_sort(arr, middle + 1, right)
        merge(arr, left, middle, right)
    end
end

local arr = {5, 1, 4, 2, 8}
merge_sort(arr, 1, #arr)
print(table.concat(arr, " "))
