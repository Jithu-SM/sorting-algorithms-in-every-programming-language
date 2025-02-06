using System;

class CombSort
{
    public static void Sort(int[] arr)
    {
        int n = arr.Length;
        int gap = n;
        bool swapped;
        do
        {
            gap = (int)(gap / 1.3);
            if (gap < 1) gap = 1;
            swapped = false;

            for (int i = 0; i + gap < n; i++)
            {
                if (arr[i] > arr[i + gap])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        } while (gap > 1 || swapped);
    }

    public static void Main()
    {
        int[] arr = { 8, 4, 1, 56, 3, -44, 23, -6, 28, 0 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
