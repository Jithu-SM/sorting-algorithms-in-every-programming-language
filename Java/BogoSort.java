import java.util.Random;

public class BogoSort {
    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 4};
        bogoSort(array);
        System.out.print("Sorted array: ");
        printArray(array);
    }

    public static void bogoSort(int[] array) {
        Random random = new Random();
        while (!isSorted(array)) {
            shuffle(array, random);
        }
    }

    private static void shuffle(int[] array, Random random) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}