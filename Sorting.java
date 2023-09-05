public class Sorting
{
    private static int cCount = 0;
    private static int sCount = 0;;
    
    public static void bubbleSort(int[] list)
    {
        int sCount = 0;
        int cCount = 0;
        for (int i = 0; i < list.length - 1; i++)
        {
            for (int j = 0; j < list.length - 1; j++)
            {
                if (list[j] > list[j + 1])
                {
                    sCount++;
                    cCount++;
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        System.out.println(", " + cCount + ", " + sCount);
    }
    
    public static void selectionSort(int[] list)
    {
        int sCount = 0;
        int cCount = 0;
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
            if (location != i)
            {
                sCount++;
                cCount++;
                int temp = min;
                list[location] = list[i];
                list[i] = temp;
            }
        }
        System.out.println(", " + cCount + ", " + sCount);
    }
    
    public static void insertionSort(int[] list)
    {
        for (int i = 1; i < list.length; i++)
        {
            int j = i;
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
        System.out.println(", " + cCount + ", " + sCount);
    }
    
    public static void mergeSort(int[] list)
    {
        mergeSort(0, list.length - 1, list);
        System.out.println(", " + cCount + ", " + sCount);
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
        int[] newArr = new int[list.length];
        int location = beg;
        while (i <= mid && j <= end)
        {
            if (list[i] < list[j])
            {
                newArr[location] = list[i];
                i++;
                location++;
                cCount++;
                sCount++;
            }
            else
            {
                newArr[location] = list[j];
                j++;
                location++;
                cCount++;
                sCount++;
            }
        }
        while (i <= mid)
        {
            newArr[location] = list[i];
            i++;
            location++;
            sCount++;
        }
        while (j <= end)
        {
            newArr[location] = list[j];
            j++;
            location++;
            sCount++;
        }
        for (int x = beg; x <= end; x++)
        {
            list[x] = newArr[x];
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
