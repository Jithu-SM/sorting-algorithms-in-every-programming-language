#include <stdio.h>

void flip(int arr[], int i) {
    int start = 0;
    while (start < i) {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
        start++;
        i--;
    }
}

int findMax(int arr[], int n) {
    int maxIdx = 0;
    for (int i = 1; i < n; i++)
        if (arr[i] > arr[maxIdx])
            maxIdx = i;
    return maxIdx;
}

void pancakeSort(int arr[], int n) {
    for (int currSize = n; currSize > 1; currSize--) {
        int maxIdx = findMax(arr, currSize);
        if (maxIdx != currSize - 1) {
            flip(arr, maxIdx);
            flip(arr, currSize - 1);
        }
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int arr[] = {23, 10, 20, 11, 12, 6, 7};
    int n = sizeof(arr) / sizeof(arr[0]);

    pancakeSort(arr, n);
    printf("Sorted array:\n");
    printArray(arr, n);

    return 0;
}
