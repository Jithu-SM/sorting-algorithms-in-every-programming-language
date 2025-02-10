#include <stdio.h>

#define ASCENDING 1
#define DESCENDING 0

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void bitonicMerge(int arr[], int low, int cnt, int dir) {
    if (cnt > 1) {
        int k = cnt / 2;
        for (int i = low; i < low + k; i++) {
            if ((dir == ASCENDING && arr[i] > arr[i + k]) ||
                (dir == DESCENDING && arr[i] < arr[i + k])) {
                swap(&arr[i], &arr[i + k]);
            }
        }
        bitonicMerge(arr, low, k, dir);
        bitonicMerge(arr, low + k, k, dir);
    }
}

void bitonicSort(int arr[], int low, int cnt, int dir) {
    if (cnt > 1) {
        int k = cnt / 2;
        bitonicSort(arr, low, k, ASCENDING);
        bitonicSort(arr, low + k, k, DESCENDING);
        bitonicMerge(arr, low, cnt, dir);
    }
}

void sort(int arr[], int n) {
    bitonicSort(arr, 0, n, ASCENDING);
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int arr[] = {3, 7, 2, 5, 8, 4, 6, 1};
    int n = sizeof(arr) / sizeof(arr[0]);

    sort(arr, n);
    printf("Sorted array: \n");
    printArray(arr, n);

    return 0;
}