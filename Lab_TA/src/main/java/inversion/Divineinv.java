package inversion;

import soluteinter.Solution;
public class Divineinv extends Solution {
    public Divineinv(int count){
        super(count);
    }
    @Override
    public void solve() {
        int[] temp= new int[array.length];
        mergeSortAndCountInversions(array, temp, 0, array.length - 1);
    }
    private static int mergeSortAndCountInversions(Integer[] arr, int[] temp, int left, int right) {
        int inversionCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            inversionCount += mergeSortAndCountInversions(arr, temp, left, mid);
            inversionCount += mergeSortAndCountInversions(arr, temp, mid + 1, right);
            inversionCount += mergeAndCountInversions(arr, temp, left, mid, right);
        }
        return inversionCount;
    }
    private static int mergeAndCountInversions(Integer[] arr, int[] temp, int left, int mid, int right) {
        int inversionCount = 0;
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += (mid - i + 1);
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        return inversionCount;
    }
}
