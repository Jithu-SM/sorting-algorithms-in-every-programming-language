function partition(arr, left, right)
    local pivot = arr[right]
    local i = left - 1
    for j = left, right - 1 do
        if arr[j] <= pivot then
            i = i + 1
            arr[i], arr[j] = arr[j], arr[i]
        end
    end
    arr[i + 1], arr[right] = arr[right], arr[i + 1]
    return i + 1
end

function randomized_partition(arr, left, right)
    local rand_index = math.random(left, right)
    arr[right], arr[rand_index] = arr[rand_index], arr[right]
    return partition(arr, left, right)
end

function randomized_quick_sort(arr, left, right)
    if left < right then
        local pi = randomized_partition(arr, left, right)
        randomized_quick_sort(arr, left, pi - 1)
        randomized_quick_sort(arr, pi + 1, right)
    end
end

math.randomseed(os.time())
local arr = {5, 1, 4, 2, 8}
randomized_quick_sort(arr, 1, #arr)
print(table.concat(arr, " "))
