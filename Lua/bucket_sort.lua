function bucket_sort(arr, bucket_size)
    bucket_size = bucket_size or 5
    local min_value, max_value = math.min(table.unpack(arr)), math.max(table.unpack(arr))

    local bucket_count = math.floor((max_value - min_value) / bucket_size) + 1
    local buckets = {}

    for i = 1, bucket_count do buckets[i] = {} end

    for _, v in ipairs(arr) do
        local index = math.floor((v - min_value) / bucket_size) + 1
        table.insert(buckets[index], v)
    end

    for _, bucket in ipairs(buckets) do
        table.sort(bucket)
    end

    local sorted_arr = {}
    for _, bucket in ipairs(buckets) do
        for _, v in ipairs(bucket) do
            table.insert(sorted_arr, v)
        end
    end

    return sorted_arr
end

local arr = {29, 25, 3, 49, 9, 37, 21, 43}
arr = bucket_sort(arr)
print(table.concat(arr, " "))
