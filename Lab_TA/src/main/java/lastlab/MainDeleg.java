package lastlab;

import java.util.List;

public class MainDeleg {
    MainPart mainPart;

    public MainDeleg(MainPart mainPart) {
        this.mainPart = mainPart;
    }
    public List<List<Point>> findLines() {
        return mainPart.findLines();
    }
    public List<Point> getpoints(){
        return mainPart.getPoints();
    }
}
