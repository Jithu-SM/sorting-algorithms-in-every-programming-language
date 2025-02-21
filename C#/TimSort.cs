using System;

class TimSort
{
    private const int RUN = 32;

    public static void Sort(int[] arr)
    {
        int n = arr.Length;
        for (int i = 0; i < n; i += RUN)
            InsertionSort(arr, i, Math.Min((i + 31), (n - 1)));

        for (int size = RUN; size < n; size = 2 * size)
        {
            for (int left = 0; left < n; left += 2 * size)
            {
                int mid = left + size - 1;
                int right = Math.Min((left + 2 * size - 1), (n - 1));

                if (mid < right)
                    Merge(arr, left, mid, right);
            }
        }
    }

    private static void InsertionSort(int[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    private static void Merge(int[] arr, int left, int mid, int right)
    {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        for (int i = 0; i < len1; i++)
            leftArr[i] = arr[left + i];

        for (int j = 0; j < len2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i1 = 0, i2 = 0, k = left;
        while (i1 < len1 && i2 < len2)
            arr[k++] = leftArr[i1] <= rightArr[i2] ? leftArr[i1++] : rightArr[i2++];

        while (i1 < len1) arr[k++] = leftArr[i1++];
        while (i2 < len2) arr[k++] = rightArr[i2++];
    }

    public static void Main()
    {
        int[] arr = { 5, 21, 7, 23, 19 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
