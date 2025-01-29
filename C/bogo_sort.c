#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int isSorted(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1])
            return 0;
    }
    return 1;
}

void shuffle(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        int r = rand() % n;
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
    }
}

void bogoSort(int arr[], int n) {
    while (!isSorted(arr, n)) {
        shuffle(arr, n);
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    srand(time(NULL));
    int arr[] = {3, 2, 5, 1};
    int n = sizeof(arr) / sizeof(arr[0]);

    bogoSort(arr, n);
    printf("Sorted array: \n");
    printArray(arr, n);

    return 0;
}
