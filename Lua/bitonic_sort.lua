function bitonic_compare(arr, low, cnt, dir)
    if cnt > 1 then
        local k = cnt // 2
        for i = low, low + k - 1 do
            if (dir and arr[i] > arr[i + k]) or (not dir and arr[i] < arr[i + k]) then
                arr[i], arr[i + k] = arr[i + k], arr[i]
            end
        end
        bitonic_compare(arr, low, k, dir)
        bitonic_compare(arr, low + k, k, dir)
    end
end

function bitonic_merge(arr, low, cnt, dir)
    if cnt > 1 then
        local k = cnt // 2
        bitonic_merge(arr, low, k, true)
        bitonic_merge(arr, low + k, k, false)
        bitonic_compare(arr, low, cnt, dir)
    end
end

function bitonic_sort(arr, low, cnt, dir)
    if cnt > 1 then
        local k = cnt // 2
        bitonic_sort(arr, low, k, true)
        bitonic_sort(arr, low + k, k, false)
        bitonic_merge(arr, low, cnt, dir)
    end
end

local arr = {3, 7, 4, 8, 6, 2, 1, 5}
bitonic_sort(arr, 1, #arr, true)
print(table.concat(arr, " "))
