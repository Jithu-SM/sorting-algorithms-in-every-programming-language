function insertion_sort(arr, left, right)
    for i = left + 1, right do
        local key = arr[i]
        local j = i - 1
        while j >= left and arr[j] > key do
            arr[j + 1] = arr[j]
            j = j - 1
        end
        arr[j + 1] = key
    end
end

function heapify(arr, n, i)
    local largest = i
    local left = 2 * i + 1
    local right = 2 * i + 2

    if left < n and arr[left] > arr[largest] then
        largest = left
    end

    if right < n and arr[right] > arr[largest] then
        largest = right
    end

    if largest ~= i then
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)
    end
end

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

function intro_sort(arr, left, right, depth_limit)
    local size = right - left + 1
    if size < 16 then
        insertion_sort(arr, left, right)
    elseif depth_limit == 0 then
        heap_sort(arr, left, right)
    else
        quick_sort(arr, left, right)
    end
end

function heap_sort(arr, left, right)
    local n = right + 1
    for i = math.floor(n / 2) - 1, left, -1 do
        heapify(arr, n, i)
    end
    for i = n - 1, left + 1, -1 do
        arr[left], arr[i] = arr[i], arr[left]
        heapify(arr, i, left)
    end
end

local arr = {5, 1, 4, 2, 8}
intro_sort(arr, 1, #arr, math.floor(math.log(#arr) * 2))
print(table.concat(arr, " "))
