function comb_sort(arr)
    local gap = #arr
    local shrink = 1.3
    local swapped = true

    while gap > 1 or swapped do
        gap = math.floor(gap / shrink)
        if gap < 1 then gap = 1 end
        swapped = false

        for i = 1, #arr - gap do
            if arr[i] > arr[i + gap] then
                arr[i], arr[i + gap] = arr[i + gap], arr[i]
                swapped = true
            end
        end
    end
end

local arr = {5, 1, 4, 2, 8}
comb_sort(arr)
print(table.concat(arr, " "))
