using System;

class PancakeSort
{
    public static void Sort(int[] arr)
    {
        int n = arr.Length;
        for (int currSize = n; currSize > 1; currSize--)
        {
            int maxIdx = FindMaxIndex(arr, currSize);
            if (maxIdx != currSize - 1)
            {
                Flip(arr, maxIdx);
                Flip(arr, currSize - 1);
            }
        }
    }

    private static int FindMaxIndex(int[] arr, int n)
    {
        int maxIdx = 0;
        for (int i = 1; i < n; i++)
            if (arr[i] > arr[maxIdx])
                maxIdx = i;
        return maxIdx;
    }

    private static void Flip(int[] arr, int i)
    {
        int start = 0;
        while (start < i)
        {
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    public static void Main()
    {
        int[] arr = { 3, 6, 2, 4, 5, 1 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
