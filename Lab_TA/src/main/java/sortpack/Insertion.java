package sortpack;

import soluteinter.Solution;
import soluteinter.Sortingtype;

import java.util.Arrays;

public final class Insertion extends Solution {
    public Insertion(int count, Sortingtype type){
        super(count, type);
    }
    @Override
    public void solve() {
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < count; i++)
        {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key)
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        System.out.println(Arrays.toString(array));
    }
}
