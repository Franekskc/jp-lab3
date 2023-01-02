import java.awt.*;

public abstract class MyShape {
    protected int x, y, height = 50;
    protected Color color;

    public MyShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
