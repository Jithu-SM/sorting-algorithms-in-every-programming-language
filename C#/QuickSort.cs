using System;

class QuickSort
{
    public static void Sort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pivot = Partition(arr, low, high);
            Sort(arr, low, pivot - 1);
            Sort(arr, pivot + 1, high);
        }
    }

    private static int Partition(int[] arr, int low, int high)
    {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp2 = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp2;
        return i + 1;
    }

    public static void Main()
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        Sort(arr, 0, arr.Length - 1);
        Console.WriteLine(string.Join(" ", arr));
    }
}