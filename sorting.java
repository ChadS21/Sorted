public class sorting
{
    public static void insertion(int[] list)
    {
        for (int i = 0; i < list.length - 1; i++)
        {
            if (list[i] > list[i + 1])
            {
                int temp = list[i];
                list[i] = list[i + 1];
                list[i + 1] = temp;
                i--;
            }
        }
    }
    
    
    public static void bubble(int[] list)
    {
        for (int i = 0; i < list.length - 1; i++)
        {
            if (list[i] > list[i + 1])
            {
                int temp = list[i];
                list[i] = list[i + 1];
                list[i + 1] = temp;
            }
        }
    }
    
    public static void selection(int[] list)
    {
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
                int temp = min;
                list[location] = list[i];
                list[i] = temp;
            }
        }
    }
    
    public static void testBubble()
    {
        int[] list = {5, 1, 2, 12, 9};
        for (int a : list)
        {
            System.out.print(a + ",");
        }
        System.out.println();
        bubble(list);
        for (int a : list)
        {
            System.out.print(a + ",");
        }
    }
    
    public static void testInsertion()
    {
        int[] list = {5, 1, 2, 12, 9};
        for (int a : list)
        {
            System.out.print(a + ",");
        }
        System.out.println();
        insertion(list);
        for (int a : list)
        {
            System.out.print(a + ",");
        }
    }
    
    public static void testSelection()
    {
        int[] list = {5, 1, 2, 12, 9};
        for (int a : list)
        {
            System.out.print(a + ",");
        }
        System.out.println();
        selection(list);
        for (int a : list)
        {
            System.out.print(a + ",");
        }
    }
}
