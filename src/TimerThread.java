import java.awt.*;

public class TimerThread extends Thread {

    int timer;
    CanvasWindow window;

    public TimerThread(CanvasWindow window) {
        this.window = window;
        timer = 6;
    }

    @Override
    public void run() {
        window.triangle.setEnabled(false);
        window.rectangle.setEnabled(false);
        window.oval.setEnabled(false);
        while (timer > 0) {
            timer--;
            window.timerLabel.setText(String.valueOf(timer));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        window.tool = 0;
        window.canvasPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        window.timerLabel.setText("");
        window.triangle.setEnabled(true);
        window.rectangle.setEnabled(true);
        window.oval.setEnabled(true);
        interrupt();
    }
}
