using System;

class BlockSort
{
    static int BLOCK_SIZE = 4; 

    static void InsertionSort(int[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int key = arr[i];
            int j = i - 1;

            while (j >= left && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void Merge(int[] arr, int left, int mid, int right)
    {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++)
            leftArr[i] = arr[left + i];

        for (int i = 0; i < rightSize; i++)
            rightArr[i] = arr[mid + 1 + i];

        int iL = 0, iR = 0, k = left;
        while (iL < leftSize && iR < rightSize)
        {
            if (leftArr[iL] <= rightArr[iR])
                arr[k++] = leftArr[iL++];
            else
                arr[k++] = rightArr[iR++];
        }

        while (iL < leftSize)
            arr[k++] = leftArr[iL++];

        while (iR < rightSize)
            arr[k++] = rightArr[iR++];
    }

    public static void Sort(int[] arr)
    {
        int n = arr.Length;

        for (int i = 0; i < n; i += BLOCK_SIZE)
        {
            int right = Math.Min(i + BLOCK_SIZE - 1, n - 1);
            InsertionSort(arr, i, right);
        }

        for (int size = BLOCK_SIZE; size < n; size *= 2)
        {
            for (int left = 0; left < n - 1; left += 2 * size)
            {
                int mid = left + size - 1;
                int right = Math.Min(left + 2 * size - 1, n - 1);
                if (mid < right)
                    Merge(arr, left, mid, right);
            }
        }
    }

    public static void Main()
    {
        int[] arr = { 29, 10, 14, 37, 13, 44, 19, 25, 33, 22, 17, 39 };
        Console.WriteLine("Original array: " + string.Join(", ", arr));

        Sort(arr);

        Console.WriteLine("Sorted array: " + string.Join(", ", arr));
    }
}
