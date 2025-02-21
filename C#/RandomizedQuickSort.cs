using System;

class RandomizedQuickSort
{
    private static Random rand = new Random();

    public static void Sort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pivot = RandomizedPartition(arr, low, high);
            Sort(arr, low, pivot - 1);
            Sort(arr, pivot + 1, high);
        }
    }

    private static int RandomizedPartition(int[] arr, int low, int high)
    {
        int pivotIdx = rand.Next(low, high + 1);
        
        // Swap arr[pivotIdx] and arr[high]
        int temp = arr[pivotIdx];
        arr[pivotIdx] = arr[high];
        arr[high] = temp;

        return Partition(arr, low, high);
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
        Console.WriteLine("Before Sorting: " + string.Join(" ", arr));

        Sort(arr, 0, arr.Length - 1);

        Console.WriteLine("After Sorting: " + string.Join(" ", arr));
    }
}
