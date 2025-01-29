#include <stdio.h>
#include <stdlib.h>

#define BUCKET_SIZE 10

void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i], j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

void bucketSort(int arr[], int n) {
    int buckets[BUCKET_SIZE][n], bucketCount[BUCKET_SIZE] = {0};

    for (int i = 0; i < n; i++) {
        int bi = arr[i] / 10;
        buckets[bi][bucketCount[bi]++] = arr[i];
    }

    for (int i = 0, k = 0; i < BUCKET_SIZE; i++) {
        insertionSort(buckets[i], bucketCount[i]);
        for (int j = 0; j < bucketCount[i]; j++)
            arr[k++] = buckets[i][j];
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int arr[] = {42, 32, 33, 52, 37, 47, 51};
    int n = sizeof(arr) / sizeof(arr[0]);

    bucketSort(arr, n);
    printf("Sorted array: \n");
    printArray(arr, n);

    return 0;
}
