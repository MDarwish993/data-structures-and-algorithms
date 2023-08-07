package codeChallenges;

public class ReverseArrayProblem {
    public static void main(String[] args) {
        int[] numbers = {1,2,4,5,7,2,6,9,22,45,7,44,3,2,34};
        int[] reversedArray = reverseArray(numbers);
        
        for (int num : reversedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversedArr = new int[arr.length];
        int index = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            reversedArr[index] = arr[i];
            index++;
        }

        return reversedArr;
    }
}
