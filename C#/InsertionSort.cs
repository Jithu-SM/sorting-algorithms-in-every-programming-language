using System;

class InsertionSort
{
    public static void Sort(int[] arr)
    {
        int n = arr.Length;
        for(int i = 1; i < n; i++)
        {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key)
            {
                arr[j +1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void Main()
    {
        int[] arr = { 12, 11, 13, 5, 6 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}