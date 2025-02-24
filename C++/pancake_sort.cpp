#include <iostream>

using namespace std;

void reverse(int arr[], int start, int end) {
    while (start < end) {
        swap(arr[start], arr[end]);
        start++;
        end--;
    }
}

void pancakeSort(int arr[], int n) {
    for (int currSize = n; currSize > 1; --currSize) {
        int maxIndex = 0;
        for (int i = 0; i < currSize; ++i) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        if (maxIndex != currSize - 1) {
            reverse(arr, 0, maxIndex);
            reverse(arr, 0, currSize - 1);
        }
    }
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    int arr[] = {3, 6, 2, 7, 5, 8, 1, 4};
    int n = sizeof(arr) / sizeof(arr[0]);

    pancakeSort(arr, n);

    printArray(arr, n);

    return 0;
}
