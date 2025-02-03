function get_max(arr)
    local max_val = arr[1] or 0 
    for i = 2, #arr do
        if arr[i] > max_val then
            max_val = arr[i]
        end
    end
    return max_val
end

function counting_sort_radix(arr, exp)
    local n = #arr
    local output = {}  
    local count = {}   

    for i = 0, 9 do count[i] = 0 end

    for i = 1, n do
        local index = math.floor(arr[i] / exp) % 10
        count[index] = (count[index] or 0) + 1
    end

    for i = 1, 9 do
        count[i] = count[i] + (count[i - 1] or 0)
    end

    for i = n, 1, -1 do
        local index = math.floor(arr[i] / exp) % 10
        local pos = count[index]
        output[pos] = arr[i]
        count[index] = count[index] - 1
    end

    for i = 1, n do
        arr[i] = output[i] or arr[i] 
    end
end

function radix_sort(arr)
    if #arr == 0 then return end  

    local max_val = get_max(arr)
    local exp = 1
    while max_val / exp >= 1 do
        counting_sort_radix(arr, exp)
        exp = exp * 10
    end
end

local arr = {170, 45, 75, 90, 802, 24, 2, 66}
radix_sort(arr)
print(table.concat(arr, " "))
