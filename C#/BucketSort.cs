using System;
using System.Collections.Generic;

class BucketSort
{
    public static void Sort(int[] arr)
    {
        int n = arr.Length;
        if (n <= 0) return;

        int maxVal = arr[0], minVal = arr[0];

        for (int i = 1; i < n; i++)
        {
            if (arr[i] > maxVal) maxVal = arr[i];
            if (arr[i] < minVal) minVal = arr[i];
        }

        int bucketCount = Math.Max(1, (maxVal - minVal) / n + 1);
        List<int>[] buckets = new List<int>[bucketCount];

        for (int i = 0; i < bucketCount; i++)
            buckets[i] = new List<int>();

        foreach (var num in arr)
        {
            int bucketIndex = (num - minVal) * (bucketCount - 1) / (maxVal - minVal + 1);
            buckets[bucketIndex].Add(num);
        }

        for (int i = 0; i < bucketCount; i++)
            buckets[i].Sort();

        int index = 0;
        for (int i = 0; i < bucketCount; i++)
            foreach (var num in buckets[i])
                arr[index++] = num;
    }

    public static void Main()
    {
        int[] arr = { 78, 17, 39, 26, 72, 94, 21, 40, 55, 69 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
