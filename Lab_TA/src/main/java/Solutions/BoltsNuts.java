package Solutions;

import soluteinter.Solution;

public final class BoltsNuts extends Solution {
    public BoltsNuts(int count) {
        super(count);
    }

    @Override
    public void solve() {
        qsortx(0,array.length-1);
    }
    public void qsortx(int low, int high) {
        int i, j;
        int tmp, pivot;
        i = low;
        j = high;
        pivot = array[low + (high - low) / 2];
        do {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
                i++;
                if (j > 0) {
                    j--;
                }
            }
        } while (i <= j);
        if (i < high) {
            qsortx(i, high);
        }
        if (j > low) {
            qsortx(low, j);
        }
    }
}
