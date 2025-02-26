public class BucketSort {
    public static void bucketSort(int[] arr, int n) {
        if (n <= 0)
            return;

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        int bucketRange = (max - min) / n + 1;
        int[][] buckets = new int[n][0];

        for (int i = 0; i < n; i++) {
            int bucketIndex = Math.min((arr[i] - min) / bucketRange, n - 1);
            buckets[bucketIndex] = appendToArray(buckets[bucketIndex], arr[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (buckets[i].length > 0) {
                int[] sortedBucket = insertionSort(buckets[i]);
                for (int j = 0; j < sortedBucket.length; j++) {
                    arr[index++] = sortedBucket[j];
                }
            }
        }
    }

    private static int[] appendToArray(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = value;
        return newArr;
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 897, 565, 656, 1234, 665, 3434, 114 };
        int n = arr.length;
        bucketSort(arr, n);

        System.out.println("Sorted array is ");
        for (int el : arr) {
            System.out.print(el + " ");
        }
    }
}
