package lastlab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Task1 extends MainPart{
    public Task1(String path) {
        super(path);
    }

    @Override
    List<List<Point>> findLines() {
        List<List<Point>> lines = new ArrayList<>();
        points.sort(Comparator.comparingDouble(Point::getX));
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            List<Point> sortedPoints = new ArrayList<>(points);
            sortedPoints.remove(p1);
            sortedPoints.sort(Comparator.comparingDouble(p -> Math.atan2(p.getY() - p1.getY(), p.getX() - p1.getX())));
            for (int j = 0; j < sortedPoints.size(); j++) {
                Point p2 = sortedPoints.get(j);

                for (int k = j + 1; k < sortedPoints.size(); k++) {
                    Point p3 = sortedPoints.get(k);

                    for (int l = k + 1; l < sortedPoints.size(); l++) {
                        Point p4 = sortedPoints.get(l);
                        if (isLineThroughPoints(p1, p2, p3, p4)) {
                            List<Point> line = new ArrayList<>();
                            line.add(p1);
                            line.add(p2);
                            line.add(p3);
                            line.add(p4);
                            lines.add(line);
                        }
                    }
                }
            }
        }

        return lines;
    }
}
