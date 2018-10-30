import java.util.Random;

public class MergeSort {


    static void mSort(int a[], int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mSort(a, low, mid);
            mSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    static void merge(int a[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[a.length];

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
                k++;
            }
            if (a[i] > a[j]) {
                temp[k] = a[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = a[j];
            j++;
            k++;
        }

        for (int c = 0; c < k; c++) {
            a[low] = temp[c];
            low++;
        }
    }


    public static void main(String[] args) {
        for (int size = 100000; size < 500000; size = size + 1000) {
            int arr[] = new int[size];

            Random random = new Random();
            // Insert into array
            for (int j = 0; j < size; j++) {
                arr[j] = random.nextInt();
            }

            //BSearch
            long t1 = System.nanoTime();
            mSort(, 0, arr.length - 1);
            long t2 = System.nanoTime();

            System.out.println("\t" + arr);

            long duration = t2 - t1;

            System.out.println(size + ", " + duration);

        }
    }

}
