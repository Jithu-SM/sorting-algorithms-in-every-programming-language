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

function merge(arr, l, m, r)
    local left = {}
    local right = {}

    for i = l, m do table.insert(left, arr[i]) end
    for i = m + 1, r do table.insert(right, arr[i]) end

    local i, j, k = 1, 1, l
    while i <= #left and j <= #right do
        if left[i] <= right[j] then
            arr[k] = left[i]
            i = i + 1
        else
            arr[k] = right[j]
            j = j + 1
        end
        k = k + 1
    end

    while i <= #left do
        arr[k] = left[i]
        i = i + 1
        k = k + 1
    end

    while j <= #right do
        arr[k] = right[j]
        j = j + 1
        k = k + 1
    end
end

function block_sort(arr, l, r)
    if l < r then
        local m = math.floor((l + r) / 2)
        block_sort(arr, l, m)
        block_sort(arr, m + 1, r)
        merge(arr, l, m, r)
    end
end

local arr = {3, 5, 2, 9, 1, 4, 8, 6}
block_sort(arr, 1, #arr)
print(table.concat(arr, " "))
