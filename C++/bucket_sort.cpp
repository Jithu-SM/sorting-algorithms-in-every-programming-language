#include <iostream>
using namespace std;

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

void bucketSort(int arr[], int n, int bucketCount) {
    int maxVal = arr[0];
    for (int i = 1; i < n; i++)
        if (arr[i] > maxVal)
            maxVal = arr[i];

    int buckets[bucketCount][n], bucketSize[bucketCount] = {0};

    for (int i = 0; i < n; i++) {
        int index = (arr[i] * bucketCount) / (maxVal + 1);
        buckets[index][bucketSize[index]++] = arr[i];
    }

    int index = 0;
    for (int i = 0; i < bucketCount; i++) {
        insertionSort(buckets[i], bucketSize[i]);
        for (int j = 0; j < bucketSize[i]; j++)
            arr[index++] = buckets[i][j];
    }
}

int main() {
    int arr[] = {42, 32, 23, 52, 73, 25, 34};
    int n = sizeof(arr) / sizeof(arr[0]);
    int bucketCount = 5;

    bucketSort(arr, n, bucketCount);

    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";

    return 0;
}
