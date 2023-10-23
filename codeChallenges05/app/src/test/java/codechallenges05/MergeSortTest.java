package codechallenges05;

import mergeSort.MergeSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    MergeSort mergeSorter=new MergeSort();
   @Test
    public void testMergeSort() {
        int[] arr = {8, 4, 23, 42, 16, 15};
        int[] expected = {4, 8, 15, 16, 23, 42};
       mergeSorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        mergeSorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortSingleElementArray() {
        int[] arr = {5};
        int[] expected = {5};
        mergeSorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        mergeSorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        mergeSorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}
