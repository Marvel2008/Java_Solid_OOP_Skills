package sortpack;

import soluteinter.Solution;

import java.util.Random;

public final class RandomQuickSort extends Solution {

    public RandomQuickSort(int count){
        super(count);
    }
    private void random(Integer[] array,int low,int high)
    {
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;
        int temp1=array[pivot];
        array[pivot]=array[high];
        array[high]=temp1;
    }
    private int partition(Integer array[],int low, int high)
    {
        random(array,low,high);
        int pivot = array[high];
        int i = (low-1);
        for (int j = low; j < high; j++)
        {
            if (array[j] < pivot)
            {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }

    @Override
    public void solve() {
        sort(array,0,array.length-1);
    }
    private void sort(Integer arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}
