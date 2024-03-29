package sortpack;

import soluteinter.Solution;
import soluteinter.Sortingtype;

public final class Buble extends Solution {
    public Buble(int count, Sortingtype type){
        super(count, type);
    }
    @Override
    public void solve() {
        for (int i = 0; i < count - 1; i++)
        {
            for (int j = 0; j < count - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
