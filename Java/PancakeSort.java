public class PancakeSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 7, 5, 8, 4, 1};
        pancakeSort(arr);
        printArray(arr);
    }

    public static void pancakeSort(int[] arr) {
        for (int currSize = arr.length; currSize > 1; --currSize) {
            int maxIndex = findMax(arr, currSize);
            if (maxIndex != currSize - 1) {
                flip(arr, maxIndex);
                flip(arr, currSize - 1);
            }
        }
    }

    private static int findMax(int[] arr, int n) {
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static void flip(int[] arr, int end) {
        int start = 0;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}