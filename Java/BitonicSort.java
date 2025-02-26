import java.util.Arrays;

public class BitonicSort {

    public static int[] copyOf(int[] original, int newLength) {
        int[] copy = new int[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public void bitonicSort(int[] arr, int low, int cnt, boolean dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            bitonicSort(arr, low, k, true);
            bitonicSort(arr, low + k, k, false);
            bitonicMerge(arr, low, cnt, dir);
        }
    }

    public void bitonicMerge(int[] arr, int low, int cnt, boolean dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                if (dir == (arr[i] > arr[i + k])) {
                    int temp = arr[i];
                    arr[i] = arr[i + k];
                    arr[i + k] = temp;
                }
            }
            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low + k, k, dir);
        }
    }

    public void sort(int[] arr, int n, boolean up) {
        bitonicSort(arr, 0, n, up);
    }

    public static void main(String[] args) {
        BitonicSort ob = new BitonicSort();
        int[] arr = {3, 7, 4, 8, 6, 2, 1, 5, 0};
        int n = arr.length;

        int powerOfTwo = 1;
        while (powerOfTwo < n) {
            powerOfTwo *= 2;
        }

        int[] paddedArr = Arrays.copyOf(arr, powerOfTwo);
        for (int i = n; i < powerOfTwo; i++) {
            paddedArr[i] = Integer.MAX_VALUE;
        }

        ob.sort(paddedArr, powerOfTwo, true);

        System.out.println("Sorted array");
        for (int i = 0; i < n; i++) {
            System.out.print(paddedArr[i] + " ");
        }
    }
}
