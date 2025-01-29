# Sorting Algorithms

### 1. Bitonic Sort
**Description:** Bitonic Sort is a parallel sorting algorithm that works on a bitonic sequence (a sequence that is first increasing then decreasing). It is mainly used in parallel computing.

**Time Complexity:** O(n log² n)

**Use Case:** Suitable for parallel processing environments.

---

### 2. Block Sort
**Description:** Block Sort is a stable sorting algorithm that combines the ideas of merge sort and insertion sort. It is designed to be efficient in practical use.

**Time Complexity:** O(n log n)

**Use Case:** Efficient for large datasets while maintaining stability.

---

### 3. Bogo Sort
**Description:** Bogo Sort (or permutation sort) is an extremely inefficient sorting algorithm that randomly shuffles elements until they are sorted.

**Time Complexity:** O((n+1)!) in the worst case

**Use Case:** Used for educational purposes to demonstrate bad algorithm design.

---

### 4. Bubble Sort
**Description:** Bubble Sort repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.

**Time Complexity:** O(n²)

**Use Case:** Simple but inefficient; used for small datasets or educational purposes.

---

### 5. Bucket Sort
**Description:** Bucket Sort distributes elements into multiple buckets and then sorts each bucket individually (often using insertion sort or another algorithm).

**Time Complexity:** O(n+k) (average case)

**Use Case:** Useful when input is uniformly distributed over a range.

---

### 6. Cocktail Shaker Sort
**Description:** A variation of Bubble Sort that sorts in both directions in a single pass.

**Time Complexity:** O(n²)

**Use Case:** Provides minor improvements over Bubble Sort.

---

### 7. Comb Sort
**Description:** An improvement over Bubble Sort that eliminates small values at the end by comparing elements at a gap and reducing the gap gradually.

**Time Complexity:** O(n log n) (average case)

**Use Case:** More efficient than Bubble Sort but not as efficient as Quick Sort.

---

### 8. Counting Sort
**Description:** Counting Sort is a non-comparison sorting algorithm that works by counting the number of occurrences of each element.

**Time Complexity:** O(n + k)

**Use Case:** Works well when sorting integers within a known range.

---

### 9. Gnome Sort
**Description:** Similar to Insertion Sort, Gnome Sort swaps elements that are out of order and moves backward when needed.

**Time Complexity:** O(n²)

**Use Case:** Simple but inefficient sorting algorithm.

---

### 10. Heap Sort
**Description:** Heap Sort utilizes a binary heap data structure to extract the largest element and build a sorted array.

**Time Complexity:** O(n log n)

**Use Case:** Efficient and widely used in systems where memory usage is a concern.

---

### 11. Insertion Sort
**Description:** Builds the sorted array one element at a time by comparing it with the previous elements.

**Time Complexity:** O(n²)

**Use Case:** Works well for small datasets or nearly sorted arrays.

---

### 12. Intro Sort
**Description:** A hybrid sorting algorithm that combines Quick Sort, Heap Sort, and Insertion Sort.

**Time Complexity:** O(n log n)

**Use Case:** Used in standard libraries like C++ STL.

---

### 13. Merge Sort
**Description:** A divide-and-conquer sorting algorithm that recursively splits and merges arrays.

**Time Complexity:** O(n log n)

**Use Case:** Stable sorting, widely used in external sorting.

---

### 14. Pancake Sort
**Description:** A sorting algorithm that flips elements to place the maximum element at the end iteratively.

**Time Complexity:** O(n²)

**Use Case:** Mainly theoretical and used for educational purposes.

---

### 15. Quick Sort
**Description:** A divide-and-conquer sorting algorithm that picks a pivot and partitions the array around it.

**Time Complexity:** O(n log n) (average case)

**Use Case:** One of the most commonly used sorting algorithms.

---

### 16. Radix Sort
**Description:** A non-comparative sorting algorithm that sorts elements digit by digit.

**Time Complexity:** O(nk)

**Use Case:** Suitable for sorting large numbers efficiently.

---

### 17. Randomized Quick Sort
**Description:** A variation of Quick Sort that selects a random pivot to improve performance on certain datasets.

**Time Complexity:** O(n log n) (average case)

**Use Case:** Reduces the worst-case scenario of Quick Sort.

---

### 18. Selection Sort
**Description:** Selects the smallest element and swaps it with the first element, then repeats for the next element.

**Time Complexity:** O(n²)

**Use Case:** Simple but inefficient for large datasets.

---

### 19. Shell Sort
**Description:** An improved version of Insertion Sort that sorts elements far apart first, reducing swaps in later iterations.

**Time Complexity:** O(n log n) (depends on gap sequence)

**Use Case:** Efficient for medium-sized datasets.

---

### 20. Tim Sort
**Description:** A hybrid sorting algorithm that merges Insertion Sort and Merge Sort for better efficiency.

**Time Complexity:** O(n log n)

**Use Case:** Used in Python’s and Java’s sorting libraries.

---

## Contributing
Feel free to contribute to this repository by adding code implementations, optimizations, or explanations.


