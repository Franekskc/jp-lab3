import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class PasswordWindow{

    public PasswordWindow() {


        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setSize(250, 130);
        window.setTitle("Weryfikacja");
        window.setLocationRelativeTo(null);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setBounds(20, 20, 100, 20);
        passwordLabel.setText("Password:");
        window.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 20, 120, 20);
        window.add(passwordField);

        JButton confirmButton = new JButton();
        confirmButton.setText("Confirm");
        confirmButton.setBounds(20, 50, 200, 30);
        confirmButton.addActionListener(e -> {
            if (Arrays.equals(passwordField.getPassword(),"123".toCharArray())) {
                window.dispose();
                CanvasWindow canvasWindow = new CanvasWindow();
            } else {
                window.dispose();
                JOptionPane.showMessageDialog(window, "Wrong Password");
            }
        });
        confirmButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        window.add(confirmButton);

        window.setLayout(null);
        window.setVisible(true);
    }
}
