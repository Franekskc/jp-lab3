import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.lang.Math;

public class RunningButton implements MouseListener {
    public RunningButton(JButton button) {
        button.setText("OK");
        button.setBounds(200, 225, 100, 50);
        button.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        PasswordWindow passwordWindow = new PasswordWindow();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();

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
                System.out.println(x);
                System.out.println(y);
                System.out.println(n);
                System.out.println(m);
            } while (Math.abs(x - n) < 200 && Math.abs(y - m) < 100);

            e.getComponent().setLocation(n, m);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {}
}
