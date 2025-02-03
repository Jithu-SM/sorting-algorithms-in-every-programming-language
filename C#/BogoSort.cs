using System;

class BogoSort
{
    static Random rand = new Random();

    static bool IsSorted(int[] arr)
    {
        for (int i = 0; i < arr.Length - 1; i++)
        {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    static void Shuffle(int[] arr)
    {
        for (int i = 0; i < arr.Length; i++)
        {
            int j = rand.Next(arr.Length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void Sort(int[] arr)
    {
        while (!IsSorted(arr))
        {
            Shuffle(arr);
        }
    }

    public static void Main()
    {
        int[] arr = { 3, 2, 5, 1, 4 };
        Sort(arr);
        Console.WriteLine(string.Join(" ", arr));
    }
}
