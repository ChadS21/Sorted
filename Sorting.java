public class Sorting
{
    private static long comparisons = 0;
    private static long swaps = 0;
    
    public static void bubbleSort(int[] list)
    {
        long sCount = 0;
        long cCount = 0;
        for (int i = 0; i < list.length - 1; i++)
        {
            for (int j = 0; j < list.length - 1; j++)
            {
                cCount++;
                if (list[j] > list[j + 1])
                {
                    sCount++;
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        System.out.print(", " + cCount + ", " + sCount);
    }
    
    public static void selectionSort(int[] list)
    {
        long sCount = 0;
        long cCount = 0;
        for (int i = 0; i < list.length - 1; i++)
        {
            int min = list[i];
            int location = i;
            for (int j = i + 1; j < list.length; j++)
            {
                if (list[j] < min)
                {
                    min = list[j];
                    location = j;
                }
            }
            cCount++;
            if (location != i)
            {
                sCount++;
                int temp = min;
                list[location] = list[i];
                list[i] = temp;
            }
        }
        System.out.print(", " + cCount + ", " + sCount);
    }
    
    public static void insertionSort(int[] list)
    {
        long sCount = 0;
        long cCount = 0;
        for (int i = 1; i < list.length; i++)
        {
            int j = i;
            cCount++;
            while (j != 0 && list[j] < list[j - 1])
            {
                sCount++;
                cCount++;
                int temp = list[j];
                list[j] = list[j - 1];
                list[j - 1] = temp;
                j--;
            }
        }
        System.out.print(", " + cCount + ", " + sCount);
    }
    
    public static void mergeSort(int[] list)
    {
        mergeSort(0, list.length - 1, list);
        System.out.print(", " + comparisons + ", " + swaps);
    }
    
    public static void mergeSort(int beg, int end, int[] list)
    {
        if (beg == end)
        {
            return;
        }
        int mid = (beg + end) / 2;
        mergeSort(beg, mid, list);
        mergeSort(mid + 1, end, list);
        merge(beg, mid, end, list);
    }
    
    public static void merge(int beg, int mid, int end, int[] list)
    {
        int i = beg;
        int j = mid + 1;
        int[] newArr = new int[end - beg + 1];
        int location = 0;
        while (i <= mid && j <= end)
        {
            if (list[i] < list[j])
            {
                newArr[location] = list[i];
                i++;
                location++;
                comparisons++;
                swaps++;
            }
            else
            {
                newArr[location] = list[j];
                j++;
                location++;
                comparisons++;
                swaps++;
            }
        }
        while (i <= mid)
        {
            newArr[location] = list[i];
            i++;
            location++;
            swaps++;
        }
        while (j <= end)
        {
            newArr[location] = list[j];
            j++;
            location++;
            swaps++;
        }
        for (int x = beg; x <= end; x++)
        {
            list[x] = newArr[x - beg];
        }
    }
    
    public static void testBubble()
    {
        int[] list = {5, 1, 50, 2, 3, 182, 12, 97, 14, 9};
        for (int a : list)
        {
            System.out.print(a + ",");
        }
        System.out.println();
        bubbleSort(list);
        for (int a : list)
        {
            System.out.print(a + ",");
        }
    }
    
    public static void testInsertion()
    {
        int[] list = {5, 1, 50, 2, 3, 182, 12, 97, 14, 9};
        for (int a : list)
        {
            System.out.print(a + ",");
        }
        System.out.println();
        insertionSort(list);
        for (int a : list)
        {
            System.out.print(a + ",");
        }
    }
    
    public static void testSelection()
    {
        int[] list = {5, 1, 50, 2, 3, 182, 12, 97, 14, 9};
        for (int a : list)
        {
            System.out.print(a + ",");
        }
        System.out.println();
        selectionSort(list);
        for (int a : list)
        {
            System.out.print(a + ",");
        }
    }
    
    public static void testMerge()
    {
        int[] list = {5, 1, 50, 2, 3, 182, 12, 97, 14, 9};
        for (int a : list)
        {
            System.out.print(a + ",");
        }
        System.out.println();
        mergeSort(list);
        for (int a : list)
        {
            System.out.print(a + ",");
        }
    }
}
