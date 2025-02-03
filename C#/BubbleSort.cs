using System;

class BubbleSort
{
    public static void Sort(int[] arr)
    {
        int n = arr.Length;
        bool swapped;
        do
        {
            swapped = false;
            for (int i = 0; i < n - 1; i++)
            {
                if (arr[i] > arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static void Main()
    {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
