function flip(arr, i)
    local j = 1
    while j < i do
        arr[j], arr[i] = arr[i], arr[j]
        j = j + 1
        i = i - 1
    end
end

function find_max(arr, n)
    local max = 1
    for i = 2, n do
        if arr[i] > arr[max] then
            max = i
        end
    end
    return max
end

function pancake_sort(arr)
    local n = #arr
    for curr_size = n, 2, -1 do
        local max_index = find_max(arr, curr_size)
        if max_index ~= curr_size then
            flip(arr, max_index)
            flip(arr, curr_size)
        end
    end
end

local arr = {5, 1, 4, 2, 8}
pancake_sort(arr)
print(table.concat(arr, " "))
