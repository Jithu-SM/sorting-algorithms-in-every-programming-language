#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void insertionSort(int arr[], int left, int right) {
    for (int i = left + 1; i <= right; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= left && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1, n2 = right - mid;
    int leftArr[n1], rightArr[n2];

    for (int i = 0; i < n1; i++)
        leftArr[i] = arr[left + i];
    for (int i = 0; i < n2; i++)
        rightArr[i] = arr[mid + 1 + i];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (leftArr[i] <= rightArr[j])
            arr[k++] = leftArr[i++];
        else
            arr[k++] = rightArr[j++];
    }
    while (i < n1)
        arr[k++] = leftArr[i++];
    while (j < n2)
        arr[k++] = rightArr[j++];
}

void blockSort(int arr[], int left, int right, int blockSize) {
    if (right - left + 1 <= blockSize) {
        insertionSort(arr, left, right);
        return;
    }
    int mid = left + (right - left) / 2;
    blockSort(arr, left, mid, blockSize);
    blockSort(arr, mid + 1, right, blockSize);
    merge(arr, left, mid, right);
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int arr[] = {5, 2, 9, 1, 5, 6, 3};
    int n = sizeof(arr) / sizeof(arr[0]);

    blockSort(arr, 0, n - 1, 4);
    printf("Sorted array: \n");
    printArray(arr, n);

    return 0;
}
