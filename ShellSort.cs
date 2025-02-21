using System;

class ShellSort
{
    public static void Sort(int[] arr)
    {
        int n = arr.Length;
        for (int gap = n / 2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i++)
            {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp;
            }
        }
    }

    public static void Main()
    {
        int[] arr = { 12, 34, 54, 2, 3 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
