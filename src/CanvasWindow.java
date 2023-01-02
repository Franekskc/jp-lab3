import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class CanvasWindow extends JFrame {

    Color color;
    int tool;
    ArrayList<MyRectangle> rectangles = new ArrayList<>();
    ArrayList<MyOval> ovals = new ArrayList<>();
    ArrayList<MyTriangle> triangles = new ArrayList<>();
    JLabel timerLabel;
    JMenuItem triangle;
    JMenuItem rectangle;
    JMenuItem oval;
    CanvasPanel canvasPanel;
    TimerThread timerThread;

    public CanvasWindow() {

        color = Color.BLACK;


        CanvasWindow window = this;

        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setSize(500, 500);
        window.setTitle("Canvas");


        canvasPanel = new CanvasPanel(window);
        canvasPanel.setPreferredSize(new Dimension(400, 400));
        window.add(canvasPanel);

        timerLabel = new JLabel();
        timerLabel.setForeground(Color.RED);
        canvasPanel.add(timerLabel);

        canvasPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

                Point a = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(a, window);
                int x = (int) a.getX();
                int y = (int) a.getY();
                switch (tool) {
                    case 2 -> {
                        triangles.add(new MyTriangle(x - 9, y - 45, color));
                        canvasPanel.repaint();
                    }
                    case 3 -> {
                        rectangles.add(new MyRectangle(x - 32, y - 79, color));
                        canvasPanel.repaint();
                    }
                    case 4 -> {
                        ovals.add(new MyOval(x - 32, y - 79, color));
                        canvasPanel.repaint();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        JMenuBar menuBar = new JMenuBar();

        JMenu tools = new JMenu("Tools");
        tools.setMnemonic(KeyEvent.VK_T);
        menuBar.add(tools);

        JMenuItem chooseColor = new JMenuItem("Choose Color (1)", KeyEvent.VK_1);
        chooseColor.addActionListener(e -> {
            window.color = JColorChooser.showDialog(window, "Select a color", window.color);
            window.getContentPane().setBackground(window.color);
        });
        chooseColor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tools.add(chooseColor);

        triangle = new JMenuItem("Triangle (2)", KeyEvent.VK_2);
        triangle.addActionListener(e -> {
            tool = 2;
            canvasPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            timerThread = new TimerThread(window);
            timerThread.start();
        });
        triangle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tools.add(triangle);

        rectangle = new JMenuItem("Square (3)", KeyEvent.VK_3);
        rectangle.addActionListener(e -> {
            tool = 3;
            canvasPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            timerThread = new TimerThread(window);
            timerThread.start();
        });
        rectangle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tools.add(rectangle);

        oval = new JMenuItem("Circle (4)", KeyEvent.VK_4);
        oval.addActionListener(e -> {
            tool = 4;
            canvasPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            timerThread = new TimerThread(window);
            timerThread.start();
        });
        oval.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tools.add(oval);

        window.setJMenuBar(menuBar);


        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    void drawMyRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (MyRectangle rectangle : rectangles) {
            g2d.setColor(rectangle.color);
            g2d.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }

    void drawMyOvals(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (MyOval oval : ovals) {
            g2d.setColor(oval.color);
            g2d.drawOval(oval.x, oval.y, oval.width, oval.height);
        }
    }

    void drawMyTriangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (MyTriangle triangle : triangles) {
            g2d.setColor(triangle.color);
            g2d.drawLine(triangle.a.startPoint.x, triangle.a.startPoint.y, triangle.a.endPoint.x, triangle.a.endPoint.y);
            g2d.drawLine(triangle.b.startPoint.x, triangle.b.startPoint.y, triangle.b.endPoint.x, triangle.b.endPoint.y);
            g2d.drawLine(triangle.c.startPoint.x, triangle.c.startPoint.y, triangle.c.endPoint.x, triangle.c.endPoint.y);
        }
    }
}
