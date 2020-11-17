/***********************
 * ---------> [MAX_HEAP]
 * @author s---s as Undertale
 * @version 13/11/2020
 ***********************/
public class heap_methods
{
    public static void make_heap(int a[])
    {
        int size = heap_size(a);
        for(int i = size/2; i > 0; i--)
        {
            heapify(a,i);
        }
        return;
    }

    private static void heapify(int a[], int i)
    {
        int a_size = heap_size(a);
        while(true)
        {
            int max = i;
            if(left(i) <= a_size && a[left(i)] > a[max])
            {
                max = left(i);      
            }
            if(right(i) <= a_size && a[right(i)] > a[max])
            {
                max = right(i);
            }
            if(max == i)
            {
                return;
            }
            swap(a,max,i);
        }
    }

    public static void add_element(int[] a, int value)
    {
        int a_size = heap_size(a) + 1;
        int i      = a_size - 1;
        a[i]       = value;
        while( i > 1 && a[i] > a[parent(i)])
        {
            swap(a,i,parent(i));
            i = parent(i);
        }
        return;
    }

    public static void extract_max(int arr[])
    {
        int a_size = heap_size(arr);
        swap(arr,1,a_size);
        heapify(arr,1);
        arr[a_size] = 0;
    }

    public static void heap_short(int arr[])
    {
        make_heap(arr);
        for(int i = arr.length; i<2; i--)
        {
            swap(arr,1,i);
            heapify(arr,i);
        }
    }

    private static int heap_size(int a[])
    {
        int size = 0;
        for(int i = 1; i< a.length; i++)
        {
            if(a[i] != 0)
                size++;
            if(a[i] == 0)
                return size+1;
        }
        return size;
    }

    public static boolean is_leaf(int arr[],int i)
    {
        if(i > (heap_size(arr)/2))
            return true;
        else
            return false;
    }

    public static boolean is_heap(int arr[])
    {
        int size =  heap_size(arr);
        for(int i = 1; i < size; i++)
        {
            if(left(i)< size && arr[left(i)] > arr[i])
                return false;
            if(right(i)< size && arr[right(i)] > arr[i])
                return false;
        }
        return true;
    }

    private static void swap(int a[],int max,int i)
    {
        int temp = a[i]  ;
        a[i]     = a[max];
        a[max]   = temp  ;
    }

    public static int parent(int i)
    {
        return i/2;
    }

    public static int left(int i)
    {
        return 2*i;
    }

    public static int right(int i)
    {
        return (2*i)+1;
    }

    public static void print_array(int arr[])
    {
        String s ="";
        int mode = 0;
        s+="[";
        for(int i = 1; i<arr.length; i++)
        {
            if(arr[i] == 0)
            {
                continue;
            }
            s+=arr[i];
            if(i < arr.length-1)
            {
                if(arr[i+1] !=0 )
                    s+=",";
            }
        }
        s+="]";
        System.out.println(s);
    }
}