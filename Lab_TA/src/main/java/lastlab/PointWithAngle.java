package lastlab;

public final class PointWithAngle {
    private Point point;
    private double angle;

    public PointWithAngle(Point point, double angle) {
        this.point = point;
        this.angle = angle;
    }

    public Point getPoint() {
        return point;
    }

    public double getAngle() {
        return angle;
    }
}
