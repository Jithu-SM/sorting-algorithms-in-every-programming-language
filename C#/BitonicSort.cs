using System;

class BitonicSort
{
    static void BitonicMerge(int[] arr, int low, int cnt, bool ascending)
    {
        if (cnt > 1)
        {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
            {
                if ((arr[i] > arr[i + k]) == ascending)
                {
                    int temp = arr[i];
                    arr[i] = arr[i + k];
                    arr[i + k] = temp;
                }
            }
            BitonicMerge(arr, low, k, ascending);
            BitonicMerge(arr, low + k, k, ascending);
        }
    }

    static void BitonicSortRecursive(int[] arr, int low, int cnt, bool ascending)
    {
        if (cnt > 1)
        {
            int k = cnt / 2;
            BitonicSortRecursive(arr, low, k, true);
            BitonicSortRecursive(arr, low + k, k, false);
            BitonicMerge(arr, low, cnt, ascending);
        }
    }

    public static void Sort(int[] arr)
    {
        int n = arr.Length;
        int powerOfTwo = 1;
        while (powerOfTwo < n) powerOfTwo *= 2;

        int[] paddedArray = new int[powerOfTwo];
        Array.Copy(arr, paddedArray, n);
        for (int i = n; i < powerOfTwo; i++) paddedArray[i] = int.MaxValue; 

        BitonicSortRecursive(paddedArray, 0, powerOfTwo, true);

        Array.Copy(paddedArray, arr, n);
    }

    public static void Main()
    {
        int[] arr = { 3, 7, 2, 8, 6, 4, 5, 1 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
