public class L_3016 {

    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));
    }

    public static int minimumPushes(String word) {
        int[] b = new int[26];
        for (byte i : word.getBytes()) {
            b[i - 'a']++;
        }
        quickSort(b, 0, 25);
        int sum = 0;
        for (int i = 18; i < 26; i++) {
            sum += b[i];
        }
        for (int i = 10; i < 18; i++) {
            sum += b[i] * 2;
        }
        for (int i = 2; i < 10; i++) {
            sum += b[i] * 3;
        }
        for (int i = 0; i < 2; i++) {
            sum += b[i] * 4;
        }
        return sum;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(int[] arr, int low, int high) {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
