function gnome_sort(arr)
    local index = 1
    while index <= #arr do
        if index == 1 or arr[index - 1] <= arr[index] then
            index = index + 1
        else
            arr[index], arr[index - 1] = arr[index - 1], arr[index]
            index = index - 1
        end
    end
end

local arr = {5, 1, 4, 2, 8}
gnome_sort(arr)
print(table.concat(arr, " "))
