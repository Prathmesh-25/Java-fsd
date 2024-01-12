package com.lesson5;

class QuickSort
{
   
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        { 
            if (arr[j] <= pivot)
            {
                i++;

                // swap the values arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap the values arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    //sorting function
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {

            int p = partition(arr, low, high);

            
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }

    public static void main(String args[])
    {
        int arr[] = {8,2,5,20,14,12,17};
        int l = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, l-1);

        System.out.println("sorted array");
        
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}

