public class IntroSort {

    private static final int SIZE_THRESHOLD = 16;

    public static void introSort(int[] array) {
        int depthLimit = 2 * (int) (Math.log(array.length) / Math.log(2));
        introSort(array, 0, array.length - 1, depthLimit);
    }

    private static void introSort(int[] array, int start, int end, int depthLimit) {
        if (end - start <= SIZE_THRESHOLD) {
            insertionSort(array, start, end);
        } else if (depthLimit == 0) {
            heapSort(array, start, end);
        } else {
            int pivot = partition(array, start, end);
            introSort(array, start, pivot - 1, depthLimit - 1);
            introSort(array, pivot + 1, end, depthLimit - 1);
        }
    }

    private static void insertionSort(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= start && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private static void heapSort(int[] array, int start, int end) {
        buildMaxHeap(array, start, end);
        for (int i = end; i > start; i--) {
            swap(array, start, i);
            maxHeapify(array, start, i - 1, start);
        }
    }

    private static void buildMaxHeap(int[] array, int start, int end) {
        for (int i = (end + start) / 2; i >= start; i--) {
            maxHeapify(array, i, end, start);
        }
    }

    private static void maxHeapify(int[] array, int i, int end, int start) {
        int left = 2 * (i - start) + 1 + start;
        int right = 2 * (i - start) + 2 + start;
        int largest = i;

        if (left <= end && array[left] > array[largest]) {
            largest = left;
        }
        if (right <= end && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest);
            maxHeapify(array, largest, end, start);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 8, 10, 1, 2, 11, 4};
        introSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}