import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.lang.Math;

public class RunningButton extends JButton implements MouseListener {

    JFrame window;
    public RunningButton(JFrame window) {
        this.window = window;
        setText("OK");
        setBounds(200, 225, 100, 50);
        addMouseListener(this);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        new PasswordWindow();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        Point a = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(a, window);

        int x = (int) a.getX();
        int y = (int) a.getY();
        System.out.println(x);
        System.out.println(y);

        Random rand = new Random();
        int n;
        int m;

        if (!(Math.abs(e.getComponent().getX() - x) < 10 && e.getComponent().getY() < y &&
                y < e.getComponent().getY()+100))
        {
            do {
                n = rand.nextInt(280);
                n += 110;
                m = rand.nextInt(280);
                m += 110;
            } while (Math.abs(x - n) < 200 && Math.abs(y - m) < 100);

            e.getComponent().setLocation(n, m);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {}


}
