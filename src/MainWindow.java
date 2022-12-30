import javax.swing.*;

public class MainWindow {
    public MainWindow(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(500,500);
        window.setTitle("Uciekający przycisk");

        JButton button = new JButton();
        RunningButton runningButton = new RunningButton(button);
        window.add(button);

        window.setLayout(null);
        window.setVisible(true);

    }
}
