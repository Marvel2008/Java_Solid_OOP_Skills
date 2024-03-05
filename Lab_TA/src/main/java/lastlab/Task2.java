package lastlab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task2 extends MainPart implements Merge{
    public Task2(String path) {
        super(path);
    }

    @Override
    List<List<Point>> findLines() {
        List<List<Point>> lines = new ArrayList<>();
        List<Point> sortedPoints = new ArrayList<>(points);
        for (int i = 0; i < sortedPoints.size(); i++) {
            Point p = sortedPoints.get(i);
            List<PointWithAngle> pointsWithAngle = new ArrayList<>();

            for (int j = 0; j < sortedPoints.size(); j++) {
                if (i != j) {
                    Point q = sortedPoints.get(j);
                    double angle = Math.atan2(q.getY() - p.getY(), q.getX() - p.getX());
                    pointsWithAngle.add(new PointWithAngle(q, angle));
                }
            }
            Merge.mergeSort(pointsWithAngle, Comparator.comparing(PointWithAngle::getAngle));
            for (int j = 0; j < pointsWithAngle.size() - 2; j++) {
                Point q1 = pointsWithAngle.get(j).getPoint();
                Point q2 = pointsWithAngle.get(j + 1).getPoint();
                Point q3 = pointsWithAngle.get(j + 2).getPoint();

                if (isLineThroughPoints(p, q1, q2, q3)) {
                    List<Point> line = new ArrayList<>();
                    line.add(p);
                    line.add(q1);
                    line.add(q2);
                    line.add(q3);
                    lines.add(line);
                }
            }
        }

        return lines;
    }
}
