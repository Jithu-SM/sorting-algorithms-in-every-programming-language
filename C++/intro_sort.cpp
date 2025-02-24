#include <iostream>
#include <cmath>

using namespace std;

void insertionSort(int arr[], int left, int right) {
    for (int i = left + 1; i <= right; ++i) {
        int key = arr[i];
        int j = i - 1;
        while (j >= left && arr[j] > key) {
            arr[j + 1] = arr[j];
            --j;
        }
        arr[j + 1] = key;
    }
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; ++j) {
        if (arr[j] < pivot) {
            ++i;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return i + 1;
}

void make_heap(int arr[], int start, int end) {
    for (int i = (end - start) / 2 - 1; i >= start; --i) {
        int root = i;
        while (root * 2 + 1 <= end) {
            int child = root * 2 + 1;
            if (child + 1 <= end && arr[child] < arr[child + 1]) {
                child++;
            }
            if (arr[root] < arr[child]) {
                swap(arr[root], arr[child]);
                root = child;
            } else {
                break;
            }
        }
    }
}

void sort_heap(int arr[], int start, int end) {
    make_heap(arr, start, end);
    for (int i = end; i > start; --i) {
        swap(arr[start], arr[i]);
        make_heap(arr, start, i - 1);
    }
}

void quickSort(int arr[], int low, int high, int depthLimit) {
    while (low < high) {
        if (depthLimit == 0) {
            make_heap(arr, low, high);
            sort_heap(arr, low, high);
            return;
        }
        int pivot = partition(arr, low, high);
        if (pivot - low < high - pivot) {
            quickSort(arr, low, pivot - 1, depthLimit - 1);
            low = pivot + 1;
        } else {
            quickSort(arr, pivot + 1, high, depthLimit - 1);
            high = pivot - 1;
        }
    }
}

void introSort(int arr[], int left, int right) {
    int depthLimit = 2 * log(right - left + 1);
    quickSort(arr, left, right, depthLimit);
    insertionSort(arr, left, right);
}

int main() {
    int arr[] = {10, 7, 8, 9, 1, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    introSort(arr, 0, n - 1);

    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";
    }
    return 0;
}
