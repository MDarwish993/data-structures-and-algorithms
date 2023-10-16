package InsertionSortPackage;

public class InsertionSort {
    public static int[] insertionSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            insert(input, i);
        }

        return input;
    }

    public static void insert(int[] array, int currentIndex) {
        int currentValue = array[currentIndex];
        int i = currentIndex - 1;

        while (i >= 0 && array[i] > currentValue) {
            array[i + 1] = array[i];
            i--;
        }

        array[i + 1] = currentValue;
    }
}
