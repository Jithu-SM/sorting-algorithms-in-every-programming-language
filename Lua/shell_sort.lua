function shell_sort(arr)
    local n = #arr
    local gap = math.floor(n / 2)

    while gap > 0 do
        for i = gap + 1, n do
            local temp = arr[i]
            local j = i
            while j > gap and arr[j - gap] > temp do
                arr[j] = arr[j - gap]
                j = j - gap
            end
            arr[j] = temp
        end
        gap = math.floor(gap / 2)
    end
end

local arr = {5, 1, 4, 2, 8}
shell_sort(arr)
print(table.concat(arr, " "))
