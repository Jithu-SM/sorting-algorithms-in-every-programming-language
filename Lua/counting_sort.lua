function counting_sort(arr)
    local max_val = math.max(table.unpack(arr))
    local min_val = math.min(table.unpack(arr))
    local range = max_val - min_val + 1

    local count = {}
    for i = 1, range do count[i] = 0 end

    for i = 1, #arr do
        count[arr[i] - min_val + 1] = count[arr[i] - min_val + 1] + 1
    end

    local index = 1
    for i = 1, range do
        while count[i] > 0 do
            arr[index] = i + min_val - 1
            count[i] = count[i] - 1
            index = index + 1
        end
    end
end

local arr = {5, 1, 4, 2, 8, 2, 1}
counting_sort(arr)
print(table.concat(arr, " "))
