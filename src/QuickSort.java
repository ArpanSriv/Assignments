import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class QuickSort {

    static int partition(ArrayList<Integer> arr, int low, int high) {

        //Normal Pivot
        int pivot = arr.get(high);


        ///Randomized Pivot
//        Random random = new Random();
//        int pivot = arr.get(random.nextInt(high));

        //Middle Pivot
//        int pivot = arr.get(low + (high - low) / 2);

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    static void sort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // Driver program
    public static void main(String args[]) {
        for (int size = 100000; size < 500000; size = size + 1000) {
            ArrayList<Integer> arr = new ArrayList<>(size);

            // Insert into array
            for (int j = 0; j < size; j++) {
                arr.add(j);
            }

            Collections.shuffle(arr);

            //BSearch
            long t1 = System.nanoTime();
            sort(arr, 0, size - 1);
            long t2 = System.nanoTime();

            long duration = t2 - t1;

            System.out.println(size + ", " + duration);

        }
    }
}
