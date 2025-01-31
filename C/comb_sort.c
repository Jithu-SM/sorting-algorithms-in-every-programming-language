#include <stdio.h>

int getNextGap(int gap) {
    gap = (gap * 10) / 13;
    return (gap < 1) ? 1 : gap;
}

void combSort(int arr[], int n) {
    int gap = n, swapped = 1;
    while (gap > 1 || swapped) {
        gap = getNextGap(gap);
        swapped = 0;
        for (int i = 0; i < n - gap; i++) {
            if (arr[i] > arr[i + gap]) {
                int temp = arr[i];
                arr[i] = arr[i + gap];
                arr[i + gap] = temp;
                swapped = 1;
            }
        }
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int arr[] = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};
    int n = sizeof(arr) / sizeof(arr[0]);

    combSort(arr, n);
    printf("Sorted array:\n");
    printArray(arr, n);

    return 0;
}
