import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class CanvasWindow extends JFrame{

    public static Color color;
    int tool;
    ArrayList<MyRectangle> rectangles = new ArrayList<>();
    ArrayList<MyOval> ovals = new ArrayList<>();
    ArrayList<MyTriangle> triangles = new ArrayList<>();

    public CanvasWindow(){

        color = Color.BLACK;
        tool = 0;

        CanvasWindow window = this;

        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setSize(500,500);
        window.setTitle("Canvas");

        CanvasPanel canvasPanel = new CanvasPanel(window);
        canvasPanel.setPreferredSize(new Dimension(400,400));
        window.add(canvasPanel);
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
                        triangles.add(new MyTriangle(x-9,y-45,color));
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
                tool = 0;
                canvasPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        JMenuBar menuBar = new JMenuBar();

        JMenu tools = new JMenu("Tools");
        tools.setMnemonic(KeyEvent.VK_T);
        menuBar.add(tools);
        tools.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        JMenuItem color = new JMenuItem("Color (1)",KeyEvent.VK_1);
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CanvasWindow.color =JColorChooser.showDialog(window,"Select a color", CanvasWindow.color);
                window.getContentPane().setBackground(CanvasWindow.color);
            }
        });
        color.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tools.add(color);

        JMenuItem pencil = new JMenuItem("Triangle (2)",KeyEvent.VK_2);
        pencil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tool = 2;
                canvasPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }
        });
        pencil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tools.add(pencil);

        JMenuItem square = new JMenuItem("Square (3)",KeyEvent.VK_3);
        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tool = 3;
                canvasPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }
        });
        square.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tools.add(square);

        JMenuItem circle = new JMenuItem("Circle (4)",KeyEvent.VK_4);
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tool = 4;
                canvasPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }
        });
        circle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tools.add(circle);



        window.setJMenuBar(menuBar);


        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    public void drawMyRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (MyRectangle rectangle : rectangles) {
            g2d.setColor(rectangle.color);
            g2d.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }

    public void drawMyOvals(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (MyOval oval : ovals) {
            g2d.setColor(oval.color);
            g2d.drawOval(oval.x,oval.y,oval.width,oval.height);
        }
    }

    public void drawMyTriangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (MyTriangle triangle : triangles) {
            g2d.setColor(triangle.color);
            g2d.drawLine(triangle.a.startPoint.x,triangle.a.startPoint.y,triangle.a.endPoint.x,triangle.a.endPoint.y);
            g2d.drawLine(triangle.b.startPoint.x,triangle.b.startPoint.y,triangle.b.endPoint.x,triangle.b.endPoint.y);
            g2d.drawLine(triangle.c.startPoint.x,triangle.c.startPoint.y,triangle.c.endPoint.x,triangle.c.endPoint.y);
        }
    }
}
