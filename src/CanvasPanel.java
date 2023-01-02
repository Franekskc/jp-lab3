import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {

    CanvasWindow window;
    public CanvasPanel(CanvasWindow window){
        this.window = window;
        setPreferredSize(new Dimension(400,400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        window.drawMyRectangles(g);
        window.drawMyOvals(g);
    }
}
