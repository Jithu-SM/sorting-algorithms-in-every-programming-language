local RUN = 32

function insertion_sort(arr, left, right)
    for i = left + 1, right do
        local temp = arr[i]
        local j = i - 1
        while j >= left and arr[j] > temp do
            arr[j + 1] = arr[j]
            j = j - 1
        end
        arr[j + 1] = temp
    end
end

function merge(arr, left, mid, right)
    local left_part = {}
    local right_part = {}
    for i = left, mid do
        table.insert(left_part, arr[i])
    end
    for i = mid + 1, right do
        table.insert(right_part, arr[i])
    end

    local i, j, k = 1, 1, left
    while i <= #left_part and j <= #right_part do
        if left_part[i] <= right_part[j] then
            arr[k] = left_part[i]
            i = i + 1
        else
            arr[k] = right_part[j]
            j = j + 1
        end
        k = k + 1
    end

    while i <= #left_part do
        arr[k] = left_part[i]
        i = i + 1
        k = k + 1
    end

    while j <= #right_part do
        arr[k] = right_part[j]
        j = j + 1
        k = k + 1
    end
end

function tim_sort(arr)
    local n = #arr

    for i = 1, n, RUN do
        insertion_sort(arr, i, math.min(i + RUN - 1, n))
    end

    local size = RUN
    while size < n do
        for left = 1, n, 2 * size do
            local mid = left + size - 1
            local right = math.min(left + 2 * size - 1, n)
            if mid < right then
                merge(arr, left, mid, right)
            end
        end
        size = 2 * size
    end
end

local arr = {5, 1, 4, 2, 8, 3, 7, 6, 0}
tim_sort(arr)
print(table.concat(arr, " "))
