public class Sorting
{
    private static long comparisons = 0;
    private static long swaps = 0;
    
    /**
    * Sorts an array by pushing higher values below all lower values
    */
    public static void bubbleSort(int[] arr) {
        long swaps = 0;
        long comparisons = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                comparisons++;
                
                // Swaps if needed
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        System.out.print(", " + comparisons + ", " + swaps);
    }
    
    /**
    * Sorts an array by swapping values in with the value that
    * belongs at that index when sorted
    */
    public static void selectionSort(int[] arr) {
        long swaps = 0;
        long comparisons = 0;
        
        // Iterates through array to allow swaps if necessary
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int location = i;
            
            // Iterates through array to find minimum value after index
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < min) {
                    min = arr[j];
                    location = j;
                }
            }
            comparisons++;
            
            // Swaps value with the minimum value after it
            if (location != i) {
                swaps++;
                int temp = min;
                arr[location] = arr[i];
                arr[i] = temp;
            }
        }
        
        System.out.print(", " + comparisons + ", " + swaps);
    }
    
    /**
    * Sorts an array by swapping values with all higher preceding values
    */
    public static void insertionSort(int[] arr) {
        long swaps = 0;
        long comparisons = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            comparisons++;
            
            // Swaps a value if lower than preceding value in array
            while (j != 0 && arr[j] < arr[j - 1]) {
                swaps++;
                comparisons++;
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        
        System.out.print(", " + comparisons + ", " + swaps);
    }
    
    /**
    * Initiates merge sort for an array
    */
    public static void mergeSort(int[] arr) {
        mergeSort(0, arr.length - 1, arr);
        System.out.print(", " + comparisons + ", " + swaps);
    }
    
    /**
    * Sorts an array by breaking it down and merges back into a sorted order
    */
    public static void mergeSort(int start, int end, int[] arr) {
        // Base case
        if (start == end) {
            return;
        } else {
            int mid = (start + end) / 2;
            mergeSort(start, mid, arr);
            mergeSort(mid + 1, end, arr);
            merge(start, mid, end, arr);
        }
    }
    
    /**
    * Merges a split array into a sorted order
    */
    public static void merge(int start, int mid, int end, int[] arr) {
        int i = start;
        int j = mid + 1;
        int[] newArr = new int[end - start + 1];
        int location = 0;
        
        /**
        * Determines which piece of the array has a lower value and adds that
        * to the correct index of the sorted array
        */
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                newArr[location] = arr[i];
                i++;
                location++;
                comparisons++;
                swaps++;
            } else {
                newArr[location] = arr[j];
                j++;
                location++;
                comparisons++;
                swaps++;
            }
        }
        
        /**
        * Adds the remaining values of a half if all values from the
        * other are already added
        */
        while (i <= mid) {
            newArr[location] = arr[i];
            i++;
            location++;
            swaps++;
        }
        
        while (j <= end) {
            newArr[location] = arr[j];
            j++;
            location++;
            swaps++;
        }
        
        // Copies the sorted array to the original array
        for (int x = start; x <= end; x++) {
            arr[x] = newArr[x - start];
        }
    }
    
    public static void testBubble() {
        int[] arr = {5, 1, 50, 2, 3, 182, 12, 97, 14, 9};
        
        for (int a : arr) {
            System.out.print(a + ",");
        }
        
        System.out.println();
        bubbleSort(arr);
        
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }
    
    public static void testInsertion() {
        int[] arr = {5, 1, 50, 2, 3, 182, 12, 97, 14, 9};
        
        for (int a : arr) {
            System.out.print(a + ",");
        }
        
        System.out.println();
        insertionSort(arr);
        
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }
    
    public static void testSelection() {
        int[] arr = {5, 1, 50, 2, 3, 182, 12, 97, 14, 9};
        
        for (int a : arr) {
            System.out.print(a + ",");
        }
        
        System.out.println();
        selectionSort(arr);
        
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }
    
    public static void testMerge() {
        int[] arr = {5, 1, 50, 2, 3, 182, 12, 97, 14, 9};
        
        for (int a : arr) {
            System.out.print(a + ",");
        }
        
        System.out.println();
        mergeSort(arr);
        
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }
}