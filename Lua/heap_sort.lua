function heapify(arr, n, i)
    local largest = i
    local left = 2 * i + 1
    local right = 2 * i + 2

    if left <= n and arr[left] > arr[largest] then
        largest = left
    end

    if right <= n and arr[right] > arr[largest] then
        largest = right
    end

    if largest ~= i then
        arr[i], arr[largest] = arr[largest], arr[i]  -- swap
        heapify(arr, n, largest)
    end
end

function heap_sort(arr)
    local n = #arr
    for i = math.floor(n / 2) - 1, 1, -1 do
        heapify(arr, n, i)
    end

    for i = n, 2, -1 do
        arr[1], arr[i] = arr[i], arr[1]
        heapify(arr, i - 1, 1)
    end
end

local arr = {5, 1, 4, 2, 8}
heap_sort(arr)
print(table.concat(arr, " "))
