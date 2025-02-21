using System;

class RadixSort
{
    public static void Sort(int[] arr)
    {
        int max = GetMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10)
            CountSort(arr, exp);
    }

    private static int GetMax(int[] arr)
    {
        int max = arr[0];
        for (int i = 1; i < arr.Length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    private static void CountSort(int[] arr, int exp)
    {
        int n = arr.Length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--)
        {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void Main()
    {
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
