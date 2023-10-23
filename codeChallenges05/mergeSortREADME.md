# Challenge Merge Sort
#### Pseudocode
ALGORITHM Mergesort(arr)
DECLARE n <-- arr.length

    if n > 1
      DECLARE mid <-- n/2
      DECLARE left <-- arr[0...mid]
      DECLARE right <-- arr[mid...n]
      // sort the left side
      Mergesort(left)
      // sort the right side
      Mergesort(right)
      // merge the sorted left and right sides together
      Merge(left, right, arr)

ALGORITHM Merge(left, right, arr)
DECLARE i <-- 0
DECLARE j <-- 0
DECLARE k <-- 0

    while i < left.length && j < right.length
        if left[i] <= right[j]
            arr[k] <-- left[i]
            i <-- i + 1
        else
            arr[k] <-- right[j]
            j <-- j + 1

        k <-- k + 1

    if i = left.length
       set remaining entries in arr to remaining values in right
    else
       set remaining entries in arr to remaining values in left

## Trace
Sample Array:[8, 4, 23, 42, 16, 15]

### Initial Array: [8, 4, 23, 42, 16, 15]
1. First Split (Mergesort)

- Left: [8, 4, 23]
- Right: [42, 16, 15]

Now, we recursively apply Mergesort to both left and right.

2. Split Left (Mergesort)

- Left: [8]
- Right: [4, 23]

Continue splitting until we have single elements.

3. Split Right (Mergesort)

- Left: [4]
- Right: [23]

Now, we merge the sorted subarrays.

4. Merge Left and Right (Merge)

- Merged: [4, 8, 23]

The left half is sorted. Now, we proceed to the right half.

5. Split Left (Mergesort)

- Left: [42]
- Right: [16, 15]

Continue splitting until we have single elements.

6. Split Right (Mergesort)

- Left: [16]
- Right: [15]

Now, we merge the sorted subarrays.

7. Merge Left and Right (Merge)

- Merged: [15, 16]

The right half is sorted. Now, we merge the two sorted halves.

8. Merge Left and Right (Merge)

-Merged: [4, 8, 15, 16, 23, 42]

The final sorted array is obtained.
## Efficency
- Time Complexity: O(n log n) .
- Space Complexity: O(n) .

