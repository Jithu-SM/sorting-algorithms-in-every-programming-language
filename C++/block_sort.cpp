#include <iostream>
using namespace std;

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
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int L[n1], R[n2];

    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];

    for (int i = 0; i < n2; i++)
        R[i] = arr[mid + 1 + i];

    int i = 0, j = 0, k = left;

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void blockSort(int arr[], int n, int blockSize) {
    for (int i = 0; i < n; i += blockSize) {
        insertionSort(arr, i, min(i + blockSize - 1, n - 1));
    }

    for (int size = blockSize; size < n; size *= 2) {
        for (int left = 0; left < n - 1; left += 2 * size) {
            int mid = min(left + size - 1, n - 1);
            int right = min(left + 2 * size - 1, n - 1);
            merge(arr, left, mid, right);
        }
    }
}

int main() {
    int arr[] = {4, 3, 1, 7, 9, 2, 8, 6, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    int blockSize = 3;

    blockSort(arr, n, blockSize);

    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    
    return 0;
}
