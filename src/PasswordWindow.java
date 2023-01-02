import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class PasswordWindow extends JFrame{

    public PasswordWindow() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(250, 130);
        setTitle("Weryfikacja");
        setLocationRelativeTo(null);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setBounds(20, 20, 100, 20);
        passwordLabel.setText("Password:");
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 20, 120, 20);
        add(passwordField);

        JButton confirmButton = new JButton();
        confirmButton.setText("Confirm");
        confirmButton.setBounds(20, 50, 200, 30);
        confirmButton.addActionListener(e -> {
            if (Arrays.equals(passwordField.getPassword(),"123".toCharArray())) {
                dispose();
                new CanvasWindow();
            } else {
                dispose();
                JOptionPane.showMessageDialog(this, "Wrong Password");
            }
        });
        confirmButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(confirmButton);

        setResizable(false);
        setLayout(null);
        setVisible(true);
    }
}
