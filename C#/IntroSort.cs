using System;

class IntroSort
{
    private static int MaxDepth(int n)
    {
        return (int)(2 * Math.Log(n));
    }

    public static void Sort(int[] arr)
    {
        int depthLimit = MaxDepth(arr.Length);
        IntroSortUtil(arr, 0, arr.Length - 1, depthLimit);
    }

    private static void IntroSortUtil(int[] arr, int low, int high, int depthLimit)
    {
        int n = high - low + 1;
        if (n <= 16)
        {
            InsertionSort(arr, low, high);
        }
        else if (depthLimit == 0)
        {
            HeapSort(arr, low, high);
        }
        else
        {
            int pivot = Partition(arr, low, high);
            IntroSortUtil(arr, low, pivot - 1, depthLimit - 1);
            IntroSortUtil(arr, pivot + 1, high, depthLimit - 1);
        }
    }

    private static void InsertionSort(int[] arr, int low, int high)
    {
        for (int i = low + 1; i <= high; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void HeapSort(int[] arr, int low, int high)
    {
        for (int i = (high - low) / 2 + low; i >= low; i--)
            Heapify(arr, high - low + 1, i, low);

        for (int i = high; i > low; i--)
        {
            int temp = arr[low];
            arr[low] = arr[i];
            arr[i] = temp;
            Heapify(arr, i - low, low, low);
        }
    }

    private static void Heapify(int[] arr, int n, int i, int offset)
    {
        int largest = i, left = 2 * i + 1 - offset, right = 2 * i + 2 - offset;

        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            Heapify(arr, n, largest, offset);
        }
    }

    private static int Partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;
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
        int[] arr = { 10, 3, 8, 7, 2, 6, 4, 1 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
