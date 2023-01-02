import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{


    public MainWindow(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
        setTitle("Uciekający przycisk");

        JButton runningButton = new RunningButton(this);
        add(runningButton);

        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);

    }
}
