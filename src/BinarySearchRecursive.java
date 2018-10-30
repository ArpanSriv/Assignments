import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearchRecursive {

    // Returns index of x if it is present in arr[l..
    // r], else return -1
    private static int binarySearch(ArrayList<Integer> arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr.get(mid) == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr.get(mid) > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        //  in array
        return -1;

    }

    public static void main(String[] args) {

        for (int size = 1000000; size < 50000000; size = size + 100000) {
            ArrayList<Integer> arr = new ArrayList<>(size);

            // Insert into array
            for (int j = 0; j < size; j++) {
                arr.add(j);
            }

            Collections.shuffle(arr);

            //BSearch
            long t1 = System.nanoTime();
            binarySearch(arr, 0, size - 1, size + 10);
            long t2 = System.nanoTime();

            long duration = t2 - t1;

            System.out.println(size + ", " + duration);

        }
    }

}