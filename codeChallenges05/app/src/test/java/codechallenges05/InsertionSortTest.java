package codechallenges05;


import InsertionSortPackage.InsertionSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest {
    @Test
    public void testInsertionSort() {
        InsertionSort sorter = new InsertionSort();
        int[] input = {4, 2, 1, 5, 6};
        int[] expected = {1, 2, 4, 5, 6};
        int[] result = sorter.insertionSort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortWithEmptyArray() {
        InsertionSort sorter = new InsertionSort();
        int[] input = {};
        int[] expected = {};
        int[] result = sorter.insertionSort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortWithSingleElement() {
        InsertionSort sorter = new InsertionSort();
        int[] input = {42};
        int[] expected = {42};
        int[] result = sorter.insertionSort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortWithSortedArray() {
        InsertionSort sorter = new InsertionSort();
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = sorter.insertionSort(input);
        assertArrayEquals(expected, result);
    }
}
