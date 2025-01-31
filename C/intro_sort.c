#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void insertionSort(int arr[], int low, int high) {
    for (int i = low + 1; i <= high; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= low && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

void heapify(int arr[], int n, int i) {
    int largest = i, left = 2 * i + 1, right = 2 * i + 2;
    if (left < n && arr[left] > arr[largest])
        largest = left;
    if (right < n && arr[right] > arr[largest])
        largest = right;
    if (largest != i) {
        swap(&arr[i], &arr[largest]);
        heapify(arr, n, largest);
    }
}

void heapSort(int arr[], int n) {
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
    for (int i = n - 1; i > 0; i--) {
        swap(&arr[0], &arr[i]);
        heapify(arr, i, 0);
    }
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high], i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return i + 1;
}

void introSortUtil(int arr[], int low, int high, int depthLimit) {
    int size = high - low + 1;
    if (size < 16) {
        insertionSort(arr, low, high);
        return;
    }
    if (depthLimit == 0) {
        heapSort(arr + low, size);
        return;
    }
    int pivot = partition(arr, low, high);
    introSortUtil(arr, low, pivot - 1, depthLimit - 1);
    introSortUtil(arr, pivot + 1, high, depthLimit - 1);
}

void introSort(int arr[], int n) {
    int depthLimit = 2 * log(n);
    introSortUtil(arr, 0, n - 1, depthLimit);
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int arr[] = {10, 3, 15, 7, 8, 23, 74, 18};
    int n = sizeof(arr) / sizeof(arr[0]);

    introSort(arr, n);
    printf("Sorted array:\n");
    printArray(arr, n);

    return 0;
}
