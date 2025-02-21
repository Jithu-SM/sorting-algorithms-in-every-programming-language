using System;

class SelectionSort
{
    public static void Sort(int[] arr)
    {
        int n = arr.Length;
        for (int i = 0; i < n - 1; i++)
        {
            int minIdx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIdx])
                    minIdx = j;

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void Main()
    {
        int[] arr = { 64, 25, 12, 22, 11 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
