public class BlockSort {
    public static void blockSort(int[] array) {
        int n = array.length;
        if (n <= 1) return;
        int max = array[0], min = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        int range = max - min + 1;
        int[] count = new int[range];
        for (int i = 0; i < n; i++) {
            count[array[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                array[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 7, 2, 8, 3, 13, 1, 0};
        blockSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}