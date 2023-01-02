import java.awt.*;

public class MyTriangle extends MyShape {
    MyLine a, b, c;
    double lenght = 2 * height / Math.sqrt(3);

    public MyTriangle(int x, int y, Color color) {
        super(x, y, color);
        a = new MyLine(x + (int) lenght / 2, y + height / 3, x - (int) lenght / 2, y + height / 3);
        b = new MyLine(x + (int) lenght / 2, y + height / 3, x, y - 2 * height / 3);
        c = new MyLine(x - (int) lenght / 2, y + height / 3, x, y - 2 * height / 3);
    }
}
