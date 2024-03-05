package lastlab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface Merge {
    static void mergeSort(List<PointWithAngle> list, Comparator<PointWithAngle> comparator) {
        if (list.size() > 1) {
            int middle = list.size() / 2;

            List<PointWithAngle> left = new ArrayList<>(list.subList(0, middle));
            List<PointWithAngle> right = new ArrayList<>(list.subList(middle, list.size()));

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            merge(list, left, right, comparator);
        }
    }

    private static void merge(List<PointWithAngle> list, List<PointWithAngle> left, List<PointWithAngle> right, Comparator<PointWithAngle> comparator) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                list.set(mergedIndex++, left.get(leftIndex++));
            } else {
                list.set(mergedIndex++, right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            list.set(mergedIndex++, left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            list.set(mergedIndex++, right.get(rightIndex++));
        }
    }
}
