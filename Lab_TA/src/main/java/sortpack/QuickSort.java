package sortpack;
import soluteinter.Solution;

public final class QuickSort extends Solution{
    public QuickSort(int count){
        super(count);
    }

    private void quicksort(int from, int to){
        if (from < to) {

            int divideIndex = partition(from, to);
            quicksort(from, divideIndex - 1);
            quicksort(divideIndex, to);
        }
    }
    @Override
    public void solve() {
        quicksort(0,array.length-1);
    }
    private int partition(int from, int to) {
        int rightIndex = to;
        int leftIndex = from;
        int pivot = array[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
    private  void swap(int index1, int index2) {
        int tmp  = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
