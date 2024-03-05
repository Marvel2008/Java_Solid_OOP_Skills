package lastlab;

import com.lab.lab_ta.HelloApplication;
import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class MainPart{
    protected List<Point> points;

    public MainPart(String path) {
        this.points = loadPointsFromFile(path);
    }
    abstract List<List<Point>> findLines();

    protected List<Point> loadPointsFromFile(String filename) {
        List<Point> points = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] coordinates = br.readLine().split(" ");
                double x = Double.parseDouble(coordinates[0]);
                double y = Double.parseDouble(coordinates[1]);
                points.add(new Point(x, y));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return points;
    }

    protected double calculateSlope(Point p1, Point p2) {
        if (p1.getX() == p2.getX()) {
            return Double.POSITIVE_INFINITY; // Vertical line
        } else {
            return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        }
    }
    protected boolean isLineThroughPoints(Point p1, Point p2, Point p3, Point p4) {
        double slope1 = calculateSlope(p1, p2);
        double slope2 = calculateSlope(p1, p3);
        double slope3 = calculateSlope(p1, p4);

        return Math.abs(slope1 - slope2) < 0.0001 && Math.abs(slope1 - slope3) < 0.0001;
    }

    public List<Point> getPoints() {
        return points;
    }
}
