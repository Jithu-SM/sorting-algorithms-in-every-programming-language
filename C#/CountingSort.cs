using System;

class CountingSort
{
    public static void Sort(int[] arr)
    {
        int max = arr[0], min = arr[0];
        foreach (var num in arr)
        {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.Length];

        foreach (var num in arr)
            count[num - min]++;

        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];

        for (int i = arr.Length - 1; i >= 0; i--)
        {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.Length; i++)
            arr[i] = output[i];
    }

    public static void Main()
    {
        int[] arr = { 4, 2, 2, 8, 3, 3, 1 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
