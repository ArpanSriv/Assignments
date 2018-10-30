import java.util.ArrayList;
import java.util.Collections;

public class HeapSort {
    public static void sort(ArrayList<Integer> arr) {
        int n = arr.size();

        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end 
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    static void heapify(ArrayList<Integer> arr, int n, int i) {
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root 
        if (l < n && arr.get(l) > arr.get(largest))
            largest = l;

        // If right child is larger than largest so far 
        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;

        // If largest is not root 
        if (largest != i) {
            int swap = arr.get(i);
            arr.add(i, arr.get(largest));
            arr.add(largest, swap);

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest);
        }
    }

    // Driver program 
    public static void main(String args[]) {

        for (int size = 1000; size < 5000000; size = size + 10000) {

            ArrayList<Integer> arr = new ArrayList<>(size);

            // Insert into array
            for (int j = 0; j < arr.size(); j++) {
                arr.add(j);
            }

            Collections.shuffle(arr);

            //BSearch
            long t1 = System.nanoTime();
            sort(arr);
            long t2 = System.nanoTime();

            long duration = t2 - t1;

            System.out.println(size + ", " + duration);

        }
    }
}