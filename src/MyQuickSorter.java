import java.util.Scanner;
import java.util.Random;

public class MyQuickSorter {

    private int array[];
    private int length;

    public void sort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;

        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[(lowerIndex + higherIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot && i <= higherIndex) {
                i++;
            }
            while (array[j] > pivot && j >= lowerIndex) {
                j--;
            }

            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void printArray(int A[]) {
        int n = A.length;
        for (int i = 0; i < n; ++i)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String a[]) {

        MyQuickSorter sorter = new MyQuickSorter();
        Scanner m = new Scanner(System.in);
        Random randomNumGenerator = new Random();
        // int n=A.length();
        System.out.println("enter the size of array");
        int n = 100;
        // n=m.nextInt();
        System.out.println(+n);
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            int t = randomNumGenerator.nextInt(n);
            ;
            A[i] = t;
        }
        System.out.println("Given Array");
        printArray(A);
        long lStartTime = System.nanoTime();
        sorter.sort(A);
        long lEndTime = System.nanoTime();
        long output = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds: " + output);
        System.out.println("\nSorted array");
        printArray(A);
    }
}